package uni11_FicherosDeTextos.Teoria.T7_ProcesamientoArchivosDeTexto;

public class ProcesamientoArchivosDeTexto {

    public static void main(String[] args) {

        System.out.println("== Procesamiento de archivos de texto ==");
        /* La posibilidad de realizar desde Java operaciones con ficheros abre muchas posibilidades a la hora de procesar
        archivos: cambiar una palabra por otra, eliminar ciertos Ficheros de texto y paso de parámetros por línea de
        comandos 252 caracteres, mover de sitio una línea o una palabra, borrar espacios o tabulaciones al final de las
        líneas o cualquier otra cosa que se nos pueda ocurrir.
        Cuando se procesa un archivo de texto, los pasos a seguir son los siguientes:
        1. Leer una línea del fichero origen mientras quedan líneas por leer.
        2. Modificar la línea (normalmente utilizando los métodos que ofrece la clase String).
        3. Grabar la línea modificada en el fichero destino.
        4. Volver al paso 1.
        */

        /* A continuación tienes algunos métodos de la clase String que pueden resultar muy útiles para procesar archivos
        de texto:
        - charAt(int n) Devuelve el carácter que está en la posición n-ésima de la cadena. Recuerda que la primera posición
        es la número 0.
        - indexOf(String palabra) Devuelve un número que indica la posición en la que comienza una palabra determinada.
        - length() Devuelve la longitud de la cadena.
        - replace(char c1, char c2) Devuelve una cadena en la que se han cambiado todas las ocurrencias del carácter c1
        por el carácter c2.
        - substring(int inicio,int fin) Devuelve una subcadena.
        - toLowerCase() Convierte todas las letras en minúsculas.
        - toUpperCase() Convierte todas las letras en mayúsculas.
        */

        //A continuación tienes un ejemplo en el que se usan los métodos descritos anteriormente.

        System.out.println("====================== Ejemplo 1 ======================");
        String palabra = "berengena";
        System.out.println("En la posición de la palabra " + palabra + " esta la letra " + palabra.charAt(2));

        System.out.println("\n====================== Ejemplo 2 ======================");
        String frase = "Hola caracola";
        char[] trozo = new char[10];

        trozo[0] = 'z';
        trozo[1] = 'z';
        trozo[2] = 'z';

        frase.getChars(2, 7, trozo, 1);
        System.out.println("El array de caractéres vale");
        System.out.println(trozo);

        System.out.println("\n====================== Ejemplo 3 ======================");
        System.out.println("La secuencia \"co\" aparece en la frase en la posición " + frase.indexOf("co"));

        System.out.println("\n====================== Ejemplo 4 ======================");
        System.out.println("La paabra \"murcielago\" tiene " + frase.length() + " letras");

        System.out.println("\n====================== Ejemplo 5 ======================");
        String frase2 = frase.replace('o', 'u');
        System.out.println(frase2);

        System.out.println("\n====================== Ejemplo 6 ======================");
        frase2 = frase.substring(3, 10);
        System.out.println(frase2);

        System.out.println("\n====================== Ejemplo 7 ======================");
        System.out.println(frase.toLowerCase());

        System.out.println("\n====================== Ejemplo 8 ======================");
        System.out.println(frase.toUpperCase());

    }
}