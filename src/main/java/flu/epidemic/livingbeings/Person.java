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

    // manager of the state
    StatesManager statesManager;
    // after infected, the time of infection is increment
    private int timeInfection;
    // after contagious, the time of contagious is increment
    private int timeContagious;
    // after contagious, the time of contagious is increment
    private int timeRecover;

    private int moveSlowly;

    public Person(Field field, Location location) {
        super(Being.PERSON, field, location);
        this.statesManager = new StatesManagerPerson(field, location);
        this.timeInfection = 0;
        moveSlowly = 0;
    }

    @Override
    public void act() {
        if (isAlive()) {
            updateTime();

            this.state = statesManager.getState(virus, timeInfection, timeContagious, timeRecover);

            if (state.isEquals(StateType.HEALTHY)) {
                resetTime();

                Location newLocation = getField().freeAdjacentLocation(getLocation());

                if (newLocation != null)
                    setLocation(newLocation);

            } else if  (state.isEquals(StateType.SICK) || state.isEquals(StateType.CONTAGIOUS)) {
                if ((moveSlowly % 20) == 0) {
                    Location newLocation = getField().freeAdjacentLocation(getLocation());

                    if (newLocation != null)
                        setLocation(newLocation);
                }
                moveSlowly++;
            } else if (state.isEquals(StateType.DEAD)) {
                setDead();
            }
        }
    }

    private void resetTime() {
        timeContagious = 0;
        timeInfection = 0;
        timeRecover = 0;
    }

    @Override
    protected void updateTime() {
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

