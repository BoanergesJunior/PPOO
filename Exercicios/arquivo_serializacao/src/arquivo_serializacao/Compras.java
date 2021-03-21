package arquivo_serializacao;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class Compras implements Comparable<Compras>, Serializable{

	private static final long serialVersionUID = 1L;
	private String cpf;
	private String nome;
	private String data;
	private Double valor;

	public Compras(String cpf, String nome, String data, Double valor){
		this.cpf = cpf;
		this.nome = nome;
		this.data = data;
		this.valor = valor;
	}

	public Compras(){}

	public String getCPF() {
		return cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getData() {
		return data;
	}
	
	public Double getValor() {
		return valor;
	}
	
	
	public ArrayList<Compras> gerarRelatorioCliente(ArrayList<Compras> historico, String cpf) {
		ArrayList<Compras> cliente = new ArrayList<>();
		for(Compras compras : historico) {
			if(compras.getCPF().equals(cpf)) {
				cliente.add(compras);
			}
		}
		print(cliente);
		return cliente;
	}
	
	public void print(ArrayList<Compras> cliente) {
		Collections.sort(cliente);
		for(Compras compras : cliente) {
			System.out.print(compras);
		}
	}
	
	@Override
	public String toString() {
		return getData() + ", " + getNome() + ", " + getValor() + "\n";
	}
	
	
	@Override
	public int compareTo(Compras cliente) {
        if(this.getValor() > cliente.getValor()){
            return 1;
        }else if(this.getValor() < cliente.getValor()){
            return -1;
        }
		return 0;
	}

	
}
