package heranca_polimorfismo;

import java.util.Scanner;
import java.math.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		BigDecimal truncate;
		
		System.out.println("###### SIMULAÇÃO ######");
		System.out.print("Entre com o valor a ser investido: ");
		double valorInicial = in.nextDouble();
		System.out.print("Entre com a duração da aplicação em meses: ");
		int meses = in.nextInt();
		
		System.out.print("1 - Investimento em poupança\n");
		System.out.print("Entre com o valor da taxa Selic em %: ");
		float taxaSelic = in.nextFloat();
		System.out.print("Entre com o valor da taxa referencial (TR) em %: ");
		float taxaReferencial = in.nextFloat();
		Poupanca poupanca = new Poupanca(taxaSelic, taxaReferencial, valorInicial, meses);
		truncate = new BigDecimal(poupanca.getValor());
		truncate = truncate.setScale(2, RoundingMode.UP);
		System.out.print("Valor final para investimento em poupança: " + truncate);
		
		System.out.print("\n2 - Investimento em CDB\n");
		System.out.print("Entre com o valor da taxa CDI em %: ");
		float valorCDI = in.nextFloat();
		CDB cdb = new CDB(valorCDI, valorInicial, meses);
		truncate = new BigDecimal(cdb.getValor());
		truncate = truncate.setScale(2, RoundingMode.UP);
		System.out.print("Valor final para investimento em CDB: " + truncate);
		
		System.out.print("\n3 - Investimento em ação\n");
		System.out.print("Entre com o preço inicial da ação: ");
		float valorInicialAcao = in.nextFloat();
		System.out.print("Entre com o preço final da ação: ");
		float valorFinalAcao = in.nextFloat();
		Acao acao = new Acao(valorInicialAcao, valorFinalAcao, valorInicial, meses);
		truncate = new BigDecimal(acao.getValor());
		truncate = truncate.setScale(2, RoundingMode.UP);
		System.out.print("Valor final para investimento em ação: " + truncate);
		
		in.close();
	}
}
