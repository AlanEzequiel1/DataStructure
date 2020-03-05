/*Alan Ezequiel Savoy
 * A01351362
 * Me ayude para la explicacion de un video de youtube y de una pagina de internet:
 * https://www.youtube.com/watch?v=TzeBrDU-JaY&feature=youtu.be
 * https://www.geeksforgeeks.org/merge-sort/
 * 
 */
public class Ordenamientos {

	/*
	public static <E extends Comparable<E>> void bubbleSort(E[] datos) {
		for (int i = 0; i < datos.length-1; i++) {
			for(int j=0; j<datos.length-1-i; j++){
				if (datos[j].compareTo(datos[j+1])>1) {
					swap(datos, j, j+1);
				}
			}
		}
	}
	*/
	public static <E> void imprimeArreglo(E[]datos) {
		for (E tmp:datos) {
			System.out.print(tmp+", ");
		}
	}
	private static <E>void swap(E[] datos, int i, int j) {
		E aux = datos[i];
		datos[i]=datos[j];
		datos[j]=aux;
	}
	/*
	public static <E extends Comparable<E>> void mergesort(E[] datos) {
		mergesort(datos, 0, datos.length-1);
		imprimeArreglo(datos);
	}
	
	private static <E extends Comparable<E>> void mergesort(E[] datos, int primero, int ultimo) {
		if (primero<ultimo) {
			int central =(primero+ultimo)/2;
			mergesort(datos, primero, central);
			mergesort(datos, central+1, ultimo);
			mezcla(datos, primero, ultimo);
		}
	}
	
	private static <E extends Comparable<E>> void mezcla(E[] datos, int primero, int ultimo) {
		//Los datos ya estan ordenados de primer a central y de central+1 a ultimo
		//Tengo que dejar los datoa ordenados desde primero hasta el ultimo
		//Necesitas apoyarte de un arreglo temporal y no olvides regresar los datos al arreglo original
		E [] aux =  (E[]) new Comparable[ultimo-primero+1];
		int mid = ((primero+ultimo)/2)+1;
		int apuntadorI = primero;
		int apuntadorD = mid;
		int apuntadorAyuda =0;
		while (apuntadorI<mid&&apuntadorD<=ultimo) {
			E datoIzq = datos[apuntadorI];
			E datoDer = datos[apuntadorD];
			if (datoIzq.compareTo(datoDer)<=0) {
				aux[apuntadorAyuda]=datos[apuntadorI];
				apuntadorI++;
			}else {
				aux[apuntadorAyuda]=datos[apuntadorD];
				apuntadorD++;
			}
			apuntadorAyuda++;
		}
		//si quedaron datos del lado izquierdo, los termino de insertar
		while(apuntadorI<mid){
			aux[apuntadorAyuda]=datos[apuntadorI];
			apuntadorI++;	
			apuntadorAyuda++;
		}
		//si quedaron del lado derecho, los termino de insertar
		while(apuntadorD<=ultimo){
			aux[apuntadorAyuda]=datos[apuntadorD];
			apuntadorD++;
			apuntadorAyuda++;
		}

		apuntadorAyuda=0;

		//insertar en datos desde primero hasta ultimo los datos de aux
		for(int i=primero;i<=ultimo;i++){
			datos[i]=aux[apuntadorAyuda];
			apuntadorAyuda++;
		}
	}
	*/
	
	public static <E extends Comparable<E>>void quicksort(E[] datos) {
		quicksort(datos, 0, datos.length-1);
		imprimeArreglo(datos);
	}
	
	private static <E extends Comparable<E>>void quicksort(E[] datos, int left, int right) {
		if (left<right) {
			int posPivote = particion(datos, left, right);
			quicksort(datos, left, posPivote-1);
			quicksort(datos, posPivote+1, right);
		}
	}
	
	private static <E extends Comparable<E>> int particion(E[] datos, int left, int right) {
		E p =datos[left];
		int i = left+1;
		for (int j = left+1; j <= right; j++) {
			if (datos[j].compareTo(p)<0) {
				swap(datos, i, j);
				i++;
			}
		}
		swap(datos, left , i-1);
		return i-1 ;
	}
	
	public static void main(String[] args) {
		Integer[] valores = {200,15,7,-20,155,33,-40,-21,1,90,0,-300,100000,15,-50,15};
		//bubbleSort(valores);
		//System.out.println();
		//mergesort(valores);
		//System.out.println();
		quicksort(valores);
	}
}
