package padrao_decorator;

public class Tomate extends Condimento{
	public Tomate(Sanduiche sanduba) {
		super(sanduba);
	}
	
	@Override
	public double preco() {
		return 0.50 + getSanduiche().preco();
	}
}
