package padrao_strategy;

public class VeiculoPasseio implements NotaFiscal{
	
	double valorDiaria;
	int dias;
	
	public VeiculoPasseio(double valorDiaria, int dias) {
		this.valorDiaria = valorDiaria;
		this.dias = dias;
	}
	
	public double calcularNota() {
		return valorDiaria * dias;
	}

}
