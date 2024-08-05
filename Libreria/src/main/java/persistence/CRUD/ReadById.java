package persistence.CRUD;

import java.util.ArrayList;

public interface ReadById<T>{
    public T readById (T value) throws ClassNotFoundException;
}
