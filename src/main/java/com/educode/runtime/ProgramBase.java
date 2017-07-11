package com.educode.runtime;

import com.educode.events.Broadcaster;
import com.educode.events.EventInvocationRequest;
import com.educode.minecraft.entity.EntityRobot;
import com.educode.nodes.method.MethodDeclarationNode;
import com.educode.nodes.ungrouped.EventDefinitionNode;
import com.educode.runtime.types.*;
import com.educode.visitors.interpreter.InterpretationVisitor;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import scala.actors.threadpool.Arrays;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

public abstract class ProgramBase implements IRobot, IProgramBase
{
    // Queues
    private final Queue<TickCommand> _commandQueue = new ConcurrentLinkedQueue<>();
    private final BlockingQueue<EventInvocation> _eventQueue = new ArrayBlockingQueue<>(128); // Has a maximum capacity of 128 event invocations
    private final BlockingQueue<EventInvocationRequest> _interpretedEventQueue = new ArrayBlockingQueue<>(128); // Has a maximum capacity of 128 event invocations

    // General
    private final Random _rand = new Random();
    private List<EventDefinitionNode> _eventDefinitions;
    private List<MethodDeclarationNode> _methodDeclarations;
    private String _programName;
    private InterpretationVisitor _interpreter;

    // Minecraft related
    private World _world;
    private EntityRobot _robot;
    private EntityPlayer _player;

    // Used by implemented programs
    protected final ProgramBase robot = this;

    // Threading
    private Thread _mainThread, _eventThread;

    public abstract void main() throws InterruptedException;

    private static int gbl = 0;
    public void init(String programName, Thread mainThread, World world, EntityPlayer player, List<EventDefinitionNode> eventDefinitions, List<MethodDeclarationNode> methodDeclarations)
    {
        this._world = world;
        this._player = player;
        this._eventDefinitions = eventDefinitions;
        this._methodDeclarations = methodDeclarations;
        this._programName = programName;

        // Set threads and create thread for event invoker
        this._mainThread = mainThread;
        this._mainThread.setName(String.format("ProgramRunner/%s/%s", getProgramName(), gbl++));

        // Spawn robot
        this._robot = new EntityRobot(this, _world, player);
        this._robot.setSpawnPosition(player);
        this._world.spawnEntity(_robot);
    }

    public void setInterpreter(InterpretationVisitor interpreter)
    {
        this._interpreter = interpreter;
    }

    public Thread getEventThread()
    {
        return this._eventThread;
    }

    public Thread getMainThread()
    {
        return this._mainThread;
    }

    public String getProgramName()
    {
        return this._programName;
    }

    public BlockingQueue<EventInvocation> getEventQueue()
    {
        return this._eventQueue;
    }

    public BlockingQueue<EventInvocationRequest> getInterpretedEventQueue()
    {
        return this._interpretedEventQueue;
    }

    public TickCommand pollCommand()
    {
        return _commandQueue.poll();
    }

    public List<EventDefinitionNode> getEventDefinitions()
    {
        return this._eventDefinitions;
    }

    public List<MethodDeclarationNode> getMethodDeclarations()
    {
        return this._methodDeclarations;
    }

    public EntityPlayer getPlayer()
    {
        return this._player;
    }

    public ExtendedList<Double> range(double min, double max)
    {
        ExtendedList<Double> ret = new ExtendedList<>();

        for (double c = min; c <= max; c++)
            ret.addItem(c);

        return ret;
    }

    public Double time()
    {
        return (double) System.currentTimeMillis();
    }

    public void debug(String string)
    {
        System.out.println(string);
    }

    @Override
    public String getName()
    {
        return getRobot().getName();
    }

    public double random(Double min, Double max)
    {
        return (max - min) * _rand.nextFloat() + min;
    }

    @Override
    public boolean isRobot()
    {
        return true;
    }

    @Override
    public boolean isPlayer()
    {
        return false;
    }

    public void waitForTick() throws InterruptedException
    {
        executeOnTick(() -> null);
    }

    public void wait(Double time) throws InterruptedException
    {
        waitInternal(time.longValue());
    }

    private void waitInternal(long time) throws InterruptedException
    {
        long sleepStarted = System.currentTimeMillis();

        // Use the opportunity to wait for events
        EventInvocationRequest eventRequest = this._interpretedEventQueue.poll(time, TimeUnit.MILLISECONDS);
        if (eventRequest != null)
        {
            // Invoke event request
            this._interpreter.invokeEvent(eventRequest);

            // Calculate remaining sleep time
            long remainingSleepTime =  (sleepStarted + time) - System.currentTimeMillis();
            if (remainingSleepTime > 0)
                waitInternal(remainingSleepTime);
        }
    }

