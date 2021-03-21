package classe_abstrata_interface;

public class IniciativaPrivada extends Beneficiario{

	private String cpf;
	private String nome;
	private int tipoBeneficiario;
	
	public IniciativaPrivada(String cpf, String nome, int tipoBeneficiario) {
		this.cpf = cpf;
		this.nome = nome;
		this.tipoBeneficiario = tipoBeneficiario;
	}

	@Override
	public String getNome() {
		return nome;
	}
	
	@Override
	public String getCPF() {
		return cpf;
	}

	@Override
	public Double getAposentadoria() {
		return tipoBeneficiario * 0.01 * 5645.80;
	}
	
	@Override 
	public String toString(){
		return "Aposentadoria: " + getAposentadoria();
	}

	
}
