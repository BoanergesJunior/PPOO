package padrao_decorator;

public abstract class Sanduiche {
	private String nome;
	
	public String getDescricao() {
		return nome;
	}
	
	public void setDescricao(String nome) {
		this.nome = nome;
	}
	
	public abstract double preco();
}
