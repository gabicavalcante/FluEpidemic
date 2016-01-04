package flu.epidemic.livingbeings.animals;

import flu.epidemic.livingbeings.Being;

import flu.epidemic.simulator.Field;
import flu.epidemic.simulator.Location;
import flu.epidemic.states.State;

/**
 * @author Raquel Oliveira
 * @version 07/12/2015.
 */
public class Chicken extends Bird {
    public Chicken(Field field, Location location) {
        super(Being.CHICKEN, field, location);
    }
}
