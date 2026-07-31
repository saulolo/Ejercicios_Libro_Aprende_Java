package uni9_POO.Ejer_3_Arrays_de_Objetos.Ejercicio9_9_3;

import java.time.Year;

/**
 * Realiza el programa “Colección de discos” por tu cuenta, mirando lo menos posible el ejemplo que se proporciona.
 * Pruébalo primero para ver cómo funciona y luego intenta implementarlo tú mismo.
 * @author Saulolo
 */
public class ColeccionDiscosMain {

    public static void main(String[] args) {

        System.out.println("=== COLECCIÓN DE DISCOS ===");

        Disco[] discos = new Disco[4];

        //Disco 1
        discos[0] = new Disco();
        discos[0].setTitulo("The Wall");
        discos[0].setArtista("Pink Floid");
        discos[0].setAnioLanzamiento(Year.of(1979));
        discos[0].setNumeroPistas(26);

        //Disco 2
        discos[1] = new Disco();
        discos[1].setTitulo("21");
        discos[1].setArtista("Adele");
        discos[1].setAnioLanzamiento(Year.of(2011));
        discos[1].setNumeroPistas(11);

        //Disco 3
        discos[2] = new Disco();
        discos[2].setTitulo("The Eminen Show");
        discos[2].setArtista("Eminen");
        discos[2].setAnioLanzamiento(Year.of(2002));
        discos[2].setNumeroPistas(20);

        //Disco 4
        discos[3] = new Disco();
        discos[3].setTitulo("Thiller");
        discos[3].setArtista("Michael Jackson");
        discos[3].setAnioLanzamiento(Year.of(1082));
        discos[3].setNumeroPistas(9);


        //Mostrando Discos
        for (Disco disco : discos) {
            System.out.println(disco);
        }
    }

}
