package flu.epidemic.livingbeings;

import flu.epidemic.Enum.Being;
import flu.epidemic.virus.H1N1;

/**
 * @author Raquel Oliveira, Gabriela Cavalcante
 * @version 07/12/2015.
 */
public class Pig extends Animal {

    public Pig(){
        super(Being.PIG);
        this.type = Being.PIG;
        this.virus = new H1N1();
    }
}
