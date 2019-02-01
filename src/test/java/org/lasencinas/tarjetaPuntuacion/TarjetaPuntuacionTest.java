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

        assertEquals(10, tarjeta.computarSpare('/'));
        assertEquals(0, tarjeta.computarSpare('2'));
        assertEquals(0, tarjeta.computarSpare('-'));
    }

    @Test
    public void computarTarjetaSoloPinsTest() {

        String puntuacion = "2716-82734618-458144";

        assertEquals(81, tarjeta.computarTarjeta(puntuacion));
    }

    @Test
    public void isSpareTest() {

        assertEquals(true, tarjeta.isSpare('/'));
        assertEquals(false, tarjeta.isSpare('5'));
    }

    @Test
    public void computarTarjetaSpareTest() {

        String puntuacion = "729-34247/3142414581";

        assertEquals(77, tarjeta.computarTarjeta(puntuacion));
    }

    //Test failed
    @Test
    public void computarTarjetaSpareTest2() {

        String puntuacion = "5/5/5/5/5/5/5/5/5/5/5";

        assertEquals(150, tarjeta.computarTarjeta(puntuacion));
    }

    @Test
    public void computarTarjetaStrikeTest() {

        String puntuacion = "813641X184527X5216";

        assertEquals(100, tarjeta.computarTarjeta(puntuacion));
    }

    @Test
    public void isStrikeTest() {
        assertEquals(true, tarjeta.isStrike('X'));
        assertEquals(false, tarjeta.isStrike('6'));
    }

}