package exercicio_1;

public class Custo {

	public void valorProduto(int codigo, int quantidade) {
		Double valor = 0.0;
		
		if(codigo <= 10) valor = 10.0;
		else if(codigo > 10 && codigo <= 20) valor = 15.0;
		else if(codigo > 20 && codigo <= 30) valor = 20.0;
		else if(codigo > 30 && codigo <= 40) valor = 30.0;
		
		Desconto desconto = new Desconto();
		
		Double total = valor * quantidade;
		
		System.out.print(valor + "\n" + total + "\n");
		
		desconto.desconto(total);
	}

}
