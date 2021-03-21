/**
 * Esta classe representa um personagem do jogo, o qual poderá participar de lutas.
 * Cada personagem eh conectado a outros indicando as possiveis transformacoes.
 * A principio as transformacoes sao lobisomen, mumia, vampiro e zumbi. Para
 * cada transformacao possivel, o personagem guarda uma referencia para o outro
 * personagem ou null se nao for possivel aquela transformacao.
 * @author Luiz Merschmann
 * @version 29/11/2020
 */

import java.util.HashMap;

public class Personagem {
    private String identificacao;
    private int forcaAtaque;
    private int forcaDefesa;
    private HashMap<String, Personagem> saida = new HashMap<String, Personagem>();
    
    
    public void todosPersonagens(Personagem lobisomen, Personagem mumia, Personagem vampiro, Personagem zumbi, Personagem diabo) {
    	saida.put("lobisomen", lobisomen);
    	saida.put("mumia", mumia);
    	saida.put("vampiro", vampiro);
    	saida.put("zumbi", zumbi);
    	saida.put("diabo", diabo);
    }
    
    public Personagem getPersonagens(String personagem) {
    	return saida.get(personagem);
    }
    
    public Personagem getPersonagem(String personagem) {
    	if(personagem.equals("lobisomen"))
    		return getPersonagens("lobisomen");
    	if(personagem.equals("mumia"))
    		return getPersonagens("mumia");
    	if(personagem.equals("vampiro"))
    		return getPersonagens("vampiro");
    	if(personagem.equals("zumbi"))
    		return getPersonagens("zumbi");
    	if(personagem.equals("diabo"))
    		return getPersonagens("diabo");
   
    	return null;
    }
    
    /**
     * Cria um personagem com a "descricao" e habilidades (forca
     * de ataque e defesa) passadas. Inicialmente ele não pode
     * sofrer transformacoes.
     * @param descricao A descricao do personagem.
     * @param forcaAtaque A forca de ataque daquele personagem.
     * @param forcaDefesa A forca de defesa daquele personagem.
     */
    public Personagem(String descricao,int forcaAtaque, int forcaDefesa) {
        this.identificacao = descricao;
        this.forcaAtaque = forcaAtaque;
        this.forcaDefesa = forcaDefesa;
    }
    /**
     * Define as transformacoes possiveis. Cada transformacao leva a um
     * outro personagem ou eh null (transformacao impossivel).
     * @param t1 Transformar em lobisomen.
     * @param t2 Transformar em mumia.
     * @param t3 Transformar em vampiro.
     * @param t4 Transformar em zumbi.
     * @param t5 Transformar em diabo.
     */
    public void definirTransformacoes(Personagem t1, Personagem t2, Personagem t3, Personagem t4, Personagem t5){
        if(t1 != null)
            saida.put("lobisomen", t1);
        if(t2 != null)
        	saida.put("mumia", t2);
        if(t3 != null)
        	saida.put("vampiro", t3);
        if(t4 != null)
        	saida.put("zumbi", t4);
        if(t5 != null)
        	saida.put("diabo", t5);

    }
   
    
    public String getIdentificacao() {
    	return identificacao;
    }
    
    public int getForcaAtaque() {
    	return forcaAtaque;
    }
    
    public int getForcaDefesa() {
    	return forcaDefesa;
    }
    
    
    /**
     * @return A descricao do personagem.
     */
    public String getDescricao() {
        return getIdentificacao() + "\t--> Força de ataque = " + getForcaAtaque()+ "\tForça de defesa = " + getForcaDefesa();
    }
}
