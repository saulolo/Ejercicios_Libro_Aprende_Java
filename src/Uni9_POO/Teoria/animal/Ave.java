package Uni9_POO.Teoria.animal;

public class Ave extends Animal{

    public Ave(Sexo s) {
        super(s);
    }

    public Ave() {
    }

    public void aseate() {
        System.out.println("Me estoy limpiando las plumas.");
    }

    public void vuela() {
        System.out.println("Estoy volando.");
    }
}
