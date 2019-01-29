package org.lasencinas.tarjetaPuntuacion;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TarjetaPuntuacionTest {

    private TarjetaPuntuacion tarjeta = null;

    @Before
    public void init() {

        tarjeta = new TarjetaPuntuacion();
    }

    @Test
    public void computarStrikeTest() {

        assertEquals(tarjeta.getStrike(), tarjeta.computarStrike('X'));
        assertEquals(0, tarjeta.computarStrike('9'));
    }

    @Test
    public void computarPins() {

        String pins = "-123456789";
        assertEquals(0, tarjeta.computarPins('-'));

        for (int i = 0; i < pins.length(); i++) {
            assertEquals(i, tarjeta.computarPins(pins.charAt(i)));
        }

//        for(Integer i = 1; i <= 9; i++) {
//            assertEquals(i.intValue(), tarjeta.computarPins(i.toString()));
//        }
    }

    @Test
    public void computarTarjetaVeinteBolas() {

        String tarjetaVeinteBolas = "111111111111111111110";
        tarjeta = new TarjetaPuntuacion(tarjetaVeinteBolas);

        assertEquals(20, tarjeta.computarTarjeta());
    }
}