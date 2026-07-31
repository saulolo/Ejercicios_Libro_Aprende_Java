package uni10_ColeccionesDiccionarios.Ejercicios.Ejercicio10_3_5;

import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Realiza de nuevo el ejercicio de la <b>colección de discos</b> pero utilizando esta vez una lista para almacenar la
 * información sobre los discos en lugar de un array convencional. Comprobarás que el código se simplifica notablemente
 * ¿Cuánto ocupa el programa original hecho con un array? ¿Cuánto ocupa este nuevo programa hecho con una lista?
 * @author Saulolo
 */
public class NuevoColeccionDiscosArraysListMain {

    private static ColeccionDiscosArraysList coleccion;
    private static Scanner sc;

    public static void main(String[] args) {

        System.out.println("=== COLECCIÓN DE DISCOS CON ARRAYLIST ===");

        // Inicializamos con una capacidad máxima de 5 discos
        coleccion = new ColeccionDiscosArraysList(5);
        sc = new Scanner(System.in);

        int opcion;
        do {
            mostrarMenu();
            System.out.print("Selecciona una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiamos el buffer

            switch (opcion) {
                case 1:
                    nuevoDiscoI();
                    break;
                case 2:
                    listarDiscos();
                    break;
                case 3:
                    borrarDisco();
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);

        sc.close();
    }

    /**
     * Muestra el menú principal.
     */
    private static void mostrarMenu() {
        System.out.println("\n=== COLECCIÓN DE DISCOS ===");
        System.out.println("1. Nuevo disco");
        System.out.println("2. Listado");
        System.out.println("3. Borrar disco");
        System.out.println("4. Salir");
    }

    /**
     * Añade un nuevo disco con validaciones.
     */
    private static void nuevoDiscoI() {
        if (coleccion.estaLlena()) {
            System.out.println("❌ ERROR: La colección está llena. Borra un disco para añadir uno nuevo.");
            return;
        }

        DiscoNuevoArrayList disco = new DiscoNuevoArrayList();

        System.out.print("Título: ");
        disco.setTitulo(sc.nextLine());

        System.out.print("Artista: ");
        disco.setArtista(sc.nextLine());

        System.out.print("Año de lanzamiento: ");
        int anio = sc.nextInt();
        sc.nextLine(); // Limpiamos el buffer
        disco.setAnioLanzamiento(Year.of(anio));

        System.out.print("Número de pistas: ");
        disco.setNumeroPistas(sc.nextInt());
        sc.nextLine(); // Limpiamos el buffer

        System.out.print("Género: ");
        disco.setGenero(sc.nextLine());

        System.out.print("Duración (minutos): ");
        disco.setDuracion(sc.nextInt());
        sc.nextLine(); // Limpiamos el buffer

        if (coleccion.anadirDisco(disco)) {
            System.out.println("✅ Disco añadido con ID: " + disco.getId());
        }
    }

    /**
     * Muestra el submenú de listado.
     */
    private static void listarDiscos() {
        int opcion;
        do {
            System.out.println("\n=== SUBMENÚ LISTADO ===");
            System.out.println("1. Listado completo");
            System.out.println("2. Listado por artista");
            System.out.println("3. Listado por género");
            System.out.println("4. Listado por duración");
            System.out.println("5. Volver");
            System.out.print("Selecciona una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiamos el buffer

            switch (opcion) {
                case 1:
                    mostrarListadoCompleto();
                    break;
                case 2:
                    mostrarListadoPorArtista();
                    break;
                case 3:
                    mostrarListadoPorGenero();
                    break;
                case 4:
                    mostrarListadoPorDuracion();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }

    /**
     * Muestra todos los discos.
     */
    private static void mostrarListadoCompleto() {
        if (coleccion.estaVacia()) {
            System.out.println("❌ No hay discos en la colección.");
            return;
        }
        ArrayList<DiscoNuevoArrayList> discos = coleccion.obtenerTodos();
        for (DiscoNuevoArrayList disco : discos) {
            System.out.println(disco);
        }
    }

    /**
     * Muestra discos por artista.
     */
    private static void mostrarListadoPorArtista() {
        System.out.print("Introduce el nombre del artista: ");
        String artista = sc.nextLine();

        // CORREGIDO: Llamamos a obtenerPorArtista(artista) en lugar de obtenerTodos()
        ArrayList<DiscoNuevoArrayList> discos = coleccion.obtenerPorArtista(artista);

        // CORREGIDO: Usamos el método isEmpty() nativo de las listas
        if (discos.isEmpty()) {
            System.out.println("❌ No hay discos de ese artista.");
            return;
        }
        for (DiscoNuevoArrayList disco : discos) {
            System.out.println(disco);
        }
    }

    /**
     * Muestra discos por género.
     */
    private static void mostrarListadoPorGenero() {
        System.out.print("Introduce el género: ");
        String genero = sc.nextLine();

        ArrayList<DiscoNuevoArrayList> discos = coleccion.obtenerPorGenero(genero);

        if (discos.isEmpty()) {
            System.out.println("❌ No hay discos de ese género.");
            return;
        }
        for (DiscoNuevoArrayList disco : discos) {
            System.out.println(disco);
        }
    }

    /**
     * Muestra discos en un rango de duración.
     */
    private static void mostrarListadoPorDuracion() {
        System.out.print("Duración mínima (minutos): ");
        int min = sc.nextInt();
        System.out.print("Duración máxima (minutos): ");
        int max = sc.nextInt();
        sc.nextLine(); // Limpiamos el buffer

        // CORREGIDO: El orden de los parámetros debe ser (min, max)
        ArrayList<DiscoNuevoArrayList> discos = coleccion.obtenerPorDuracion(min, max);

        if (discos.isEmpty()) {
            System.out.println("❌ No hay discos en ese rango de duración.");
            return;
        }
        for (DiscoNuevoArrayList disco : discos) {
            System.out.println(disco);
        }
    }

    /**
     * Borra un disco por ID con validaciones.
     */
    private static void borrarDisco() {
        if (coleccion.estaVacia()) {
            System.out.println("❌ No hay discos para borrar.");
            return;
        }

        System.out.print("Introduce el ID del disco a borrar: ");
        int id = sc.nextInt();
        sc.nextLine(); // Limpiamos el buffer

        // Verifica que el ID existe
        if (!coleccion.existeDisco(id)) {
            System.out.println("❌ ERROR: No existe un disco con ID " + id);
            return;
        }

        // Borra el disco
        if (coleccion.eliminarDisco(id)) {
            System.out.println("✅ Disco eliminado correctamente.");
        }

        System.out.println("\n== ¿Cuánto ocupa el programa original hecho con un array? y ¿Cuánto ocupa este nuevo\n" +
                "programa hecho con una lista?==");
        System.out.println("Se reduce casi a la mitad de líneas de codigo generadas, ya que con arrays manuales" +
                "debemos de generar lógica compleja, en cambio usando ArrayList aprovechamos sus métodos nativos.");

    }
}