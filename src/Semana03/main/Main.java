package Semana03.main;

import Semana03.clase.Employee;

public class Main {
   public static void main(String[] args) {
        Employee emp1 = new Employee();
        emp1.name = "Alicia";
        emp1.setRole("Developer");
        emp1.setSalary(3000);

        Employee emp2 = new Employee();
        emp2.name = "Juan";
        emp2.setRole("Manager");
        emp2.setSalary(5000);

        System.out.println("Employee 1: " + emp1.name + ", Role: " + emp1.getRole() + ", Salary: " + emp1.getSalary());
        System.out.println("Employee 2: " + emp2.name + ", Role: " + emp2.getRole() + ", Salary: " + emp2.getSalary());
    }
}
