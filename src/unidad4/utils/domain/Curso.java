package unidad4.utils.domain;

import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

public class Curso {
    private final String codigo;
    private final String nombre;
    private final List<UnidadTematica> unidades = new ArrayList<>();
    private final List<Estudiante> inscritos = new ArrayList<>();

    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    // COMPOSICION 
    public void agregarUnidad(String titulo, int semanas) {
        unidades.add(new UnidadTematica(titulo, semanas));

    }

    // AGREGACION 

    public void inscribirEstudiante(Estudiante estudiante) {
        Objects.requireNonNull(estudiante, "El estudiante no puede ser nulo");
        if (!inscritos.contains(estudiante)) {
            inscritos.add(estudiante);
        }
    }

    public void desinscribir(Estudiante estudiante) {
        inscritos.remove(estudiante);
    }

    public List<UnidadTematica> getUnidades(){
        return List.copyOf(unidades);
    }
    public List<Estudiante> getInscritos(){
        return List.copyOf(inscritos);
    }

    @Override
    public String toString() {
        return "Curso{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", unidades=" + unidades +
                ", inscritos=" + inscritos.size() +
                '}';
    }
}
