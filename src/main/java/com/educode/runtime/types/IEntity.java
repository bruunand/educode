package com.educode.runtime.types;

/**
 * Created by zen on 4/18/17.
 */
public interface IEntity extends IBase
{
    Coordinates getCoordinates();
    double getHealth();
    boolean isRobot();
    boolean isPlayer();
}
