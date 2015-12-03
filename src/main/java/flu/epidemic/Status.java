package flu.epidemic;

/**
 * Enum to represents the STATUS of a person.
 */
public enum Status {
    HEALTHY("helthy"),
    SICK("sick"),
    CONTAGIUS("contagious"),
    RECOVERING("recovering");
    DEAD("dead");

    private String name = "";

    /**
     * Constructor enum
     * @param name
     */
    Direction(String name) {
        this.name = name;
    }

    /**
     * Method that change the direction to String
     * @return name
     */
    public String toString() {
        return name;
    }

    /**
     * Method that receive a direction like string and return a object Direction
     * @param status string with the direction
     * @return object Direction
     */
    public static Status fromString(String status){
        if (status != null){
            for (Status d : Status.values()){
                if (d.toString().equalsIgnoreCase(status)) return d;
            }
        }
        return null;
    }
}