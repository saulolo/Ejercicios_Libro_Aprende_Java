package Uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_3;

public class Lagarto extends Animal{

    public Lagarto(String name, String comida, int edad, String familia) {
        super(name, comida, edad, familia);
    }


    public void alimentacion() {
        System.out.println("Soy carnivoro.");;
    }


    public void piel() {
        System.out.println("Mi piel es muy dura.");;
    }

    public void sangre() {
        System.out.println("Mi sangre es fria.");;
    }
}
