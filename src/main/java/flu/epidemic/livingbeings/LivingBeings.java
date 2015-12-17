package flu.epidemic.livingbeings;

import flu.epidemic.Enum.Being;
import flu.epidemic.Enum.Status;
import flu.epidemic.virus.Virus;

import java.util.Random;

/**
 * @author Gabriela Cavalcante
 * @version 03/12/15.
 */
public abstract class LivingBeings {

    protected Status state;
    protected Being type;
    protected Virus virus;

    public LivingBeings(Being type) {
        this.state = Status.HEALTHY;
        this.type = type;
        this.virus = null;
    }

    public LivingBeings(Being type, Virus virus) {
        this.state = Status.HEALTHY;
        this.type = type;
        this.virus = virus;
    }

    public boolean wasInfected(){
        Random random = new Random();
        Double ran = (random.nextDouble())*100;
        return ran >= this.virus.getInfectionRate();
    }
}
