package com.educode.runtime.types;

/**
 * Created by zen on 4/18/17.
 */
public interface ICoordinates extends IBase
{
    float getX();
    float getY();
    float getZ();

    void setX(float value);
    void setY(float value);
    void setZ(float value);
}
