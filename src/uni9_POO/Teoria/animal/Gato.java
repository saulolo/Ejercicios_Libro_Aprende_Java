package uni9_POO.Teoria.animal;

public class Gato extends Animal implements Mascota{

    private String raza;

    public Gato(Sexo s, String r) {
        super(s);
        raza = r;
    }

    public Gato(Sexo s) {
        super(s);
        raza = "Siamés";
    }

    public Gato(String r) {
        super(Sexo.HEMBRA);
        raza = r;
    }

    public Gato() {
        super(Sexo.HEMBRA);
        raza = "Siamés";
    }

    public void maulla() {
        System.out.println("Miauuuuu");
    }

    public void ronronea() {
        System.out.println("mrrrrrr");
    }

    /**
     * Hace que el gato coma.
     * @param comida A los gatos les gusta el pescado, si le damos otra comida los rechazará
     */
    @Override
    public void come(String comida) {
        if (comida.equals("pescado")){
            System.out.println("Hmmmm, gracias");
        }
        else {
            System.out.println("Lo siento, yo solo como pescado");
        }
    }

    /**
     * Pone a pelear dos gatos. Solo se van a pelear dos machos entre si.
     * @param contrincante es el gato contra el que pelar.
     */
    @Override
    public void peleaCon (Animal contrincante) {
        if(this.getSexo().equals(Sexo.HEMBRA)){
            System.out.println("no me gusta pelear");
        }
        else{
            if(contrincante.getSexo().equals(Sexo.HEMBRA)){
                System.out.println("no peleo con gatitas");
            }
            else{
                System.out.println("ven aqui que te vas a enterar");
            }
        }
    }


    @Override
    public String toString() {
        return "Raza: " + raza + "\n******************\n";
    }


    @Override
    public String getCodigo() {
        return "";
    }

    @Override
    public void hacerRuido() {
        maulla();
        ronronea();
    }

}
