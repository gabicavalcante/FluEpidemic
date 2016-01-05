package flu.epidemic.livingbeings.animals;

import flu.epidemic.livingbeings.Being;

import flu.epidemic.simulator.Field;
import flu.epidemic.simulator.Location;

/**
 * @author Raquel Oliveira, Gabriela Cavalcante
 * @version 07/12/2015.
 */
public class Duck extends Bird {
    public Duck(Field field, Location location){
        super(Being.DUCK, field, location);
    }

    @Override
    public void act() {
        super.act();
    }
}
