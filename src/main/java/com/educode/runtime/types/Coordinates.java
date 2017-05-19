package com.educode.runtime.types;

import com.educode.runtime.types.ICoordinates;
import net.minecraft.util.math.BlockPos;

/**
 * Created by Andreas on 12-04-2017.
 */
public class Coordinates implements ICoordinates
{
    private double _x;
    private double _y;
    private double _z;

    public Coordinates(double x, double y, double z)
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

        double x = this.getX() + other.getX() * multiplier;
        double y = this.getY() + other.getY() * multiplier;
        double z = this.getZ() + other.getZ() * multiplier;

        return new Coordinates(x, y, z);
    }

    /* Not defined in interface because it should only be accessed with unary minus */
    public Coordinates negate()
    {
        double x = this.getX() * -1;
        double y = this.getY() * -1;
        double z = this.getZ() * -1;

        return new Coordinates(x, y, z);
    }

    public BlockPos toBlockPos()
    {
        return new BlockPos(_x, _y, _z);
    }

    @Override
    public double getX()
    {
        return this._x;
    }

    @Override
    public double getY()
    {
        return this._y;
    }

    @Override
    public double getZ()
    {
        return this._z;
    }

    @Override
    public void setX(double value)
    {
        this._x = value;
    }

    @Override
    public void setY(double value)
    {
        this._y = value;
    }

    @Override
    public void setZ(double value)
    {
        this._z = value;
    }

    public String toString()
    {
        return String.format("X: %.2f, Y: %.2f, Z: %.2f", getX(), getY(), getZ());
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