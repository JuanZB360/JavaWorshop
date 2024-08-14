package persistence.CRUD;

public interface ReadUnique <T> {
    public T readUnique(T request) throws ClassNotFoundException;
}
