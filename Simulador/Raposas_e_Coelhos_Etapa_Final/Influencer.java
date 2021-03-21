import java.util.List;
import java.util.Random;

/**
 * The class reponsable for the objects we see in the field
 *
 * @author Boanerges Junior, João Plínio, Wagner Moretti
 */
public abstract class Influencer implements Actor {

    // A shared random number generator to control breeding.
    private static final Random rand = new Random();
    //Row location of the influencer.
    private int row;
    //Col location of the influencer.
    private int col;
    //Field of the influencer
    private Field field;

    /**
     * Constructor of the influencer
     *
     * @param row
     * @param col
     */
    public Influencer(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     *
     * @param updatedField The new field that is going to overplace the main
     * field.
     * @param actors the list of actors.
     */
    @Override
    public void act(Field updatedField, List<Actor> actors) {
        updatedField.place(this, new Location(row, col));
    }

    /**
     * Check whether the animal is alive or not.
     *
     * @return True if the fox is still alive.
     */
    @Override
    public boolean isExists() {
        return true;
    }

    /**
     *
     * @return the row of location the influencer
     */
    public int getRow() {
        return row;
    }

    /**
     *
     * @return the col of location the influencer
     */
    public int getCol() {
        return col;
    }
}
