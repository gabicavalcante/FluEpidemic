package flu.epidemic;

/**
 * Enum to represents the STATUS of a person.
 *
 * @author Raquel Lopes de Oliveira
 * @version 1.0
 * @created 03/12/2015
 */
public enum Status {
    HEALTHY("helthy"),
    SICK("sick"), //infected
    CONTAGIUS("contagious"),
    RECOVERING("recovering"),
    DEAD("dead");

    private String status = "";
   // private Status previousStatus = "helthy";

    /**
     * Constructor enum
     * @param status
     */
    Status(String status) {
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

    /**
     * Method that receive a status as string and return the object Status
     * @param status string with the status
     * @return object Status
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