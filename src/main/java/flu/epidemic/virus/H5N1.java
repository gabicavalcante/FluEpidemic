package flu.epidemic.virus;

/**
 * @author Raquel Oliveira
 * @created 07/12/2015.
 */
public class H5N1 extends Virus {
    public H5N1(){
        this.name = TypeVirus.H5N1;

        this.incubationTime = 2;
        this.recoverTime = 2;
        this.contagiousTime = 2;

        this.mortalityRate = 0.85;
        this.infectionRate = 0.65;
    }
}
