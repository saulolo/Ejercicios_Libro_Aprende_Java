package Uni9_POO.Teoria.animal;

public class MascotaMain {

    public static void main(String[] args) {


        Gato garfield = new Gato(Sexo.MACHO, "34560");
        Mascota lisa = new Gato(Sexo.HEMBRA, "96509");
        Perro kuki = new Perro(Sexo.HEMBRA,"2345678");
        Mascota ayo = new Perro(Sexo.MACHO,"7785950");

        System.out.println(garfield.getCodigo());
        System.out.println(lisa.getCodigo());
        System.out.println(kuki.getCodigo());
        System.out.println(ayo.getCodigo());

        garfield.come("pescado");
        lisa.come("hamburguesa");
        kuki.come("pescado");
        lisa.peleaCon(garfield);
        ayo.peleaCon(kuki);
        
    }
}
