package flu.epidemic.exceptions;

/**
 * @author Gabriela Cavalcante
 * @version 17/12/15.
 */
public class DimensionNegativeException extends Exception {
    public DimensionNegativeException(){
        super();
    }

    public DimensionNegativeException(String message){
        super(message);
    }
}
