import java.util.Collections;
import java.util.List;
import java.util.Random;
/**
 * Classe responsável pela primeira população do campo
 *
 * @author Boanerges Junior, João Plínio, Wagner Moretti
 */
public class Populate {

    // The probability that a fox will be created in any given grid position.
    private static final double FOX_CREATION_PROBABILITY = 0.05;
    // The probability that a rabbit will be created in any given grid position.
    private static final double RABBIT_CREATION_PROBABILITY = 0.09;
    
	private static final double HUNTER_CREATION_PROBABILITY = 0.05;

    /**
     * Popula pela primeira vez o campo com nossos atores
     * @param field O campo atual, limpo
     * @param actor Lista de atores que irão popular o campo
     * 
     */
    public void populateFirst(Field field, List<Actor> actor) {
        Random rand = new Random();
        field.clear();
        
        Stone stone;
        for (int x = 0; x < 50; x++) {
        	int row = rand.nextInt(field.getDepth() - 3); //****
            int col = rand.nextInt(field.getWidth() - 3);
        	for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    stone = new Stone(i + row, j + col);
                    actor.add(stone);
                    field.place(stone, stone.getRow(), stone.getCol());
                }
            }
        }
        
        Tree tree;
        for (int i = 0; i < 500; i++) {
            int row = rand.nextInt(field.getDepth());
            int col = rand.nextInt(field.getWidth());
            Location loc = new Location(row, col);
            tree = new Tree(row, col);
            if (!(field.getObjectAt(loc) instanceof Stone)) {
                actor.add(tree);
                field.place(tree, tree.getRow(), tree.getCol());
            }
        }

        for (int row = 0; row < field.getDepth(); row++) {
            for (int col = 0; col < field.getWidth(); col++) {
                Location loc = new Location(row, col);

                if (rand.nextDouble() <= FOX_CREATION_PROBABILITY) {
                    Fox fox = new Fox(true, field, loc);
                        actor.add(fox);
                        field.place(fox, row, col);
                } 
                else if (rand.nextDouble() <= RABBIT_CREATION_PROBABILITY) {
                    Rabbit rabbit = new Rabbit(true, field, loc);
                    actor.add(rabbit);
                    field.place(rabbit, row, col);
                }
                else if (rand.nextDouble() <= HUNTER_CREATION_PROBABILITY) {
                	Hunter hunter = new Hunter(true, field, loc);
                	actor.add(hunter);
                	field.place(hunter,row, col);
                }
            }
        }
        Collections.shuffle(actor);
    }
}
