package Calculadora;

import java.util.ArrayList;

public class CalculoResultado {

		ArrayList<String> equacao;
		private int posicao;
		private double valor1, valor2;
		private double resultado;
		Boolean checkError;

		public CalculoResultado() {
			equacao = new ArrayList<>();
			posicao = 0;
			valor1 = 0;
			valor2 = 0;
			resultado = 0;
			checkError = false;
		}


		public String Resultado(ArrayList<String> calcular) {
			equacao = calcular;
			
			for (int i = 0; i < equacao.size(); i++) {
				if(equacao.get(i).equals("*")) {
					calculaEquacao("*");
					i = 0;
				}
				else if(equacao.get(i).equals("/")) {
					calculaEquacao("/");
					i = 0;
				}
			}
			
			for (int i = 0; i < equacao.size(); i++) {
				if(equacao.get(i).equals("+")) {
					calculaEquacao("+");
					i = 0;
				}
				else if(equacao.get(i).equals("-")) {
					calculaEquacao("-");
					i = 0;
				}
			}
			System.out.println(resultado);
			return Double.toString(resultado);
		}
		
		public void calculaEquacao(String op) {
			posicao = equacao.indexOf(op);
			
			valor1 = Double.parseDouble(equacao.get(posicao - 1));
			valor2 = Double.parseDouble(equacao.get(posicao + 1));
			
			resultado = calculaResultado(valor1, valor2, op);
		
			for (int i = 0; i < 3; i++) {
				equacao.remove(equacao.get(posicao - 1));
			}
			equacao.add(posicao - 1, Double.toString(resultado));
			
		}
		
		public double calculaResultado(double valor1, double valor2, String op) {
			if(op.equals("+"))
				return valor1 + valor2;
			else if (op.equals("-"))
				return valor1 - valor2;
			else if (op.equals("*"))
				return valor1 * valor2;
			else if (op.equals("/")) {
				return valor1 / valor2;
			}
			return 0.0;
		}
}
