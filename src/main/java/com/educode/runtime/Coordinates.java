package com.educode.runtime;

import net.minecraft.util.math.BlockPos;

/**
 * Created by Andreas on 12-04-2017.
 */
public class Coordinates implements ICoordinates
{
    private float _x;
    private float _y;
    private float _z;

    public Coordinates(float x, float y, float z)
    {
        this._x = x;
        this._y = y;
        this._z = z;
    }

    public Coordinates(BlockPos pos)
    {
        this._x = pos.getX();
        this._y = pos.getY();
        this._z = pos.getZ();
    }

    public BlockPos toBlockPos()
    {
        return new BlockPos(_x, _y, _z);
    }

    @Override
    public float getX()
    {
        return this._x;
    }

    @Override
    public float getY()
    {
        return this._y;
    }

    @Override
    public float getZ()
    {
        return this._z;
    }

    @Override
    public void setX(float value)
    {
        this._x = value;
    }

    @Override
    public void setY(float value)
    {
        this._y = value;
    }

    @Override
    public void setZ(float value)
    {
        this._z = value;
    }

    public String toString()
    {
        return String.format("X: %f, Y: %f, Z: %f", getX(), getY(), getZ());
    }

}