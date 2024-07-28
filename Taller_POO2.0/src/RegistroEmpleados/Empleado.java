package RegistroEmpleados;

public class Empleado extends Persona{
    //Atributos
    private int idEmpleado;
    private float salario;

    //Constructor
    public Empleado(int id,String nombre, int edad, float salario) {
        super(nombre, edad);
        this.idEmpleado = id;
        this.salario = salario;
    }

    //Getters y Setters
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    //Métodos

    @Override
    public String toString() {
        return "idEmpleado=" + idEmpleado +
                ", salario=" + salario +"| ";
    }
}
