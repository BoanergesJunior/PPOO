package padrao_decorator;

public class Hamburguer extends Condimento{

	public Hamburguer(Sanduiche sanduba) {
		super(sanduba);
	}
	
	@Override
	public double preco() {
		return 4.00 + getSanduiche().preco();
	}
	
}
