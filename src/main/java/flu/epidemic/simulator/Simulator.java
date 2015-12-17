package flu.epidemic.simulator;

import flu.epidemic.Enum.Being;
import flu.epidemic.livingbeings.Animal;
import flu.epidemic.livingbeings.Person;
import flu.epidemic.livingbeings.LivingBeings;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.awt.Color;

/**
 * A simple predator-prey simulator, based on a rectangular field containing
 * rabbits and foxes.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class Simulator {
    // Constants representing configuration information for the simulation.
    // The default width for the grid.
    private static final int DEFAULT_WIDTH = 120;
    // The default depth of the grid.
    private static final int DEFAULT_DEPTH = 80;
    // The probability that a person will be created in any given grid position.
    private static final double PERSON_CREATION_PROBABILITY = 0.02;
    // The probability that a animal will be created in any given grid position.
    private static final double ANIMAL_CREATION_PROBABILITY = 0.08;

    // List of living beings in the field.
    private List<LivingBeings> livingBeingses;
    // The current state of the field.
    private Field field;
    // The current step of the simulation.
    private int step;
    // A graphical view of the simulation.
    private List<SimulatorView> views;

    /**
     * Construct a simulation field with default size.
     */
    public Simulator() {
        this(DEFAULT_DEPTH, DEFAULT_WIDTH);
    }

    /**
     * Create a simulation field with the given size.
     * 
     * @param depth
     *            Depth of the field. Must be greater than zero.
     * @param width
     *            Width of the field. Must be greater than zero.
     */
    public Simulator(int depth, int width) {
        if (width <= 0 || depth <= 0) {
            System.out.println("The dimensions must be greater than zero.");
            System.out.println("Using default values.");
            depth = DEFAULT_DEPTH;
            width = DEFAULT_WIDTH;
        }

        livingBeingses = new ArrayList<>();
        field = new Field(depth, width);

        views = new ArrayList<>();

        SimulatorView view = new GridView(depth, width);
        view.setColor(Person.class, Color.ORANGE);
        view.setColor(Animal.class, Color.BLUE);
        view.setColor(Animal.class, Color.GRAY);
        views.add(view);

        view = new GraphView(500, 150, 500);
        view.setColor(Person.class, Color.BLACK);
        view.setColor(Animal.class, Color.RED);
        view.setColor(Animal.class, Color.GREEN);
        views.add(view);

        // Setup a valid starting point.
        reset();
    }

    /**
     * Run the simulation from its current state for a reasonably long period,
     * (4000 steps).
     */
    public void runLongSimulation() {
        simulate(4000);
    }

    /**
     * Run the simulation from its current state for the given number of steps.
     * Stop before the given number of steps if it ceases to be viable.
     * 
     * @param numSteps
     *            The number of steps to run for.
     */
    public void simulate(int numSteps) {
        for (int step = 1; step <= numSteps && views.get(0).isViable(field); step++) {
            simulateOneStep();
        }
    }

    /**
     * Run the simulation from its current state for a single step. Iterate over
     * the whole field updating the state of each fox and rabbit.
     */
    public void simulateOneStep() {
        step++;

        // Provide space for newborn animals.
        List<LivingBeings> newAnimals = new ArrayList<>();
        // Let all rabbits act.
        for (LivingBeings animal : livingBeingses) {
        }

        // Add the newly born foxes and rabbits to the main lists.
        livingBeingses.addAll(newAnimals);

        updateViews();
    }

    /**
     * Reset the simulation to a starting position.
     */
    public void reset() {
        step = 0;
        livingBeingses.clear();
        for (SimulatorView view : views) {
            view.reset();
        }

        populate();
        updateViews();
    }

    /**
     * Update all existing views.
     */
    private void updateViews() {
        for (SimulatorView view : views) {
            view.showStatus(step, field);
        }
    }

    /**
     * Randomly populate the field with animals and people.
     * TODO: see this class after
     */
    private void populate() {
        Random rand = Randomizer.getRandom();
        field.clear();
        for (int row = 0; row < field.getDepth(); row++) {
            for (int col = 0; col < field.getWidth(); col++) {
                if (rand.nextDouble() <= ANIMAL_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                } else if (rand.nextDouble() <= PERSON_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                }
            }
        }
    }
}
