package uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_2;

public class Vehiculo {

    private static int vehiculosCreados = 0;
    protected static int kilometrosTotales = 0;
    protected int kilometrosRecorridos = 0;

    public Vehiculo() {
        vehiculosCreados++;
    }

    public void andar(int km) {
        kilometrosRecorridos += km;
        Vehiculo.kilometrosTotales += km;
    }

    public static int getVehiculosCreados() {
        return vehiculosCreados;
    }


    public int getKilometrosRecorridos() {
        return kilometrosRecorridos;
    }

    public static int getKilometrosTotales() {
        return kilometrosTotales;
    }
}
