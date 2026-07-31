package uni9_POO.Teoria.coche;

public class Coche {

    private static int kilometrajeTotal = 0;
    private String marca;
    private String modelo;
    private int kilometraje;

    public Coche(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public static int getKilometrajeTotal() {
        return kilometrajeTotal;
    }

    public void recorre(int km) {
        kilometraje += km;
        kilometrajeTotal += km;
    }
}
