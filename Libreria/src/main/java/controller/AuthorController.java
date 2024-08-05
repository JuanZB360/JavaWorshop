package controller;

import entity.AuthorEntity;
import model.AuthorModelImpl;
import persistence.IModel.IAuthorModel;

import javax.swing.*;
import java.util.ArrayList;

public class AuthorController {

    IAuthorModel authorModel = new AuthorModelImpl();

    //create
    public AuthorEntity CreateAuthor (AuthorEntity entity) throws ClassNotFoundException {
        return this.authorModel.create(entity);
    }
    //delete
    public void DeleteAuthor(AuthorEntity entity) throws ClassNotFoundException {
        this.authorModel.delete(entity);
    }
    //read by id
    public AuthorEntity ReadById (AuthorEntity entity) throws ClassNotFoundException {
        return this.authorModel.readById(entity);
    }
    //read all
    public ArrayList<AuthorEntity> ReadAll() throws ClassNotFoundException {
        return this.authorModel.readAll();
    }
    //Update
    public AuthorEntity UpdateAuthor(AuthorEntity entity) throws ClassNotFoundException {
        return this.authorModel.update(entity);
    }

}
