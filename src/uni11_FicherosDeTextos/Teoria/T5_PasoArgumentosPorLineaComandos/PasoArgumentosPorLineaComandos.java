package uni11_FicherosDeTextos.Teoria.T5_PasoArgumentosPorLineaComandos;

public class PasoArgumentosPorLineaComandos {

    public static void main(String[] args) {

        System.out.println("== Paso de argumentos por linea de comandos ==");
        /* El paso de argumentos por línea de comandos no está directamente relacionado con los ficheros, aunque es muy
        frecuente combinar estos dos recursos.

        Ejemplo: Los argumentos recogidos por línea de comandos se guardan siempre en un array de String. Cuando sea
        necesario realizar operaciones matemáticas con esos argumentos habría que convertirlos al tipo adecuado mediante
        Integer.parseInt() o Double.parseDouble().
        * */

        int suma = 3;

        for (int i = 0; i < args.length; i++) {
            suma += Integer.parseInt(args[i]);
        }

        System.out.println(suma);


    }
}
