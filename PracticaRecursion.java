
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
			if (respuesta1) {
				return true;
			}
			boolean respuesta2=coordenadasTwitter(x1, y1+x1, xf, yf);
			if (respuesta2) {
				return true;
			}
			return false;
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
	
	public static boolean palindromoIterativo(int x) {
		int falta=x;
		int numeroInvertido=0;
		int resto=0;
		while(falta!=0)
		{
		 resto=falta%10;
		 numeroInvertido=numeroInvertido*10+resto;
		 falta=falta/10;
		}
		if (numeroInvertido==x) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean palindromoRec(int x) {
		return palindromoRec(x, x, 0, 0);
	}
	public static boolean palindromoRec(int x,int numero,int numeroInvertido, int resto) {
		if (numero==0) {
			if (numeroInvertido==x) {
				return true;
			}
			else {
				return false;
			}
		}else {
			resto=numero%10;
			numeroInvertido=numeroInvertido*10+resto;
			numero =numero/10;
			return palindromoRec(x, numero, numeroInvertido, resto);
		}
	}
	public static int imprimir(int x) {
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
		//imprimir(10);
		System.out.println(coordenadasTwitter(1, 24, 123, 172));
		//System.out.println(reachingPoints(3, 3, 12, 9));
		//System.out.println(palindromoIterativo(4224));
		//System.out.println(palindromoRec(0));
	}

}
