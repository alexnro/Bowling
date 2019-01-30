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

    public boolean isSpare(char punto) {
        if (punto == '/') {
            return true;
        } else {
            return false;
        }
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

    public int computarTarjeta(String puntuacion) {

        int total = 0;

        for (int bola = 0; bola < puntuacion.length(); bola++) {
            char punto = puntuacion.charAt(bola);
            if (!isSpare(punto)) {
                if (puntuacion.indexOf(punto) != -1) {
                    total += this.pins.indexOf(punto);
                }
            } else {
                char spare = puntuacion.charAt(bola + 1);
                char pinAterior = puntuacion.charAt(bola - 1);
                total += 10 + this.pins.indexOf(spare) - this.pins.indexOf(pinAterior);
            }
        }
        return total;
    }

    public int computarSpare(char spare) {
        try {
            if (spare == '/') {
                return this.SPARE;
            } else {
                return this.CERO;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return this.CERO;
        }
    }
}