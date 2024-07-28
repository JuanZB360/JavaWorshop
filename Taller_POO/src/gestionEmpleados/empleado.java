package gestionEmpleados;

public class empleado {

    // Atributos
    private String name;
    private String position;
    private float salary;
    private final int id;
    private static int idEmployee;

    // Constructor

    public empleado() {
        this.id = idEmployee++;
    }

    // Getter

    public String getName() {
        return this.name;
    }

    public String getPosition() {
        return this.position;
    }

    public float getSalary() {
        return this.salary;
    }

    public int getId() {
        return this.id;
    }

    // Setter

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    // Metodos

    public void increaseSalary(float percentage) {
        float increase = (percentage / 100) * this.salary;
        this.salary += increase;
    }

    // sobre escritura de toString

    @Override
    public String toString() {
        return "Id: " + this.id + ", Empleado: " + this.name + ", Puesto: " + this.position + ", Salario: $" + this.salary;
    }

}
