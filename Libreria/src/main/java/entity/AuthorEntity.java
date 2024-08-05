package entity;

public class AuthorEntity {
    //Atributos
    private int id;
    private String name;
    private String nationality;

    //Constructor
    public AuthorEntity(){}

    public AuthorEntity(int id, String name, String nationality) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
    }

    public AuthorEntity(String name, String nationality) {
        this.name = name;
        this.nationality = nationality;
    }

    public AuthorEntity(int id) {
        this.id = id;
    }

    //Getters y Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    //ToString

    @Override
    public String toString() {
        return "| id: " + id + " | " +
                " name: " + name + " | " +
                " nationality: " + nationality + " |\n";
    }
}
