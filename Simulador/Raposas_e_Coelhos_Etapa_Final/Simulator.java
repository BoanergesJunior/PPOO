import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Color;

/**
 * A simple predator-prey simulator, based on a field containing rabbits and
 * foxes, hunters, trees and stones.
 *
 * @author Boanerges Junior, João Plínio, Wagner Moretti
 */
public class Simulator {

    // The private static final variables represent 
    // configuration information for the simulation.
    // The default width for the grid.
    private static final int DEFAULT_WIDTH = 200;
    // The default depth of the grid.
    private static final int DEFAULT_DEPTH = 100;

    // Lista de atores existentes no campo
    private List<Actor> actors;
    // Lista de atores que acabaram de nascer
    private List<Actor> newActors;
    // The current state of the field.
    private Field field;
    // A second field, used to build the next stage of the simulation.
    private Field updatedField;
    // The current step of the simulation.
    private int step;
    // Simulação gráfica
    private AnimatedView view;
    //Initial population.
    private Populate population;

    /**
     * Construct a simulation field with default size.
     */
    public Simulator() {
        this(DEFAULT_DEPTH, DEFAULT_WIDTH);
    }

    /**
     * Create a simulation field with the given size.
     *
     * @param depth Depth of the field. Must be greater than zero.
     * @param width Width of the field. Must be greater than zero.
     */
    public Simulator(int depth, int width) {
        if (width <= 0 || depth <= 0) {
            System.out.println("The dimensions must be greater than zero.");
            System.out.println("Using default values.");
            depth = DEFAULT_DEPTH;
            width = DEFAULT_WIDTH;
        }
        actors = new ArrayList<>();
        newActors = new ArrayList<>();
        field = new Field(depth, width);
        updatedField = new Field(depth, width);
        population = new Populate();

        view = new AnimatedView(depth, width);
        //Cores
        view.setColor(Fox.class, Color.red);
        view.setColor(Rabbit.class, Color.yellow);
        view.setColor(Stone.class, Color.gray);
        view.setColor(Tree.class, Color.green);
        view.setColor(Hunter.class, Color.black);

        // Setup a valid starting point.
        reset();
        runLongSimulation();
    }

    /**
     * Run the simulation from its current state for a reasonably long period,
     * e.g. 50 steps.
     */
    public void runLongSimulation() {
        simulate(50);
    }

    /**
     * Run the simulation from its current state for the given number of steps.
     * Stop before the given number of steps if it ceases to be viable.
     *
     * @param numsteps The number of steps the simulation will take.
     */
    public void simulate(int numSteps) {
        for (int step = 1; step <= numSteps && view.isViable(field); step++) {
            simulateOneStep();
            try {
                Thread.sleep(200);
            } catch (Exception erro) {
            }
        }
    }

    /**
     * Executa a simulação, atualiza todo objeto contido no array
     */
    public void simulateOneStep() {
        step++;
        newActors.clear();
        for (Iterator<Actor> iter = actors.iterator(); iter.hasNext();) {
            Actor animal = iter.next();
            animal.act(updatedField, newActors);

            if (!animal.isExists()) {
                iter.remove();

            }
        }
        actors.addAll(newActors);

        // Swap the field and updatedField at the end of the step.
        Field temp = field;
        field = updatedField;
        updatedField = temp;
        updatedField.clear();

        // display the new field on screen
        view.showStatus(step, field);
    }

    /**
     * Reset the simulation to a starting position.
     */
    public void reset() {
        step = 0;
        actors.clear();
        field.clear();
        updatedField.clear();
        population.populateFirst(field, actors);

        // Show the starting state in the view.
        view.showStatus(step, field);
    }

}
