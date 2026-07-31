package uni10_ColeccionesDiccionarios.Teoria.ArrayList;

import java.util.Objects;

public class Gato implements Comparable<Gato>{

    private String nombre;
    private String color;
    private int edad;

    public Gato(String nombre, String color, int edad) {
        this.nombre = nombre;
        this.color = color;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getColor() {
        return color;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "[" + nombre + " | " + color + " | " + edad + " años]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Gato gato = (Gato) o;
        return edad == gato.edad && Objects.equals(nombre, gato.nombre) && Objects.equals(color, gato.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, color, edad);
    }

    /*Lo siguiente y no menos importante es definir el métod compareTo. Este métod debe devolver un 0 si los elementos
        que se comparan son iguales, un número negativo si el primer elemento que se compara es menor que el segundo y un
        número positivo en caso contrario.*/
    @Override
    public int compareTo(Gato g) {
        return this.nombre.compareTo(g.getNombre());
    }
}
