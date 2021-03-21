package Calculadora;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;

public class LayoutCalculadora {
	private JFrame janela;
	private JTextField visor;
	
	private JButton igual;
	private JButton mais;
	private JButton menos;
	private JButton dividir;
	private JButton multiplicar;
	private JButton ponto;
	private JButton AC;
	private JButton zero;
	private JButton um;
	private JButton dois;
	private JButton tres;
	private JButton quatro;
	private JButton cinco;
	private JButton seis;
	private JButton sete;
	private JButton oito;
	private JButton nove;
	
	private String setTextVisor;
	private String calculo;
	private ArrayList<String> equacao;
	
	public LayoutCalculadora() {
		
		setTextVisor = "";
		calculo = "";
		equacao = new ArrayList<>();
		
		janela = new JFrame("Calculadora");
		AC = new JButton("AC");
		mais = new JButton("+");
		igual = new JButton("=");
		menos = new JButton("-");
		dividir = new JButton("/");
		multiplicar = new JButton("*");
		ponto = new JButton(".");
		AC = new JButton("AC");
		zero = new JButton("0");
		um = new JButton("1");
		dois = new JButton("2");
		tres = new JButton("3");
		quatro = new JButton("4");
		cinco = new JButton("5");
		seis = new JButton("6");
		sete = new JButton("7");
		oito = new JButton("8");
		nove = new JButton("9");
		
		visor = new JTextField();
		visor.setEditable(false);
		visor.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		//adicao
		mais.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				equacao.add(calculo);
				equacao.add("+");
				calculo = "";
				setTextVisor += "+";
				visor.setText(setTextVisor);
			}
		});
		
		//subtracao
		menos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				equacao.add(calculo);
				equacao.add("-");
				calculo = "";
				setTextVisor += "-";
				visor.setText(setTextVisor);
			}
		});
		
		//divisao
		dividir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				equacao.add(calculo);
				equacao.add("/");
				calculo = "";
				setTextVisor += "/";
				visor.setText(setTextVisor);
			}
		});
		
		//multiplicacao
		multiplicar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				equacao.add(calculo);
				equacao.add("*");
				calculo = "";
				setTextVisor += "*";
				visor.setText(setTextVisor);
			}
		});
		
		ponto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				calculo += ".";
				setTextVisor += ".";
				visor.setText(setTextVisor);
			}
		});
		
		um.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				calculo += "1";
				setTextVisor += "1";
				visor.setText(setTextVisor);
			}
		});
		
		dois.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				calculo += "2";
				setTextVisor += "2";
				visor.setText(setTextVisor);
			}
		});
		
		tres.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				calculo += "3";
				setTextVisor += "3";
				visor.setText(setTextVisor);
			}
		});
		
		quatro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				calculo += "4";
				setTextVisor += "4";
				visor.setText(setTextVisor);
			}
		});
		
		cinco.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				calculo += "5";
				setTextVisor += "5";
				visor.setText(setTextVisor);
			}
		});
		
		seis.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				calculo += "6";
				setTextVisor += "6";
				visor.setText(setTextVisor);
			}
		});
		
		sete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				calculo += "7";
				setTextVisor += "7";
				visor.setText(setTextVisor);
			}
		});
		
		oito.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				calculo += "8";
				setTextVisor += "8";
				visor.setText(setTextVisor);
			}
		});
		
		nove.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				calculo += "9";
				setTextVisor += "9";
				visor.setText(setTextVisor);
			}
		});
		
		zero.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				calculo += "0";
				setTextVisor += "0";
				visor.setText(setTextVisor);
			}
		});
		
		igual.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) { 
				equacao.add(calculo);
				System.out.println(equacao);
				CalculoResultado resultado = new CalculoResultado();
				String valor = resultado.Resultado(equacao); 
				
				valor = valor.length() <= 10 ? valor : valor.substring(0, 10);
				if(valor == "Infinity")
					visor.setText("Math Error");
				else
					visor.setText(valor);
				
				equacao.clear();
				calculo = " ";
				setTextVisor = " ";
			}
		});
		
		AC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				equacao.clear();
				calculo = " ";
				setTextVisor = " ";
				visor.setText(setTextVisor);
			}
		});
		
		montarJanela();
	}
	
	public void montarJanela() {
		janela.setSize(400, 300);
		janela.setLayout(new BorderLayout());
		
		JPanel painelEsq = new JPanel();
		painelEsq.setLayout(new GridLayout(4,4));
		painelEsq.add(um);
		painelEsq.add(dois);
		painelEsq.add(tres);
		painelEsq.add(dividir);
		painelEsq.add(quatro);
		painelEsq.add(cinco);
		painelEsq.add(seis);
		painelEsq.add(multiplicar);
		painelEsq.add(sete);
		painelEsq.add(oito);
		painelEsq.add(nove);
		painelEsq.add(menos);
		painelEsq.add(zero);
		painelEsq.add(ponto);
		painelEsq.add(mais);
		painelEsq.add(igual);
		
		janela.add(painelEsq, BorderLayout.CENTER);
		
		JPanel painelSup = new JPanel();
		painelSup.setLayout(new GridLayout(1,2));
		painelSup.add(AC);
		painelSup.add(visor);
		janela.add(painelSup, BorderLayout.NORTH);
		
		teste();
	}
	
	public void exibir() {
		janela.setVisible(true);
	}
	
	public void teste() {
		visor.setText("0");
	}
	
}
