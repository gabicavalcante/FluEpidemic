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
 * @author Gabriela Cavalcante
 * @version 04/01/2015.
 */
public class StatesManagerAnimal extends StatesManager {
    private Being animalType;

    public StatesManagerAnimal(Being animal, Field field, Location location) {
        super(field, location);
        this.animalType = animal;
    }

    public StatesManagerAnimal(Being animal, StateType state, Field field, Location location) {
        super(field, location);
        this.currentState = state;
        this.animalType = animal;
    }

    @Override
    public StateType getState(Virus virus, int timeInfection, int timeContagious) {
        if (currentState.isEquals(StateType.HEALTHY)) {
            currentState = analyseStateHealthy();
        } else if (currentState.isEquals(StateType.SICK)) {
            currentState = analyseStateSick(virus, timeInfection);
        } else if (currentState.isEquals(StateType.CONTAGIOUS)) {
            currentState = analyseStateContagious(virus, timeContagious);
        }
        return currentState;
    }

    @Override
    public StateType getState(Virus virus, int timeInfection, int timeContagious, int timeRecover) {
        return null;
    }

    @Override
    StateType analyseStateContagious(Virus virus, int timeContagious) {
        if (timeContagious == virus.getContagiousTime()) 
            return StateType.DEAD;
        return StateType.CONTAGIOUS;
    }

    @Override
    StateType analyseStateHealthy() {
        for (Location loc : field.adjacentLocations(location)) {
            LivingBeings beings = (LivingBeings) field.getObjectAt(loc);
            Random rand = Randomizer.getRandom();
            if (beings != null && beings.getState().isEquals(StateType.CONTAGIOUS) && rand.nextDouble() <= beings.getVirus().getInfectionRate()) {
            	if (animalType.isEquals(beings.getType())){
                    currentVirus = beings.getVirus();
                    return StateType.SICK;
            	}
            	else if((animalType.isEquals(Being.DUCK) && beings.getType().isEquals(Being.CHICKEN)) ||
                        (animalType.isEquals(Being.CHICKEN) && beings.getType().isEquals(Being.DUCK))){
            		currentVirus = beings.getVirus();
                    return StateType.SICK;
            	}
            }
        }
        return StateType.HEALTHY;
    }
}
