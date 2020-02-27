
public class Fibonacci {
	public static long fibonacci(int n) {
		if (n==0 || n ==1) {
			return 1;
		}else {
			return fibonacci(n-1)+fibonacci(n-2);
		}
	}
	public static long fibonacciOpt(int n) {
		long [] serie = new long[n+1];
		serie[0]=serie[1]=1;
		//return fibonacciOpt(n-1)+fibonacciOpt(n-2);
		return fibonacciOpt(n,serie);
	
	}
	private static long fibonacciOpt(int n, long[] serie ) {
		/*
		if (n>2) {
			serie[n]= serie[n-1]+ serie[n-2];
		}else {
			return 1;
		}
		*/
		
			if (serie[n]> 0) {
				return serie[n];
			}else {
				serie[n] = fibonacciOpt(n-1, serie)+fibonacciOpt(n-2, serie);
				return serie[n];
			}
		
	}
	public static void main(String[] args) {
		long ini=System.nanoTime(),
				fin;
		System.out.println(Fibonacci.fibonacci(40));
		fin= System.nanoTime();
		System.out.println("Se tardo "+ (fin-ini)/1000000000.0);
	}

}
