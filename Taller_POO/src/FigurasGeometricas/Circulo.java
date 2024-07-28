package FigurasGeometricas;

public class Circulo extends Figura {
    //atributos
    private double radio;

    //Constructor
    public Circulo () {}

    //constructor con radio
    public Circulo(float radio){
        this.radio = radio;
    }

    //getter
    public double getRadio() {
       return radio;
    }

    //setter
    public void setRadio(double radio) {
      this.radio = radio;
    }

    //metodo
    @Override
    public void calcularArea() {
        double Area = this.radio * Math.PI;
        System.out.println("El área del círculo es: " + Area);
    }
}
