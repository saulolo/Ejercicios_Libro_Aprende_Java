package uni9_POO.Teoria.animal;

public interface Mascota {

    String getCodigo();
    void hacerRuido();
    void come(String comida);
    void peleaCon(Animal contrincante);
}
