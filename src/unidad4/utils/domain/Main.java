package unidad4.utils.domain;

public class Main {
    public static void main(String[] args) {
        Profesor profesor = new Profesor("P001", "Dr. Juan Perez", "Matemáticas");
        Estudiante estudiante1 = new Estudiante("E001", "Ana Gómez", "Ingeniería");
        Estudiante estudiante2 = new Estudiante("E002", "Luis Martínez", "Arquitectura");

        Curso programacion = new Curso("C001", "Programación 101");
        profesor.dictar(programacion);

        // COMPOSICION

        programacion.agregarUnidad("herencia", 2);
        programacion.agregarUnidad("polimorfismo", 3);

        // AGREGACION
        programacion.inscribirEstudiante(estudiante1);
        programacion.inscribirEstudiante(estudiante2);

        // ASOSIACION
        Proyecto proyecto = new Proyecto("Sistema de Gestión", estudiante1);
        profesor.asesorar(proyecto);
    }
}
