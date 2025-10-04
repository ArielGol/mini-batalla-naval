package ar.com.codigomariano.enums;

public enum Posiciones {
	AGUA('A'),
	BARCO('B');
	
	char posiciones;
	
	private Posiciones(char posicion) {
		this.posiciones=posicion;
	}
	
	public char getPosicion() {
		return this.posiciones;
	}
	

}
