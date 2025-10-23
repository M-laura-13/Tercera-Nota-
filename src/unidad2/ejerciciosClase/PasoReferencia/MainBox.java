package unidad2.ejerciciosClase.PasoReferencia;

public class MainBox {
    public static void ChangeBox(Box newBox){
        newBox.size = 20;
    }

    public static void main(String[] args) {
        Box box = new Box(50);
        System.out.println("Tamaño de la caja "+ box.size);

        ChangeBox(box);
        System.out.println("Tamaño despues de cambiar la caja "+box.size);
    }
}
