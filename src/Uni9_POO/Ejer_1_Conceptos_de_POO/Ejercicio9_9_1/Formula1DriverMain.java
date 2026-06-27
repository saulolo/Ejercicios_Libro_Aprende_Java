package Uni9_POO.Ejer_1_Conceptos_de_POO.Ejercicio9_9_1;

public class Formula1DriverMain {

    public static void main(String[] args) {

        Formula1Driver driver1 = new Formula1Driver(1L, "Saul", "Echeverri", 40, "2312134331", "Masculino", 20);
        Formula1Driver driver2 = new Formula1Driver(2L, "Alejandra", "Arenas");


        System.out.println(driver1.getName() + " " +  driver1.getLastName() + " " + driver1.getAge() + " " + driver1.getPhone());
        System.out.println(driver2.getName() + " " + driver2.getLastName() );

    }
}
