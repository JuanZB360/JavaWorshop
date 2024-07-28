package CuentaBancaria;

public class CuentaBancaria {

    // Atributos
    private final int numeroCuenta;
    private static int cuenta;
    private String Titular;
    private String contrasena;
    private double Balance;
    private float saldo;
    private static float ingreso;
    private static float egreso;


    // Constructor
    public CuentaBancaria() {
        this.numeroCuenta = cuenta++;
    }

    // Getter
    public String getTitular() {
        return this.Titular;
    }

    public double getBalance() {
        return this.Balance;
    }

    public float getSaldo() {
        return this.saldo;
    }

    public int getNumeroCuenta() {
        return this.numeroCuenta;
    }

    // Setter
    public void setTitular(String titular) {
        this.Titular = titular;
    }

    public void setBalance(double balance) {
        this.Balance = balance;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void setContrasena(String contrasena)  {
        this.contrasena = contrasena;
    }

    // Metodo


    public boolean berificar (String contrasena) {
        return this.contrasena.equals(contrasena);
    }

    public void DepositoDinero (float saldo) {
        this.saldo += saldo;
        ingreso += saldo;
        System.out.println("Deposito exitoso...");
    }

    public void RetirarDinero (float retiro) {
        if(this.saldo - retiro > 0){
            this.saldo -= retiro;
            egreso += retiro;
            System.out.println("El retiro se realizo con exito");
        }else{
            System.out.println("No tienes saldo suficiente....");
        }
    }

    public void Balance () {
        System.out.println("Balance de la cuenta: " + cuenta);
        System.out.println("Total de ingresos: " + ingreso);
        System.out.println("Total de egresos: " + egreso);
        System.out.println("Diferencia de ingresos y egresos: " + (ingreso - egreso));
    }

    public void verSaldo() {
        System.out.println("Tu saldo es: " + this.saldo);
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "numeroCuenta=" + numeroCuenta +
                ", Titular='" + Titular + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
