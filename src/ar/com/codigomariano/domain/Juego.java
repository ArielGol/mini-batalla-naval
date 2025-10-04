package ar.com.codigomariano.domain;

import java.util.Random;
import java.util.Scanner;

import ar.com.codigomariano.enums.Posiciones;

public class Juego {
	
	public char[][] tablero=new char[5][5];
	private final static int TOTAL_JUGADAS=10;
	private final static int BARCOS_HUNDIDOS=5; 
	
	public Juego() {
		inicializarTablero(this.tablero);

	}
	
	private static void inicializarTablero(char[][] tablero) {
		Random r=new Random();
		for(int fila=0;fila<tablero.length;fila++) {
			for(int col=0;col<tablero[fila].length;col++) {
				int aleatorio=r.nextInt(0, Posiciones.values().length);
				if(aleatorio==0) {
					tablero[fila][col]=Posiciones.AGUA.getPosicion();
				}else {
					tablero[fila][col]=Posiciones.BARCO.getPosicion();
				}
			}
		}

	}
	
	public static void jugar(char[][] tablero) {
		Scanner s=new Scanner(System.in);
		int barcos=0;
		int jugadas=0;
		while(jugadas<TOTAL_JUGADAS && barcos!=BARCOS_HUNDIDOS) {
			System.out.print("Ingresa fila(1-5): ");
			int fila=(s.nextInt())-1;
			System.out.print("Ingresa columna(1-5): ");
			int col=(s.nextInt())-1;
			if(tablero[fila][col]==0) {
				System.out.println("Ya ingresastes en esta posicion");
			} else {
				if(tablero[fila][col]=='B') {
					System.out.println("¡Hundiste un barco!");
					
					barcos++;
				}else {
					System.out.println("¡Agua!");
				}
			}
			tablero[fila][col]=0;
			jugadas++;
			}
		System.out.println("Has hundido: "+barcos+" barcos");	
		System.out.println("Juego terminado");
		s.close();
	}

}
