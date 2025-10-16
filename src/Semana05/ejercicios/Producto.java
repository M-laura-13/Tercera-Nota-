package Semana05.ejercicios;


class Producto {
    private String code;
    private String name;
    private double price;
    
    public Producto(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }
    
    public String getCode() {
        return code;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    @Override
    public String toString() {
        return "Code: " + code + " | Name: " + name + " | Price: $" + price;
    }
}

// Inventory.java
import java.util.ArrayList;
import java.util.HashMap;

class Inventory {
    private ArrayList<Producto> products;
    private HashMap<String, Producto> catalog;
    
    public Inventory() {
        products = new ArrayList<>();
        catalog = new HashMap<>();
    }
    
    public void addProduct(Producto p) {
        products.add(p);
        catalog.put(p.getCode(), p);
        System.out.println("Product added: " + p.getName());
    }
    
    public void showProducts() {
        System.out.println("\n=== All Products in Inventory ===");
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            for (Producto p : products) {
                System.out.println(p);
            }
        }
        System.out.println("=================================\n");
    }
    
    public Producto searchProduct(String code) {
        return catalog.get(code);
    }
}

// Main.java
