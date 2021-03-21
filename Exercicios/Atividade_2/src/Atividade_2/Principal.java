package Atividade_2;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		double valorCafe[] = {7.50, 4.30, 10.00};
		double valorComplemento[] = {5.00, 8.00, 2.00};
		
		System.out.print("Digite o código do tipo do café (0: Americano/1: Expresso/2: Sem Cafeína): ");
		int codCafe = in.nextInt();
		
		Cafe cafe = new Cafe(codCafe);
		
		System.out.print("Deseja adicionar algum complemento? (0: não ou 1: sim): ");
		int resposta = in.nextInt();
		int count = 1;
		
		if(resposta == 1) {
			System.out.print("Insira o código do " + count + "º complemento desejado (0: leite, 1: chocolate, 2: canela): ");
			int codComplemento = in.nextInt();
			cafe.inserirComplemento(codComplemento);
			count++;
			
			boolean complemento = true;
			
			System.out.print("Deseja adicionar outro complemento? (0: não ou 1: sim): ");
			resposta = in.nextInt();
			if(resposta == 1) {
				do {
					System.out.print("Insira o código do " + count + "º complemento desejado (0: leite, 1: chocolate, 2: canela): ");
					codComplemento = in.nextInt();
					cafe.inserirComplemento(codComplemento);
					count++;
					
					System.out.print("Deseja adicionar outro complemento? (0: não ou 1: sim): ");
					resposta = in.nextInt();
					if(resposta == 0) {
						complemento = false;
					}
				}while(complemento);
			}
		}
		
		
		String tipoCafe = "";
		switch(cafe.getTipoCafe()) {
			case 0: tipoCafe = "Americano"; break;
			case 1: tipoCafe = "Expresso"; break;
			case 2: tipoCafe = "Sem Cafeína"; break;
		}
		
		System.out.println("############### NOTA FISCAL ###############");
		System.out.println("Café: " + tipoCafe);
		System.out.println("Preço do café: " + valorCafe[cafe.getTipoCafe()]);
		
		double totalComplementos = 0;
		for(int i = 0; i < cafe.getSize(); i++) {
			totalComplementos += valorComplemento[cafe.codComplemento(i)];
		}
		
		System.out.println("Preço dos complementos: " + totalComplementos);
		System.out.println("Total: " + (totalComplementos + valorCafe[cafe.getTipoCafe()]));


	}
	

}
