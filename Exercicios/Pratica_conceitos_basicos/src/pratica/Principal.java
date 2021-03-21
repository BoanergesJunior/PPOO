//package pratica;

import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
			
		System.out.print("Cadastrar nova disciplina: ");
		String sigla = in.nextLine();
		Departamento departamento = new Departamento(sigla);
		Disciplina remover;
		
		int comando;
		do {
			System.out.print(
				"########### SISTEMA DE CADASTRO ###########\n" +
				"1 - Cadastrar nova disciplina\n" +
				"2 - Remover disciplina\n" +
				"3 - Listar todas as disciplinas\n" +
				"4 - Sair\n" +
				"Escolha o número correspondente a uma das opções anteriores: "
			);
			
			comando = in.nextInt();
			
			switch(comando) {
				case 1:
					System.out.print("Cadastrar nova disciplina: ");
					String codigo = in.next();
					departamento.adicionarDisciplina(codigo);
					break;
				case 2:
					System.out.print("Codigo da disciplina a remover: ");
					String codRemover = in.next();
					remover = departamento.buscarDisciplina(codRemover);
					if(remover != null)
						departamento.removerDisciplina(remover.getCodigo());
					break;
				case 3:
					departamento.listarDisciplinas();
					break;
			}
		}while(comando != 4);
		
		in.close();
	}
}
