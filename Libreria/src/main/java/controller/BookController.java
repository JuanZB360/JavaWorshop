package controller;

import entity.BookEntity;
import model.BookModelImpl;
import persistence.IModel.IBookModel;

import java.util.ArrayList;

public class BookController {
    IBookModel bookController = new BookModelImpl();
    //create
    public BookEntity Create(BookEntity entity) throws ClassNotFoundException {
        return this.bookController.create(entity);
    }
    //Delete
    public void Delete(BookEntity entity) throws ClassNotFoundException {
        this.bookController.delete(entity);
    }
    //Update
    public BookEntity Update(BookEntity entity) throws ClassNotFoundException {
        return this.bookController.update(entity);
    }
    //read all
    public ArrayList<BookEntity> ReadAll(BookEntity entity) throws ClassNotFoundException {
        return this.bookController.readAll();
    }
    //read by id
    public BookEntity ReadById(BookEntity entity) throws ClassNotFoundException {
        return this.bookController.readById(entity);
    }
}