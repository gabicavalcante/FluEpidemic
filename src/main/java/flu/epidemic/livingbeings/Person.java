package flu.epidemic.livingbeings;

import flu.epidemic.Enum.Being;
import flu.epidemic.Enum.Status;

import java.util.Date;
import java.util.Random;

import flu.epidemic.simulator.Field;

import flu.epidemic.simulator.Location;
import flu.epidemic.exceptions.RecoveredException;
import flu.epidemic.virus.Virus;

/**
 * @author Huang Xiaohan, Gabriela Cavalcante
 * @version 10/12/15
 */
public class Person extends LivingBeings {

    private static final double VACCINATED_RATE = 0.02;
    private static final double CONTAGIOUS = 2;

    // state of the person
    private Status state;
    // type of virus
    private Virus virus;
    // Some individuals may be vaccinated against the viruses.
    private boolean isImmune;
    // if this person was infected
    private boolean isInfect;
    // data of infection
    private Date dateInfection;
    // location
    private Location position;
    private Field field;
    
    public Person(Location position, Field field) {
        super(Being.PERSON);
        // All people are healthy in the beginning.
        this.state = Status.HEALTHY;
        this.position = position;
        this.field = field;
    }

    /**
     * Return if this person is immune
     * @return the state of this person
     */
    public boolean getIsImmune(){
        return isImmune;
    }

    /**
     * This method will define if the person is immune
     * @param isImmune return if this person is immune or not
     */
    public void setIsImmune(boolean isImmune) {
        this.isImmune = isImmune;
    }

    /**
     * If the person was vaccinated
     * @param isImmune is this person is immune
     */
    public void wasVaccinated(boolean isImmune) {
        Random random = new Random();
        Double ran = (random.nextDouble()) * 100;
        if(ran < VACCINATED_RATE) this.setIsImmune(false);
        this.setIsImmune(true);
    }

    public void tryRecovered() throws RecoveredException {
        if (this.state == Status.CONTAGIUS){
            Random random = new Random();
            double rand = (random.nextDouble()) * 100;
            if(rand < this.virus.getMortalityRate()){
                this.state= Status.DEAD;
            }
            else{
            	this.state = Status.RECOVERING;
            	this.isInfect = false;
            	this.dateInfection = null;
            }
        }
        else
            throw new RecoveredException("This person was not infected");
    }
    
    public void trySick(Virus virus) {
    	if(this.state.isEquals(Status.HEALTHY) && !this.getIsImmune()){
    		this.state = Status.SICK;
    		this.isInfect = true;
    		this.dateInfection = new Date();
    	}
    }
    
    public void tryContagious() {
    	Date recentDate = new Date();
    	long timeDif = (recentDate.getTime() - dateInfection.getTime())/60;
    	//use minute as the day
    	if(this.state.isEquals(Status.SICK) && timeDif >= this.virus.getIncubationTime())
    		this.state = Status.CONTAGIUS;
    }
}
