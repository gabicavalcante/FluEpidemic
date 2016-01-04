package flu.epidemic.virus;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @version 04/01/16.
 */
public class H5N1Test {
    H5N1 virus;

    @Before
    public void defineContext() {
        virus = new H5N1();
    }

    @Test
    public void testClass() {
        assertEquals(virus.getClass(), H5N1.class);
    }

    @Test
    public void testIncubationTime() {
        assertEquals(5, virus.getIncubationTime());
    }

    @Test
    public void testInfectionRate() {
        assertTrue(0.4 == virus.getInfectionRate());
    }

    @Test
    public void testMortalityRate() {
        assertTrue(1 == virus.getMortalityRate());
    }

    @Test
    public void testToString() {
        assertEquals("H5N1", TypeVirus.H5N1.toString());
    }
}
