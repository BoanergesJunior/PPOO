package classe_abstrata_interface;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ServicoPublico extends Beneficiario{

	private String cpf;
	private String nome;
	private Double tipoBeneficiario;
	
	public ServicoPublico(String cpf, String nome, Double tipoBeneficiario) {
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
		return tipoBeneficiario * 0.8;
	}
	
	@Override
	public Double getINSS() {
		return tipoBeneficiario * 0.14;
	}
	
	@Override 
	public String toString(){
		BigDecimal truncate = new BigDecimal(getINSS());
		truncate = truncate.setScale(2, RoundingMode.DOWN); 
		return "Aposentadoria: " + getAposentadoria() + "\n"
				+ "Contribuicao INSS: " + truncate;
	}
}
