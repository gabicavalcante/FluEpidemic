package flu.epidemic;

import flu.epidemic.Enum.Being;

/**
 * Created by Raquel on 07/12/2015.
 */
public class Pig extends Animal{

    public Pig(){
        super();
        this.type = Being.PIG;
        this.virus = new H1N1();
    }
}
