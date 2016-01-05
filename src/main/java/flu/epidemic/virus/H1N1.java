package flu.epidemic.virus;

/**
 * @author Raquel Oliveira
 * @author Gabriela Cavalcante
 * @created 07/12/2015.
 */
public class H1N1 extends Virus {
    public H1N1() {
        this.name = TypeVirus.H1N1;

        this.incubationTime = 1;
        this.recoverTime = 3;
        this.contagiousTime = 1;

        this.mortalityRate = 1;
        this.infectionRate = 0.80;
    }
}
