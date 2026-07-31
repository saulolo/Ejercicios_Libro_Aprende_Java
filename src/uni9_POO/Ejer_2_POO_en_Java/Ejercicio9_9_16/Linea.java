package uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_16;

public class Linea {

    private Punto punto1;
    private Punto punto2;

    public Linea(Punto punto1, Punto punto2) {
        this.punto1 = punto1;
        this.punto2 = punto2;
    }

    @Override
    public String toString() {
        return "(" + punto1 + ") y (" + punto2 + ")";
    }
}
