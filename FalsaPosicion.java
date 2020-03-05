import java.util.ArrayList;

/*
 * Creado por:
 * Alan Ezequiel Savoy
 * Jorge Salgado 
 * 
 * Metodos Numericos
 * Falsa posicion
 */

public class FalsaPosicion {
	private ArrayList iteraciones = new ArrayList ();
	public double sacarRaiz(Funcion f, double x0, double x1, int n, double error ) {
		// x0 es el valor inicial, x1 el segundo valor, n es el maximo de iteraciones posibles y el error es el error permitido
		double respuesta = Double.NaN;
		double x=x0;
		int k=0;
		String i = "x0\tx1\t\t\t\tx\t\tf(x)\t\terrorPermitido:";
		iteraciones.add(i);
		while (Math.abs(f.evaluar(x))>=error&&k<n) {
			x=((x*f.evaluar(x1)) - (x1 * f.evaluar(x0)))/(f.evaluar(x1)-f.evaluar(x0));
			i="\n"+ x0 + "\t" + x1 + "\t" + x + "\t" + f.evaluar(x) + "\t" + error;
			iteraciones.add(i);
			if (f.evaluar(x0)*f.evaluar(x)<0) {
				x1=x;
			}else {
				x0 = x;
			}
			k++;
			if (k<n) {
				respuesta =x;
			}
		}
		return respuesta;
	}
	
	public ArrayList getIter() {
		return iteraciones;
	}
	
}
abstract class Funcion {
	public abstract double evaluar(double x0);
}

class Main {
	public static void main(String[] args) {
		Funcion f = new Funcion() {

			@Override
			public double evaluar(double x) {
				return Math.pow(x, 10)-(10*x)+4;
			}
		};
		
		FalsaPosicion fp = new FalsaPosicion();
		double raiz = fp.sacarRaiz(f, 0, 1, 20, 0.01);
		System.out.println("El valor de la raiz es: "+raiz);
		System.out.println("Iteraciones realizadas \n"+fp.getIter());
	}
}