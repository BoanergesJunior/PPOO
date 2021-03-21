//package programacao_generica;

public class CompraNormal extends Compra{
	
	CompraNormal(String nomeProduto, int qntComprada, double precoUnid, double desconto){
		super(nomeProduto, qntComprada, precoUnid, desconto);
	}
	
	@Override
	public double calcularDesconto() {
		double valor = getQnt() * getPreco() - (getQnt() * getPreco() * getDesconto()/100);
		return valor > 0 ? valor : 0;
	}
}
