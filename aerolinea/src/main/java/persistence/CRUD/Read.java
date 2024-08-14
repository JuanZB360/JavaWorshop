package persistence.CRUD;

import java.util.ArrayList;

public interface Read <T> {
    public ArrayList<T> read(T value) throws ClassNotFoundException;
}
