package padrao_decorator;

public class Cebola extends Condimento{
	
	public Cebola(Sanduiche sanduba) {
		super(sanduba);
	}
	
	@Override
	public double preco() {
		return 1.30 + getSanduiche().preco();
	}
}
