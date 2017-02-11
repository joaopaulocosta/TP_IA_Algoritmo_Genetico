package util.ag;
import java.util.Random;

public class Populacao {
	
	private static final int PERC_MUTACAO = 1;		//taxa de mutaçao em %
	private static final int PERC_CROSSOVER = 70;	//taxa de crossover em %
	
	private int tam;			//tamanho da populaçao
	private Individuo lista[];	//lista de individuos da populaçao
	
	private int individuosJaSorteados[];	/*vetor que auxilia a funçao torneio, inviabilizando a escolha
											* de um mesmo individuo duas vezes */
	
	//construtor, recebe a quantidade de individuos da populaçao
	public Populacao(int n){
		tam = n;
		lista = new Individuo[n];
		for(int i = 0; i < tam; i++)
			lista[i] = new Individuo();
		individuosJaSorteados = new int[tam];
		
	}
	

	
	/*Método que imprimi as geraçoes no seguinte padrao: 
	* "Individuo Cromossomos(valorBinario) valorDecimal valorEmf(x) */
	public void imprimirPopulacao(){
		for(int i = 0; i < tam; i++){
			int dec = lista[i].getDecimal();
			System.out.println((i+1) + " " + lista[i].getCromo() + " "
					+ dec + " " + f(dec));
		}
		System.out.println();
	}
	
	public void limparSorteio(){
		for(int i = 0; i < tam; i++){
			individuosJaSorteados[i] = 0;
		}
	}
	
	/*Funçao que sorteia entre dois individuos da populaçao e retorna o que possui
	* maior valor de f(x) */
	public Individuo torneio(){
		Random gerador = new Random();
		int a;
		int b;
		
		//inviabiliza individuos serem sorteados mais de uma vez
		do{
			a = gerador.nextInt(tam);
		}while(individuosJaSorteados[a] == 1);	
		
		do{
			b = gerador.nextInt(tam);
		}while(individuosJaSorteados[b] == 1);
	
		
		//envia o individuo com maior valor de f(x)
		Individuo aux;
		if(f(lista[a].getDecimal()) > f(lista[b].getDecimal())){
			individuosJaSorteados[a] = 1;
			return lista[a];
		}
		else{
			individuosJaSorteados[b] = 1;
			return lista[b];
		}
	}
	
	//metodo que aplica a mutaçao no individuo
	public void mutacao(Individuo ind){
		Random gerador = new Random();
		for(int i = 0; i < ind.CROMO; i++){
			if(gerador.nextInt(100) <= PERC_MUTACAO-1){
				ind.trocaCromo(i);
			}
		}
	}
	
	
	//método que aplica o crossover
	public void crossover(Individuo novaGeracao[], int cont){
		Individuo pai = torneio();
		Individuo mae = torneio();
		Random gerador = new Random();
		
		//System.out.println(pai.getCromo() + " " + pai.getDecimal());
		//System.out.println(mae.getCromo() + " " + mae.getDecimal());
		
		if(gerador.nextInt(100)< PERC_CROSSOVER){
			//System.out.println("Crossover");
			int pontoCorte = gerador.nextInt(5);
			//System.out.println("Ponto de corte: " + pontoCorte);
			
			for(int i = 0; i< pontoCorte; i++){
				int aux = pai.getCromo(i);
				pai.setCromo(i, mae.getCromo(i));
				mae.setCromo(i, aux);
			}
			
			pai.calcDecimal();
			mae.calcDecimal();
			
			//System.out.println(pai.getCromo() + " " + pai.getDecimal());
			//System.out.println(mae.getCromo() + " " + mae.getDecimal());
			
			//System.out.println("Mutacao");
			mutacao(pai);
			mutacao(mae);
			pai.calcDecimal();
			mae.calcDecimal();
			
			//System.out.println(pai.getCromo() + " " + pai.getDecimal());
			//System.out.println(mae.getCromo() + " " + mae.getDecimal());
			
		}
		
		novaGeracao[cont++] = pai;
		novaGeracao[cont] = mae;
		
		
		
	}
	
	//método principal que chama os outros metodos necessarios para criar uma nova geraçao
	public void novaGeracao(){
		Individuo novaGeracao[] = new Individuo[tam];
		int cont = 0;
		while(cont < tam){
			crossover(novaGeracao, cont);
			cont += 2;
		}
		
		limparSorteio();
		
		lista = novaGeracao;
	}
	
	//Funçao que calcula o peso de cada individuo
	public int f(int x){
		return ( (x * x) - (3* x) + 4);
	}
	
}
