package flu.epidemic.states;

import java.util.Random;

import flu.epidemic.livingbeings.Being;
import flu.epidemic.livingbeings.LivingBeings;
import flu.epidemic.livingbeings.animals.Animal;
import flu.epidemic.simulator.Field;
import flu.epidemic.simulator.Location;
import flu.epidemic.simulator.Randomizer;
import flu.epidemic.virus.Virus;

/**
 * @author Huang Xiaohan
 * @version 04/01/2015.
 */
public abstract class StatesManagerAnimal {
	private State currentState;
    private Field field;
    private Location location;
    private Virus currentVirus;
    private Animal animal;

    public StatesManagerAnimal(Animal animal,Field field, Location location) {
        currentState = State.HEALTHY;
        this.field = field;
        this.location = location;
    }

    public StatesManagerAnimal(Animal animal,State state, Field field, Location location) {
        this.currentState = state;
        this.field = field;
        this.location = location;
    }

    public State getState(Virus virus, int timeInfection, int timeContagious) {
        if (currentState.isEquals(State.HEALTHY)) {
            return analyseStateHealthy();
        } else if (currentState.isEquals(State.SICK)) {
            return analyseStateSick(virus, timeInfection);
        } else if (currentState.isEquals(State.CONTAGIUS)) {
            return analyseStateContagious(virus, timeContagious);
        }
        return null;
    }


    private State analyseStateContagious(Virus virus, int timeContagious) {
        if (timeContagious == virus.getContagiousTime()) 
            return State.DEAD;
        else return State.CONTAGIUS;
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
            if (beings != null && beings.getState().isEquals(State.CONTAGIUS) && rand.nextDouble() <= beings.getVirus().getInfectionRate()) {
            	if(animal.getType().isEquals(beings.getType())){
                    currentVirus = beings.getVirus();
                    return State.SICK;
            	}
            	else if((animal.getType().isEquals(Being.DUCK) && beings.getType().isEquals(Being.CHICKEN)) || (animal.getType().isEquals(Being.CHICKEN) && beings.getType().isEquals(Being.DUCK))){
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
