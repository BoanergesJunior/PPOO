//package pratica;

import java.util.Scanner;
import java.util.ArrayList;

public class Departamento {
	private String sigla;
	private ArrayList<Disciplina> lista;
	
	Scanner in = new Scanner(System.in);
	
	Departamento(String sigla){
		this.sigla = sigla;
		lista = new ArrayList<>();
		adicionarDisciplina(this.sigla);
	}
	
	public void adicionarDisciplina(String sigla) {
		System.out.print("Insira a carga horaria: ");
		int cargaHoraria = in.nextInt();
		Disciplina disciplina = new Disciplina(sigla, cargaHoraria);
		lista.add(disciplina);
	}
	
	public Disciplina buscarDisciplina(String codDisciplina) {
			
		for(Disciplina object : this.lista) {
			if(object.getCodigo().equals(codDisciplina))
				return lista.get(lista.indexOf(object));
		}
		return null;
	}
	
	public void removerDisciplina(String codDisciplina) {
		int index = 0;
		for(Disciplina object : this.lista) {
			if(object.getCodigo().equals(codDisciplina)) {
				index = lista.indexOf(object);
			}
		}
		lista.remove(index);
	}
	
	public void listarDisciplinas() {
		for(Disciplina print : this.lista) {
			System.out.print("Disciplina: " + print.getCodigo() + " / Carga Horaria Semanal: " + print.getCargaHorariaSemanal() + "\n\n");
		}
	}
}
