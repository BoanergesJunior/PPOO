package heranca_polimorfismo;

public class Poupanca extends Valor_tempo{
	private float taxaSelic;
	private float taxaReferencial;
	
	Poupanca(float taxaSelic, float taxaReferencial, double valorInicial, int meses){
		super(valorInicial, meses);
		this.taxaSelic = taxaSelic;
		this.taxaReferencial = taxaReferencial;
	}
	
	@Override
	public double getValor(){
		double taxa = ((0.7 * taxaSelic + taxaReferencial) * getMeses()) + getValorInicial();
		return taxa;
	}
	
}
