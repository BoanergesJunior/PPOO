package Atividade_2;

import java.util.ArrayList;

public class Cafe {
	private int tipoCafe;
	private ArrayList<Integer> lista;
	
	public Cafe(int tipoCafe) {
		this.tipoCafe = tipoCafe;
		lista = new ArrayList<>();
	}
	
	public int getTipoCafe(){
		return tipoCafe;
	}
	
	public int getSize() {
		return lista.size();
	}
	
	public int codComplemento(int posicao) {
		return lista.get(posicao);
	}
	
	public void inserirComplemento(int codComplemento) {
		lista.add(codComplemento);
	}
}
