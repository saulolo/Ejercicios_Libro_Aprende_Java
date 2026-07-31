package uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_18;

public class Incidencia {

    private static int incidencia = 1;
    private static int pendientes = 0;

    private int codigo;
    private int puesto;
    private String info;
    private String status;
    private String resolucion;

    public Incidencia(int puesto, String info) {
        this.codigo = incidencia++;
        this.puesto = puesto;
        this.info = info;
        this.status = "Pendiente";
        this.resolucion = "";
        pendientes++;
    }


    /**
     * Resuelve la incidencia, cambia su estado y actualiza el contador de pendientes.
     * @param resolucion Explicación de la solución o del fallo detectado.
     */
    public void resuelve(String resolucion) {
        if (status.equals("Pendiente")) {
            this.status = "Resuelta";
            this.resolucion = resolucion;
            pendientes--;
        }
    }

    public static int getPendientes() {
        return pendientes;
    }

    @Override
    public String toString() {
        String resultado = "Incidencia " + codigo + " - Puesto: " + puesto + " - " + info + " - " + status;
        if (status.equals("Resuelta")) {
            resultado += " - " + resolucion;
        }
        return resultado;
    }

}
