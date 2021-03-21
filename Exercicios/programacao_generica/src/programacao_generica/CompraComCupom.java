//package programacao_generica;

public class CompraComCupom extends Compra{

	CompraComCupom(String nomeProduto, int qntComprada, double precoUnid, double desconto){
		super(nomeProduto, qntComprada, precoUnid, desconto);
	}
	
	@Override
	public double calcularDesconto() {
		double valor = getQnt() * getPreco() - getDesconto();
		return valor > 0 ? valor : 0;
	}
}
