package persistence.IModel;

import entity.BookEntity;
import persistence.CRUD.*;

import java.awt.print.Book;
import java.util.ArrayList;

public interface IBookModel  extends    Create<BookEntity>,
                                        Update<BookEntity>,
                                        Delete<Boolean, BookEntity>,
                                        ReadAll<BookEntity>,
                                        ReadById<ArrayList<BookEntity>,BookEntity> {}
