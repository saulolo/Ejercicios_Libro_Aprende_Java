package Uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_1;

/**
 * Implementa la clase Caballo vista en un ejercicio anterior. Pruébala creando instancias y aplicándole algunos métodos.
 * @author Saulolo
 */
public class Caballo {

    private Long id;
    private String nombre;
    private String raza;
    private String color;
    private String genero;
    private double peso;
    private int edad;

    public Caballo(Long id, String nombre, String raza, String color, String genero, double peso, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.color = color;
        this.genero = genero;
        this.peso = peso;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    public void comer() {
        System.out.println("Estoy comiendo.");
    }

    public void correr() {
        System.out.println("Estoy mamao.");
    }

    public void relinchar() {
        System.out.println("relinchando.");
    }


    @Override
    public String toString() {
        return String.format(
                "╔═════════════════════════════════╗" +
                        "\n║ID        : %-20s ║" +
                        "\n║Nombre    : %-20s ║" +
                        "\n║Raza      : %-20s ║" +
                        "\n║Color     : %-20s ║" +
                        "\n║Genero    : %-20s ║" +
                        "\n║Peso      : %-20.1f ║" +
                        "\n║Edad      : %-20d ║" +
                        "\n╚═════════════════════════════════╝",
                id, nombre, raza, color, genero, peso, edad
        );
    }
}
