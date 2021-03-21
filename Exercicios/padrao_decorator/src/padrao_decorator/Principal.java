package padrao_decorator;

public class Principal {

	public static void main(String[] args) {
		Sanduiche sanduiche = new PaoHamburguer("X-Burger");
		sanduiche = new Hamburguer(sanduiche);
		sanduiche = new Queijo(sanduiche);
		sanduiche = new Queijo(sanduiche);
		gerarRelatorio(sanduiche);
		
		
		/*Sanduiche sanduiche2 = new PaoFrances("X-Burger2");
		sanduiche2 = new Cebola(sanduiche2);
		sanduiche2 = new Tomate(sanduiche2);
		gerarRelatorio(sanduiche2);*/
	}

	
	public static void gerarRelatorio(Sanduiche sanduiche) {
		System.out.println("Sanduiche: " + sanduiche.getDescricao() + " Preço: R$ " + sanduiche.preco());
	}
}
