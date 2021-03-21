package heranca_polimorfismo;

public class Valor_tempo {
	
	private double valorInicial;
	private int meses;
	
	
	Valor_tempo(double valorInicial, int meses){
		this.valorInicial = valorInicial;
		this.meses = meses;
	}
	
	public double getValorInicial(){
		return valorInicial;
	}
	
	public int getMeses(){
		return meses;
	}
	
	public double getValor() {
		return 0;
	}

}
