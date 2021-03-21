//package programacao_generica;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class NotaFiscal {
	private int dia, mes, ano;
	List<Compra> listaCompras;
	
	NotaFiscal(int dia, int mes, int ano){
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		listaCompras = new ArrayList<Compra>();
	}
	
	public void comprar(Compra compra) {
		listaCompras.add(compra);
	}
	
	public int getDia() {
		return dia;
	}
	
	public int getMes() {
		return mes;
	}
	
	public int getAno() {
		return ano;
	}
	
	public void imprimirNotaFiscal() {
		Collections.sort(listaCompras);
		
		System.out.print(
				"Data: " + getDia() + "/" + getMes() + "/" + getAno() + "\n\n" +
				"Produto" + "\t\t" + "Qnt" + "\t" + "Preço" + "\t" + "Valor Pago" + "\n"
			);
		
		double total = 0;
		
		for(Compra compra: listaCompras) {
        	System.out.println(compra);
        	total += compra.calcularDesconto();
        }
		
		System.out.print("\n" + "Total R$ " + total);
	}
}
