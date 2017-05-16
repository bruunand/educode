package com.educode.types;

import com.educode.helper.InterfaceConverter;
import com.educode.runtime.types.*;
import com.educode.symboltable.SymbolTable;

/**
 * Created by zen on 3/10/17.
 */
public class Type
{
    private Type _childType = null;
    private final byte _kind;

    public static final byte VOID = 0, BOOL = 1, NUMBER = 2, COORDINATES = 3, STRING = 4, ERROR = 5, ENTITY = 6, COLLECTION = 7, ROBOT = 8, ITEM = 9;

    private static SymbolTable _primitiveSymbolTable, _baseSymbolTable, _collectionSymbolTable, _entitySymbolTable, _robotSymbolTable, _coordinatesSymbolTable, _itemSymbolTable, _stringSymbolTable;

    static
    {
        // Initialize default types
        VoidType = new Type(VOID);
        BoolType = new Type(BOOL);
        NumberType = new Type(NUMBER);
        CoordinatesType = new Type(COORDINATES);
        StringType = new Type(STRING);
        EntityType = new Type(ENTITY);
        RobotType = new Type(ROBOT);
        ItemType = new Type(ITEM);
        Error = new Type(ERROR);

        // Create primitive symbol table
        _primitiveSymbolTable = new SymbolTable(null);

        // Construct symbol tables from interfaces
        _baseSymbolTable        = InterfaceConverter.getSymbolTableFromClass(null, IBase.class);
        _coordinatesSymbolTable = InterfaceConverter.getSymbolTableFromClass(_baseSymbolTable, ICoordinates.class);
        _collectionSymbolTable  = InterfaceConverter.getSymbolTableFromClass(_baseSymbolTable, ICollection.class);
        _entitySymbolTable      = InterfaceConverter.getSymbolTableFromClass(_baseSymbolTable, IEntity.class);
        _itemSymbolTable        = InterfaceConverter.getSymbolTableFromClass(_baseSymbolTable, IItem.class);
        _stringSymbolTable      = InterfaceConverter.getSymbolTableFromClass(_baseSymbolTable, IString.class);
        _robotSymbolTable       = InterfaceConverter.getSymbolTableFromClass(_entitySymbolTable, IRobot.class);
    }

    public Type(byte kind)
    {
        this._kind = kind;
    }

    // Constructor for creation of new collection types
    public Type(Type child)
    {
        this(COLLECTION);
        this._childType = child;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o instanceof Type)
        {
            Type otherType = (Type) o;

            if (otherType._kind == this._kind)
            {
                if (this.getChildType() != null && otherType.getChildType() != null)
                    return this.getChildType().equals(otherType.getChildType());
                else
                    return true;
            }
        }

        return false;
    }

    public byte getKind()
    {
        return this._kind;
    }

    public Type getChildType()
    {
        return this._childType;
    }

    public boolean isReferenceType()
    {
        return this._kind == COLLECTION || this._kind == ENTITY || this._kind == ROBOT || this._kind == ITEM;
    }

    // Special types are ones that cannot be instantiated or assigned to
    public boolean isSpecialType()
    {
        return this._kind == ROBOT || this._kind == VOID || this._kind == ERROR;
    }

    public SymbolTable getSymbolTable()
    {
        // Some types have special symbol tables
        // In other cases, we return the base symbol table

        if (this.equals(Type.EntityType))
            return _entitySymbolTable;
        else if (this.equals(Type.RobotType))
            return _robotSymbolTable;
        else if (this.equals(Type.CoordinatesType))
            return _coordinatesSymbolTable;
        else if (this.equals(Type.ItemType))
            return _itemSymbolTable;
        else if (this.equals(Type.StringType))
            return _stringSymbolTable;
        else if (this.isCollection())
        {
            // _doesReturn a temporary symbol table derived from collectionSymbolTable
            // This method has methods that are specific to the child type of the collection

            SymbolTable tempTable = new SymbolTable(_collectionSymbolTable);
            tempTable.addDefaultMethod("addItem", Type.VoidType, this.getChildType());

            return tempTable;
        }

        return _baseSymbolTable;
    }

    public boolean isCollection()
    {
        return this._kind == COLLECTION;
    }

    @Override
    public String toString()
    {
        switch (_kind)
        {
            case Type.NUMBER:
                return "NUMBER";
            case Type.STRING:
                return "STRING";
            case Type.BOOL:
                return "BOOLEAN";
            case Type.COORDINATES:
                return "COORDINATES";
            case Type.VOID:
                return "VOID";
            case Type.ERROR:
                return "ERROR";
            case Type.ENTITY:
                return "ENTITY";
            case Type.COLLECTION:
                return "COLLECTION<" + this.getChildType() + ">";
            case Type.ROBOT:
                return "ROBOT";
            case Type.ITEM:
                return "ITEM";
            default:
                return "UNDEFINED"; // Should not happen
        }
    }

    public static final Type VoidType;
    public static final Type BoolType ;
    public static final Type NumberType;
    public static final Type CoordinatesType;
    public static final Type StringType;
    public static final Type EntityType;
    public static final Type RobotType;
    public static final Type ItemType;
    public static final Type Error;
}
