package flu.epidemic.livingbeings;

import java.util.Date;

import java.util.List;

import flu.epidemic.states.State;
import flu.epidemic.states.StatesManager;
import flu.epidemic.simulator.Field;

import flu.epidemic.simulator.Location;

/**
 * @author Huang Xiaohan
 * @author Gabriela Cavalcante
 * @version 10/12/15
 */
public class Person extends LivingBeings {

    private static final double VACCINATED_RATE = 0.02;
    private static final double CONTAGIOUS = 2;

    // manager of the state
    StatesManager statesManager;
    // after infected, the time of infection is increment
    private int timeInfection;
    // after contagious, the time of contagious is increment
    private int timeContagious;
    // after contagious, the time of contagious is increment
    private int timeRecover;

    public Person(Field field, Location location) {
        super(Being.PERSON, field, location);
        this.statesManager = new StatesManager(field, location);
        this.timeInfection = 0;
    }

    @Override
    public void act() {
        updateTime();

        this.state = statesManager.getState(virus, timeInfection, timeContagious, timeRecover);

        if(state.isEquals(State.HEALTHY)) {
            Location newLocation = getField().freeAdjacentLocation(getLocation());

            if (newLocation != null)
                setLocation(newLocation);

        } else if (state.isEquals(State.DEAD)) {
            setDead();
        }
    }

    private void updateTime() {
        if (state.isEquals(State.SICK)) {
            virus = statesManager.getCurrentVirus();
            timeInfection++;
        }
        if (state.isEquals(State.CONTAGIUS))
            timeContagious++;
        if (state.isEquals(State.RECOVERING))
            timeRecover++;
    }
}

