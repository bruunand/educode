package com.educode.runtime.types;

/**
 * Created by zen on 4/18/17.
 */
public interface ICoordinates extends IBase
{
    double getX();
    double getY();
    double getZ();

    void setX(double value);
    void setY(double value);
    void setZ(double value);

    double distanceTo(Coordinates coords);
}
