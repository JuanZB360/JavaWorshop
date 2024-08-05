package persistence.CRUD;

import entity.AuthorEntity;

public interface Update <T> {
    public T update(T entity) throws ClassNotFoundException;
}
