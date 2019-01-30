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

    public int computarTarjeta(String tarjeta) {
        //TODO
        //Doesn't work
        int total = 0;

        for (int i = 0, len = tarjeta.length(); i < len; i++) {
            char pin = tarjeta.charAt(i);
            if (tarjeta.indexOf(pin) != -1) {
                total += i;
            }
        }
        return total;
    }

    public int computarSpare(char spare) {
        if (spare == '/') {
            return this.SPARE;
        }else {
            return this.CERO;
        }
    }
}