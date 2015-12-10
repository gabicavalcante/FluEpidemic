package flu.epidemic;

import flu.epidemic.Enum.Being;

import java.util.Date;

/**
 * Created by gabriela on 26/11/15.
 */
public class Person extends LivingBeings{
    private boolean isImune; //Some individuals may be vaccinated against the viruses.
    private boolean infect;
    private Date dateInfection;

    private static final int CONTAGIOUS = 2;

    public Person(){
        this.canRecover = true;
        setIsImune(false);
        this.virus = new H1N1();
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
}
