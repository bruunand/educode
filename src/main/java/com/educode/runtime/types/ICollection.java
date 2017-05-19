package com.educode.runtime.types;

/**
 * Created by User on 18-Apr-17.
 */
public interface ICollection<E>
{
    // add is not here because it is a part of the list interface
    void removeItemAt(double index);
    E getItemAt(double index);
    void addItem(E item);
    E setItemAt(double index, E item);
    double getSize();
}
