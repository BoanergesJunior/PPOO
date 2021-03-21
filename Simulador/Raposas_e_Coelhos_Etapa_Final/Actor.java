import java.util.List;

/**
 * Classe responsável pelos objetos em campo
 *
 * * @author Boanerges Junior, João Plínio, Wagner Moretti
 */
public interface Actor {
    
    /**
     * Define as ações dos objetos
     * @param updatedField Campo atualizado.
     * @param actors Lista de objetos no campo
     */
    abstract public void act (Field updatedField,List<Actor> actors);
    /**
     * 
     * @return Retorna True se estiver vivo
     */
    abstract public boolean isExists();
}
