package uni10_ColeccionesDiccionarios.Ejercicios.Ejercicio10_3_14;

public class DetalleCompra {

    private String nombre;
    private int cantidad;

    public DetalleCompra(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
