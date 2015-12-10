package flu.epidemic;

import flu.epidemic.Enum.Being;
import flu.epidemic.Enum.Status;

import java.util.Random;

/**
 * Created by gabriela on 03/12/15.
 */
public abstract class LivingBeings {

    protected Status state;
    protected Being type;
    protected Virus virus;

    public boolean wasInfected(){
        Random random = new Random();
        Double ran = (random.nextDouble())*100;
        if(ran < this.virus.infectionRate){
            return false;
        }
        return true;
    }
}
