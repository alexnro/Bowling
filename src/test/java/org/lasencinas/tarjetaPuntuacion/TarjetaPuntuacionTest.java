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
    public void computarPinsTest() {

        String pins = "-123456789";
        assertEquals(0, tarjeta.computarPins('-'));

        for (int i = 0; i < pins.length(); i++) {
            assertEquals(i, tarjeta.computarPins(pins.charAt(i)));
        }

        /*Other way to write de test
        for(Integer i = 1; i <= 9; i++) {
            assertEquals(i.intValue(), tarjeta.computarPins(i.toString()));
        }
        */
    }

    @Test
    public void computarTarjetaVeinteBolasTest() {

        String tarjetaVeinteBolas = "11111111111111111111";
        tarjeta = new TarjetaPuntuacion(tarjetaVeinteBolas);

        assertEquals(20, tarjeta.computarTarjeta(tarjetaVeinteBolas));
    }

    @Test
    public void computarSpareTest() {

        assertEquals(10, tarjeta.computarSpare("7/"));
        assertEquals(0, tarjeta.computarSpare("23"));
        assertEquals(0, tarjeta.computarSpare("/2"));
    }

    @Test
    public void computarTarjetaTestSoloPins() {

        String puntuacion = "2716-82734618-458144";
        tarjeta = new TarjetaPuntuacion(puntuacion);

        assertEquals(81, tarjeta.computarTarjeta(puntuacion));
    }
}