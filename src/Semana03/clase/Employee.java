package Semana03.clase;

public class Employee {
    public String name;
    private double salary;
    protected String role;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        } else {
          System.out.println("El salario debe ser mayor que 0");
        }
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}