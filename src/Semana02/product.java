package Semana02;

public class product {
     String name;
        double price;
        int quantity;

        public product(String name, double price, int quantity){
            this.name=name;
            this.price = price;
            this.quantity= quantity; 
        }

        void sell(int amount){
           if (quantity >= amount) {
            quantity -= amount;
            System.out.println("Vendio "+ amount +"unidades de"+ name);
           } else {
            System.out.println("No hay suficientes ventas en el stock la cantidad es de "+amount+ "unidades de"+ name );
           }
        }

        void restock(int amount){
            quantity += amount;
            System.out.println("se ha aumentado la cantidad a "+ amount+  "del"+ name);
        }

        void showProduct(){
            System.out.println("el producto"+name +"tiene un precio de"+ price+"con una cantidad de "+ quantity);
        }
}
