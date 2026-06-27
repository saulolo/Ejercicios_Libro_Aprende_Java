package Uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_3;

public class Gato extends Mamifero{

    public Gato(String name, String comida, int edad, String familia) {
        super(name, comida, edad, familia);
    }

    public void dormir(int horas) {
        System.out.println("Duermo de dia, unas " + horas + " horas.");
    }

    public void vision() {
        System.out.println("Veo de noche.");
    }

    public void aseo() {
        System.out.println("Soy muy limpio.");
    }

    @Override
    public void relacion(String compartimiento) {
        System.out.println("Soy muy " + compartimiento);;
    }
}
