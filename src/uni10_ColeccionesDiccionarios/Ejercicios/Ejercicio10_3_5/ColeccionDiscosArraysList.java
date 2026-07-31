package uni10_ColeccionesDiccionarios.Ejercicios.Ejercicio10_3_5;

import java.util.ArrayList;

public class ColeccionDiscosArraysList {

    private ArrayList<DiscoNuevoArrayList> listaDiscos;
    private int capacidadMaxima;

    /**
     * Crea una colección de discos con capacidad máxima.
     * @param capacidadMaxima Número máximo de discos que puede albergar la colección.
     */
    public ColeccionDiscosArraysList(int capacidadMaxima) {
        this.listaDiscos = new ArrayList<>(5);
        this.capacidadMaxima = capacidadMaxima;
    }

    /**
     * Verifica si la colección está llena.
     * @return true si está llena, false en caso contrario.
     */
    public boolean estaLlena() {
        return listaDiscos.size() >= capacidadMaxima;
    }

    /**
     * Verifica si la colección está vacía.
     * @return true si está vacía, false en caso contrario.
     */
    public boolean estaVacia() {
        return listaDiscos.isEmpty();
    }

    /**
     * Verifica si un ID de disco ya existe.
     * @param id ID a verificar.
     * @return true si existe, false en caso contrario.
     */
    public boolean existeDisco(int id) {
        for (DiscoNuevoArrayList listaDisco : listaDiscos) {
            if (listaDisco.getId() == id) return true;
        }
        return false;
    }

    /**
     * Añade un disco a la colección.
     * @param discoNuevo Disco a añadir.
     * @return true si se añadió, false si está llena.
     */
    public boolean anadirDisco(DiscoNuevoArrayList discoNuevo) {
        if (estaLlena()) {
            return false;
        }
        listaDiscos.add(discoNuevo);
        return true;
    }

    /**
     * Elimina un disco por su ID.
     * @param id ID del disco a eliminar.
     * @return true si se eliminó, false si no existe.
     */
    public boolean eliminarDisco(int id) {
        for (DiscoNuevoArrayList listaDisco : listaDiscos) {
            if (listaDisco.getId() == id) {
                listaDiscos.remove(listaDisco);
                return true;
            }
        }
        return false;
    }

    /**
     * Devuelve todos los discos de la colección.
     * @return Una lista (ArrayList) que contiene todos los discos almacenados.
     */
    public ArrayList<DiscoNuevoArrayList> obtenerTodos() {
        return listaDiscos;
    }

    /**
     * Devuelve discos de un artista específico.
     * @param artista Nombre del artista.
     * @return Una lista (ArrayList) de discos que coinciden con el artista indicado.
     */
    public ArrayList<DiscoNuevoArrayList> obtenerPorArtista(String artista) {
        ArrayList<DiscoNuevoArrayList> resultados = new ArrayList<>();
        for (DiscoNuevoArrayList disco : listaDiscos) {
            if (disco.getArtista().equalsIgnoreCase(artista)) {
                resultados.add(disco);
            }
        }
        return resultados;
    }

    /**
     * Devuelve discos de un género específico.
     * @param genero Nombre del género.
     * @return Una lista (ArrayList) de discos que coinciden con el género indicado.
     */
    public ArrayList<DiscoNuevoArrayList> obtenerPorGenero(String genero) {
        ArrayList<DiscoNuevoArrayList> resultados = new ArrayList<>();
        for (DiscoNuevoArrayList disco : listaDiscos) {
            if (disco.getGenero().equalsIgnoreCase(genero)) {
                resultados.add(disco);
            }
        }
        return resultados;
    }

    /**
     * Devuelve discos en un rango de duración.
     * @param duracionMin Duración mínima en minutos.
     * @param duracionMax Duración máxima en minutos.
     * @return Una lista (ArrayList) de discos cuya duración se encuentra en el rango especificado.
     */
    public ArrayList<DiscoNuevoArrayList> obtenerPorDuracion(int duracionMin, int duracionMax) {
        ArrayList<DiscoNuevoArrayList> resultados = new ArrayList<>();
        for (DiscoNuevoArrayList disco : listaDiscos) {
            if (disco.getDuracion() >= duracionMin && disco.getDuracion() <= duracionMax) {
                resultados.add(disco);
            }
        }
        return resultados;
    }

    /**
     * Devuelve la cantidad de discos en la colección.
     * @return Cantidad de discos.
     */
    public int getCantidad() {
        return listaDiscos.size();
    }
}
