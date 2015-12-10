package flu.epidemic;

import flu.epidemic.Enum.TypeVirus;

/**
 * Created by Raquel on 07/12/2015.
 */
public class H5N1 extends Virus {

    public H5N1(){
        this.name = TypeVirus.H5N1;
        this.incubationTime = 5;
        this.mortalityRate = 1; // Dont recover 
    }
}
