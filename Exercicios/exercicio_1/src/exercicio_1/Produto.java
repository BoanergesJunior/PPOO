package exercicio_1;

import java.util.Scanner;

public class Produto {

	public static void main(String[] args) {

		Scanner scanIn = new Scanner(System.in);
		Custo custo = new Custo();
		
		System.out.print("Digite o código do produto: ");
		int codigo = scanIn.nextInt();
		System.out.print("Digite a quantidade: ");
		int quantidade = scanIn.nextInt();
		scanIn.close();
		
		custo.valorProduto(codigo, quantidade);
		
	}

}
