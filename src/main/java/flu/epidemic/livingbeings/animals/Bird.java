package flu.epidemic.livingbeings.animals;

import flu.epidemic.livingbeings.Being;

import flu.epidemic.simulator.Field;
import flu.epidemic.simulator.Location;
import flu.epidemic.virus.H5N1;

import java.util.List;

/**
 * @author Raquel Oliveria
 * @version 07/12/2015.
 */
public class Bird extends Animal {
    public Bird(Being being, Field field, Location location) {
        super(being, field, location);
        this.virus = new H5N1();
    }
}
