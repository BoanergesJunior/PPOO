package arquivo_serializacao;

import java.io.*;
import java.util.ArrayList;



public class Historico{
	private ArrayList<Compras> historico;//contendo tudo do txt
	private ArrayList<Compras> relatorio;//relatorio de acordo com cpf
	private ManipuladoraArquivos manipulaArq;
	
	public Historico() {
		historico = new ArrayList<Compras>();
		relatorio = new ArrayList<Compras>();
		manipulaArq = new ManipuladoraArquivos();
	}
	
	public void gravarRelatorioTxt() {
		
		if(relatorio.isEmpty())
			System.out.print("Não relatório para salvar \n\n");
		else {
			String cpf = relatorio.get(0).getCPF();
			try (FileWriter arquivo = new FileWriter(cpf + ".txt")) {
	            for (Compras compras : relatorio) {
	                arquivo.write(compras.getCPF() + "," + compras.getNome() + "," + compras.getData() + "," + compras.getValor() + "\n");
	            }
	        }
			catch (IOException e) {
	            System.out.println("Falha ao salvar o Arquivo " + cpf + ".txt");
	        }
		}
	}
	
	public void historicoTxt(String nomeArquivo) {
		historico = manipulaArq.LerTXT(nomeArquivo);
	}
	
	public void gerarRelatorio(String cpf) {
		Compras cliente = new Compras();
		relatorio = cliente.gerarRelatorioCliente(historico, cpf);
	}
	
	public void lerBIN(String nomeArquivo) {
		Historico arqBin = new Historico();
		arqBin = manipulaArq.lerArquivoBinario(nomeArquivo);
	}
	
	public void salvarBIN(String nomeArquivo) {
		manipulaArq.salvarArquivoBinario(nomeArquivo, historico);
	}
	
}
