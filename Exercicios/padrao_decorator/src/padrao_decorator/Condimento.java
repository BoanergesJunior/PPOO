package padrao_decorator;

public abstract class Condimento extends Sanduiche{
	private Sanduiche sanduba;
	
	public Condimento(Sanduiche sanduba) {
		this.sanduba = sanduba;
		setDescricao(sanduba.getDescricao());
	}
	
	public Sanduiche getSanduiche() {
		return sanduba;
	}
}
