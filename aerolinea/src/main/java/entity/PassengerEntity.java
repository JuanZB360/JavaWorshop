package entity;

public class PassengerEntity {
    //attributes
    private int id;
    private String name;
    private String lastName;
    private String documentId;

    //constructor
    public PassengerEntity() {}

    public PassengerEntity(int id) {
        this.id = id;
    }

    public PassengerEntity(String name, String lastName, String documentId) {
        this.name = name;
        this.lastName = lastName;
        this.documentId = documentId;
    }

    public PassengerEntity(int id, String name, String lastName, String documentId) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.documentId = documentId;
    }

    //getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDocumentId() {
        return documentId;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    //method
    @Override
    public String toString() {
        return  "| id: " + id +
                "| Nombre: " + name +
                "| Apellido: " + lastName +
                "| Documento: " + documentId + " |\n";
    }
}
