package Uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_16;

public class Punto {

    private double x;
    private double y;


    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public String toString() {
        return x + ", " + y;
    }
}
