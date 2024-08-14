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
    public Boolean Delete(BookEntity entity) throws ClassNotFoundException {
        return this.bookController.delete(entity);
    }
    //Update
    public BookEntity Update(BookEntity entity) throws ClassNotFoundException {
        return this.bookController.update(entity);
    }
    //read all
    public ArrayList<BookEntity> ReadAll() throws ClassNotFoundException {
        return this.bookController.readAll();
    }
    //read by id
    public ArrayList<BookEntity> ReadById(BookEntity entity) throws ClassNotFoundException {
        return this.bookController.readById(entity);
    }
}