package flu.epidemic.virus;

import flu.epidemic.Enum.TypeVirus;

/**
 * @author Raquel Oliveira
 * @version 07/12/2015.
 */
public abstract class Virus {
    protected TypeVirus name; // Type of the virus
    protected double mortalityRate; // To verify if a person will recover from the illness or die
    protected int incubationTime; //Time, in days, that the individual is sick, but not contagious.
    protected double infectionRate; //of the virus

    public double getInfectionRate() { return infectionRate; }

    public double getMortalityRate() { return mortalityRate; }

    public int getIncubationTime() { return incubationTime; }
}
