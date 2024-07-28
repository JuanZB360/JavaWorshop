package RegistroEmpleados;

public class EmpleadoPermanente extends Empleado{
    //Atributos
    private String Permanente;

    //Constructor
    public EmpleadoPermanente(int id,String nombre, int edad, float salario) {
        super(id, nombre, edad, salario);
        this.Permanente = "Contrato Permanente";
    }

    //Metodo

    @Override
    public String toString() {
        return "id: "+ getIdEmpleado() +"| Nombre: " + getNombre() + "| Edad: " + getEdad() + "| Salario: " + getSalario() + " | Contrato: " + Permanente + "| \n";
    }
}
