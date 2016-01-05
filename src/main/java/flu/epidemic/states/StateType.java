package flu.epidemic.states;

/**
 * util to represents the STATUS of a person.
 *
 * @author Raquel Lopes de Oliveira
 * @author Gabriela Cavalcante
 * @created 03/12/2015
 */
public enum StateType {
    HEALTHY("healthy"),
    SICK("sick"),
    CONTAGIOUS("contagious"),
    RECOVERING("recovering"),
    DEAD("dead");

    private String state = "";

    /**
     * Constructor enum
     * @param state current state
     */
    StateType(String state) {
        this.state = state;
    }

    /**
     * Method to change status to String
     * @return current state
     */
    public String toString() {
        return this.state;
    }

    public boolean isEquals(StateType state) { return this.state.equalsIgnoreCase(state.toString()); }

    /**
     * Method that receive a status as string and return the object StateType
     * @param status string with the status
     * @return object StateType
     */
    public static StateType fromString(String status){
        if (status != null){
            for (StateType d : StateType.values()){
                if (d.toString().equalsIgnoreCase(status)) return d;
            }
        }
        return null;
    }
}