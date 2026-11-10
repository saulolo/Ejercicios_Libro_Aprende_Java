package uni12_AplicacionesWebJSP.Teoria;

public class AplicacionesWebJSP {

  public static void main(String[] args) {

    System.out.println("=== APLICACIONES WEB CON JSP ===");
    /* JavaServer Pages. En este capítulo vamos a aprender cómo utilizar páginas web como interfaz para programas en Java. Usaremos JSP
    (JavaServer Pages) que nos permitirá mezclar código en Java con código HTML.
    Web de convenciones para majeno de archivos JSP:
    https://www.oracle.com/technical-resources/articles/javase/code-convention.html

    Una aplicación JSP consistirá en una o varias páginas web que normalmente contendrá código HTML y que llevarán
    “insertado” código en Java. Este código en Java puede colocarse en cualquier parte del archivo y se delimita mediante
    las etiquetas <% y %>.
    Cuando se pulsa F6 para ejecutar la aplicación sucede lo siguiente:
    1. Tod el código (tanto HTML como JAVA) se envía al servidor (Glass Fish o Apache Tomcat por ejemplo).
    2. El servidor deja intacto el código HTML y compila y ejecuta el código en Java.
    Generalmente el código Java genera código HTML mediante las instrucciones out.print y out.println.
    3. Por último, tod el código (ya solo queda HTML) se envía al navegador que es el que muestra la página.
    Recuerda que el navegador no entiende Java (entiende Javascript que es otro lenguaje diferente) y es imprescindible
    que tod el código Java haya sido traducido previamente.

    Este módulo como se desarrolla en proyecto dedicados a JSP, cada ejecicio irá en un  proyecto a parte para no
    contaminar este repositorio.
    */

  }
}
