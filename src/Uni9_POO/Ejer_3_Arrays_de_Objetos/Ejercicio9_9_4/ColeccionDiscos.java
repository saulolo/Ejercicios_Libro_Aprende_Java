package Uni9_POO.Ejer_3_Arrays_de_Objetos.Ejercicio9_9_4;

public class ColeccionDiscos {

    private DiscoNuevo[] discosNuevos;
    private int cantidadDiscos;

    /**
     * Crea una colección de discos con capacidad máxima.
     * @param capacidad Número máximo de discos.
     */
    public ColeccionDiscos(int capacidad) {
        this.discosNuevos = new DiscoNuevo[capacidad];
        this.cantidadDiscos = 0;
    }

    /**
     * Verifica si la colección está llena.
     * @return true si está llena, false en caso contrario.
     */
    public boolean estaLlena() {
        return cantidadDiscos >= discosNuevos.length;
    }

    /**
     * Verifica si la colección está vacía.
     * @return true si está vacía, false en caso contrario.
     */
    public boolean estaVacia() {
        return cantidadDiscos == 0;
    }

    /**
     * Verifica si un ID de disco ya existe.
     * @param id ID a verificar.
     * @return true si existe, false en caso contrario.
     */
    public boolean existeDisco(int id) {
        for (int i = 0; i < cantidadDiscos; i++) {
            if (discosNuevos[i] != null && discosNuevos[i].getId() == id) {
                return true;
            }
        }
        return false;
    }

    /**
     * Añade un disco a la colección.
     * @param discoNuevo Disco a añadir.
     * @return true si se añadió, false si está llena.
     */
    public boolean anadirDisco(DiscoNuevo discoNuevo) {
        if (estaLlena()) {
            return false;
        }
        discosNuevos[cantidadDiscos] = discoNuevo;
        cantidadDiscos++;
        return true;
    }

    /**
     * Elimina un disco por su ID.
     * @param id ID del disco a eliminar.
     * @return true si se eliminó, false si no existe.
     */
    public boolean eliminarDisco(int id) {
        for (int i = 0; i < cantidadDiscos; i++) {
            if (discosNuevos[i] != null && discosNuevos[i].getId() == id) {
                // Desplazar discos
                for (int j = i; j < cantidadDiscos - 1; j++) {
                    discosNuevos[j] = discosNuevos[j + 1];
                }
                discosNuevos[cantidadDiscos - 1] = null;
                cantidadDiscos--;
                return true;
            }
        }
        return false;
    }

    /**
     * Devuelve todos los discos.
     * @return Array de discos.
     */
    public DiscoNuevo[] obtenerTodos() {
        DiscoNuevo[] resultado = new DiscoNuevo[cantidadDiscos];
        for (int i = 0; i < cantidadDiscos; i++) {
            resultado[i] = discosNuevos[i];
        }
        return resultado;
    }

    /**
     * Devuelve discos de un artista específico.
     * @param artista Nombre del artista.
     * @return Array de discos del artista.
     */
    public DiscoNuevo[] obtenerPorArtista(String artista) {
        DiscoNuevo[] resultado = new DiscoNuevo[cantidadDiscos];
        int count = 0;
        for (int i = 0; i < cantidadDiscos; i++) {
            if (discosNuevos[i] != null && discosNuevos[i].getArtista().equalsIgnoreCase(artista)) {
                resultado[count] = discosNuevos[i];
                count++;
            }
        }
        DiscoNuevo[] final_resultado = new DiscoNuevo[count];
        for (int i = 0; i < count; i++) {
            final_resultado[i] = resultado[i];
        }
        return final_resultado;
    }

    /**
     * Devuelve discos de un género específico.
     * @param genero Nombre del género.
     * @return Array de discos del género.
     */
    public DiscoNuevo[] obtenerPorGenero(String genero) {
        DiscoNuevo[] resultado = new DiscoNuevo[cantidadDiscos];
        int count = 0;
        for (int i = 0; i < cantidadDiscos; i++) {
            if (discosNuevos[i] != null && discosNuevos[i].getGenero().equalsIgnoreCase(genero)) {
                resultado[count] = discosNuevos[i];
                count++;
            }
        }
        DiscoNuevo[] final_resultado = new DiscoNuevo[count];
        for (int i = 0; i < count; i++) {
            final_resultado[i] = resultado[i];
        }
        return final_resultado;
    }

    /**
     * Devuelve discos en un rango de duración.
     * @param duracionMin Duración mínima en minutos.
     * @param duracionMax Duración máxima en minutos.
     * @return Array de discos en el rango.
     */
    public DiscoNuevo[] obtenerPorDuracion(int duracionMin, int duracionMax) {
        DiscoNuevo[] resultado = new DiscoNuevo[cantidadDiscos];
        int count = 0;
        for (int i = 0; i < cantidadDiscos; i++) {
            if (discosNuevos[i] != null && discosNuevos[i].getDuracion() >= duracionMin && discosNuevos[i].getDuracion() <= duracionMax) {
                resultado[count] = discosNuevos[i];
                count++;
            }
        }
        DiscoNuevo[] final_resultado = new DiscoNuevo[count];
        for (int i = 0; i < count; i++) {
            final_resultado[i] = resultado[i];
        }
        return final_resultado;
    }

    /**
     * Devuelve la cantidad de discos en la colección.
     * @return Cantidad de discos.
     */
    public int getCantidad() {
        return cantidadDiscos;
    }
}
