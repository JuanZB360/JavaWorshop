package FigurasGeometricas;

public class Triangulo extends Figura{

    //Atributo
    double base;
    double altura;

    //Constructor
    public Triangulo(){}

    public Triangulo(double base, double altura){
        this.base = base;
        this.altura = altura;
    }

    //Getter
    public double getBase(){
        return base;
    }

    public double getAltura(){
        return altura;
    }

    //Setter

    public void setBase(double base){
        this.base = base;
    }

    public void setAltura(double altura){
        this.altura = altura;
    }

    //Metodo

    @Override
    public void calcularArea() {
        double area = (base * altura) / 2;
        System.out.println("El area del triangulo es: " + area);
    }
}
