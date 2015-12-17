package flu.epidemic.virus;

import flu.epidemic.Enum.TypeVirus;

/**
 * Created by Raquel on 07/12/2015.
 */
public class H1N1 extends Virus {
    public H1N1(){
        this.name = TypeVirus.H1N1;
        this.incubationTime = 3;
        this.mortalityRate = 0.75;
    }
}
