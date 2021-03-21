package heranca_polimorfismo_2;

public class Despesa extends MovimentacaoFinanceira{
	private String cnpj;
	private int nParcelas;
	private Double impostoPagar;
	
	Despesa(int dia, int mes, int ano, String horario, double valor, String cnpj, int nParcelas){
		super(dia, mes, ano, horario, valor);
		this.cnpj = cnpj;
		this.nParcelas = nParcelas;
		imposto();
	}
	
	public String getCNPJ() {
		return cnpj;
	}

	public int getParcelas() {
		return nParcelas;
	}
	
	@Override
	public void imposto() {
		double[] taxaFixa = getTaxaFixa();
		impostoPagar = (taxaFixa[getMes() - 1] + (getValor() * 0.01) * getParcelas()); 
	}
	
	@Override
	public String toString() {
		return "Imposto a pagar: " + impostoPagar;
	}
	
	@Override
	public void printMovimentacao() {
		System.out.print(
				"Despesa realizada: " + 
				getDia() + "/" + 
				getMes() + "/" + 
				getAno() +
				" " + getHorario() + "\n" +
				"Valor: " + getValor() + "\n" +
				"CNPJ: " + getCNPJ() + "\n" +
				"Numero de Parcelas: " + getParcelas()+ "\n");
	}
}
