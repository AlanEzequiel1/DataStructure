/*
 * Alan Ezequiel Savoy
 * A01351362
 * Teorema De Moivre
 * 
 */


import javax.swing.JOptionPane;

public class TeoremaDeMoivre {
	double 	a,
			b,
			r,
			angulo;
	int n;
	
	String  //z2,
			respuesta;
	
	
	public TeoremaDeMoivre() {
		n = Integer.parseInt(JOptionPane.showInputDialog("Cuantas n tendra el programa"));
		a = Double.parseDouble(JOptionPane.showInputDialog("Cual es el valor de a"));
		b = 0;
		r = Math.sqrt((a*a)+(b*b));
		angulo = Math.toRadians(Math.atan2(b, a));
		respuesta ="";
		this.formula();
		System.out.println(respuesta);
	}
	public void formula() {
		for (int i = 0; i < n; i++) {
			double real, imaginario;
			real = Math.pow(Math.sqrt(r), 2)*(r*(Math.cos(angulo+(2*Math.PI*i)/n)));
			imaginario = Math.pow(Math.sqrt(r), 2)*(r*(Math.sin(angulo+(2*Math.PI*i)/n)));
			respuesta = respuesta + "X"+i+" = "+real+" + "+imaginario+"i\n";
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TeoremaDeMoivre tm = new TeoremaDeMoivre();

	}

}
