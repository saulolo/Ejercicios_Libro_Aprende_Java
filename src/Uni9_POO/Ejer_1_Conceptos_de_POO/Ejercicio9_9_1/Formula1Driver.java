package Uni9_POO.Ejer_1_Conceptos_de_POO.Ejercicio9_9_1;

/**
 * ¿Cuáles serían los atributos de la clase PilotoDeFormula1? ¿Se te ocurren algunas instancias de esta clase?:
 *
 * @author Saulolo
 */
public class Formula1Driver {

    private Long id;
    private String name;
    private String lastName;
    private int age;
    private String phone;
    private String gender;
    private int cardiovascularEndurance;


    public Formula1Driver(Long id, String name, String lastName, int age, String phone, String gender, int cardiovascularEndurance) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
        this.gender = gender;
        this.cardiovascularEndurance = cardiovascularEndurance;
    }

    public Formula1Driver(Long id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }

    public int getCardiovascularEndurance() {
        return cardiovascularEndurance;
    }
}
