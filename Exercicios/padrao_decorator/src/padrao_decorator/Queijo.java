package padrao_decorator;

public class Queijo extends Condimento{
	public Queijo(Sanduiche sanduba) {
		super(sanduba);
	}
	
	@Override
	public double preco() {
		return 2.30 + getSanduiche().preco();
	}
}
