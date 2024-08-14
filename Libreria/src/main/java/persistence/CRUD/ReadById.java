package persistence.CRUD;

import java.util.ArrayList;

public interface ReadById<A,T>{
    public A readById (T value) throws ClassNotFoundException;
}
