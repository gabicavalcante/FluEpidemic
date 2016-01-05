package flu.epidemic.livingbeings.animals;

import flu.epidemic.livingbeings.Being;

import flu.epidemic.states.StateType;
import flu.epidemic.livingbeings.LivingBeings;
import flu.epidemic.simulator.Field;
import flu.epidemic.simulator.Location;
import flu.epidemic.simulator.Randomizer;
import flu.epidemic.states.StatesManager;
import flu.epidemic.states.StatesManagerAnimal;
import java.util.Random;

/**
 * A class representing shared characteristics of animals.
 * This class was adapted to the Project Flu Epidemic.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 *
 * @author Gabriela Cavalcante
 * @version 07/12/2015
 */
public abstract class Animal extends LivingBeings {
    // after infected, the time of infection is increment
    private int timeInfection;
    // after contagious, the time of contagious is increment
    private int timeContagious;
    // manager of the state
    StatesManager statesManager;

    /**
     * Create a new animal at location in field.
     *
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Animal(Being being, Field field, Location location)
    {
        super(StateType.SICK, being, field, location);

        // some animals already being sick with their specific virus
        Random rand = Randomizer.getRandom();
        if (rand.nextBoolean()) this.state = StateType.SICK;
        else this.state = StateType.HEALTHY;

        this.field = field;
        this.statesManager = new StatesManagerAnimal(this.state, being, field, location);
    }

    /**
     * Change the State of the Animal.
     */
    @Override
    public void act() {
        if (isAlive()) {
            updateTime();

            this.state = statesManager.getState(virus, timeInfection, timeContagious);

            if (state.isEquals(StateType.DEAD)) {
                setDead();
            }
        }
    }

    /**
     * Update the time of Infection or Contagious.
     */
    @Override
    protected void updateTime() {
        if (state.isEquals(StateType.SICK))
            timeInfection++;
        else if (state.isEquals(StateType.CONTAGIOUS))
            timeContagious++;
    }
}
