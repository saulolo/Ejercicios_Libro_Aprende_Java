package Uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_3;

public class Perro extends Mamifero{

    public Perro(String name, String comida, int edad, String familia) {
        super(name, comida, edad, familia);
    }

    public String jugar() {
        return "Soy muy jugueton.";
    }

    public String olfato() {
        return "Tengo un olfato muy agudo.";
    }

    public String ladrar() {
        return "Guau guau.";
    }

    @Override
    public void relacion(String compartimiento) {
        System.out.println("Soy muy " + compartimiento);;
    }
}
