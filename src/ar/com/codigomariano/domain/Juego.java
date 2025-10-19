package ar.com.codigomariano.domain;

import java.util.Random;
import java.util.Scanner;

import ar.com.codigomariano.enums.Posiciones;

public class Juego {
	private final static int FILAS=5;
	private final static int COLUMNAS=5;
	
	private char[][] tablero=new char[FILAS][COLUMNAS];
	private final static int TOTAL_JUGADAS=10;
	private final static int BARCOS_HUNDIDOS=5; 
	
	public Juego() {
		inicializarTablero();

	}
	
	private void inicializarTablero() {
		Random r=new Random();
		for(int fila=0;fila<this.tablero.length;fila++) {
			for(int col=0;col<this.tablero[fila].length;col++) {
				int aleatorio=r.nextInt(0, Posiciones.values().length);
				this.tablero[fila][col]=Posiciones.values()[aleatorio].getPosicion();
			}
		}
	}
	
	public void jugar() {
		Scanner s=new Scanner(System.in);
		int barcos=0;
		int jugadas=0;
		char x='x';
		while(jugadas<TOTAL_JUGADAS && barcos!=BARCOS_HUNDIDOS) {
			int fila=ingresarDatos("Ingresa fila(1-5): ",s);
			int col=ingresarDatos("Ingresa columna(1-5): ",s);
			if(this.tablero[fila][col]==x) {
				mensaje("Ya ingresastes en esta posicion");
			} else {
				if(this.tablero[fila][col]==Posiciones.BARCO.getPosicion()) {
					mensaje("¡Hundiste un "+Posiciones.BARCO+"!");
					barcos++;
				}else {
					mensaje("¡"+Posiciones.AGUA+"!");
				}
			}
			tablero[fila][col]=x;
			jugadas++;
			}
		mensaje("Has hundido: "+barcos+" barcos");	
		mensaje("Juego terminado");
		s.close();
	}
	
	private int ingresarDatos(String texto,Scanner s) {
		int datoIngresado=0;
		System.out.print(texto);
		datoIngresado=(s.nextInt())-1;
		return datoIngresado;
	}
	private void mensaje(String texto) {
		System.out.println(texto);
	}

}
