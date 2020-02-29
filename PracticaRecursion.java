
public class PracticaRecursion {
	
	public static boolean coordenadasTwitter(int x1, int y1, int xf, int yf ) {
		if (x1>xf || y1>yf) {
			return false;
		}else if (x1==xf && y1==yf) {
			return true;
		}else if (x1==0 && y1==0) {
			return false;
		}else {
			boolean respuesta1=coordenadasTwitter(x1+y1, y1, xf, yf);
			boolean respuesta2=coordenadasTwitter(x1, y1+x1, xf, yf);
			if (!respuesta1) {
				respuesta2=coordenadasTwitter(x1, y1+x1, xf, yf);
				if (!respuesta2) {
					return false;
				}else {
					return true;
				}
			}else if (!respuesta2) {
				respuesta1=coordenadasTwitter(x1+y1, y1, xf, yf);
				if (!respuesta1) {
					return false;
				}else {
					return true;
				}
			}
			else {
				return true;
			}
		}
	}
	
	//version mejorada de coordenadas twitter:
	public static boolean reachingPoints(int x1, int y1, int xf, int yf ) {
		if (x1==xf && y1==yf) {
			return true;
		}else if (x1==0 && y1==0) {
			return false;
		}else if (x1+y1<=xf) {
			return reachingPoints(x1+y1, y1, xf, yf);
		}else if (x1+y1<=yf) {
			return reachingPoints(x1, y1+x1, xf, yf);
		}else {
			return false;
		}
	}
	
	
	private static int imprimir(int x) {
		int respuesta;
		if (x<=0) {
			System.out.println(x);
			return x+1;
		}else {
			System.out.println(x);
			respuesta = imprimir(x-1);
			System.out.println(respuesta);
			return respuesta+1;
		}
	}
	
	public static void main(String[] args) {
		imprimir(10);
		System.out.println(coordenadasTwitter(0, 0, 1, 1));
		System.out.println(reachingPoints(3, 5, 13, 5));
	}

}
