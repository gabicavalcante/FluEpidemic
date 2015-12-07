package flu.epidemic;

/**
 * A class representing shared characteristics of animals.
 *
 * @author Gabriela Cavalcante
 * @version 2015.11.30
 */
public class Animal extends  LivingBeings{

    private Status state;

    public Animal(){
        state = Status.HEALTHY;
    }

}
