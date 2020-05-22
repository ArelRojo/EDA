package librerias.estructurasDeDatos.jerarquicos;

/**
 * Clase ABB<E> que, en base a la identificacion AB-Nodo, representa un Arbol
 * Binario mediante un enlace a su Nodo Raiz. Para poder utilizarla como
 * Implementacion eficiente de Cola de Prioridad y Map Ordenado, sus
 * caracteristicas son las siguientes: 1.- El tipo de sus Elementos es E extends
 * Comparable<E> 2.- Como unico ATRIBUTO, protected para la Herencia, TIENE UN
 * NodoABB<E> raiz OJO: talla NO es un atributo de la clase, sino de sus Nodos
 * Precisamente por ello, esta clase implementa un ABB con Rango 3.- Tiene un
 * unico constructor, el de ABB vacio, sin parametros 4.- Todos sus metodos
 * publicos son muy simples: basicamente, contienen una invocacion al metodo
 * homonimo recursivo sobre su Nodo Raiz (son metodos guia o lanzadera) Las
 * caracteristicas de cualquiera de estos metodos recursivos son: 4.1. Su
 * modificador de visibilidad es protected y no private; 4.2. Tiene, al menos,
 * como PARAMETRO FORMAL el Nodo actual sobre el que se aplica, PERO NO ES
 * ESTATICO; al invocar su ejecucion desde el metodo publico, en su llamada mas
 * alta, el valor del Nodo actual es siempre this.raiz 4.3. En general,
 * devuelven el Nodo del ABB resultado de su aplicacion; Por ejemplo:
 * recuperar(e) devuelve el Nodo de actual que contiene a e, el elemento a
 * recuperar; insertar(e) devuelve el Nodo Raiz del ABB que se obtiene al
 * insertar el elemento e en el Nodo actual
 * 
 * @param <E>, tipo de los elementos del ABB, Comparable por definicion
 *
 **/
public class ABB<E extends Comparable<E>> {
	// Atributo protected para la herencia
	protected NodoABB<E> raiz;

	// Constructor unico de un ABB vacío, sin parametros
	public ABB() {
		raiz = null;
	}

	public boolean esVacio() {
		return raiz == null;
	}

	public int talla() {
		return talla(this.raiz);
	}

	// metodo homonimo recursivo sobre su Nodo Raiz
	protected int talla(NodoABB<E> actual) {
		if (actual == null) {
			return 0;
		} else {
			return actual.talla;
		}
	}

	/**Permite recuperar un dato e del nodo Actual de un ABB 
	 * @param e
	 * @param actual
	 * @return
	 */
	protected NodoABB<E> recuperar (E e ,NodoABB<E> actual){
		NodoABB<E> res = actual; //caso base equivalente a res == null
		if(actual != null) {
			int resC = actual.dato.compareTo(e);
			if(resC > 0) {
				res = recuperar(e, actual.izq);
			}
			else if(resC < 0) {
				res = recuperar(e, actual.der);
			} //else no hacer nada pq res se ha inicializado a actual
		} 
		return res;
	}
	
	public E recuperar(E e) {
		NodoABB<E> res = recuperar(e, this.raiz);
		
		if(res == null) {return null;}
		else {return res.dato;}
		
	}

}
