package padrao_strategy;

import java.util.Scanner;

public class Principal {
	static Scanner in = new Scanner(System.in);
	static Alugar alugar;
	static double resultado;
	static double valor;
	static int dias;
	static int tipoCabine;
	static int capacidade;
	
	public static void main(String[] args) {
		menu();
		
		int opcao = in.nextInt();
		
		calcular(opcao);
	}

	public static void menu() {
		System.out.println("#### LOCADORA DE VEICULOS ####\n"
				+ "1 - Gerar nota para veículo de passeio\n"
				+ "2 - Gerar nota para veículo de carga\n"
				+ "3 - Gerar nota para veículo de passageiros\n"
				+ "4 - Sair "
				+ "Escolha uma opcao:");
	}
	
	public static void calcular(int opcao) {
		switch(opcao) {
			case 1:
				System.out.println("Entre com valor da diária: ");
				valor = in.nextDouble();
				System.out.println("Entre com quantidade de dias: ");
				dias = in.nextInt();
				alugar = new Alugar(new VeiculoPasseio(valor, dias));
				resultado = alugar.calcularNotaFiscal();
				exibirResultado(resultado);
				break;
				
			case 2:
				System.out.println("Entre com valor da diária: ");
				valor = in.nextDouble();
				System.out.println("Entre com quantidade de dias: ");
				dias = in.nextInt();
				System.out.println("Entre com o tipo de cabine: ");
				tipoCabine = in.nextInt();
				alugar = new Alugar(new VeiculoCarga(valor, dias, tipoCabine));
				resultado = alugar.calcularNotaFiscal();
				exibirResultado(resultado);
				break;
				
			case 3:
				System.out.println("Entre com valor da diária: ");
				valor = in.nextDouble();
				System.out.println("Entre com quantidade de dias: ");
				dias = in.nextInt();
				System.out.println("Entre com o tipo a capacidade: ");
				capacidade = in.nextInt();
				alugar = new Alugar(new VeiculoPassageiro(valor, dias, capacidade));
				resultado = alugar.calcularNotaFiscal();
				exibirResultado(resultado);
				break;
				
			case 4:
				break;
				
			default:
				System.out.println("Opção Inválida");
				break;
		}
	}
	
	public static void exibirResultado(double resultado) {
		System.out.println("===================== Nota Fiscal =============================\n"
				+ "= Valor a ser pago: R$ " + resultado + "\n"
				+ "===============================================================");
	}
}
