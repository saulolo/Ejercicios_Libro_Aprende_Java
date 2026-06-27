package Uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_3;

public class Canario extends Ave{

    public Canario(String name, String comida, int edad, String familia) {
        super(name, comida, edad, familia);
    }

    public void tamanio() {
        System.out.println("Soy muy pequeño.");;
    }

    public void cantar() {
        System.out.println("Me gusta cantar en las mañanas.");;
    }

    public void vida() {
        System.out.println("Soy muy longevo.");
    }
}
