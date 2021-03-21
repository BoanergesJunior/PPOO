package arquivo_serializacao;

import java.io.IOException;
import java.util.Scanner;


public class Principal {

	private static String arquivoTxt = "dadosTexto";
	private static String arquivoBin = "dadosBinario.bin";
	private static Scanner in = new Scanner(System.in);
	private static ManipuladoraArquivos arq = new ManipuladoraArquivos();
	private static Historico historico = new Historico();
	
	public static void main(String[] args) throws IOException{

		int opcao = 0;
		
		String cpf = "";
		
		System.out.print("1 - Carregar dados de arquivo texto; \n"
						+ "2 - Carregar dados de arquivo binario; \n");
		opcao = in.nextInt();
		
		do {
			switch(opcao) {
				case 1:
					historico.historicoTxt(arquivoTxt);
					break;
					
				case 2:
					historico.lerBIN(arquivoBin);
					break;
					
				case 3:
					System.out.print("CPF ");
					cpf = in.next();
					historico.gerarRelatorio(cpf);
					
				case 4:
					historico.gravarRelatorioTxt();
					break;
					
				case 5:
					historico.salvarBIN(arquivoTxt);
					break;
			}
			menu();
			opcao = in.nextInt();
			
		}while(opcao != 6);
	}
	
	public static void menu() {
		System.out.print(
			"1 - Carregar dados de arquivo texto; \n"
			+ "2 - Carregar dados de arquivo binario; \n"
			+ "3 - Gerar relatorio na tela; \n"
			+ "4 - Salvar relatorio em arquivo de texto; \n"
			+ "5 - Gerar arquivo binario a partir do arquivo texto; \n"
			+ "6 - Sair. \n"
		);
	}

}
