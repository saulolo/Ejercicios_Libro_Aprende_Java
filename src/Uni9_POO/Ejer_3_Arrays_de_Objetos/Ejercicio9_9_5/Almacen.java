package Uni9_POO.Ejer_3_Arrays_de_Objetos.Ejercicio9_9_5;

public class Almacen {

    private final Articulo[] listaArticulos;
    private int contadorArticulos;

    public Almacen() {
        this.listaArticulos = new Articulo[100];
        this.contadorArticulos = 0;
    }


    /**
     * Agrega un nuevo artículo a la bodega si hay espacio disponible.
     * @param articulo El objeto artículo que se desea almacenar.
     */
    public void alta(Articulo articulo) {
        if (contadorArticulos >= listaArticulos.length) {
            System.out.println("Ha superado el limite de almacenamiento de la bodega.");
            return;
        }
        listaArticulos[contadorArticulos] = articulo;
        contadorArticulos++;
    }

    /**
     * Muestra por pantalla todos los artículos almacenados en el almacén.
     */
    public void listar() {
        if (contadorArticulos == 0) {
            System.out.println("No hay articulos en el almacén.");
            return;
        }

        String lineaDivisoria = "+--------+------------------------------+---------------+---------------+--------+";
        String encabezado     = "| CÓDIGO | DESCRIPCIÓN                  | PRECIO COMPRA | PRECIO VENTA  | STOCK  |";

        System.out.println(lineaDivisoria);
        System.out.println(encabezado);
        System.out.println(lineaDivisoria);

        for (int i = 0; i < contadorArticulos; i++) {
            if (listaArticulos[i] != null) {
                System.out.println(listaArticulos[i]);
            }
        }
        System.out.println(lineaDivisoria);
    }

    /**
     * Elimina un artículo del almacén utilizando su código de identificación.
     * @param codigo El identificador único del artículo que se desea dar de baja.
     */
    public void baja(int codigo) {
        int posicionEncontrado = buscarPosicion(codigo);
        if (posicionEncontrado == -1) {
            System.out.println("El Articulo con ese código no existe.");
            return;
        }
        listaArticulos[posicionEncontrado] = null;
        System.out.println("Articulo eliminado correctamente.");
    }

    /**
     * Actualiza los datos de un artículo existente en el almacén.
     * @param codigo            El identificador único del artículo a modificar.
     * @param nuevaDescripcion  El nuevo texto descriptivo para el artículo.
     * @param nuevoPrecioCompra El nuevo costo de adquisición del artículo.
     * @param nuevoPrecioVenta  El nuevo precio al público del artículo.
     */
    public void modificacion(int codigo, String nuevaDescripcion, int nuevoPrecioCompra, int nuevoPrecioVenta) {
        int posicionEncontrado = buscarPosicion(codigo);
        if (posicionEncontrado == -1) {
            System.out.println("El Articulo con ese código no existe.");
            return;
        }

        Articulo articuloExistente = listaArticulos[posicionEncontrado];
        articuloExistente.setDescripcion(nuevaDescripcion);
        articuloExistente.setPrecioCompra(nuevoPrecioCompra);
        articuloExistente.setPrecioVenta(nuevoPrecioVenta);
    }

    /**
     * Incrementa el stock de un artículo existente al recibir nueva mercancía.
     *
     * @param codido   El identificador único del artículo (nota: corregir ortografía a 'codigo').
     * @param cantidad El número de unidades que se van a añadir al inventario.
     */
    public void entradaMercancia(int codido, int cantidad) {
        int posicionEncontrada = buscarPosicion(codido);
        if (posicionEncontrada == -1) {
            System.out.println("El Articulo con ese código no existe.");
            return;
        }

        Articulo articuloExistente = listaArticulos[posicionEncontrada];

        int stockActual = articuloExistente.getStock();
        int nuevoStock = stockActual + cantidad;
        articuloExistente.setStock(nuevoStock);
    }

    /**
     * Reduce el stock de un artículo existente tras una salida de mercancía.
     *
     * @param codigo   El identificador único del artículo.
     * @param cantidad El número de unidades que se van a retirar del inventario.
     */
    public void salidaMercancia(int codigo, int cantidad) {
        int posicionEncontrada = buscarPosicion(codigo);
        if (posicionEncontrada == -1) {
            System.out.println("El articulo con ese código no existe.");
            return;
        }

        Articulo articuloExistente = listaArticulos[posicionEncontrada];
        int stockActual = articuloExistente.getStock();
        int nuevoStock = stockActual - cantidad;

        if (nuevoStock < 0) {
            System.out.println("No se puede eliminar dicha cantidad (" + cantidad + ") de mercancia." );
            return;
        }

        articuloExistente.setStock(nuevoStock);
    }

    /**
     * Busca el índice de un artículo en el arreglo según su código.
     * @param codigo El identificador único del artículo a buscar.
     * @return La posición del artículo en el arreglo, o -1 si no se encuentra.
     */
    private int buscarPosicion(int codigo) {
        for (int i = 0; i < contadorArticulos; i++) {
            if (listaArticulos[i] != null) {
                if (listaArticulos[i].getCodigo() == codigo) {
                    return i;
                }
            }
        }
        return -1;
    }

}
