package util.ag;

/*	Trabalho Pratico de Inteligência Artificial
 *	Desenvolvimento de um Algoritmo Genético
 *	
 *	Autor: Joao Paulo Costa
 *	Autor: Renato Alvarenga	 */

public class Main {
	
	public static int numGeracoes = 200;	//numero de geraçoes
	public static int numIndividuos = 10;	//numero de individuos
	
	public static void main(String [] args){
		
		
		if(args.length == 2){
			try{
				numIndividuos  = Integer.parseInt(args[0]);
				numGeracoes  = Integer.parseInt(args[1]);
			}catch(Exception e){
				System.out.println("Os argumentos devem ser do tipo inteiro!");
				return;
			}
		}else if( args.length != 2 && args.length != 0){
			System.out.println("Sao necessarios dois argumentos de entrada.");
			return;
		}

		
		Populacao pop = new Populacao(numIndividuos);
		int contGeracoes = 1;
		System.out.println("Geraçao: " + contGeracoes++);
		pop.imprimirPopulacao();
		
		for(int i = 1; i < numGeracoes; i++){
			pop.novaGeracao();
			System.out.println("Geraçao: " + contGeracoes++);
			pop.imprimirPopulacao();
		}	
		
	}
	
	
	
}
