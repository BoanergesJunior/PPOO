package Atividade_1;

public class Carrinho {
	private String cliente;
	private String[] carrinho;
	private int dia;
	private int mes;
	private int ano;
	private int contadorItens;
	
	public Carrinho(String cliente, int dia, int mes, int ano){
		this.cliente = cliente;
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		carrinho = new String[5];
		contadorItens = 0;
	}
	
	public Carrinho(String cliente, int dia, int mes, int ano, int quantidade) {
		this.cliente = cliente;
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		carrinho = new String[quantidade];
		contadorItens = 0;
	}
	
	public String getCliente(){
		return cliente;
	}
	
	public void inserirItem(String produto){
		carrinho[contadorItens] = produto;
		contadorItens++;
	}
	
	
	public void exibir(int quantidade) {
		System.out.print(
			"Nome: " + getCliente() + "\n" +
			"Data da compra: " + dia + "/" + mes + "/" + ano + "\n" +
			"Itens do carrinho: "
		);
		for(int i = 0; i < quantidade; i++) {
			System.out.print(carrinho[i] + " ");
		}
	}
}
