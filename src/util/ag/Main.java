package util.ag;

/*	Trabalho Pratico de Inteligência Artificial
 *	Desenvolvimento de um Algoritmo Genético
 *	
 *	Autor: Joao Paulo Costa
 *	Autor: Renato Alvarenga	 
 *
 *		
 *
 *	OBs: No enunciado tinhamos que limitar o valor de x entre 10 e -10 porém tivemos alguns problemas com a
 *	representatividade em binarios, logo limitamos entre 15 e -15*/

public class Main {
	
	public static final int NUM_GERACOES = 200;	//numero de geraçoes
	public static final int NUM_INDIVIDUOS = 20;	//numero de individuos
	
	public static void main(String [] args){
		Populacao pop = new Populacao(NUM_INDIVIDUOS);
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
