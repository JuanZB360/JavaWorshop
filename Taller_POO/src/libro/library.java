package libro;
import java.util.ArrayList;
import java.util.Scanner;

public class library {
    public static void main(String[] args) {

        // instaciar Scanner

        Scanner scanner = new Scanner(System.in);

        //creacion de lista para almacenar los libros

        ArrayList<Book> library = new ArrayList<>();

        boolean validate = true;

        while(validate) {

            //menu para crear, rentar y devolver libros

            System.out.println("Menu Bliblioteca:\n\t1- Crear Nuevo Libro.\n\t2- Buscar Libro\n\t3- Rentar Libro.\n\t4-Devolver Libro.\n\t5- Mostrar Todos los Libros.\n\t6- Salir");
            System.out.print("\tIngresa tu eleccion:\t");
            int option = scanner.nextInt();
            scanner.nextLine();
            System.out.println("\n");
            switch (option) {
                case 1:
                    while(true) {
                        //instanciar la claseBook

                        var createbook = new Book();

                        //Crear Libro
                        System.out.print("Ingresa el Titulo del Libro:\t");
                        String title = scanner.nextLine();
                        System.out.print("Ingresa el Nombre del autor:\t");
                        String author = scanner.nextLine();
                        System.out.print("Ingresa el Año de Publicacion:\t");
                        int year = scanner.nextInt();
                        System.out.println("\n");

                        createbook.setTitle(title);
                        createbook.setAuthor(author);
                        createbook.setYear(year);
                        library.add(createbook);

                        System.out.print("Desea crear otro libro? (Si/No)\t");
                        scanner.nextLine();
                        String answer = scanner.nextLine();

                        if (answer.equalsIgnoreCase("no")) {
                            break;
                        }
                        System.out.println("\n");

                    }
                    break;

                case 2:
                    System.out.println("Buscar Libro: ");

                    System.out.print("Ingresa el Título del Libro:\t");
                    String searchBook = scanner.nextLine();
                    System.out.print("Ingresa el Nombre del Autor:\t");
                    String searchAuthor = scanner.nextLine();
                    System.out.println("\n");

                    for(Book book : library) {
                        int a = 0;
                        a++;
                        if (book.getTitle().equalsIgnoreCase(searchBook) && book.getAuthor().equalsIgnoreCase(searchAuthor)) {
                            System.out.println("Libro Encontrado:");
                            System.out.println(book);
                            break;
                        } else if (a == library.size()) {
                            System.out.println("Libro no Encontrado.");
                        }
                    }

                    break;

                case 3:

                    System.out.println("Renta de libro");

                    System.out.print("Ingresa el nombre del libro:\t");
                    String searchBookRent = scanner.nextLine();
                    System.out.print("Ingresa el nombre del autor:\t");
                    String searchAuthorRent = scanner.nextLine();

                    for(Book book : library) {
                        if(book.getTitle().equalsIgnoreCase(searchBookRent) && book.getAuthor().equalsIgnoreCase(searchAuthorRent)) {
                            book.rentBook();
                        }
                    }
                    break;

                case 4:

                    System.out.println("Devolver libro");

                    System.out.print("Ingresa el nombre del libro:\t");
                    String searchBookReturn = scanner.nextLine();
                    System.out.print("Ingresa el nombre del autor:\t");
                    String searchAuthorReturn = scanner.nextLine();

                    for(Book book : library) {

                        if(book.getTitle().equalsIgnoreCase(searchBookReturn) && book.getAuthor().equalsIgnoreCase(searchAuthorReturn)) {
                            book.returnBook();
                        }
                    }
                    break;

                case 5:

                    for(Book book : library) {
                        System.out.println(book);
                    }
                    scanner.nextLine();

                default:
                    break;

            }

            if(option == 6) {
                validate = false;
            }

            System.out.print("\n");

        }
    }
}
