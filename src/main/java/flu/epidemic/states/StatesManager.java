package flu.epidemic.states;

import flu.epidemic.simulator.Field;
import flu.epidemic.simulator.Location;
import flu.epidemic.virus.Virus;

/**
 * @author Gabriela Cavalcante
 * @version 05/01/16.
 */
public abstract class StatesManager {
    protected StateType currentState;
    protected Field field;
    protected Location location;
    protected Virus currentVirus;

    protected StatesManager(StateType stateType, Field field, Location location) {
        currentState = stateType;
        this.field = field;
        this.location = location;
    }

    abstract StateType analyseStateContagious(Virus virus, int timeContagious);

    public abstract StateType getState(Virus virus, int timeInfection, int timeContagious);

    public abstract StateType getState(Virus virus, int timeInfection, int timeContagious, int timeRecover);

    public abstract StateType analyseStateSick(Virus virus, int timeInfection);

    abstract StateType analyseStateHealthy();

    public Virus getCurrentVirus() {
        return currentVirus;
    }
}
