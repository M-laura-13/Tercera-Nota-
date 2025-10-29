package unidad3.models;

public class Vehiculo {

    private String marca;
    private int año;
    private String color;
    private double velocidad;

    public Vehiculo(String marca, int año, String color) {
        this.marca = marca;
        this.año = año;
        this.color = color;
        this.velocidad = 0;
    }
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        if (marca != null && !marca.isEmpty())
        this.marca = marca;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        if (año > 1979 && año <= 2026) 
        this.año = año;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color != null && !color.isEmpty())
        this.color = color;
    }
    public double getVelocidad() {
        return velocidad;
    }

    public void acelerar() {
        velocidad += 5;
        System.out.println("El vehículo está acelerando.");
    }

    public void frenar() {
        if (velocidad >= 5) {
            velocidad -= 5;
            System.out.println("El vehículo está frenando.");
        } else {
            velocidad = 0;
            System.out.println("El vehículo está detenido.");
        }
    }

    public void mostrarInfo() {
        System.out.println("Marca: " + marca);
        System.out.println("Año: " + año);
        System.out.println("Color: " + color);
        System.out.println("Velocidad actual: " + velocidad + " km/h");
    }
}
