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
    boolean placeBlock(Coordinates coordinates) throws InterruptedException;
    void stop();

    // Communication
    void broadcast(float channel, String message);
    void broadcast(float channel, MinecraftEntity entity);

    // Combat
    boolean attack(MinecraftEntity entity) throws InterruptedException;

    // Movement
    void move(String direction) throws InterruptedException;
    boolean walkTo(Coordinates coords) throws InterruptedException;

    // Mining
    void mine(String direction) throws InterruptedException;
    void mineBlock(Coordinates position) throws InterruptedException;

    // Items
    ExtendedCollection<MinecraftItem> getInventory();
    void dropItems();
    float dropItem(String name, float quantity);
    MinecraftItem getHeldItem();
    void setHeldItem(MinecraftItem item);
    MinecraftItem getItemFromSlot(float index);
}