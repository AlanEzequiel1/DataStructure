
public class BusquedaBinaria {
	
	
	public static <E extends Comparable<E>> int busquedaBinaria(E[] valores, E x) {
		int low =0;
		int high = valores.length-1;
		return busquedaBinaria(valores, x, low, high);
		
	}
	public static <E extends Comparable<E>> int busquedaBinaria(E[] valores, E x, int low,  int high) {
		int mid = (low+high)/2;
		int respuesta;
		if(low>=high) {
			return-1;
		}
		if(valores[mid].compareTo(x)==0) {
			return mid;
		}else {
			if (valores[mid].compareTo(x)<0) {
				low = mid +1;
			}
			if (valores[mid].compareTo(x)>0) {
				high =mid-1;
			}
			respuesta = busquedaBinaria(valores, x, low, high);
			return respuesta;
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] valores = {0,1,2,3,4,5,5,6,6,7,8,9,10};
		System.out.println(busquedaBinaria(valores, 11));
	}

}