    @Override
    public void setWorldTime(Double time) throws InterruptedException
    {
        executeOnTick(() -> _world.setWorldTime(time.longValue() % 24000));
    }

    public void say(String message) throws InterruptedException
    {
        executeOnTick(() ->
        {
            MinecraftServer server = _world.getMinecraftServer();
            if (server == null)
                return; // Should never happen since this method is never executed client-side

            // Using an iterator should not be necessary in this iteration because it is executed on tick
            for (EntityPlayer player : server.getPlayerList().getPlayers())
                _robot.sendMessageTo(player, message);
        });
    }

    @Override
    public void explode(Double strength) throws InterruptedException
    {
        boolean mobGriefingEnabled = this._world.getGameRules().getBoolean("mobGriefing");
        executeOnTick(() -> _world.createExplosion(this._robot, getX(), getY(), getZ(), strength.floatValue(), mobGriefingEnabled));
    }

    public void dropItems() throws InterruptedException
    {
        executeOnTick(() -> _robot.dropItems());
    }

    private double getX()
    {
        return this._robot.posX;
    }

    private double getY()
    {
        return this._robot.posY;
    }

    private double getZ()
    {
        return this._robot.posZ;
    }

    @Override
    public Coordinates getCoordinates()
    {
        return new Coordinates(_robot.getPosition());
    }

    @Override
    public boolean placeBlock(Coordinates coordinates) throws InterruptedException
    {
        if (this._robot.getPosition().getDistance((int)coordinates.getX(), (int)coordinates.getY(), (int)coordinates.getZ()) > 3.0)
            return false;

        boolean result = (boolean) executeOnTick(() ->
        {
            ItemStack heldStack = getHeldItem().getWrappedItem();
            if (heldStack.getItem() instanceof ItemBlock)
            {
                ItemBlock itemBlock = (ItemBlock) heldStack.getItem();
                Block block = Block.getBlockFromItem(heldStack.getItem());

                boolean subResult = itemBlock.placeBlockAt(heldStack, _player, _world, coordinates.toBlockPos(), EnumFacing.DOWN, 0F, 0F, 0F, block.getDefaultState());
                if (subResult)
                    heldStack.shrink(1);
                return subResult;
            }
            else
                return false;
        });

        if (result)
            wait(500.0);

        return result;
    }

    @Override
    public void broadcast(Double channel, String message)
    {
        Broadcaster.broadcastMessage(this._robot, channel, message);
    }

    @Override
    public void broadcast(Double channel, MinecraftEntity entity)
    {
        Broadcaster.broadcastMessage(this._robot, channel, entity);
    }

    @Override
    public void stop() throws InterruptedException
    {
        executeOnTick(() -> getRobot().setDead());
    }

    @Override
    public boolean attack(MinecraftEntity entity) throws InterruptedException
    {
        if (this._robot.isDead || this.getDistanceTo(entity) > 3.0F)
            return false;

        executeOnTick(() -> _robot.attackEntity(entity.getWrappedEntity()));
        wait(500.0);

        return true;
    }

    private Object executeOnTick(IExecutableReturns executable) throws InterruptedException
    {
        TickCommand command = new TickCommand(executable);
        _commandQueue.add(command);

        return command.getResult();
    }

    private void executeOnTick(IExecutable executable) throws InterruptedException
    {
        executeOnTick(() ->
        {
            executable.execute();
            return null;
        });
    }

    @Override
    public Double dropItem(String name, final Double quantity) throws InterruptedException
    {
        return (Double) executeOnTick(() -> _robot.dropInventoryItem(name, quantity));
    }

    @Override
    public ExtendedList<MinecraftItem> getInventory()
    {
        ExtendedList<MinecraftItem> collection = new ExtendedList<>();

        // Add non-air blocks
        for (int i = 0; i < this._robot.getInventory().getSizeInventory(); i++)
        {
            ItemStack current = this._robot.getInventory().getStackInSlot(i);
            if (current.isEmpty())
                continue;
            collection.add(new MinecraftItem(current));
        }

        return collection;
    }

    @Override
    public MinecraftItem getHeldItem()
    {
        return new MinecraftItem(this._robot.getHeldItem(EnumHand.MAIN_HAND));
    }

    @Override
    public void setHeldItem(MinecraftItem item) throws InterruptedException
    {
        executeOnTick(() -> this._robot.setHeldItem(EnumHand.MAIN_HAND, item.getWrappedItem()));
    }

    @Override
    public MinecraftItem getItemFromSlot(Double index)
    {
        int intIndex = index.intValue();
        if (intIndex >= this._robot.getInventory().getSizeInventory())
            return new MinecraftItem();
        return new MinecraftItem(this._robot.getInventory().getStackInSlot(intIndex));
    }

    @Override
    public Double getDistanceTo(MinecraftEntity entity)
    {
    	return (double) _robot.getDistanceToEntity(entity.getWrappedEntity());
    }

