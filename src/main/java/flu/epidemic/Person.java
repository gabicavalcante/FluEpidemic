package flu.epidemic;

import flu.epidemic.Enum.Being;

import flu.epidemic.Enum.Status;

import java.util.Date;
import java.util.Random;


import flu.epidemic.Enum.*;



/**
 * Created by gabriela on 26/11/15.
 * Write by huang xiaohan on 10/12/15
 */
public class Person extends LivingBeings{

    private Status state;
    private Virus virus;
    private boolean isImune; //Some individuals may be vaccinated against the viruses.
    private static final double VACINATEDRATE = 0.02;
    private boolean isInfect;
    private Date dateInfection;
    private static final double CONTAGIOUS = 2;
    
   
    
    public Person(){
        this.state = Status.HEALTHY; // All people are healthy in the beginning.
        wasVacinated(getIsImune());
    }
   
    
    
    //Setters

    /**
     *
     * @return
     */
    public boolean getIsImune(){
        return isImune;
    }

    //Getters

    /**
     *
     * @param isImune
     */
    public void setIsImune(boolean isImune) {
        this.isImune = isImune;
    }


    public void wasVacinated(boolean isImune ){
        Random random = new Random();
        Double ran = (random.nextDouble())*100;
        if(ran < VACINATEDRATE){
            setIsImune(false);
        }
        setIsImune(true);
    }

    public void tryRecovered(){
        if (this.state == Status.CONTAGIUS){
            Random random = new Random();
            double rand = (random.nextDouble())*100;
            if(rand < this.virus.mortalityRate){
                this.state= Status.DEAD;
            }
            else{
            	this.state = Status.RECOVERING;
            	this.isInfect = false;
            	this.dateInfection = null;
            }
        }
        else
            System.out.printf("This person was not infected");
    }
    
    public void trySick(Virus virus){
    	if(this.state == Status.HEALTHY && !this.getIsImune()){
    		this.state = Status.SICK;
    		this.isInfect = true;
    		this.dateInfection = new Date();
    	}
    }
    
    public void tryContagious(){
    	Date recentdate = new Date();
    	long timedif = (recentdate.getTime() - dateInfection.getTime())/60;
    	//use minute as the day
    	if(this.state == Status.SICK && timedif >= this.virus.incubationTime)
    		this.state = Status.CONTAGIUS;
    }
}
