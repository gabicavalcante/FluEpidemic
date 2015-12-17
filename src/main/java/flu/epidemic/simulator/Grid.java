package flu.epidemic.simulator;

/**
 * Created by Raquel on 10/12/2015.
 */
public class Grid {
    /**
     * The social model describes the behaviour of the simulation elements.
     * They all live together on a two-dimensional grid and are in contact with other elements situated
     * within a neighbourhood on the grid.
     * The notion of neighbourhood is a parameter of the simulation, eg,
     * this can be the 4-neighbourhood of row and column neighbours,
     * or the 8-neighbourhood which includes diagonal neighbours,
     * or some other neighbourhood.
     *
     * An element does not necessarily contact all of its neighbours;
     * perhaps a fixed number or some percentage.
     *
     * People can move on the grid into adjacent empty squares (only one element can occupy a square).
     * This can bring them into contact with new elements.
     *
     * Sick, contagious and recovering people move more slowly than healthy people.
     *
     * Animals don't move.

     */
}
