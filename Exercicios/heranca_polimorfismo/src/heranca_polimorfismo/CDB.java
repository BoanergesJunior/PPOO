package heranca_polimorfismo;

public class CDB extends Valor_tempo{

	private float cdb;
	
	CDB(float cdb, double valor_tempo, int meses){
		super(valor_tempo, meses);
		this.cdb = cdb;
	}
	
	@Override
	public double getValor() {
		double taxa = (1.2 * cdb * getMeses()) + getValorInicial();
		return taxa;
	}
	
}
