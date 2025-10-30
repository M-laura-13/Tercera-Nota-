package unidad4.utils;

public class Empleado {
    protected String nombre;
    protected double salarioBase;
    protected Direccion direccion;

    public Empleado(String nombre, double salarioBase, Direccion direccion) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
        this.direccion = direccion;
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Salario Base: $" + salarioBase);
        System.out.println("Dirección: " + direccion.getFullAddress());
    }

    public double calcularPago() {
        return salarioBase;
    }

}
