package com.educode.runtime.types;

/**
 * Created by zen on 4/18/17.
 */
public interface IRobot extends IEntity
{
    // General
    String getProgramName();
    void say(String text) throws InterruptedException;
    void explode(Double strength) throws InterruptedException;
    void setWorldTime(Double time) throws InterruptedException;
    MinecraftEntity getOwner();
    ExtendedList<MinecraftEntity> getNearbyEntities() throws InterruptedException;
    Double getDistanceTo(MinecraftEntity entity);
    boolean placeBlock(Coordinates coordinates) throws InterruptedException;
    void stop() throws InterruptedException;

    // Communication
    void broadcast(Double channel, String message);
    void broadcast(Double channel, MinecraftEntity entity);

    // Combat
    boolean attack(MinecraftEntity entity) throws InterruptedException;

    // Movement
    void move(String direction) throws InterruptedException;
    boolean walkTo(Coordinates coords) throws InterruptedException;

    // Mining
    void mine(String direction) throws InterruptedException;
    void mineBlock(Coordinates position) throws InterruptedException;

    // Items
    ExtendedList<MinecraftItem> getInventory();
    void dropItems() throws InterruptedException;
    Double dropItem(String name, Double quantity) throws InterruptedException;
    MinecraftItem getHeldItem();
    void setHeldItem(MinecraftItem item) throws InterruptedException;
    MinecraftItem getItemFromSlot(Double index);
}