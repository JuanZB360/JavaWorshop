package RegistroEmpleados;

public class EmpleadoTemporal extends Empleado{
    //Atributos
    private String temporal;

    // Constructor
    public EmpleadoTemporal(int id, String nombre, int edad, float salario) {
        super(id, nombre, edad, salario);
        this.temporal = "Contrato Temporal";
    }

    //Métodos

    @Override
    public String toString() {
        return "id: "+ getIdEmpleado() +" | Nombre: " + getNombre() + " | Edad: " + getEdad() + " | Salario: " + getSalario() + " | contrato: " + temporal + "| \n";
    }
}
