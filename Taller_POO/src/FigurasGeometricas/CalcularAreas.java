package FigurasGeometricas;
import java.util.Scanner;

public class CalcularAreas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean calcular =true;
        while (calcular) {

            System.out.println("Menu:\n\tA que figura deseas calcularle el area:\n\t1- Circulo\n\t2- Cuadrado\n\t3- Rectangulo\n\t4- Triangulo\n\t5- Salir");
            System.out.print("\tIngresa tu elección:\t");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    Circulo circulo = new Circulo();
                    System.out.println("*** Area del Circulo ***");
                    System.out.print("Ingresa el radio del circulo: ");
                    double radio = scanner.nextDouble();
                    circulo.setRadio(radio);
                    circulo.calcularArea();
                    break;
                case 2:
                    Cuadrado cuadrado = new Cuadrado();
                    System.out.println("*** Area del Cuadrado ***");
                    System.out.print("Ingresa el lado del cuadrado: ");
                    double ladoCuadrado = scanner.nextDouble();
                    cuadrado.setLado(ladoCuadrado);
                    cuadrado.calcularArea();
                    break;
                case 3:
                    Rectangulo rectangulo = new Rectangulo();
                    System.out.println("*** Area del Rectangulo ***");
                    System.out.print("Ingresa la base del rectangulo: ");
                    double baseRectangulo = scanner.nextDouble();
                    rectangulo.setBase(baseRectangulo);
                    System.out.print("Ingresa la altura del rectangulo: ");
                    double alturaRectangulo = scanner.nextDouble();
                    rectangulo.setAltura(alturaRectangulo);
                    rectangulo.calcularArea();
                    break;
                case 4:
                    Triangulo triangulo = new Triangulo();
                    System.out.println("*** Area del Triangulo ***");
                    System.out.print("Ingresa la base del Triangulo: ");
                    double baseTriangulo = scanner.nextDouble();
                    triangulo.setBase(baseTriangulo);
                    System.out.print("Ingresa la altura del rectangulo: ");
                    double alturaTriangulo = scanner.nextDouble();
                    triangulo.setAltura(alturaTriangulo);
                    triangulo.calcularArea();
                    break;
                case 5:
                    System.out.println("Cerrando....");
                    calcular = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }

        }
    }
}