    @Override
    public boolean walkTo(Coordinates coords) throws InterruptedException
    {
        return navigateToBlock(coords.toBlockPos());
    }

    private boolean navigateToBlock(BlockPos pos) throws InterruptedException
    {
        boolean result = (boolean) executeOnTick(() -> this._robot.getNavigator().tryMoveToXYZ(pos.getX(), pos.getY(), pos.getZ(), 0.5D));

        if (result)
            wait(500.0);

        return result;
    }


    @Override
    public ExtendedList<MinecraftEntity> getNearbyEntities() throws InterruptedException
    {
        return (ExtendedList<MinecraftEntity>) executeOnTick(() ->
        {
            ExtendedList<MinecraftEntity> returnList = new ExtendedList<>();
            for (Entity entity : this._world.getEntitiesWithinAABB(EntityLivingBase.class, this._robot.getEntityBoundingBox().expand(45, 5, 45)))
            {
                if (entity.equals(this._robot))
                    continue;

                returnList.addItem(new MinecraftEntity(entity));
            }

            return returnList;
        });
    }

    @Override
    public MinecraftEntity getOwner()
    {
        return new MinecraftEntity(this.getPlayer());
    }

    @Override
    public void move(String direction) throws InterruptedException
    {
        BlockPos targetPosition = _robot.getPosition();
        switch (direction.toLowerCase())
        {
            case "north":
                targetPosition = targetPosition.north();
                break;
            case "south":
                targetPosition = targetPosition.south();
                break;
            case "east":
                targetPosition = targetPosition.east();
                break;
            case "west":
                targetPosition = targetPosition.west();
                break;
            default:
                say(String.format("Unknown direction '%s'!", direction));
                return;
        }
        
        navigateToBlock(targetPosition);
    }

    @Override
    public String toString()
    {
        return this._robot.getName();
    }

    @Override
    public double getHealth()
    {
        return this._robot.getHealth();
    }

    @Override
    public void mine(String direction) throws InterruptedException
    {
    	mine(direction, 0);
    }
    
    private void mine(String direction, int yModifier) throws InterruptedException
    {
        BlockPos targetBlockPosition = _robot.getPosition();
        if (yModifier != 0)
        	targetBlockPosition = targetBlockPosition.add(0, yModifier, 0);
        
        switch (direction)
        {
            case "down":
                targetBlockPosition = targetBlockPosition.down();
                break;
            case "up":
                targetBlockPosition = targetBlockPosition.up(2);
                break;
            case "north":
                faceAndMine((targetBlockPosition = targetBlockPosition.north()));
                break;
            case "south":
                faceAndMine((targetBlockPosition = targetBlockPosition.south()));
                break;
            case "east":
                faceAndMine((targetBlockPosition = targetBlockPosition.east()));
                break;
            case "west":
                faceAndMine((targetBlockPosition = targetBlockPosition.west()));
                break;
            default:
                say(String.format("Unknown direction '%s'!", direction));
                return;
        }
        
        if (!direction.equals("up") && !direction.equals("down"))
            targetBlockPosition = targetBlockPosition.up();
        
        faceAndMine(targetBlockPosition);
    }
    
    private void faceAndMine(BlockPos position) throws InterruptedException
    {
        if (_world.isAirBlock(position))
            return;
        
        // face(position);
        mineBlock(position);
    }

    private void mineBlock(BlockPos position) throws InterruptedException
    {
        boolean blockDestroyed = (boolean) executeOnTick(() ->
        {
            if (_world.getBlockState(position).getBlock() == Blocks.BEDROCK)
                return false;

            return _world.destroyBlock(position, true);
        });

        if (blockDestroyed)
            wait(500.0);
    }

    public void mineBlock(Coordinates position) throws InterruptedException
    {
        if(this.getCoordinates().toBlockPos().getDistance((int)position.getX(), (int)position.getY(), (int)position.getZ()) > 3.0F)
        {
            mineBlock(position.toBlockPos());
        }
    }

    public EntityRobot getRobot()
    {
        return this._robot;
    }

    public boolean queueEvent(Method invokeMethod, Object[] args)
    {
        return getEventQueue().offer(new EventInvocation(invokeMethod, args));
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof ProgramBase)
        {
            ProgramBase other = (ProgramBase) obj;

            return this.getRobot().equals(other.getRobot());
        }
        else if (obj instanceof Entity)
        {
            Entity other = (Entity) obj;

            return this.getRobot().equals(other);
        }

        return false;
    }

    public boolean queueEvent(MethodDeclarationNode methodDeclaration, Object[] args)
    {
        return getInterpretedEventQueue().offer(new EventInvocationRequest(methodDeclaration, Arrays.asList(args)));
    }
}
