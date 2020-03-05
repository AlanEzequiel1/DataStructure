
public class NReinas {
	private int[] tablero;
	public NReinas(int n) {
		tablero = new int[n];
	}

	private void imprimeTablero() {
		for (int i = 0; i < tablero.length; i++) {
			System.out.print(tablero[i]+",");
		}
		System.out.println();
	}
	
	private boolean valida(int fila, int columna) {
		for (int i = 0; i < columna; i++) {
			//revisar que no haya otra reina en la misma columna
			if (tablero[i]==fila) {
				return false;
			}
			//revisar que no haya otra reina en la misma diagonal
			if (Math.abs(columna-i)==Math.abs(fila-tablero[i])) {
				return false;
			}
		}
		return true;
	}
	public void busca() {
		busca(0);
	}
	
	private void busca(int columna) {
		for (int i = 0; i < tablero.length; i++) {
			if (valida(i,columna)) {
				this.tablero[columna]=i;
				if (columna==this.tablero.length-1) {
					imprimeTablero();
				}else {
					busca(columna);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		NReinas reinas= new NReinas(4);
		reinas.busca();

	}

}
