package flu.epidemic.livingbeings.animals;

import flu.epidemic.livingbeings.Being;

import flu.epidemic.livingbeings.LivingBeings;
import flu.epidemic.simulator.Field;
import flu.epidemic.simulator.Location;
import flu.epidemic.states.State;
import flu.epidemic.virus.H1N1;

import java.util.List;

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

    @Override
    public void act() {}
}
