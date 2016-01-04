package flu.epidemic.virus;

/**
 * @author Raquel Oliveira
 * @version 07/12/2015.
 */
public abstract class Virus {
    protected TypeVirus name; // Type of the virus

    protected int incubationTime; // Time, in days, that the individual is sick, but not contagious.
    protected int contagiousTime; // Time, in days, that the individual is contagious
    protected int recoverTime; // Time, in days, that the individual is recovering

    protected double infectionRate; // of the virus
    protected double mortalityRate; // To verify if a person will recover from the illness or die
    // TODO: time to contagious to recovering or dead

    public double getInfectionRate() { return infectionRate; }

    public double getMortalityRate() { return mortalityRate; }

    public int getIncubationTime() { return incubationTime; }

    public int getContagiousTime() {
        return contagiousTime;
    }

    public int getRecoverTime() {
        return recoverTime;
    }
}
