package com.educode.runtime.types;

import javax.swing.text.html.parser.Entity;
import java.util.List;

/**
 * Created by zen on 4/18/17.
 */
public interface IRobot extends IEntity
{
    void dropItems(ExtendedCollection<ExtendedCollection<Float>> e);
    void say(String text);
    void wait(float time);
    void move(String direction);
    void mine(String direction);
    void setWorldTime(float time);
    void explode(float strength);
    void walkTo(Coordinates coords);
    boolean attack(MinecraftEntity entity);
    float dropInventoryItem(String name, float quantity);
    float getDistanceTo(MinecraftEntity entity);
    MinecraftEntity getOwner();
    ExtendedCollection<MinecraftEntity> getNearbyEntities();
}
