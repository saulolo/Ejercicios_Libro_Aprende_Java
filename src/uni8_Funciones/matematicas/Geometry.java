package uni8_Funciones.matematicas;

/**
 * Funciones geométricas
 * @author Saulolo
 */
public class Geometry {


    /**
     * Calcula el volumen de un cilindro.
     * @param radio radio del cilindro en decimales
     * @param height altura del cilindro en decimales
     * @return el volumen del cilindro
     */
    public static double cylinderVolume(double radio, double height) {
        return Math.PI * Math.pow(radio, 2) * height;
    }


    /**
     * Calcula la longitud de una circunferencia.
     * @param radio radio de la circunferecnia en decimales
     * @return longitud de una circunferencia
     */
    public static double circumferenceLength(double radio) {
        return 2 * Math.PI * radio;
    }

}
