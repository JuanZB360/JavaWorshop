package FigurasGeometricas;

public class Cuadrado extends Figura {
    //Atributos
    private double lado;

    // Constructor

    public Cuadrado() {}

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    // Getter

    public double getLado() {
        return this.lado;
    }

    //Setter

    public void setLado(double lado) {
        this.lado = lado;
    }

    // Metodo

    @Override
    public void calcularArea() {
        double area = this.lado * lado;
        System.out.println("El area del cuadrado es: " + area);
    }
}
