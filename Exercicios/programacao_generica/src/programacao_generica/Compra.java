//package programacao_generica;

public class Compra implements Comparable<Compra>{
	private String nomeProduto;
	private int qntComprada;
	private double precoUnid;
	private double desconto;
	
	Compra(String nomeProduto, int qntComprada, double precoUnid, double desconto){
		this.nomeProduto = nomeProduto;
		this.qntComprada = qntComprada;
		this.precoUnid = precoUnid;
		this.desconto = desconto;
	}
	
	public String getNome() {
		return nomeProduto;
	}
	
	public int getQnt() {
		return qntComprada;
	}
	
	public double getPreco() {
		return precoUnid;
	}
	
	public double getDesconto() {
		return desconto;
	}
	
	public double calcularDesconto() {
		return 0.0;
	}

	@Override
	public int compareTo(Compra compra) {
        if(this.calcularDesconto() > compra.calcularDesconto()){
            return 1;
        }else if(this.calcularDesconto() < compra.calcularDesconto()){
            return -1;

        }
		return 0;
	}
	
	public String toString() {
		return getNome() + "\t" + getQnt() + "\t" + getPreco() + "\t" + calcularDesconto();
	}
	
}
