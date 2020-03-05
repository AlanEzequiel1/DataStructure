/*
 * Creado por Alan Ezequiel Savoy
 * A01351362
 * 
 * Me tarde un poco en llegar a esto no recordaba nada de genericos y tampoco sabia como funcionaba el compare to
 * su funcionamiento lo saque de esta pagina https://guru99.es/string-compareto-method-java/ lo probe con Double, Strings, Ints y con todos 
 * hacia lo que pedia. Lo unico que si tengo algo de duda es si por ejemplo mete un numero que no esta en la lista o algo que no este en la lista
 * regrese -1 y ya o que regrese la posicion -1 eso fue lo unico que no me quedo claro, igual solo es cambiar el return -1 a que retorne la posicion 
 * -1
 */
public class Recursion {
	
	//Preparacion
	public static <E extends Comparable<E>>int buscaUltimo(E[] valores, E valor){
		return buscaUltimo(valores, valor, 0);
	}
	
	//Recursion
	public static <E extends Comparable <E>>int buscaUltimo(E[]valores, E valor, int pos){
		//Creare una variable local para la respuesta
		int respuesta;
		// En caso de no que el elemento no sea igual regresara el valor -1
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
					//si no encuentra lo que pide regresara -1
					return -1;
				}
			}else {
				return respuesta;
			}
		}
		
	}

	/*
	public static void main(String[] args) {
		//pruebas
		
		String valores[]= {"Hola","no","si","Hola","Adios","no"};
		Integer valores[]= {5,4,3,2,1,1,2,3,4,5};
		Double valores[]= {5.5,4.3,3.2,.1,2.1,2.0,2.1,3.3,4.3,5.0};
		System.out.println(buscaUltimo(valores,"no"));
		System.out.println(buscaUltimo(valores,4));
		System.out.println(buscaUltimo(valores,3.3));
		
	}
	*/

}
