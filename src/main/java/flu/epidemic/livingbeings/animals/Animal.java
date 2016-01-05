package flu.epidemic.livingbeings.animals;

import flu.epidemic.livingbeings.Being;

import flu.epidemic.states.StateType;
import flu.epidemic.livingbeings.LivingBeings;
import flu.epidemic.simulator.Field;
import flu.epidemic.simulator.Location;
import flu.epidemic.simulator.Randomizer;
import flu.epidemic.states.StatesManager;
import flu.epidemic.states.StatesManagerAnimal;
import flu.epidemic.states.StatesManagerPerson;
import flu.epidemic.virus.Virus;

import java.util.Random;

/**
 * A class representing shared characteristics of animals
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 *
 * @author Gabriela Cavalcante
 * @version 07/12/2015
 */
public abstract class Animal extends LivingBeings {
    // The animal's position in the field.
    private Location location;
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
        super(being, field, location);
        this.field = field;
        this.statesManager = new StatesManagerAnimal(being, field, location);
        // some animals already being sick with their specific virus
        Random rand = Randomizer.getRandom();
        if (rand.nextBoolean()) this.state = StateType.CONTAGIOUS;
    }

    /**
     * Check whether the animal is alive or not.
     * @return true if the animal is still alive.
     */
    public boolean isAlive()
    {
        return alive;
    }

    /**
     * Indicate that the animal is no longer alive.
     * It is removed from the field.
     */
    protected void setDead()
    {
        alive = false;
        if(location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }

    /**
     * Return the animal's location.
     * @return The animal's location.
     */
    protected Location getLocation()
    {
        return location;
    }

    /**
     * Place the animal at the new location in the given field.
     * @param newLocation The animal's new location.
     */
    protected void setLocation(Location newLocation)
    {
        if(location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }

    /**
     * Return the animal's field.
     * @return The animal's field.
     */
    protected Field getField()
    {
        return field;
    }

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

    private void updateTime() {
        if (state.isEquals(StateType.SICK)) {
            virus = statesManager.getCurrentVirus();
            timeInfection++;
        }
        if (state.isEquals(StateType.CONTAGIOUS))
            timeContagious++;
    }
}
