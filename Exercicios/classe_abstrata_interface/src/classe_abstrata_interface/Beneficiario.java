package classe_abstrata_interface;

public abstract class Beneficiario {

	public Beneficiario() {}

	public abstract String getNome();
	
	public abstract String getCPF();

	public abstract Double getAposentadoria();
	
	public abstract Double getINSS();
}
