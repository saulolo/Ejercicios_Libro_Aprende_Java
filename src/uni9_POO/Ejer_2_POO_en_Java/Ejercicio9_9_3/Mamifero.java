package uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_3;

public class Mamifero extends Animal{


    public Mamifero(String name, String comida, int edad, String familia) {
        super(name, comida, edad, familia);
    }

    public void sangre() {
        System.out.println("Soy un mamifero de sangre caliente.");
    }

    public void lactar() {
        System.out.println("Me caracterizo por tener mamas.");
    }

    public void relacion(String compartimiento) {
        System.out.println("Mi caractes es: " + compartimiento);
    }
}
