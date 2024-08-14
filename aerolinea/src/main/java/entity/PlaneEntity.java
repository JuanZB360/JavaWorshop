package entity;

public class PlaneEntity {
    //attribute
    private int id;
    private String model;
    private int capacity;

    //constructor
    public PlaneEntity(){}

    public PlaneEntity(int id){
        this.id = id;
    }

    public PlaneEntity(String model, int capacity) {
        this.model = model;
        this.capacity = capacity;
    }

    public PlaneEntity(int id, String model, int capacity){
        this.id = id;
        this.model = model;
        this.capacity = capacity;
    }

    //getters
    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getCapacity() {
        return capacity;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    //method


    @Override
    public String toString() {
        return  "| id: " + id +
                "| modelo: " + model +
                "| capacidad: " + capacity +" |\n ";
    }
}
