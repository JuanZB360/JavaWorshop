package persistence.CRUD;

public interface Create <T>{
    public T create(T entity) throws ClassNotFoundException;
}
