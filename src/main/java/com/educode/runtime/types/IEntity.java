package com.educode.runtime.types;

/**
 * Created by zen on 4/18/17.
 */
public interface IEntity extends IBase
{
    Coordinates getCoordinates();
    float getHealth();
    boolean isRobot();
    boolean isPlayer();
    float getX();
    float getY();
    float getZ();
}
