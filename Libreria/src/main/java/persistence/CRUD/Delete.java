package persistence.CRUD;

public interface Delete <T>{
    public void delete(T entity) throws ClassNotFoundException;
}
