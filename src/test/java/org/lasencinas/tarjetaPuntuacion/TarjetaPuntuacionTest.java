package org.lasencinas.tarjetaPuntuacion;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TarjetaPuntuacionTest {

    @Test
    private void testComputarStrike() {

        TarjetaPuntuacion tarjeta = new TarjetaPuntuacion();

        assertEquals(10, tarjeta.computarStrike('X'));
    }
}
