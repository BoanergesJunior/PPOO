package arquivo_serializacao;

import java.io.*;
import java.util.ArrayList;

public class ManipuladoraArquivos {

	ArrayList<Compras> historico = new ArrayList<>();
	
    public Historico lerArquivoBinario(String nomeArq) {
    	Historico arq = null;
    	
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArq))) {
        	arq = (Historico) ois.readObject();
        } 
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return arq;
    }	
    
    public void salvarArquivoBinario(String nomeArquivo, ArrayList<Compras> historico) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream( "Novo_" + nomeArquivo + ".bin"))) {
            oos.writeObject(historico);
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<Compras> LerTXT(String nomeArquivo){
    	
		 try(BufferedReader arq = new BufferedReader(new FileReader(nomeArquivo + ".txt"))) {
	            String linha = arq.readLine();
	            
	            while (linha != null) {
	                String[] campos = linha.split(",");
	                historico.add(new Compras(campos[0], campos[1], campos[2], Double.parseDouble(campos[3])));
	                linha = arq.readLine();
	            }	
	     } 
		 catch (FileNotFoundException e) {
	            System.out.println("Impossível abrir o arquivo: " + nomeArquivo);

	     } 
		 catch (IOException e) {
	            System.out.println("Problema na leitura do arquivo");
	     }
		 return historico;
	}
    
}
