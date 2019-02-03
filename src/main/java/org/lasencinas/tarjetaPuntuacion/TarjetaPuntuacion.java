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

    public int computarTarjeta(String puntuacion) {
        
        for (int bola = 0; bola < puntuacion.length(); bola++) {
            char punto = puntuacion.charAt(bola);

            if ((bola == puntuacion.length()-1) && (isSpare(puntuacion.charAt(bola-1)))){
                break;
            } else if ((bola == puntuacion.length()-1) && (isStrike(puntuacion.charAt(bola-2)))) {
                computeStrike(bola, puntuacion);
                break;
            }
            if (isSpare(punto)) {
                char spare = puntuacion.charAt(bola + 1);
                char pinAterior = puntuacion.charAt(bola - 1);
                this.puntuacionTotal += 10 + this.pins.indexOf(spare) - this.pins.indexOf(pinAterior);
            } else if (isStrike(punto)) {
                computeStrike(bola, puntuacion);
            }
            else {
                if (puntuacion.indexOf(punto) != -1) {
                    this.puntuacionTotal += this.pins.indexOf(punto);
                }
            }
        }
        return this.puntuacionTotal;
    }

    public int computeStrike(int bola, String puntuacion) {

        try {
            if ((puntuacion.charAt(bola+1) == 'X') && (puntuacion.charAt(bola+2) == 'X')) {
                this.puntuacionTotal += this.STRIKE * 3;
            } else if (((puntuacion.charAt(bola+1) == 'X') && (puntuacion.charAt(bola+2) != 'X'))) {
                this.puntuacionTotal += this.STRIKE * 2;
            } else {
                char proximoPrimerPin = puntuacion.charAt(bola + 1);
                char proximoSegundoPin = puntuacion.charAt(bola + 2);
                this.puntuacionTotal += 10 + this.pins.indexOf(proximoPrimerPin) + this.pins.indexOf(proximoSegundoPin);
                return this.puntuacionTotal;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return this.CERO;
        } finally {
            return this.puntuacionTotal;
        }
    }
}