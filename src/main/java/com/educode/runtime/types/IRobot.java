package com.educode.runtime.types;

import javax.swing.text.html.parser.Entity;
import java.util.List;

/**
 * Created by zen on 4/18/17.
 */
public interface IRobot extends IEntity
{
    // General
    void say(String text);
    void explode(float strength);
    void setWorldTime(float time);
    MinecraftEntity getOwner();
    List<MinecraftEntity> getNearbyEntities();
    float getDistanceTo(MinecraftEntity entity);
    boolean placeBlock(Coordinates coordinates);

    // Combat
    boolean attack(MinecraftEntity entity);

    // Movement
    void move(String direction);
    boolean walkTo(Coordinates coords);

    // Mining
    void mine(String direction);
    void mineBlock(Coordinates position);

    // Items
    ExtendedCollection<MinecraftItem> getInventory();
    void dropItems();
    float dropItem(String name, float quantity);
    MinecraftItem getHeldItem();
    void setHeldItem(MinecraftItem item);
    MinecraftItem getItemFromSlot(float index);
}