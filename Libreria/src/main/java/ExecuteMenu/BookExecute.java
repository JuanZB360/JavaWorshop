package ExecuteMenu;

import Util.Utils;
import controller.AuthorController;
import controller.BookController;
import entity.AuthorEntity;
import entity.BookEntity;

import javax.swing.*;
import java.util.ArrayList;

public class BookExecute {
    public static void BookMenu() throws ClassNotFoundException {
        BookController bookController = new BookController();
        AuthorController authorController = new AuthorController();
        BookEntity request = new BookEntity();


        boolean session = true;
        while(session){
//            String message = JOptionPane.showMessageDialog(null,);
            int option = Utils.integer("MENU:\n\t1- Crear un libro.\n\t2- Mostrar todos los libros.\n\t3- Buscar un libro.\n\t4- Actualizar libro.\n\t5- Eliminar libro.\n\t6- Salir.");

            switch (option) {
                case 1:
                    //create
                    String name = Utils.string("Ingresa el nombre: ");
                    String age = Utils.string("Ingresa la año: ");
                    float price = Utils.decimal("Ingresa el precio: ");
                    int authorId = 0;
                    while(true) {
                        try {
                            authorId = Utils.integer("Ingresa el Id del autor: ");
                            AuthorEntity checkAuthor = new AuthorEntity(authorId);
                            AuthorEntity checkAuthorresponse = new AuthorEntity();
                            checkAuthorresponse = authorController.ReadById(checkAuthor);
                            BookEntity book = new BookEntity(name, age, price, checkAuthorresponse.getId());
                            request = bookController.Create(book);
                            break;
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null,"El author no existe...");
                        }
                    }

                    JOptionPane.showMessageDialog(null, "Libro creado con éxito:\n " + request);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Lista de libros:\n"+bookController.ReadAll());
                    break;
                case 3:
                    //read by id
                    ArrayList<BookEntity> list = new ArrayList<>();
                    BookEntity readByBook = new BookEntity();

                    option = Utils.integer("1- Buscar por Id.\n2- Buscar por nombre.\n3- Buscar por Autor.");
                    switch (option) {
                        case 1:
                            int idReadByid = Utils.integer("Ingresa el Id del libro que deseas buscar: ");
                            readByBook.setId(idReadByid);
                            break;
                        case 2:
                            String titleRead = Utils.string("Ingresa el nombre del libro que deseas buscar: ");
                            readByBook.setTitle(titleRead);
                            break;
                        case 3:
                            int authorIdread = Utils.integer("Ingresa el Id del autor del libro que deseas buscar: ");
                            readByBook.setAuthor(authorIdread);
                            break;
                    }

                    list = bookController.ReadById(readByBook);
                    if(list.size() > 0) {
                        JOptionPane.showMessageDialog(null, "Autor leído:\n " + list);
                    }else{
                        JOptionPane.showMessageDialog(null, "No se Encontro el libro que buscabas.");
                    }
                    break;
                case 4:
                    //Update
                    ArrayList<BookEntity> listUpdate = new ArrayList<>();
                    int intUpdate = Utils.integer("Ingresa el Id del libro que deseas Actualizar: ");
                    BookEntity update = new BookEntity(intUpdate);
                    listUpdate = bookController.ReadById(update);
                    if(listUpdate.size() > 0) {
                        String titleUpdate = Utils.string("Title: ");
                        String ageUpdate = Utils.string("Año: ");
                        float priceUpdate = Utils.decimal("Precio: ");
                        int authorIdUpdate = Utils.integer("Id del autor: ");
                        update.setTitle(titleUpdate);
                        update.setAge(ageUpdate);
                        update.setPrice(priceUpdate);
                        update.setAuthor(authorIdUpdate);
                        request = bookController.Update(update);
                        JOptionPane.showMessageDialog(null, "Libro actualizado con éxito:\n " + request);
                    }else{
                        JOptionPane.showMessageDialog(null, "El libro no existe.");
                    }
                    break;
                case 5:
                    //delete
                    int idDelete = Utils.integer("Ingresa el Id del libro: ");
                    BookEntity delete = new BookEntity(idDelete);
                    ArrayList<BookEntity> listDelete = new ArrayList<>();
                    listDelete = bookController.ReadById(delete);
                    if(listDelete.size() > 0) {
                        boolean response = bookController.Delete(delete);
                        if (response) {
                            JOptionPane.showMessageDialog(null, "Delete Complete...");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"El libro que deseas eliminar no existe en la base de datos...");
                    }
                    break;
                case 6:
                    session = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Option Incorrect...");
                    break;
            }
        }
    }
}
