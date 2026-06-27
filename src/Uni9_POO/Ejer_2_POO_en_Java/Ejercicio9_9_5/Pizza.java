package Uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_5;

public class Pizza {

    private String size;
    private String type;
    private String state;
    protected static int ordered = 0;
    protected static int serviced = 0;

    public Pizza(String type, String size) {
        this.type = type;
        this.size = size;
        this.state = "pedida";
        ordered++;
    }

    /**
     * Sirve la pizza si aún no está servida.
     * Si ya fue servida, muestra un mensaje por consola.
     * Incrementa el contador de pizzas servidas solo la primera vez.
     */
    public void serve() {
        if (state.equals("servida")) {
            System.out.println("esa pizza ya se ha servido.");
        } else {
            state = "servida";
            serviced++;

        }
    }


    public static int getOrdered() {
        return ordered;
    }

    public static int getServiced() {
        return serviced;
    }

    @Override
    public String toString() {
        return "Pizza "  + type + " " + size + ", " + state;
    }
}
