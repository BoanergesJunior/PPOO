package padrao_decorator;

public class PaoHamburguer extends Sanduiche {
	
	public PaoHamburguer(String nome) {
		setDescricao(nome);
	}
	
	@Override
	public double preco() {

		return 1.50;
	}
	
}
