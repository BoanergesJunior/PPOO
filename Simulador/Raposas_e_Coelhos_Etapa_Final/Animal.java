import java.util.List;
import java.util.Random;

/**
 * Classe pai responsável pelos animais
 *
 * * @author Boanerges Junior, João Plínio, Wagner Moretti
 */
public abstract class Animal implements Actor {


    private boolean alive;
    private Field field;
    private Location location;
    private int age;
    private static final Random rand = new Random();

    /**
     *
     * @param exists Define se o objeto está vivo
     * @param field O campo atual do objeto
     * @param location A localização do objeto
     */
    public Animal(boolean exists, Field field, Location location) {
        age = 0;
        this.alive = exists;
        this.field = field;
        this.location = location;
    }

    /**
     * Se existir objeto, define como vivo
     * @return Retorna True se estiver vivo
     */
    public boolean isExists() {
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

    /**
     * Define se o animal pode nascer
     */
    public boolean canBreed() {
        return age >= getBreedingAge();
    }

    /**
     * Incrementa a idade do animal
     */
    protected void incrementAge() {
        age++;
        if (age > getMaxAge()) {
            setAlive(false);
        }
    }
    
    /**
     * Caso seja possível nascer, define quantos animais irão nascer
     * @return The number of births (may be zero).
     */
    protected int breed() {
        int births = 0;
        if (canBreed() && rand.nextDouble() <= getBreedingProb()) {
            births = rand.nextInt(getMaxAge()) + 1;
        }
        return births;
    }

    /**
     * Os animais podem nascer com idade 0 ou aleatória e 0 de fome.
     * @param randomAge Se True os animais nascerão com idade aleatória
     */
    public void randomAge(boolean randomAge) {
        age = 0;
        if (randomAge) {
            age = rand.nextInt(getMaxAge());
        }
    }
    
    /**
     * Nascimento de novos animais
     * @param newAnimals Lista de novos animais
     */
    public void giveBirth(List<Actor> newAnimals) {
        List<Location> free = field.getFreeAdjacentLocations(getLocation());
        int births = breed();
        for (int b = 0; b < births && free.size() > 0; b++) {
            Animal newAnimal = getAnimal(false);
            newAnimals.add(newAnimal);
        }
    }

    /**
     *
     * @return Idade de reprodução do animal
     */
    abstract protected int getBreedingAge();

    /**
     *
     * @return Idade máxima do animal
     */
    abstract protected int getMaxAge();

    /**
     * @return Maximo em que um animal pode reproduzir
     */
    abstract protected int getMaxLitter();

    /**
     * @return Probabilidade do animal reproduzir
     */

    abstract protected double getBreedingProb();

    /**
     * @param exists Seta se o animal está vivo ou morto
     * @return
     */
    abstract protected Animal getAnimal(boolean exists);
}
