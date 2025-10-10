package Semana05.ejercicios;

public class Employee {
    String role;

    public Employee(String role) {
        this.role = role;
    }

    public void ShowResponsabilities(){
        switch (role) {
            case "Manager":
                System.out.println("Maneja el equipo");
                break;
            case "Developer":
                System.out.println("Programa y testea");
                break;
            case "Designer":
                System.out.println("Diseña iu/ux");
                break;
            default:
                System.out.println("No conocido");
                break;
        }
    }
    
}
