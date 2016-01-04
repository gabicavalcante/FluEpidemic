package flu.epidemic.virus;

/**
 * @author Raquel Oliveira
 * @created 07/12/2015.
 */
public class H5N1 extends Virus {
    public H5N1(){
        this.name = TypeVirus.H5N1;

        this.incubationTime = 5;
        this.recoverTime = 5;
        this.contagiousTime = 5;

        this.mortalityRate = 1; // Don't recover
        this.infectionRate = 0.4;
    }
}
