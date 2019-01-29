package org.lasencinas.tarjetaPuntuacion;

public class TarjetaPuntuacion {

    private int STRIKE = 10;
    private int CERO = 0;
    private int SPARE = 10;
    private String pins = "-123456789";
    private String tarjeta = "";


    public TarjetaPuntuacion(){};

    public TarjetaPuntuacion(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public int getStrike() {
        return this.STRIKE;
    }

    public int computarStrike(char strike) {
        if (strike == 'X') {
            return this.getStrike();
        }else {
            return this.CERO;
        }
    }

    public int computarPins(char pins) {
        return this.pins.indexOf(pins);
    }

    public int computarTarjeta() {
        //TODO
        int resultado = 0;

        for (int i = 0; i < this.pins.length(); i++) {
            if (this.tarjeta.charAt(i) == this.pins.indexOf(i)) {
                resultado += Character.getNumericValue(this.tarjeta.charAt(i));
            }
        }
        return resultado;
    }

    public int computarSpare() {
        //TODO
        return 10;
    }
}