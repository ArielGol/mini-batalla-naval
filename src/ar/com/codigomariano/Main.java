package ar.com.codigomariano;
import ar.com.codigomariano.domain.Juego;
import ar.com.codigomariano.exceptions.RuleIInvalidException;

public class Main {

	public static void main(String[] args) {
	
		Juego juegoUno=new Juego();
		try {
			juegoUno.jugar();	
		}catch(RuleIInvalidException ex) {
			System.out.println("Fin del juego por ingresos inválidos");
		}
		
		

}
}
