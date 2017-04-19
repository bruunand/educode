package com.educode.runtime;

/**
 * Created by User on 18-Apr-17.
 */
public interface ICollection<E>
{
    // add is not here because it is a part of the list interface
    ExtendedCollection<ExtendedCollection<Float>> test();
    void removeAt(float index);
    E getItemAt(float index);
    void addItem(E item);
    float getSize();
}
