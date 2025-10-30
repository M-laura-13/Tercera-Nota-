package unidad4.utils;

public class Direccion {
    private String calle;
    private String ciudad;

    public Direccion(String ciudad, String calle) {
        this.ciudad = ciudad;
        this.calle = calle;
    }

    public String getFullAddress () {
        return calle + ", " + ciudad;
    }
}

