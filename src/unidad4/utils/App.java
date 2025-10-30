package unidad4.utils;

public class App {
    public static void main(String[] args) {
        Direccion dir1 = new Direccion("Bogotá", "Calle 45");
        Direccion dir2 = new Direccion("Ocaña", "Calle 10");

        Empleado emp1 = new Empleado("Juan Perez", 3000, dir1);
        Vendedor vend1 = new Vendedor("Ana Gomez", 2500, 5000, 0.10, dir2);
        Gerente ger1 = new Gerente("Luis Martinez", 4000, 1000, dir1);

        emp1.mostrarInfo();
        System.out.println("Pago: $" + emp1.calcularPago());
        System.out.println();

        vend1.mostrarInfo();
        System.out.println("Pago: $" + vend1.calcularPago());
        System.out.println();

        ger1.mostrarInfo();
        System.out.println("Pago: $" + ger1.calcularPago());
    }
}
