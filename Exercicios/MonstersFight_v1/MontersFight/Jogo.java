import java.util.Random;
import java.util.Scanner;

/**
  *  Essa eh a classe principal da aplicacao "Monsters Fight".
 *  "Monsters Fight" eh um jogo de luta bastante simples, baseado em texto.
 *  Usuarios podem escolher personagens para lutar, ou seja, enfrentar um
 *  adversário desconhecido.
 * 
 *  Para jogar esse jogo, crie uma instancia dessa classe e chame o metodo
 *  "jogar".
 * 
 *  Essa classe principal cria e inicializa todas as outras: ela cria os
 *  personagens, cria o analisador e comeca o jogo. Ela tambem avalia e 
 *  executa os comandos que o analisador retorna.
 * @author Luiz Merschmann
 * @version 29/11/2020
 */
public class Jogo {
    private Analisador analisador;
    private Personagem personagemAtual;
    private boolean possoTransformar;
    
    /**
     * Cria o jogo e o incializa.
     */
    public Jogo(){
        criarPersonagens();
        analisador = new Analisador();
        possoTransformar = true;
    }
    /**
     * Cria os personagens e define o mapa de transformacoes.
     */
    private void criarPersonagens(){
        Personagem lobisomen, mumia, vampiro, zumbi, diabo;
        
        //Criando os personagens
        lobisomen = new Personagem("lobisomen",4,8);
        mumia = new Personagem("mumia",5,7);
        vampiro = new Personagem("vampiro",6,6);
        zumbi = new Personagem("zumbi",9,4);
        diabo = new Personagem("diabo",10,9);
        
        definirTransformaçõesPesonagens(lobisomen, mumia, vampiro, zumbi, diabo);
    }
    
    private void definirTransformaçõesPesonagens(Personagem lobisomen, Personagem mumia, Personagem vampiro, Personagem zumbi, Personagem diabo ) {
    	 //Definindo as transformações 
        lobisomen.definirTransformacoes(null, null, vampiro, zumbi, null);
        mumia.definirTransformacoes(lobisomen, null, null, null, null);
        vampiro.definirTransformacoes(null, mumia, null, zumbi, null);
        zumbi.definirTransformacoes(lobisomen, null, vampiro, null, diabo);
        diabo.definirTransformacoes(null, null, null, zumbi, null);
        
        personagemAtual = lobisomen;//o jogo começa com o personagem "lobisomen"

    }
    
    /**
     *  Rotina principal do jogo. Loop para obtencao dos comandos.
     */
    public void jogar(){
        //Mensagem inicial do jogo
        imprimirMsgApresentacao();
        // Entra no loop de comando principal. Repetidamente lemos
        // comandos e os executamos.
        boolean fim = false;
        while(!fim){
            Comando com = analisador.pegarComando();
            fim = executarComando(com);
        }
        System.out.println("Até a próxima partida!");
    }
    /**
    * Imprime a mensagem inicial do jogo.
    */
    
    private void observar() {
    	System.out.print(personagemAtual + " " + personagemAtual.getDescricao());
    }
    
