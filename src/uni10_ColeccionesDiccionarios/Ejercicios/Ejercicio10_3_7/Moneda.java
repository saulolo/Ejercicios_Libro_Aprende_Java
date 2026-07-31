package uni10_ColeccionesDiccionarios.Ejercicios.Ejercicio10_3_7;

public class Moneda {

    private String valor;
    private String pisicion;

    public Moneda(String valor, String pisicion) {
        this.valor = valor;
        this.pisicion = pisicion;
    }

    public String getValor() {
        return valor;
    }

    public String getPisicion() {
        return pisicion;
    }

    @Override
    public String toString() {
        return valor + " - " + pisicion;
    }
}
