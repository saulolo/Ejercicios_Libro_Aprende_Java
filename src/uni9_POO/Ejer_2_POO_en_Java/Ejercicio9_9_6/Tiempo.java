package uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_6;

public class Tiempo {

    private int hora;
    private int minuto;
    private int segundo;

    public Tiempo(int hora, int minuto, int segundo) {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    /**
     * Suma otro intervalo de tiempo a este y retorna un nuevo objeto con el resultado.
     * @param tiempo Tiempo a sumar.
     * @return Nuevo objeto Tiempo con la suma.
     */
    public Tiempo suma(Tiempo tiempo) {
        int nuevosSeg = this.segundo + tiempo.segundo;
        int nuevosMin = this.minuto + tiempo.minuto;
        int nuevosHora = this.hora + tiempo.hora;

        //Ajustar desbardamiento
        if (nuevosSeg >= 60) {
            nuevosMin += nuevosSeg / 60;
            nuevosSeg = nuevosSeg % 60;
        }

        if (nuevosMin >= 60) {
            nuevosHora += nuevosMin / 60;
            nuevosMin = nuevosMin % 60;
        }
        return new Tiempo(nuevosHora, nuevosMin, nuevosSeg);
    }


    /**
     * Resta otro intervalo de tiempo a este y retorna un nuevo objeto con el resultado.
     * Si el resultado es negativo, devuelve 0h 0m 0s.
     * @param t Tiempo a restar.
     * @return Nuevo objeto Tiempo con la resta.
     */
    public Tiempo resta(Tiempo t) {
        int totalSegundos1 = this.hora * 3600 + this.minuto * 60 + this.segundo;
        int totalSegundos2 = t.hora * 3600 + t.minuto * 60 + t.segundo;
        int diff = totalSegundos1 - totalSegundos2;
        if (diff < 0) diff = 0;

        int horas = diff / 3600;
        int minutos = (diff % 3600) / 60;
        int segundos = diff % 60;
        return new Tiempo(horas, minutos, segundos);
    }

    /**
     * Ajusta los valores de segundos, minutos y horas para que estén en sus rangos correctos.
     * Convierte el exceso de segundos a minutos y el exceso de minutos a horas.
     * Si la hora queda negativa, la pone en cero.
     */
    private void normaliza() {
        if (segundo >= 60 || segundo < 0) {
            minuto += segundo / 60;
            segundo = ((segundo % 60) + 60) % 60;
        }
        if (minuto >= 60 || minuto < 0) {
            hora += minuto / 60;
            minuto = ((minuto % 60) + 60) % 60;
        }
        if (hora < 0) hora = 0;

    }


    @Override
    public String toString() {
        return hora + "h " + minuto + "m " + segundo + "s";
    }

}