    private void imprimirMsgApresentacao(){
        System.out.println("\nSeja bem-vindo ao Monsters Fight");
        System.out.println("Monsters Fight eh um jogo de luta numa versão inicial");
        System.out.println("Digite 'ajuda' se voce precisar");
        
        System.out.println("\nVoce eh um(a) " + personagemAtual.getDescricao());
        
        System.out.println("Transformacoes possiveis: ");
        if(personagemAtual.getPersonagem("lobisomen") != null){
            System.out.println(personagemAtual.getPersonagem("lobisomen").getDescricao());   
        }
        if(personagemAtual.getPersonagem("mumia") != null){
            System.out.println(personagemAtual.getPersonagem("mumia").getDescricao());   
        }
        if(personagemAtual.getPersonagem("vampiro") != null){
            System.out.println(personagemAtual.getPersonagem("vampiro").getDescricao());   
        }
        if(personagemAtual.getPersonagem("zumbi") != null){
            System.out.println(personagemAtual.getPersonagem("zumbi").getDescricao());   
        }
        if(personagemAtual.getPersonagem("diabo") != null){
            System.out.println(personagemAtual.getPersonagem("diabo").getDescricao());   
        }
        System.out.println();
    }
    /**
     * Executa um comando do jogador.
     * @param com O Comando a ser processado.
     * @return true se o comando finaliza o jogo.
     */
    private boolean executarComando(Comando com){
        boolean querSair = false;
        if(com.ehDesconhecido()){
            System.out.println("Comando inválido!");
            return false;
        }
        
        String palavraDeComando = com.getPalavraDeComando();
        if(palavraDeComando.equalsIgnoreCase("ajuda")){
            imprimirAjuda();
        }
        else if(palavraDeComando.equals("transformar")){
            if(possoTransformar){
                transformar(com);
            }
            else{
                System.out.println("Voce deve lutar antes de realizar outra transfomacao!");
            }
        }
        else if(palavraDeComando.equalsIgnoreCase("lutar")){
            querSair = lutar();
        }
        else if(palavraDeComando.equalsIgnoreCase("sair")){
            querSair = sair(com);
        }
        else if(palavraDeComando.equalsIgnoreCase("observar")){
            observar();
        }
        
        return querSair;  
    }
    /**
     * Imprime na tela as informacoes de ajuda.
     * Aqui nos imprimimos a lista de palavras
     * de comando validas.
     */
    private void imprimirAjuda() {
        System.out.println("Suas palavras de comando sao: ");
        System.out.println(analisador.getComandos());
    }
    /** 
     * Tenta transformar o jogador em outro personagem. Se a 
     * transformacao eh posivel ela eh realizada, caso contrario
     * eh impressa uma mensagem de erro.
     * @param com O Comando a ser processado.
     */
    private void transformar(Comando com) {
        if(!com.temSegundaPalavra()){//se nao existe uma segunda palavra no comando nao eh possivel realizar a transformacao
            System.out.println("Transformar em que? Digite transformar ...");
        }
        else{
            //Obtendo a segunda palavra do comando
            String transformacao = com.getSegundaPalavra();
            //Tentando mudar de personagem
            Personagem proximoPersonagem = null;
            if(transformacao.equalsIgnoreCase("lobisomen")){
                proximoPersonagem = personagemAtual.getPersonagem("lobisomen");
            }
            else if(transformacao.equalsIgnoreCase("mumia")){
                proximoPersonagem = personagemAtual.getPersonagem("mumia");
            }
            else if(transformacao.equalsIgnoreCase("vampiro")){
                proximoPersonagem = personagemAtual.getPersonagem("vampiro");
            }
            else if(transformacao.equalsIgnoreCase("zumbi")){
                proximoPersonagem = personagemAtual.getPersonagem("zumbi");
            }
            else if(transformacao.equalsIgnoreCase("diabo")){
                proximoPersonagem = personagemAtual.getPersonagem("diabo");
            }
      
            if(proximoPersonagem == null){
                System.out.println("Essa transformacao nao eh possivel!");
            }else{
            	personagemAtual = proximoPersonagem;
            	transformacaoPossivel();
            	possoTransformar = false;
            }
        }
    }
    
    public void transformacaoPossivel() {
        
        System.out.println("\nVoce eh um(a) " + personagemAtual.getDescricao());
        System.out.println("Transformacoes possiveis: ");
        
        if(personagemAtual.getPersonagem("lobisomen") != null)
            System.out.println(personagemAtual.getPersonagem("lobisomen").getDescricao());  
        if(personagemAtual.getPersonagem("mumia") != null)
        	System.out.println(personagemAtual.getPersonagem("mumia").getDescricao());   
        if(personagemAtual.getPersonagem("vampiro") != null)
        	System.out.println(personagemAtual.getPersonagem("vampiro").getDescricao());   
        if(personagemAtual.getPersonagem("zumbi") != null)
        	System.out.println(personagemAtual.getPersonagem("zumbi").getDescricao());   
        if(personagemAtual.getPersonagem("diabo") != null)
        	System.out.println(personagemAtual.getPersonagem("diabo").getDescricao()); 
        System.out.println();
        
    }
    
    /** 
     * Realiza a luta entre o personagem do jogador e um adversario desconhecido. 
     * Gera um adversario aleatoriamente e coloca-o para lutar com o jogador.
     * Quem tiver as melhores habilidades (forca de ataque e defesa) tem mais chance
     * de vencer a batalha. Se o jogador perder a batalha o jogo termina e, caso
     * contrario, o jogo continua.
     * @return false se o jogo deve continuar ou true caso contrario.
     */
    private boolean lutar() {
        Random numAleatorio = new Random();
        System.out.println("Lutando...");
        int diferenca;
        int forcaAtaqueAdversario = numAleatorio.nextInt(11);
        int forcaDefesaAdversario = numAleatorio.nextInt(11);
        int pesoAtaque = numAleatorio.nextInt(10);
        int pesoDefesa = 10 - pesoAtaque;
        diferenca = (pesoAtaque*(personagemAtual.getForcaAtaque()-forcaAtaqueAdversario)+pesoDefesa*(personagemAtual.getForcaDefesa()-forcaDefesaAdversario))/10;
        if(diferenca >= 0){
            System.out.println("Batalha vencida! Segue o jogo...");
            possoTransformar = true;
            return(false);
        }
        System.out.println("Infelizmente o voce perdeu a batalha e o jogo acabou!");
        return(true);
    }
    /** 
     * Processa o comando "sair". Verifica o resto do comando pra 
     * verificar se queremos realmente sair do jogo.
     * @param com O Comando a ser processado.
     * @return true para sair do jogo ou false para continuar no mesmo.
     */
    private boolean sair(Comando com) {
        if(com.temSegundaPalavra()){
            System.out.println("Sair o que?");
            return false;
        }
        return true;
    }
}
