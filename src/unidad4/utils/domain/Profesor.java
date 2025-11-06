package unidad4.utils.domain;

import java.util.ArrayList;
import java.util.List;

public class Profesor extends Persona  {
    private final String departamento;
    private final List<Curso> cursos = new ArrayList<>();

    public Profesor(String id, String nombre, String departamento) {
        super(id, nombre);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public List<Curso> getCursos() {
        return List.copyOf(cursos);
    }

    public void dictar(Curso Curso){
        if (!cursos.contains(Curso)cursos.add(curso)) ;
    }

    // Asociacion simple: el profesor puede asesorar proyectos 

    public void asesorar(Proyecto proyecto){
        System.out.println(getNombre() + " esta asesorando el proyecto: " + proyecto.getTitulo());
    }
}
