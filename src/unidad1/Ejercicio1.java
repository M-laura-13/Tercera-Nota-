package unidad1;

public class Ejercicio1 {
    public static class product {
        String name;
        double price;
        int quantity;

        public product(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        void sell(int amount) {
            if (quantity >= amount) {
                quantity -= amount;
                System.out.println("Vendio " + amount + "unidades de" + name);
            } else {
                System.out.println("No hay suficientes productos en el stock actualmente tenemos " + amount
                        + " unidades de " + name);
            }
        }

        void restock(int amount) {
            quantity += amount;
            System.out.println("se ha aumentado la cantidad a " + amount + "del" + name);
        }

        void showProduct() {
            System.out.println("el producto" + name + "tiene un precio de" + price + "con una cantidad de " + quantity);
        }
    }

    public static void main(String[] args) {
        product product1 = new product("laptop", 1200000, 50);
        product product2 = new product("tv", 600000, 3);

        product1.sell(20);
        product1.restock(40);
        product1.showProduct();

        product2.sell(70);
        product2.restock(30);
        product2.showProduct();
    }
}
