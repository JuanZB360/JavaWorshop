package persistence.IModel;

import entity.BookEntity;
import persistence.CRUD.*;

import java.awt.print.Book;

public interface IBookModel  extends    Create<BookEntity>,
                                        Update<BookEntity>,
                                        Delete<BookEntity>,
                                        ReadAll<BookEntity>,
                                        ReadById<BookEntity> {}
