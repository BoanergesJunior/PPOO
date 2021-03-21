package padrao_strategy;

public class VeiculoCarga implements NotaFiscal{
	
	double valorDiaria;
	int dias;
	int tipoCabine;
	
	public VeiculoCarga(double valorDiaria, int dias, int tipoCabine) {
		this.valorDiaria = valorDiaria;
		this.dias = dias;
		this.tipoCabine = tipoCabine;
	}
	
	public double calcularNota() {
		return tipoCabine == 1 ? (valorDiaria * dias) : (1.5 * valorDiaria * dias);  
	}
}
