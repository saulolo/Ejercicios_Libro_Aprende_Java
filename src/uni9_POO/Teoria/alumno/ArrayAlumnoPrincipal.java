package uni9_POO.Teoria.alumno;

import java.util.Scanner;

public class ArrayAlumnoPrincipal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Alumno[] alumnos = new Alumno[5];

        System.out.println("Por favor introduce el nombre y la nota media de los 5 alumnos");

        String nombreIntroducido;
        double notaIntroducida;
        double sumaPromedios = 0;

        for (int i = 0; i < alumnos.length; i++) {
            alumnos[i] = new Alumno();
            System.out.println("Alumno " + i);

            System.out.println("Nombre: ");
            nombreIntroducido = scanner.next();
            (alumnos[i]).setNombre(nombreIntroducido);

            System.out.println("\nNota media: ");
            notaIntroducida = scanner.nextDouble();
            (alumnos[i]).setNotaMedia(notaIntroducida);
        }

        //Mostrar datos de los alumnos
        for (int i = 0; i < 5; i++) {
            System.out.println("Alumno " + i);
            System.out.println("Nombre " + alumnos[i].getNombre());
            System.out.println("Nota media " + alumnos[i].getNotaMedia());
            System.out.println("=======================================");
            sumaPromedios += alumnos[i].getNotaMedia();
        }

        System.out.println("El promedio global de la clase es: " + (sumaPromedios / 5));

    }
}
