package ar.com.codigomariano;
import ar.com.codigomariano.domain.Juego;

public class Main {

	public static void main(String[] args) {
	
		Juego juegoUno=new Juego();
		
		char[][] tablero=juegoUno.tablero;
		
		Juego.jugar(tablero);
		

}
}
