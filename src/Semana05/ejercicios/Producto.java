package Semana05.ejercicios;

public class Producto {
    String name;
    int price;

    public Producto(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void ShowInfo(){
        System.out.println("Nombre:"+name+ "Precio:"+price);
    }

    
}
