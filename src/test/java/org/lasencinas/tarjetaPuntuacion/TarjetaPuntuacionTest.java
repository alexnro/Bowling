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
    public void computarTarjetaVeinteBolasTest() {

        String tarjetaVeinteBolas = "11111111111111111111";

        assertEquals(20, tarjeta.computarTarjeta(tarjetaVeinteBolas));
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

    @Test
    public void computarTarjetaAllStrikeTest() {

        String puntuacion = "XXXXXXXXXXXX";

        assertEquals(300, tarjeta.computarTarjeta(puntuacion));
    }

    @Test
    public void computarStrikeTest() {

        String puntuacion = "1281314/531/XX8124";

        assertEquals(121, tarjeta.computarTarjeta(puntuacion));

    }
}