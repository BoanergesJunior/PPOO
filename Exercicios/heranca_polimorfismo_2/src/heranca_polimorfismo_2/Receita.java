package heranca_polimorfismo_2;

public class Receita extends MovimentacaoFinanceira{
	private String cpf;
	private String tipoRecebimento;
	private Double impostoPagar;
	
	Receita(int dia, int mes, int ano, String horario, double valor, String cpf, String tipoRecebimento){
		super(dia, mes, ano, horario, valor);
		this.cpf = cpf;
		this.tipoRecebimento = tipoRecebimento;
		imposto();
	}
	
	public String getCPF() {
		return cpf;
	}
	
	public String getTipoPagamento() {
		return tipoRecebimento;
	}
	
	@Override
	public void imposto(){
		String recebimento = getTipoPagamento();		
		double[] taxaFixa = getTaxaFixa();
		
		if(recebimento.equals("Dinheiro")) {
			impostoPagar = ((taxaFixa[getMes() - 1] + taxaFixa[getMes() - 1] * 0.015));
		}
		else if(recebimento.equals("Debito"))
			impostoPagar = (taxaFixa[getMes() - 1] + taxaFixa[getMes() - 1] * 0.03);
		else
			impostoPagar = (taxaFixa[getMes()] + taxaFixa[getMes() - 1] * 0.04);		
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		else if(!(obj instanceof Receita))
			return false;
		else {
			Receita receita = (Receita) obj;
			return tipoRecebimento == receita.tipoRecebimento;
		}
	}
	
	@Override
	public int hashCode() {
		int resultado = 13;
		return resultado = 37 * resultado + tipoRecebimento.hashCode();
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
				"CNPJ: " + getCPF() + "\n" +
				"Forma de pagamento: " + getTipoPagamento() + "\n");
				
	}
}
