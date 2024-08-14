package persistence.CRUD;

public interface Create <T> {
    public T create(T value) throws ClassNotFoundException;
}
