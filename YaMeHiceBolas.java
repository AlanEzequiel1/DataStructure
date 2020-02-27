import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*Hecho por Alan Ezequiel Savoy
 * A01351362
 * Analisis:
 * 
 * El calculo se me dificulto mucho, me bloqueo mucho con este tipo de calculos matematicos por alguna razon y tuve que pedir ayuda para comprender
 * el calculo matematico (NO PASAR CODIGO) entender porque se dividia entre 2 y luego otra vez pero al final se me hizo muy logico porque lo que 
 * quieres es que se haga mas chiquito y el largo siempre se tiene que dividir entre 2 por lo mismo. Lo que si entendia esque tenia que dibujar 3 circulos, uno grande con dos chicos dentro que ademas
 * tenia que estar un poco mas recorrido a la derecha.
 */


public class YaMeHiceBolas extends JFrame{
	private int nivel;//Nos va a pedir niveles como en el Fractal y tendra que dibujarse dependiendo a eso
	int x1=50;
	int y1=350;
	int largo=600;
	
	public YaMeHiceBolas() {
		super("Ya me hice bolas");
		this.setSize(720,700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.nivel=Integer.parseInt(JOptionPane.showInputDialog("¿Que nivel desea realizar?"));//pedimos el nivel
		this.setVisible(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		this.pintaCirculos(g, nivel, x1, y1, largo);
	}
	
	public void pintaCirculos(Graphics g , int nivel , int x1 , int y1 , int largo) {
		if (nivel==0) {
			g.drawOval(x1, y1, largo, largo);
		}else {
			this.pintaCirculos(g, nivel-1, x1, y1+((largo/2)/2), largo/2);//como siempre queremos que se reduzca hacemos que se divida entre 2 el largo y como van dos bolitas dentro aparte por eso las volvemos a dividir entre 2
			this.pintaCirculos(g, nivel-1, x1+largo/2, y1+((largo/2)/2), largo/2);
			this.pintaCirculos(g, nivel-1, x1, y1, largo);//circulo grande
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		YaMeHiceBolas ymhb = new YaMeHiceBolas();

	}

}
