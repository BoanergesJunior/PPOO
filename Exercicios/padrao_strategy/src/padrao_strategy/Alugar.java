package padrao_strategy;

public class Alugar {
	private NotaFiscal tipoVeiculo;
	
	public Alugar(NotaFiscal tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	public double calcularNotaFiscal() {
		return tipoVeiculo.calcularNota();
	}
}
