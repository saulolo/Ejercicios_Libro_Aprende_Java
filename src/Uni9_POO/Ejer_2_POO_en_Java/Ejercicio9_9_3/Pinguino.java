package Uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_3;

public class Pinguino extends Ave{

    public Pinguino(String name, String comida, int edad, String familia) {
        super(name, comida, edad, familia);
    }


    @Override
    public String volar() {
        return "No puedo volar";
    }

    public void pareja() {
        System.out.println("Solo tengo una pareja.");;
    }

    public void movimiento() {
        System.out.println("No puedo volar.");;
    }

    public void nadar() {
        System.out.println("Me gusta nadar.");;
    }

}
