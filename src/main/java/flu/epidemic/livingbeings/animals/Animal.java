package flu.epidemic.livingbeings.animals;

import flu.epidemic.livingbeings.Being;
import flu.epidemic.states.State;
import flu.epidemic.livingbeings.LivingBeings;
import flu.epidemic.simulator.Field;
import flu.epidemic.simulator.Location;
import flu.epidemic.simulator.Randomizer;

import java.util.Random;

/**
 * A class representing shared characteristics of animals.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public abstract class Animal extends LivingBeings {
    // Whether the animal is alive or not.
    private boolean alive;
    // The animal's position in the field.
    private Location location;

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

        // some animals already being sick with their specific virus
        Random rand = Randomizer.getRandom();
        if (rand.nextBoolean()) this.state = State.CONTAGIUS;
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
}
