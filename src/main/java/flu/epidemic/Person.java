package flu.epidemic;

import flu.epidemic.Enum.Being;

import java.util.Date;

/**
 * Created by gabriela on 26/11/15.
 */
public class Person extends LivingBeings{
    private boolean infect;
    private Date dateInfection;

    private static final int CONTAGIOUS = 2;

    public Person(){
        
    }

}
