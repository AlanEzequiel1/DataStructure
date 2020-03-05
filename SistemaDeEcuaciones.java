/*
 * Hecho por Alan Ezequiel Savoy
 * A01351362
 */

import java.util.Scanner;

public class SistemaDeEcuaciones {
	double x1, x2, y1, y2, t1, t2, x, y;
	

	public SistemaDeEcuaciones() {
		boolean valido = false;
		x1=0;
		x2=0;
		y1=0;
		y2=0;
		t1=0;
		t2=0;
		x=0;
		y=0;
		
	}
	public void pedirNumeros() {
		boolean valido = false;
		System.out.println("Para el sistema de ecuaciones porfavor introduzca los 6 numeros");
		System.out.println("Los numeros ingresados se acomodaran en este orden:");
		System.out.println("numero 1 x, numero 2 y = numero 3, luego igual respectivamente para la segunda ecuacion");
		System.out.println("Ingrese los numeros:");
		Scanner numero = new Scanner(System.in);
		
			try {
				x1=numero.nextDouble();
				y1=numero.nextDouble();
				t1=numero.nextDouble();
				x2=numero.nextDouble();
				y2=numero.nextDouble();
				t2=numero.nextDouble();
				System.out.println("Sus numeros son \n"+ x1+"x "+ y1+"y ="+ t1+"\n"+ x2+"x "+ y2+"y = "+ t2);
				valido = true;
				
			} catch (Exception e) {
				System.out.println("Ha ocurrido un problema, ya que ingreso un valor invalido");
				x1=0;
				x2=0;
				y1=0;
				y2=0;
				t1=0;
				t2=0;
			}
	}
	
	public void despejar() {
		x= ((t1*y2)-(y1*t2))/((x1*y2)-(y1*x2));
		y=((x1*t2)-(t1*x2))/((x1*y2)-(y1*x2));
		
	}
	
	public void empezar() {
		this.pedirNumeros();
		this.despejar();
		System.out.println("x= "+x+" y su y= "+y);
	}
	
	
	public static void main(String[] args) {
		SistemaDeEcuaciones sde = new SistemaDeEcuaciones();
		sde.empezar();
	}

}
