package exercicio_1;

public class Desconto {

	public void desconto(Double total) {
		
		Double valorDesconto = 0.0;
		Double valorDaCompra = 0.0;
		
		if(total <= 250) valorDesconto = total*0.05;
		else if (total > 250 && total <= 500) valorDesconto = total*0.1;
		else if (total > 500) valorDesconto = total*0.15;
		
		valorDaCompra = total - valorDesconto;
		
		System.out.print(valorDesconto + "\n" + valorDaCompra + "\n");
	}	
}
