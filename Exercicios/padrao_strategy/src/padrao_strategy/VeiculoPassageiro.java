package padrao_strategy;

public class VeiculoPassageiro implements NotaFiscal{
	
	double valorDiaria;
	int dias;
	int capacidade;
	
	public VeiculoPassageiro(double valorDiaria, int dias, int capacidade) {
		this.valorDiaria = valorDiaria;
		this.dias = dias;
		this.capacidade = capacidade;
	}
	
	public double calcularNota() {	
		return (valorDiaria * dias * (((double)capacidade/100) + 1));
	}
}
