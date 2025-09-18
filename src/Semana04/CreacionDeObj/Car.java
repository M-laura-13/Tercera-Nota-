package Semana04.CreacionDeObj;

public class Car {
    String brand;
    int year;

    public Car(String brand, int year){
        this.brand = brand;
        this.year = year;
    }

    public void displayInfo(){
        System.out.println("Marca:"+ brand +"año:"+ year);
    }
}
