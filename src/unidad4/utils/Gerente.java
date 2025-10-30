package unidad4.utils;

public class Gerente extends Empleado {
    private double bono;
    

    public Gerente(String nombre, double salarioBase,double bono, Direccion direccion) {
        super(nombre, salarioBase, direccion);
        this.bono = bono;
       
    }

    @Override
    public void mostrarInfo() {
        System.out.println(" Gerente:"+ nombre + " - Salario Base: $" + calcularPago() );
    }

    @Override
    public double calcularPago() {
        return salarioBase + bono;
    }
    
}