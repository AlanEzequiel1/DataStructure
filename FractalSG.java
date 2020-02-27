import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class FractalSG extends JFrame {
	private Point a =new Point (550,100),
				b=new Point (50,400),
				c=new Point (750,550);
	private int nivel;

	public FractalSG() {
		super("Fractal Sierpinski Gasket");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.nivel=Integer.parseInt(JOptionPane.showInputDialog("Escribe la profundidad que quieres para el fractal"));
		this.setVisible(true);
	}
	private void pintaLineas(Graphics g, Point a, Point b) {
		g.drawLine(a.x, a.y, b.x, b.y);
	}
	
	private Point puntoMedio(Point a, Point b) {
		int xM=(a.x+b.x)/2;
		int yM=(a.y+b.y)/2;
		//Point pm= new Point(xM,yM);
		return new Point(xM,yM);
	}
	
	private void pintaTriangulos(Graphics g, int n, Point a, Point b, Point c) {
		if (n==0) {
			this.pintaLineas(g, a, b);
			this.pintaLineas(g, b, c);
			this.pintaLineas(g, c, a);
			
		}else {
			Point pmab=this.puntoMedio(a, b),
					pmbc=this.puntoMedio(b, c),
					pmca=this.puntoMedio(c, a);
			this.pintaTriangulos(g, n-1, a, pmab, pmca);
			this.pintaTriangulos(g, n-1, pmab, b, pmbc);
			this.pintaTriangulos(g, n-1, pmca, pmbc, c);
			
		}
	}
	public void paint(Graphics g) {
		super.paint(g);
		this.pintaTriangulos(g, nivel, a, b, c);
	}
	public static void main(String[] args) {
		FractalSG ventana = new FractalSG();

	}

}
