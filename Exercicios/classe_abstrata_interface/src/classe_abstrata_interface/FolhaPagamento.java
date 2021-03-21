package classe_abstrata_interface;
import java.util.ArrayList;


public class FolhaPagamento {
	private ArrayList<Beneficiario> listaBeneficiario = new ArrayList<Beneficiario>();
	
	public void cadastrarBeneficiario(Beneficiario beneficiario) {
		listaBeneficiario.add(beneficiario);

	}
	
	public void gerarFolhaPagamento() {
		for(Beneficiario ben: listaBeneficiario) {
			System.out.println(
				"Nome: " + ben.getNome() + "\n" +
				"Cpf: " + ben.getCPF() + "\n" +
				ben.toString() + "\n");
		}
	}
}
