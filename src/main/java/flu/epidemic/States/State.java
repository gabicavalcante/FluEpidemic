package flu.epidemic.States;

/**
 * Enum to represents the STATUS of a person.
 *
 * @author Raquel Lopes de Oliveira
 * @version 1.0
 * @created 03/12/2015
 */
public enum State {
    HEALTHY("healthy"),
    SICK("sick"), //infected
    CONTAGIUS("contagious"),
    RECOVERING("recovering"),
    DEAD("dead");

    private String status = "";
   // private State previousStatus = "helthy";

    /**
     * Constructor enum
     * @param status
     */
    State(String status) {
        this.status = status;
        //this.previousStatus = previousStatus;
    }

    /**
     * Method to change status to String
     * @return status
     */
    public String toString() {
        return status;
    }

    public boolean isEquals(State state) { return this.status.equalsIgnoreCase(state.toString()); }

    /**
     * Method that receive a status as string and return the object State
     * @param status string with the status
     * @return object State
     */
    public static State fromString(String status){
        if (status != null){
            for (State d : State.values()){
                if (d.toString().equalsIgnoreCase(status)) return d;
            }
        }
        return null;
    }

}