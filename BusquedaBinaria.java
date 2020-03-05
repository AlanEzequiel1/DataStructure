
public class BusquedaBinaria {


	public static <E extends Comparable<E>> int busquedaBinaria(E[] valores, E x) {
		return busquedaBinaria(valores, x, 0, valores.length-1);

	}
	private static <E extends Comparable<E>> int busquedaBinaria(E[] valores, E x, int low,  int high) {
		int mid = (low+high)/2;
		int respuesta;
		if(low>high) {
			return-1;
		}else if(valores[mid].compareTo(x)==0) {
			return mid;
		}else if (valores[mid].compareTo(x)<0) {
			low = mid +1;
		}else {
			high =mid-1;
		}
		respuesta = busquedaBinaria(valores, x, low, high);
		return respuesta;
	}

	public static <E extends Comparable<E>>int binarySearchIterative(E[] datos, E valor){
		int low=0,  high = datos.length-1,  mid;
		while (low<=high) {
			mid = (low+high)/2;
			if(datos[mid].compareTo(valor)==0) {
				return mid;
			}else if (datos[mid].compareTo(valor)<0) {
				low = mid +1;
			}else {
				high =mid-1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] valores = {0,1,2,3,4,5,5,6,6,7,8,9,10};
		System.out.println(busquedaBinaria(valores, 1));
		System.out.println(binarySearchIterative(valores, 1));
	}

}
