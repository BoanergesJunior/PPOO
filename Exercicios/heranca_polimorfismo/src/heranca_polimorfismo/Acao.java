package heranca_polimorfismo;

public class Acao extends Valor_tempo{

	private float valorInicialAcao;
	private float valorFinalAcao;
	
	
	Acao(float valorInicialAcao, float valorFinalAcao, double valorInicial, int meses){
		super(valorInicial, meses);
		this.valorInicialAcao = valorInicialAcao;
		this.valorFinalAcao = valorFinalAcao;
	}
	
	@Override
	public double getValor(){
		double calculo = ((valorFinalAcao/valorInicialAcao) * 100) - 100;
		double taxa = (calculo * getMeses()) + getValorInicial();
		return taxa;
	}
}
