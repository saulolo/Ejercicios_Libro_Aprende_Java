package uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_10;

/**
 * Las amebas son seres unicelulares de forma cambiante ya que carecen de pared celular. Fagocitan cualquier cosa que se
 * les pone por delante. Crea la clase {@code Ameba} con el atributo {@code peso}, un número entero que indica los
 * microgramos que pesa el bicho. Al tratarse de una unidad tan pequeña, no se tienen en cuenta los decimales, será
 * un dato entero. Cuando Dios crea una ameba de la nada – {@code new Ameba()} – su peso es de 3 microgramos. Al comer,
 * va incrementando su peso; gasta un microgramo en el proceso de fagocitar y el resto hace que aumente de peso.
 * Por ejemplo, si come una partícula de 6 microgramos – por ej. {@code miAmeba.come(6)} – engordaría 5 microgramos.
 * Una ameba se puede comer a otra ameba. En este caso, sucede lo mismo que anteriormente, se gasta un microgramo en el
 * proceso de fagocitado y el resto lo engorda la ameba que come. Por ejemplo, si una ameba de 7 microgramos se come a
 * una de 4, acaba pesando 10 microgramos. La ameba comida no se destruye sino que se quedaría con un peso de 0
 * microgramos, una pena de ameba vamos.
 * Posteriormente, una ameba comida podría recuperarse si ella misma come algo. Nótese que el método come está sobrecargado.
 * @author Saulolo
 */
public class AmebaMain {

    public static void main(String[] args) {

        System.out.println("=== AMEBA ===");

        Ameba a1 = new Ameba();
        a1.come(2);
        System.out.println(a1);

        Ameba a2 = new Ameba();
        a2.come(4);
        System.out.println(a2);

        a1.come(a2);
        System.out.println(a1);
        System.out.println(a2);

        a2.come(3);
        System.out.println(a2);
    }
}
