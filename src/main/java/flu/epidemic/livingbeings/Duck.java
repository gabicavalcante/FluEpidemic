package flu.epidemic;

import flu.epidemic.Enum.Being;
import flu.epidemic.livingbeings.Bird;

/**
 * @author Raquel Oliveira, Gabriela Cavalcante
 * @version 07/12/2015.
 */
public class Duck extends Bird {
    private Being type;

    public Duck(){
        super();
        this.type = Being.DUCK;
    }
}
