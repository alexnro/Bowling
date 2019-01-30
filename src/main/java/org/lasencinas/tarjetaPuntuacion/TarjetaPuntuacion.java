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

    //Temporal method
    public int computarTarjetaVeinteBolas() {
        return 20;
    }

    public int computarSpare(String frame) {
        try {
            if (frame.charAt(1) == '/') {
                return this.SPARE;
            } else {
                return this.CERO;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return this.CERO;
        }
    }
}