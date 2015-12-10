package flu.epidemic;

import flu.epidemic.Enum.Being;
import flu.epidemic.Enum.Status;

import java.util.Date;
import java.util.Random;

/**
 * Created by gabriela on 26/11/15.
 */
public class Person extends LivingBeings{
    private boolean isImune; //Some individuals may be vaccinated against the viruses.
    private static final double VACINATEDRATE = 0.02;
    private boolean isInfect;
    private Date dateInfection;
    private static final double CONTAGIOUS = 2;

    public Person(){
        this.state = Status.HEALTHY; // All people are healthy in the beginning.
        this.virus = new H1N1();
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
        if(ran < this.VACINATEDRATE){
            setIsImune(false);
        }
        setIsImune(true);
    }

    public void tryRecovered(Status state){
        if (state == Status.CONTAGIUS){
            Random random = new Random();
            double rand = (random.nextDouble())*100;
            if(rand < this.virus.mortalityRate){
                this.state= Status.DEAD;
            }
            this.state = Status.RECOVERING;
        }
        else
            System.out.printf("This person was not infected");
    }
}
