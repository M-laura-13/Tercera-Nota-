package unidad3.models;

public class Carro extends Vehiculo {
    private boolean puertasAbiertas;

    public Carro(String marca, int año, String color) {
        super(marca, año, color);
        this.puertasAbiertas = false;
    }

    public boolean ispuertasAbiertas() {
        return puertasAbiertas;
    }

    public void abrirPuertas() {
        if (!puertasAbiertas){
            puertasAbiertas = true;
             System.out.println("Las puertas del carro están abiertas.");
        } else {
            System.out.println("Las puertas del carro ya están abiertas.");
        }
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Estado puertas: " + (puertasAbiertas ? "Abiertas" : "Cerradas"));
    }
    
}
