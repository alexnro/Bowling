package org.lasencinas.tarjetaPuntuacion;

public class TarjetaPuntuacion {

    String simbolos = "-123456789/X";

    public TarjetaPuntuacion() {
        this.simbolos = null;
    }

    public TarjetaPuntuacion(String simbolos) {
        this.simbolos = simbolos;
    }

    public int computarStrike(char strike) {
        return 10;
    }

}