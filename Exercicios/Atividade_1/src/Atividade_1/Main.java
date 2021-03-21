package Atividade_1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Insira nome do cliente, dia, mes, ano: ");
		
		String nome = in.nextLine();
		int dia = in.nextInt();
		int mes = in.nextInt();
		int ano = in.nextInt();
		
		System.out.print("Insira quantidade desejada: ");
		
		int quantidade = in.nextInt();
		
		if(quantidade == 5) {
			Carrinho compras = new Carrinho(nome, dia, mes, ano);
			
			System.out.print("Insira os produtos desejados: ");
			
			for(int i = 0; i < 5; i++) {
				String produto = in.next();
				compras.inserirItem(produto);
			}
			compras.exibir(quantidade);
		}
		else {
			Carrinho compras = new Carrinho(nome, dia, mes, ano, quantidade);
			
			System.out.print("Insira os produtos desejados: ");
			
			for(int i = 0; i < quantidade; i++) {
				String produto = in.next();
				compras.inserirItem(produto);
			}
			compras.exibir(quantidade);
		}
		
		in.close();
	}

}
