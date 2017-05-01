package com.educode.runtime.types;

import com.educode.runtime.types.ICoordinates;
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

    /* Not defined in interface because it should only be accessed with the additive operators */
    public Coordinates add(Coordinates other, boolean subtract)
    {
        int multiplier = subtract ? -1 : 1;

        float x = this.getX() + other.getX() * multiplier;
        float y = this.getY() + other.getY() * multiplier;
        float z = this.getZ() + other.getZ() * multiplier;

        return new Coordinates(x, y, z);
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

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Coordinates)
        {
            Coordinates coords = (Coordinates) obj;
            return this.getX() == coords.getX() && this.getY() == coords.getY() && this.getZ() == coords.getZ();
        }

        return false;
    }
}