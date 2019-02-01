package org.lasencinas.tarjetaPuntuacion;

public class TarjetaPuntuacion {

    private int STRIKE = 10;
    private int CERO = 0;
    private int SPARE = 10;
    private String pins = "-123456789";
    private String tarjeta = "";
    private int puntuacionTotal = 0;


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

    public boolean isStrike(char punto) {
        if (punto == 'X') {
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
        
        for (int bola = 0; bola < puntuacion.length(); bola++) {
            char punto = puntuacion.charAt(bola);
            if ((bola == puntuacion.length()-1) && (isSpare(puntuacion.charAt(bola-1)))){
                break;
            } else if ((bola == puntuacion.length()-1) && (isStrike(puntuacion.charAt(bola-2)))) {
                strikeFinal(punto, puntuacion.charAt(bola+1), puntuacion.charAt(bola+2));
                break;
            }
            if (isSpare(punto)) {
                char spare = puntuacion.charAt(bola + 1);
                char pinAterior = puntuacion.charAt(bola - 1);
                this.puntuacionTotal += 10 + this.pins.indexOf(spare) - this.pins.indexOf(pinAterior);
            } else if (isStrike(punto)) {
                char proximoPrimerPin = puntuacion.charAt(bola + 1);
                char proximoSegundoPin = puntuacion.charAt(bola + 2);
                char pinAterior = puntuacion.charAt(bola - 1);
                this.puntuacionTotal += 10 + this.pins.indexOf(proximoPrimerPin) + this.pins.indexOf(proximoSegundoPin);
            }
            else {
                if (puntuacion.indexOf(punto) != -1) {
                    this.puntuacionTotal += this.pins.indexOf(punto);
                }
            }
        }
        return this.puntuacionTotal;
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

    public int strikeFinal(char punto, char puntuacionSiguiente, char puntuacionFinal) {
        if ((isStrike(puntuacionSiguiente)) && (isStrike(puntuacionFinal))) {
            this.puntuacionTotal += 30;
        } else if (isStrike(puntuacionSiguiente)) {
            //TODO
        }
        return this.puntuacionTotal;
    }
}