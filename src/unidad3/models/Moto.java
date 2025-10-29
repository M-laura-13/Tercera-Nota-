package unidad3.models;

    public class Moto extends Vehiculo {
    private boolean caballito;
    
    // Constructor
    public Moto(String marca, int anio, String color) {
        super(marca, anio, color); // Llama al constructor de Vehiculo
        this.caballito = false;
    }
    
    // Método específico de Moto: hacer caballito (wheelie)
    public void hacerCaballito() {
        if (getVelocidad() > 0) {
            caballito = true;
            System.out.println(" ¡WHEELIE! ¡La moto está haciendo caballito! 🤘");
            System.out.println(" ¡Ten cuidado!");
        } else {
            System.out.println(" No puedes hacer caballito sin velocidad. ¡Acelera primero!");
        }
    }
    
    // Método para terminar el caballito
    public void terminarCaballito() {
        if (caballito) {
            caballito = false;
            System.out.println(" Volviendo a posición normal");
        }
    }
    
    // Sobrescribir mostrarInfo para agregar info específica de la moto
    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Haciendo caballito: " + (caballito ? "Sí" : "No"));
    }
}

