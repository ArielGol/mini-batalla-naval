package ar.com.codigomariano.batalla;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		char[][] tablero=new char[5][5];
		
		inicializarTablero(tablero);		
		jugar(tablero);
		
		
		
	
	}
	
	private static void inicializarTablero(char[][] tablero) {
		Random r=new Random();
		char[] posiciones=new char[] {'A','B'};
		for(int fila=0;fila<tablero.length;fila++) {
			for(int col=0;col<tablero[fila].length;col++) {
				int aleatorio=r.nextInt(0, posiciones.length);
				if(aleatorio==0) {
					tablero[fila][col]=posiciones[0];
				}else {
					tablero[fila][col]=posiciones[1];
				}
			}
		}

	}
	
	private static void jugar(char[][] tablero) {
		Scanner s=new Scanner(System.in);
		
		int barcos=0;
		int jugadas=0;
		while(jugadas<10 && barcos!=5) {
			System.out.print("Ingresa fila(1-5): ");
			int fila=(s.nextInt())-1;
			System.out.print("Ingresa columna(1-5): ");
			int col=(s.nextInt())-1;
			if(tablero[fila][col]==0) {
				System.out.println("Ya ingresastes en esta posicion");
			} else {
				if(tablero[fila][col]=='B') {
					System.out.println("¡Hundiste un barco!");
					tablero[fila][col]=0;
					barcos++;
				}else {
					System.out.println("¡Agua!");
					tablero[fila][col]=0;
				
				}
			}
			jugadas++;
			}
			
		System.out.println("Juego terminado");
	}

}
