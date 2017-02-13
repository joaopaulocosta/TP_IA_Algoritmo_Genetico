package util.ag;
import java.util.Random;

/*	Trabalho Pratico de Inteligência Artificial
 *	Desenvolvimento de um Algoritmo Genético
 *	
 *	Autor: Joao Paulo Costa
 *	Autor: Renato Alvarenga */

public class Individuo {
	public static final int CROMO = 5;	//quantidade de cromossomos dos individuos (proporcional ao limitante)
	private static final int LIM = 15;	//limitande do x da funcao usada
	private int cromo[];	//sequencia de bits
	private int dec;		//valor decimal da sequencia de bits
	
	//construtor
	public Individuo(){
		cromo = new int[CROMO];
		gerarCromo();
	}
	
	//gera os cromossomos de valores binarios aleatoriamente
	private void gerarCromo(){
		do{
			Random gerador = new Random();
			for(int i = 0; i < CROMO; i++){
				cromo[i] = gerador.nextInt(2);
			}
			calcDecimal();
		}while(dec > LIM || dec < -LIM);
	}
	
	//Funçao que retorna a sequencia de cromossomos em uma stringBuffer
	public StringBuffer getCromo(){
		StringBuffer str = new StringBuffer("");
		for(int i = (CROMO-1); i >= 0; i--){
			str.append(cromo[i]);
		}
		return str;
	}

	//Calcula o valor decimal dos cromossomos do individuos formado por uma sequencia de bits
	public void calcDecimal(){
		dec = 0;
		for(int i = 0; i < CROMO-1 ; i++){
			dec += cromo[i] * Math.pow(2,i);
		}

		if(cromo[CROMO-1] == 1){
			dec *= -1;
		}
	}
	
	public int getDecimal(){
		return dec;
	}
	
	//troca o valor de um cromossomo
	public void trocaCromo(int i){
		if(cromo[i] == 1)
			cromo[i] = 0;
		else
			cromo[i] = 1;
	}
	
	public int getCromo(int i){
		return cromo[i];
	}
	
	public void setCromo(int i, int valor){
		cromo[i] = valor;
	}
	
}
