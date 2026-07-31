package uni9_POO.Teoria.animal;

public abstract class Animal {

    private Sexo sexo;


    public Animal() {
        sexo = Sexo.MACHO;
    }

    public Animal(Sexo s) {
        sexo = s;
    }


    public Sexo getSexo() {
        return sexo;
    }

    public void duerme() {
        System.out.println("Zzzzzzzzzzzzzz");
    }

    @Override
    public String toString() {
        return "Sexo: " + sexo + "\n";
    }

}
