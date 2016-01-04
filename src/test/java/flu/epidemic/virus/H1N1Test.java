package flu.epidemic.virus;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Raquel Oliveira
 * @created 04/01/2016.
 */
public class H1N1Test {
    H1N1 virus;

    @Before
    public void defineContext() {
        virus = new H1N1();
    }

    @Test
    public void testClass() {
        assertEquals(virus.getClass(), H1N1.class);
    }

    @Test
    public void testIncubationTime() {
        assertEquals(3, virus.getIncubationTime());
    }

    @Test
    public void testInfectionRate() {
        assertTrue(0.5 == virus.getInfectionRate());
    }

    @Test
    public void testMortalityRate() {
        assertTrue(0.75 == virus.getMortalityRate());
    }

    @Test
    public void testToString() {
        assertEquals("H1N1", TypeVirus.H1N1.toString());
    }
}
