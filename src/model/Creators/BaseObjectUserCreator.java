package model.Creators;

import exceptions.CreateObjectException;

public interface BaseObjectUserCreator<T> {
    public T create () throws CreateObjectException;
}
