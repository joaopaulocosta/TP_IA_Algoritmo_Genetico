package util.ag;

public class Main {
	
	public static final int NUM_GERACOES = 50;
	
	public static void main(String [] args){
		Populacao pop = new Populacao(10);
		int contGeracoes = 1;
		System.out.println("Geraçao: " + contGeracoes++);
		pop.imprimirPopulacao();
		
		for(int i = 1; i < NUM_GERACOES; i++){
			pop.novaGeracao();
			System.out.println("Geraçao: " + contGeracoes++);
			pop.imprimirPopulacao();
		}	
		
	}
	
	
	
}
