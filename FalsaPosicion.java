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
		String i = " Numero de iteración:\tx0\tx1\tx\tf(x)\terrorPermitido,\terrorNormalizado ";
		iteraciones.add(i);
		while ((Math.abs(f.evaluar(x))>error&&k<n)) {
			x=x0*f.evaluar(x1) - x1 * f.evaluar(x0)/(f.evaluar(x1)-f.evaluar(x0));
			i="\n\t\t"+k+"\t"+ round(x0, 3) + "\t" + round(x1, 3) + "\t" + round(x, 3) + "\t" + round(f.evaluar(x),3) + "\t" + error+"\t\t"+round(Math.abs((f.evaluar(k+1)-f.evaluar(k))/f.evaluar(k)),3);
			iteraciones.add(i);
			if (f.evaluar(x0)*f.evaluar(x)<0) {
				x1=x;
			}else {
				x0 = x;
			}
			k++;
			
		}
		if (k<n) {
			respuesta =x;
		}
		return respuesta;
	}
	
	public ArrayList getIter() {
		return iteraciones;
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	
	public static void main(String[] args) {
		Funcion f = new Funcion() {

			@Override
			public double evaluar(double x) {
				return Math.pow(x, 5)-2*x+70;
			}
		};
		
		FalsaPosicion fp = new FalsaPosicion();
		double raiz = fp.sacarRaiz(f, 0, 1, 20, 0.01);
		System.out.println("El valor de la raiz es: "+raiz);
		System.out.println("Iteraciones realizadas \n"+fp.getIter());
	}
	
}
abstract class Funcion {
	public abstract double evaluar(double x0);
}
