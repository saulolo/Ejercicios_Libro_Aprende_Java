
package uni9_POO.Teoria.gato_simple;

/**
 * Definición de la Clase Gato
 */
public class GatoSimple {
    
    //Atributos
    String color;
    String raza;
    int edad;
    String sexo;
    double peso;
    
    
    //Métodos
    
    
    //Constructor

    GatoSimple(String s) {
        this.sexo = s;
    }
    
    //getter

    String getSexo() {
        return this.sexo;
    }
    
    /*
    Hace que el gato maulle
    */
    void maulla() {
        System.out.println("Miauuuu");
    }
    
    /*
    Hace que el gato ronronee
    */
    void ronronea() {
        System.out.println("mrrrrr");
    }
    
    /*
    Hace que el gato coma.
    A los gatos les gusta el pescado, si le damos otra comida los rechazará.
    */
    void come(String comida) {
        if (comida.equals("pescado")){
            System.out.println("Hmmmm, gracias");
        }
        else {
            System.out.println("Lo siento, yo solo como pescado");
        }
    }
    
    /*
    Pone a pelear dos gatos.
    Solo se van a pelear dos machos entre si.
    @param conricante es el gato contra el que pelar.
    */
    void peleaCon (GatoSimple contrincante) {
        if(this.sexo.equals("hembra")){
            System.out.println("no me gusta pelear");
        }
        else{
            if(contrincante.getSexo().equals("hembra")){
                System.out.println("no peleo con gatitas");
            }
            else{
                System.out.println("ven aqui que te vas a enterar");
            }
        }
    }

}
