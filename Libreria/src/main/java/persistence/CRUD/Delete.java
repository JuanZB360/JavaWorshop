package persistence.CRUD;

public interface Delete <A,T>{
    public A delete(T entity) throws ClassNotFoundException;
}
