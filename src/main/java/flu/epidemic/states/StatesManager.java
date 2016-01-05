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

    protected StatesManager(Field field, Location location) {
        currentState = StateType.HEALTHY;
        this.field = field;
        this.location = location;
    }

    abstract StateType analyseStateContagious(Virus virus, int timeContagious);

    public abstract StateType getState(Virus virus, int timeInfection, int timeContagious);

    public abstract StateType getState(Virus virus, int timeInfection, int timeContagious, int timeRecover);

    StateType analyseStateSick(Virus virus, int timeInfection) {
        if (timeInfection == virus.getIncubationTime()) {
            return StateType.CONTAGIOUS;
        }
        return StateType.SICK;
    }

    abstract StateType analyseStateHealthy();

    public Virus getCurrentVirus() {
        return currentVirus;
    }
}
