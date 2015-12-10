package flu.epidemic;

import flu.epidemic.Enum.Being;
import flu.epidemic.Enum.Status;

/**
 * A class representing shared characteristics of animals.
 *
 * @author Gabriela Cavalcante
 * @version 2015.11.30
 */
public class Animal extends LivingBeings{

    public Animal(){
        this.virus = new H1N1();
        this.canRecover = false;
    }

}
