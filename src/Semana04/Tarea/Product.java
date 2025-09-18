package Semana04.Tarea;

public class Product {
    private String name;
    private double price;
    private int quantity;

    
    public Product() {
        this.name = "Milk";
        this.price = 3.000;
        this.quantity = 2;
    }


    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 0;
    }

   
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void showProduct() {
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("-----------------------");
    }
    public void update(String name) {
        this.name = name;
    }

    public void update(double price) {
        this.price = price;
    }

    public static void main(String[] args) {
        Product p1 = new Product();
        Product p2 = new Product("Egg", 12.000);
        Product p3 = new Product("Butter", 8.000, 2);

        p1.showProduct();
        p2.showProduct();
        p3.showProduct();

    }
}
