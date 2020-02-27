
public class Recursion {
	
	//Preparacion
	public static <E extends Comparable<E>>int buscaUltimo(E[] valores, E valor){
		//inicializas pos
		int pos = 0;
		return buscaUltimo(valores, valor, pos);
	}
	
	//Recursion
	public static <E extends Comparable <E>>int buscaUltimo(E[]valores, E valor, int pos){
		//Creare una variable local para la respuesta
		int respuesta;
		// En caso de no encontrar el elemento regresa el valor -1
		if (pos == valores.length-1) {
			if (valor.compareTo(valores[pos])==0) {
				return pos;
			}else {
				return -1;
			}
			
		}
		else {
			respuesta = buscaUltimo(valores, valor, pos+1);
			if (respuesta == -1) {
				if (valor.compareTo(valores[pos])==0) {
					return pos;
				}else {
					return -1;
				}
			}else {
				return respuesta;
			}
		}
		
	}

	public static void main(String[] args) {
		String arr[]= {"Hola","no","si","Hola","Adios","no"};
		System.out.println(buscaUltimo(arr,"no"));

	}

}
