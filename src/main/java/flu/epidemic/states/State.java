package flu.epidemic.states;

/**
 * util to represents the STATUS of a person.
 *
 * @author Raquel Lopes de Oliveira
 * @author Gabriela Cavalcante
 * @created 03/12/2015
 */
public enum State {
    HEALTHY("healthy"),
    SICK("sick"),
    CONTAGIUS("contagious"),
    RECOVERING("recovering"),
    DEAD("dead");

    private String state = "";

    /**
     * Constructor enum
     * @param state current state
     */
    State(String state) {
        this.state = state;
    }

    /**
     * Method to change status to String
     * @return current state
     */
    public String toString() {
        return this.state;
    }

    public boolean isEquals(State state) { return this.state.equalsIgnoreCase(state.toString()); }

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