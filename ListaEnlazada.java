import java.util.NoSuchElementException;

public class ListaEnlazada<E> {
	private NodoLE<E> inicio;
	private NodoLE<E> fin;
	private int size;
	
	public ListaEnlazada() {
		this.inicio=this.fin=null;
		this.size=0;
	}
	public ListaEnlazada(E[] arreglo) {
		
		for (int i = 0; i < arreglo.length; i++) {
			if (i==0) {
				insertarInicio(arreglo[i]);
				insertarFin(arreglo[i]);
			}else {
				NodoLE current = inicio;
			}
			size++;
		}
		//Inicializa la lista con los valores del arreglo {1,8,10,2} -> 1 -> 8 -> 10 -> 2 size =4
	}
	
	public E borrarInicio() {
		try {
			E tmp = inicio.valor;
			inicio = inicio.next;
			return tmp;
		} catch (NullPointerException e) {
			throw new NoSuchElementException("No se puede regresar el inicio de una lista vacia");
		}
			
		//borra el primer elemento de la lista y regresa el valor que se elimino 
		//en caso de que la lista este vacia debe arrojar una execpcion No such element exception
		
	}
	public E inicio() {
		try {
			return this.inicio.valor;
		} catch (NullPointerException e) {
			throw new NoSuchElementException("No se puede regresar el inicio de una lista vacia");
		}
	}
	public E fin() {
		try {
			return this.fin.valor;
		} catch (NullPointerException e) {
			throw new NoSuchElementException("No se puede regresar el fin de una lista vacia");
		}
		
	}
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return this.size==0;
	}
	
	public void insertarInicio(E valor) {
		inicio = new NodoLE<E>(valor, this.inicio);
		if (fin==null) {
			fin = this.inicio;
		}
		size++;
	}

	public void insertarNumero(E valor) {
		NodoLE tmp = inicio;
		for (int i = 0; i < size; i++) {
			if (i==size-2) {
				NodoLE nuevo = new NodoLE(valor, fin);
				tmp = nuevo;
			}else {
				tmp = tmp.next;
			}
			
		}
	}
	
	public String toString() {
		String respuesta="Elementos de la lista: \n";
		NodoLE current = inicio;
		for (int i = 0; i < size; i++) {
			respuesta = current.valor+", ";
			current =  current.next;
		}
		return respuesta;
	}
	
	public void insertarFin(E valor) {
		if (size!=0) {
			NodoLE<E> nuevo = new NodoLE<E>(valor);
			fin.next = nuevo;
			fin = nuevo;
			size++;
		}else {
			this.insertarInicio(valor);
		}
	}
	public E borrarEn(int pos) {
		
	}
	public void setAt(E valor, int pos) {
		if (pos>0||pos<size) {
			NodoLE<E> current = inicio;
			for (int i = 0; i < pos; i++) {
				current = current.next;
			}
			current.valor = valor;
		}else {
			throw new IndexOutOfBoundsException("no se puede modificar la posicion "+pos+"en una lista de tamaño: "+size);
		}
		
		
	}
	public E borrarFin() {
		try {
			E valor;
			if (size==1) {
				valor = inicio();
				this.borrarInicio();
				size = 0;
				return valor;
			}else {
				NodoLE<E> current = inicio;
				for (int i = 0; i < size-2; i++) {
					current = current.next;
				}
				valor = current.next.valor;
				current.next = null;
				this.fin=current;
				this.size--;
				return valor;
			}
			
		} catch (NullPointerException e) {
			throw new NoSuchElementException("no se puede borrar el inicio de una lista vacia");
		}
		
	}
	public static void main(String[] args) {
		Integer [] valores = {1,8,10,2};
		ListaEnlazada le = new ListaEnlazada(valores);
		le.toString();

	}
	

}

class NodoLE<E>{
	E valor;
	NodoLE<E> next;
	
	@Override
	public String toString() {
		return valor.toString();
	}
	public NodoLE(E valor) {
		this(valor,null);
	}
	
	public NodoLE(E valor, NodoLE<E> next) {
		super();
		this.valor=valor;
	}
	public E getValor() {
		return valor;
	}
	public void setValor(E valor) {
		this.valor = valor;
	}
	public NodoLE<E> getNext() {
		return next;
	}
	public void setNext(NodoLE<E> next) {
		this.next = next;
	}
}
