package Uni9_POO.Teoria.animal;

public class Perro extends Animal implements Mascota {

    private String codigo;

    public Perro(Sexo s, String codigo) {
        super(s);
        this.codigo = codigo;
    }

    @Override
    public String getCodigo() {
        return codigo;
    }

    @Override
    public void hacerRuido() {
        ladra();
    }

    @Override
    public void come(String comida) {
        if (comida.equals("carne")) {
            System.out.println("Hmmmm, gracias");
        } else {
            System.out.println("Lo siento, yo solo como carne");
        }
    }

    @Override
    public void peleaCon(Animal contrincante) {
        if(contrincante.getClass().getSimpleName().equals("Perro")){
            System.out.println("ven aqui que te vas a enterar");
        }
        else{
            System.out.println("No me gusta pelear");
        }
    }

    public void ladra() {
        System.out.println("Guau guau");
    }
}
