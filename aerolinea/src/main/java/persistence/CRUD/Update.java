package persistence.CRUD;

public interface Update <T>{
    public T update(T entity) throws ClassNotFoundException;
}
