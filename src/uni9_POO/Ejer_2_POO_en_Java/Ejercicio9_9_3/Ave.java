package uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_3;

public class Ave extends Animal{

    public Ave(String name, String comida, int edad, String familia) {
        super(name, comida, edad, familia);
    }

    public String plumaje() {
        return "Tengo plumas";
    }

    public String volar() {
        return "Me desplazo por los aires";
    }

    public String pico() {
        return "No tengo dientes porque tengo un pico.";
    }
}
