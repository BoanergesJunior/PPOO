import java.awt.Color;

/**
 * Interface responsável para setar o que vemos na classe Field
 *
 * @author Boanerges Junior, João Plínio, Wagner Moretti
 */
public interface SimulatorView {
	/**
	 * 
	 * @param cl A classe que receberá as cores
	 * @param color A cor em que a classe será pintada
	 */
	void setColor(Class cl, Color color);
	/**
	 * @param field
	 * @return Seta o campo como visível
	 */
	boolean isViable(Field field);
	
	/**
	 * @param step Mostra os passos da simulação
	 * @param field O campo atualizado e onde os objetos se encontram
	 */
	void showStatus(int step,Field field);
}
