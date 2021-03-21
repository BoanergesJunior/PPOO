package heranca_polimorfismo_2;

import java.util.Scanner;

public class Programa {

	private static Scanner in = new Scanner(System.in);
	private static Extrato extrato = new Extrato();
	
	public static void main(String[] args) {
		
		
		//Despesa();
		//Despesa();
		
		//Receita();
		//Receita();
		
		MovimentacaoFinanceira movimentacao1 = new Despesa(8, 2, 2018, "15:30", 500.0, "012.345.678/0001-10", 3);
		extrato.addExtrato(movimentacao1);
		
		MovimentacaoFinanceira movimentacao2 = new Despesa(9, 4, 2018, "13:49", 700.0, "765.432.109/0001-10", 1);
		extrato.addExtrato(movimentacao2);
		
		MovimentacaoFinanceira movimentacao3 = new Receita(10, 6, 2018, "09:28", 1500.0, "123.456.789-0", "Debito");
		extrato.addExtrato(movimentacao3);
		
		MovimentacaoFinanceira movimentacao4 = new Receita(11, 10, 2018, "17:00", 1000.0, "098.765.432-1", "Dinheiro");
		extrato.addExtrato(movimentacao4);
		
		
		extrato.printMovimentacao();
	}
	
	private static void Despesa() {
		System.out.print("Inserir data, mes e ano: ");
		int dia = in.nextInt();
		int mes = in.nextInt();
		int ano = in.nextInt();
		
		System.out.print("Inserir hora: ");
		String horario = in.next();
		
		
		System.out.print("Inserir valor: ");
		Double valor = in.nextDouble();
		
		System.out.print("Inserir CNPJ: ");
		String cnpj = in.next();
		
		System.out.print("Inserir número de parcelas: ");
		int nParcelas = in.nextInt();
		
		MovimentacaoFinanceira movimentacao = new Despesa(dia, mes, ano, horario, valor, cnpj, nParcelas);
		extrato.addExtrato(movimentacao);
		
	}
	
	private static void Receita() {
		System.out.print("Inserir data, mes e ano: ");
		int dia = in.nextInt();
		int mes = in.nextInt();
		int ano = in.nextInt();
		
		System.out.print("Inserir hora: ");
		String horario = in.next();
		
		System.out.print("Inserir valor: ");
		Double valor = in.nextDouble();
		
		System.out.print("Inserir CPF: ");
		String cpf = in.next();
		
		System.out.print("Inserir forma de pagamento: ");
		String formaPagamento = in.next();
		
		MovimentacaoFinanceira movimentacao = new Receita(dia, mes, ano, horario, valor, cpf, formaPagamento);
		extrato.addExtrato(movimentacao);
		System.out.print("\n");
	}
}

