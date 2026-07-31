package uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_3;

public class Animal {

    private String name;
    private String comida;
    private int edad;
    private String familia;


    public Animal(String name, String comida, int edad, String familia) {
        this.name = name;
        this.comida = comida;
        this.edad = edad;
        this.familia = familia;
    }

    public void comer() {
        System.out.println("El animal esta comiendo: " + comida);
    }

    public void desplazar(String desplazamiento) {
        System.out.println("Me desplazo: "+ desplazamiento);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComida() {
        return comida;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", comida='" + comida + '\'' +
                ", edad=" + edad +
                ", familia='" + familia + '\'' +
                '}';
    }
}
