package flu.epidemic.livingbeings.animals;

import flu.epidemic.livingbeings.Being;

import flu.epidemic.simulator.Field;
import flu.epidemic.simulator.Location;
import flu.epidemic.virus.H1N1;

/**
 * @author Raquel Oliveira, Gabriela Cavalcante
 * @version 07/12/2015.
 */
public class Pig extends Animal {
    public Pig(Field field, Location location){
        super(Being.PIG, field, location);
        this.type = Being.PIG;
        this.virus = new H1N1();
    }
}
