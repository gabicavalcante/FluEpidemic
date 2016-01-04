package flu.epidemic.livingbeings.animals;

import flu.epidemic.livingbeings.Being;

import flu.epidemic.simulator.Field;
import flu.epidemic.simulator.Location;
import flu.epidemic.states.State;

/**
 * @author Raquel Oliveira, Gabriela Cavalcante
 * @version 07/12/2015.
 */
public class Duck extends Bird {
    private Being type;

    public Duck(Field field, Location location){
        super(Being.DUCK, field, location);
    }
}
