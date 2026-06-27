package Uni9_POO.Ejer_3_Arrays_de_Objetos.Ejercicio9_9_5;

public class Articulo {

    private int codigo;
    private String descripcion;
    private int precioCompra;
    private int precioVenta;
    private int stock;


    public Articulo(int codigo, String descripcion, int precioCompra, int precioVenta, int stock) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.stock = stock;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(int precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    @Override
    public String toString() {
        String prCompraStr = precioCompra + " $";
        String prVentaStr  = precioVenta + " $";
        String stockStr    = stock + " und";

        // Formato exacto de la fila (debe coincidir en espacios con el encabezado)
        String formatoFila = "| %-6d | %-28s | %-13s | %-13s | %-6s |";

        // Corrección de la lógica: Asegura que si es corta o nula, no se quede vacía
        String descripcionStr = (descripcion == null) ? "N/A" : descripcion;
        if (descripcionStr.length() > 28) {
            descripcionStr = descripcionStr.substring(0, 25) + "...";
        }

        // Enviamos 'descripcionStr' que ahora sí contiene el texto correcto
        return String.format(formatoFila, codigo, descripcionStr, prCompraStr, prVentaStr, stockStr);
    }
}
