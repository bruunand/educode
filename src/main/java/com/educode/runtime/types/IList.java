package com.educode.runtime.types;

/**
 * Created by User on 18-Apr-17.
 */
public interface IList
{
    // add is not here because it is a part of the list interface
    void removeItemAt(Double index);
    Object getItemAt(Double index);
    void addItem(Object item);
    Object setItemAt(Double index, Object item);
    double getSize();
}
