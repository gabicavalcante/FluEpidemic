package flu.epidemic.livingbeings;

import flu.epidemic.states.StateType;
import flu.epidemic.states.StatesManager;
import flu.epidemic.states.StatesManagerPerson;
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
        this.statesManager = new StatesManagerPerson(field, location);
        this.timeInfection = 0;
    }

    @Override
    public void act() {
        updateTime();

        this.state = statesManager.getState(virus, timeInfection, timeContagious, timeRecover);

        if(state.isEquals(StateType.HEALTHY)) {
            Location newLocation = getField().freeAdjacentLocation(getLocation());

            if (newLocation != null)
                setLocation(newLocation);

        } else if (state.isEquals(StateType.DEAD)) {
            setDead();
        }
    }

    private void updateTime() {
        if (state.isEquals(StateType.SICK)) {
            virus = statesManager.getCurrentVirus();
            timeInfection++;
        }
        if (state.isEquals(StateType.CONTAGIOUS))
            timeContagious++;
        if (state.isEquals(StateType.RECOVERING))
            timeRecover++;
    }
}

