package flu.epidemic.States;

import flu.epidemic.livingbeings.LivingBeings;
import flu.epidemic.livingbeings.Person;
import flu.epidemic.simulator.Field;
import flu.epidemic.simulator.Location;
import flu.epidemic.simulator.Randomizer;
import flu.epidemic.virus.Virus;

import java.util.Random;

/**
 * @author Gabriela Cavalcante
 * @created 03/01/16.
 */
public class StatesManager {
    private State currentState;
    private Field field;
    private Location location;
    private Virus currentVirus;

    public StatesManager(Field field, Location location) {
        currentState = State.HEALTHY;
        this.field = field;
        this.location = location;
    }

    public StatesManager(State state, Field field, Location location) {
        this.currentState = state;
        this.field = field;
        this.location = location;
    }

    public State getState(Virus virus, int timeInfection, int timeContagious, int timeRecover) {
        if (currentState.isEquals(State.HEALTHY)) {
            return analyseStateHealthy();
        } else if (currentState.isEquals(State.SICK)) {
            return analyseStateSick(virus, timeInfection);
        } else if (currentState.isEquals(State.CONTAGIUS)) {
            return analyseStateContagious(virus, timeContagious);
        } else if (currentState.isEquals(State.RECOVERING)) {
            return analyseStateRecover(virus, timeRecover);
        }
        return null;
    }

    private State analyseStateRecover(Virus virus, int timeRecover) {
        if (timeRecover == virus.getIncubationTime()) {
            return State.HEALTHY;
        }
        return State.RECOVERING;
    }

    private State analyseStateContagious(Virus virus, int timeContagious) {
        Random rand = Randomizer.getRandom();
        if (timeContagious == virus.getContagiousTime()) {
            if (rand.nextDouble() <= virus.getMortalityRate())
                return State.DEAD;
        }
        return State.RECOVERING;
    }

    private State analyseStateSick(Virus virus, int timeInfection) {
        if (timeInfection == virus.getIncubationTime()) {
            return State.CONTAGIUS;
        }
        return State.SICK;
    }

    private State analyseStateHealthy() {
        for (Location loc : field.adjacentLocations(location)) {
            LivingBeings beings = (LivingBeings) field.getObjectAt(loc);
            Random rand = Randomizer.getRandom();
            if (beings != null && beings.getState().isEquals(State.CONTAGIUS)) {
                if(rand.nextDouble() <= beings.getVirus().getInfectionRate()){
                	currentVirus = beings.getVirus();
                    return State.SICK;
                }
            }
        }
        return State.HEALTHY;
    }

    public Virus getCurrentVirus() {
        return currentVirus;
    }
}
