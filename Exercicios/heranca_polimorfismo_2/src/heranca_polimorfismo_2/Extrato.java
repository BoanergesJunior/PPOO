package heranca_polimorfismo_2;

import java.util.ArrayList;

public class Extrato {
	private ArrayList<MovimentacaoFinanceira> listaDeMovimentacao = new ArrayList<>();
	
	Extrato(){}
	
	public void addExtrato(MovimentacaoFinanceira movimentacao) {
		listaDeMovimentacao.add(movimentacao);
	}
	
	public void printMovimentacao() {
		 for(MovimentacaoFinanceira obj : listaDeMovimentacao) {
			 obj.printMovimentacao();
			 System.out.println(obj.toString() + "\n");
		 }
	}

}
