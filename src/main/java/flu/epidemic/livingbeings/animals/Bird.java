package flu.epidemic.livingbeings.animals;

import flu.epidemic.Enum.Being;
import flu.epidemic.virus.H5N1;

/**
 * @author Raquel Oliveria
 * @version 07/12/2015.
 */
public class Bird extends Animal {
    public Bird(){
        super(Being.DUCK);
        this.virus = new H5N1();
    }
}
