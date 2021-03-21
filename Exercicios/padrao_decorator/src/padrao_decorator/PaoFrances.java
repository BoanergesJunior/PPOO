package padrao_decorator;

public class PaoFrances extends Sanduiche{
	public PaoFrances(String nome) {
		setDescricao(nome);
	}
	
	@Override
	public double preco() {

		return 1.50;
	}
}
