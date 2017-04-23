package com.educode.runtime;

import com.educode.runtime.types.Coordinates;
import com.educode.runtime.types.IEntity;
import com.educode.runtime.types.MinecraftEntity;

import java.util.List;

/**
 * Created by zen on 4/18/17.
 */
public interface IRobot extends IEntity
{
    void dropItems();
    void say(String text);
    void wait(float time);
    void move(String direction);
    void mine(String direction);
    void setWorldTime(float time);
    void explode(float strength);
    void walkTo(Coordinates coords);
    boolean attack(MinecraftEntity entity);
    boolean placeBlock(Coordinates coordinates);
    float dropItem(String name, float quantity);
    float getDistanceTo(MinecraftEntity entity);
    MinecraftEntity getOwner();
    List<MinecraftEntity> getNearbyEntities();
}
