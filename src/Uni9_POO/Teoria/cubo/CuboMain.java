package Uni9_POO.Teoria.cubo;

public class CuboMain {

    public static void main(String[] args) {

        Cubo cubito = new Cubo(2);
        Cubo cubote = new Cubo(7);

        System.out.println("Cubito: \n");
        cubito.pinta();

        System.out.println("\nCubote: \n");
        cubote.pinta();

        System.out.println("Lleno el cubito: \n");
        cubito.llena();
        cubito.pinta();

        System.out.println("El cubote sigue vacio: \n");
        cubote.pinta();

        System.out.println("Ahora vuelco lo que tiene cubito dentro del cubote: \n");
        cubito.vuelcaEn(cubote);

        System.out.println("Cubito: \n");
        cubito.pinta();

        System.out.println("\nCubote: \n");
        cubote.pinta();


    }
}
