package com.educode.runtime;

import net.minecraft.util.math.BlockPos;

/**
 * Created by Andreas on 12-04-2017.
 */
public class Coordinates
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

    public float getX()
    {
        return this._x;
    }

    public float getY()
    {
        return this._y;
    }

    public float getZ()
    {
        return this._z;
    }

    /*TODO: skulle have nogle metoder*/

}