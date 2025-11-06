package unidad4.utils.domain;

public class Estudiante extends Persona {
    private final String programa;

    public Estudiante(String id, String nombre, String programa) {
        super(id, nombre);
        this.programa = programa;
    }
     public String getPrograma() {
        return programa;

}
}
