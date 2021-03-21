package classe_abstrata_interface;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ForcasArmadas extends Beneficiario{

	private String cpf;
	private String nome;
	private Double tipoBeneficiario;
	
	public ForcasArmadas(String cpf, String nome, Double tipoBeneficiario) {
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
		return tipoBeneficiario * 0.9;
	}
	
	@Override
	public Double getINSS() {
		return tipoBeneficiario * 0.11;
	}
	
	@Override 
	public String toString(){
		BigDecimal truncate = new BigDecimal(getINSS());
		truncate = truncate.setScale(2, RoundingMode.DOWN); 
		return "Aposentadoria: " + getAposentadoria() + "\n"
				+ "Contribuicao INSS: " + truncate;
	}
}
