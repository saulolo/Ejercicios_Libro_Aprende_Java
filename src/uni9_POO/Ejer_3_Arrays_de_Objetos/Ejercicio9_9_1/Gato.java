package uni9_POO.Ejer_3_Arrays_de_Objetos.Ejercicio9_9_1;

public class Gato {

    private String nombre;
    private int edad;


    public Gato() {
    }

    public Gato(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "\n┌──────────────────────────────┐" +
                "\n│         🐱 GATO              │" +
                "\n├──────────────────────────────┤" +
                "\n│  • Nombre : " + String.format("%-16s", nombre) + " │" +
                "\n│  • Edad   : " + String.format("%-16s", edad + " años") + " │" +
                "\n└──────────────────────────────┘\n";
    }
}
