package Uni9_POO.Teoria.cubo;

public class Cubo {

    private int capacidad;
    private int contenido;

    public Cubo(int capacidad) {
        this.capacidad = capacidad;
    }


    public int getCapacidad() {
        return capacidad;
    }

    public int getContenido() {
        return contenido;
    }

    public void setContenido(int contenido) {
        this.contenido = contenido;
    }

    public void vacia() {
        contenido = 0;
    }

    public void llena() {
        contenido = capacidad;
    }

    public void pinta() {
        for (int nivel = capacidad; nivel > 0 ; nivel--) {
            if (contenido >= nivel) System.out.println("#~~~~#");
            else System.out.println("#    #");
        }
        System.out.println("######");
    }

    public void vuelcaEn(Cubo destino) {
        int libres = destino.getCapacidad() - destino.getContenido();

        if (libres > 0) {
            if (contenido <= libres) {
                destino.setContenido(destino.getContenido() + contenido);
                vacia();
            } else {
                contenido -= libres;
                destino.llena();
            }
        }
    }
}
