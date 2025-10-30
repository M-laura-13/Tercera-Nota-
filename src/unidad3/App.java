package unidad3;
import unidad3.models.* vehiculo;
import models.Vehiculo;    
import models.Carro;
import models.Moto;

public class App {
    public static void main(String[] args) {
         System.out.println(">>> VEHÍCULO GENÉRICO <<<");
        Vehiculo vehiculo1 = new Vehiculo("Toyota", 2022, "Rojo");
        vehiculo1.mostrarInfo();
        vehiculo1.acelerar();
        vehiculo1.acelerar();
        vehiculo1.frenar();
        System.out.println();
        
        // Crear un carro y demostrar función ABRIR PUERTAS
        System.out.println(">>> CARRO <<<");
        Carro carro1 = new Carro("Honda", 2023, "Azul", 4);
        carro1.mostrarInfo();
        System.out.println("\n--- Función específica de Carro: ABRIR PUERTAS ---");
        carro1.abrirPuertas(); // FUNCIÓN ESPECÍFICA DE CARRO
        carro1.abrirPuertas(); // Intenta abrir de nuevo (ya están abiertas)
        carro1.acelerar();
        carro1.acelerar();
        carro1.acelerar();
        carro1.frenar();
        carro1.cerrarPuertas();
        System.out.println();
        
        // Crear una moto y demostrar función HACER CABALLITO (WHEELIE)
        System.out.println(">>> MOTO <<<");
        Moto moto1 = new Moto("Yamaha", 2024, "Negro", "Deportiva");
        moto1.mostrarInfo();
        System.out.println("\n--- Función específica de Moto: HACER CABALLITO (WHEELIE) ---");
        moto1.hacerCaballito(); // FUNCIÓN ESPECÍFICA DE MOTO (sin velocidad)
        System.out.println("\nPrimero aceleramos...");
        moto1.acelerar();
        moto1.acelerar();
        moto1.acelerar();
        System.out.println("\nAhora sí, ¡a hacer caballito!");
        moto1.hacerCaballito(); // FUNCIÓN ESPECÍFICA DE MOTO (con velocidad)
        moto1.terminarCaballito();
        moto1.frenar();
        moto1.frenar();
        System.out.println();
        
        // Demostración adicional de las funciones específicas
        System.out.println(">>> DEMOSTRACIÓN ADICIONAL <<<");
        System.out.println("\n--- Creando otro CARRO y usando ABRIR PUERTAS ---");
        Carro carro2 = new Carro("Ford", 2021, "Blanco", 2);
        carro2.abrirPuertas(); // INVOCANDO FUNCIÓN ESPECÍFICA DESDE MAIN
        
        System.out.println("\n--- Creando otra MOTO y usando WHEELIE ---");
        Moto moto2 = new Moto("Kawasaki", 2023, "Verde", "Touring");
        moto2.acelerar();
        moto2.acelerar();
        moto2.hacerCaballito(); 
    }
}
