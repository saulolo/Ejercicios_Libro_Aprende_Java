package Uni9_POO.Teoria.cuadrado;

public class Cuadrado {

    private int lado;


    public Cuadrado(int lado) {
        lado = 1;
    }

    @Override
    public String toString() {

        int i;
        int espacios;
        String resultado = "";

        for (int j = 0; j < lado; j++) {
            resultado += "￿￿";
        }

        resultado += "\n";

        for (int j = 1; j < lado - 1; j++) {
            resultado += "￿￿";
        }

        for (espacios = 1; espacios < this.lado - 1; espacios++) {
            resultado += " ";
        }
        resultado += "￿￿\n";

        for (i = 0; i < this.lado; i++) {
            resultado += "￿￿";
        }
        resultado += "\n";

        return resultado;
    }
}
