package RegistroEmpleados;
import java.util.ArrayList;

public class GestionEmpleados {
    //Atributos
    private final ArrayList<Empleado> empleados ;

    // Constructor
    public GestionEmpleados() {
        this.empleados = new ArrayList<>();
    }

    // Metodos
    public void agragarEmpleado(Empleado ingreso) {
        empleados.add(ingreso);
    }

    public void eliminarEmpleado(int id) {
        for(Empleado empleado : empleados){
            if(empleado.getIdEmpleado() == id){
                empleados.remove(empleado);
            }
        }
    }

    public void mostrarEmpleados() {
        System.out.println(empleados);
    }
}
