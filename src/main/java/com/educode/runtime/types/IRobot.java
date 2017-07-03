package com.educode.runtime.types;

import java.util.List;

/**
 * Created by zen on 4/18/17.
 */
public interface IRobot extends IEntity
{
    // General
    String getProgramName();
    void say(String text) throws InterruptedException;
    void explode(double strength) throws InterruptedException;
    void setWorldTime(double time) throws InterruptedException;
    MinecraftEntity getOwner();
    List<MinecraftEntity> getNearbyEntities() throws InterruptedException;
    double getDistanceTo(MinecraftEntity entity);
    boolean placeBlock(Coordinates coordinates) throws InterruptedException;
    void stop() throws InterruptedException;

    // Communication
    void broadcast(double channel, String message);
    void broadcast(double channel, MinecraftEntity entity);

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
    double dropItem(String name, double quantity) throws InterruptedException;
    MinecraftItem getHeldItem();
    void setHeldItem(MinecraftItem item) throws InterruptedException;
    MinecraftItem getItemFromSlot(double index);
}