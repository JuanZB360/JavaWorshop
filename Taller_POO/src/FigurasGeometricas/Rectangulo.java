package FigurasGeometricas;

public class Rectangulo extends Figura{
    //Atributo
    private double base;
    private double altura;

    //Constructor
    public Rectangulo() {}

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    //Getter
    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    //Setter

    public void setBase(double base) {
        this.base = base;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    //Metodo
    @Override
    public void calcularArea() {
        double area = base * altura;
        System.out.println("El area del rectangulo es: " + area);
    }
}
