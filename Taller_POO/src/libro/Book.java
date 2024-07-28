package libro;

public class Book {
    // Atributos de la clase libro

    private String title;
    private String author;
    private int year;
    private static boolean rentBook = false;
    private int idBook;
    private static int countBook;


    //Constructor vacio

    public Book(){}

    // Constructor con parametros

    /*public Book(String title, String author, int year){
        this.title = title;
        this.author = author;
        this.year = year;
        this.idBook = countBook++;
    }*/

    // Getters

    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }

    public int getYear(){
        return this.year;
    }

    static boolean getRentBook(){
        return Book.rentBook;
    }

    // Setters

    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setYear(int year){
        this.year = year;
    }

    // Metodo para prestar libros

    public void rentBook(){
        if(!rentBook){
            System.out.println("El libro \"" + this.title + "\" ha sido rentado con exito.");
            rentBook = true;
        } else {
            System.out.println("El libro \"" + this.title + "\" ya está prestado.");
        }
    }

    // metodo para regresar un libro

    public void returnBook(){
        if(rentBook){
            System.out.println("El libro \"" + this.title + "\" ha sido devuelto.");
            rentBook = false;
        } else {
            System.out.println("El libro \"" + this.title + "\" no esta rentado.");
        }
    }

    // sobre escritura del metodo object toString

    @Override
    public String toString() {
        return "Libro: " + this.title + ", Autor: " + this.author + ", Año: " + this.year;
    }

}
