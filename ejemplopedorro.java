
import java.util.Scanner;
public class ejemplopedorro {
    public static void main(String[] args) {

        Scanner datos = new Scanner(System.in);
        System.out.println("Ingrese el valor de a");
        double a = datos.nextDouble();
        System.out.println("Ingrese el valor de b");
        double b = datos.nextDouble();
        System.out.println("Ingrese el valor de epsilon");
        double c = datos.nextDouble();
        regulaFalsi(a, b, c);

    }

    public static double function(double x) {
        return Math.pow(x, 10) - 1;//aqui se escribe la funcion que debe ser continua
    }

    public static void regulaFalsi(double a, double b, double e) {
        double c = 0; //valor del medio 
        double d = 0; //variable auxiliar
        int i = 0; //contador
        if (function(a) * function(b) < 0) {
            System.out.printf("\n  \t  %.5f  \t  %.5f  \t  %.5f ", a, c, b);
            System.out.printf("\t %.5f", function(c));
            System.out.print(" \t " + i++);
            while (true) {
                c = (function(b) * a - function(a) * b) / (function(b) - function(a));
                System.out.printf("\n  \t  %.5f  \t  %.5f  \t  %.5f ", a, c, b);
                System.out.printf("\t %.5f", function(c));
                if (Math.abs(function(c)) <= Math.pow(10, -e) || Math.abs(c - d) <= Math.pow(10, -e)) {

                    System.out.println("\nEl valor de X es: " + c);
                    break;
                }
                if (function(a) * function(c) < 0) {
                    b = c;
                } else {
                    a = c;
                }
                d = c;
                System.out.print(" \t " + i++);
            }
        } else {
            System.out.println("No hay raiz");
        }
    }

}
