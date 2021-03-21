import java.util.Iterator;
import java.util.List;
import java.util.Random;
/**
 * Classe responsavel pelos caçadores que existem no campo
 *
 * @author Boanerges Junior, João Plínio, Wagner Moretti
 */
public class Hunter implements Actor {
    
    // The age to which a hunter can live.
    private static final int MAX_AGE = 250;
    // The food value of a single rabbit. In effect, this is the
    // number of steps a hunter can go before it has to eat again.
    private static final int RABBIT_FOOD_VALUE = 8;
    // A shared random number generator.
    private static final Random rand = new Random();

    // idade do cacador
    private int age;
    // Atributo para verificar se o cacador esta vivo ou nao
    private boolean alive;
    // Localizacao do cacador
    private Location location;
    // Nivel de fome do cacador, aumenta quando encontra um coelho
    private int foodLevel;

    private Field field;
    /**
     * Cria um objeto da classe hunter. Um caçador é criado com idade aleatoria
     * e nivel de fome > 0.
     * 
     * @param randomAge Se True, o objeto e criado com idade aleatoria de fome > 0
     */
    public Hunter(boolean randomAge, Field field, Location location) {
    	this.age = 0;
        this.alive = randomAge;
        this.field = field;
        this.location = location;
        setAlive(true);
        if (randomAge) {
            foodLevel = rand.nextInt(RABBIT_FOOD_VALUE);
        } else {
            // leave age at 0
            foodLevel = RABBIT_FOOD_VALUE;
        }
    }
    
    /**
     * Representa o comportamento da classe hunter
     */
    @Override
    public void act(Field updatedField, List<Actor> newFoxes) {
        incrementAge();
        incrementHunger();
        Field field = getField();
        
        if (isExists()) {
            Location newLocation = findFood(field, getLocation());

            if (newLocation == null) {
                newLocation = updatedField.freeAdjacentLocation(getLocation());
            }
            if (newLocation != null) {
                setLocation(newLocation);
                updatedField.place(this, newLocation);
            } else {
                setAlive(false);
            }
        }
    }
    
    private void incrementAge()
    {
        age++;
        if(age > MAX_AGE) {
            alive = false;
        }
    }
    
    private void incrementHunger()
    {
        foodLevel--;
        if(foodLevel <= 0) {
            alive = false;
        }
    }
    
    /**
     * Metodo para cacar objetos do tipo Rabbit
     * @param field O novo local para o Hunter ir
     * @param location Onde esta localizado
     * @return Retorna o novo local que encontrou comida, caso não retorna nulo
     */
    private Location findFood(Field field, Location location) {
        List<Location> adjacent = field.adjacentLocations(location);
        Iterator<Location> it = adjacent.iterator();
        while (it.hasNext()) {
            Location where = (Location) it.next();
            Actor actors = field.getObjectAt(where);
            if (actors instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) actors;
                if (rabbit.isExists()) {
                    rabbit.setEaten();
                    foodLevel = RABBIT_FOOD_VALUE;
                    return where;
                }
            }
        }
        return null;
    }
    
    /**
     * @return True se estiver vivo
     */
    public boolean isAlive()
    {
        return alive;
    }

    /**
     * Seta uma nova localização para o objeto
     * @param row Linha no campo
     * @param col Coluna no campo
     */
    public void setLocation(int row, int col) {
        this.location = new Location(row, col);
    }

    /**
     * Define a localização do objeto
     *
     * @param location Nova localização
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     *
     * @return Retorna a localização atual do objeto
     */
    public Location getLocation() {
        return location;
    }

    /**
     * 
     * @return Retorna o campo do objeto
     */
    public Field getField() {
        return field;
    }

    /**
     * Seta o objeto como vivo ou morto
     * @param alive True vivo, False morto
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

	@Override
	public boolean isExists() {
		return alive;
	}	
}
