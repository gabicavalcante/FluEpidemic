package flu.epidemic;

import flu.epidemic.Enum.TypeVirus;

/**
 * Created by Raquel on 07/12/2015.
 */
public abstract class Virus {
    protected TypeVirus name; // Type of the virus
    protected double mortalityRate; // To verify if a person will recover from the illness or die
    protected int incubationTime; //Time, in days, that the individual is sick, but not contagious.
    protected double infectionRate; //of the virus


}
