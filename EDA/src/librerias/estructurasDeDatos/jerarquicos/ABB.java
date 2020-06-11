package librerias.estructurasDeDatos.jerarquicos;


import librerias.estructurasDeDatos.deDispersion.EntradaMap;
import librerias.estructurasDeDatos.jerarquicos.NodoABB;
import librerias.estructurasDeDatos.lineales.LEGListaConPI;
import librerias.estructurasDeDatos.modelos.ListaConPI;

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

	/**
	 * Permite recuperar un dato e del nodo Actual de un ABB
	 * 
	 * @param e
	 * @param actual
	 * @return
	 */
	protected NodoABB<E> recuperar(E e, NodoABB<E> actual) {
		NodoABB<E> res = actual; // caso base equivalente a res == null
		if (actual != null) {
			int resC = actual.dato.compareTo(e);
			if (resC > 0) {
				res = recuperar(e, actual.izq);
			} else if (resC < 0) {
				res = recuperar(e, actual.der);
			} // else no hacer nada pq res se ha inicializado a actual
		}
		return res;
	}

	public E recuperar(E e) {
		NodoABB<E> aux = this.raiz;
		while (aux != null) {
			int resC = aux.dato.compareTo(e);
			if (resC == 0) {
				return aux.dato;
			} else if (resC > 0) {
				aux = aux.izq;
			} else {
				aux = aux.der;
			}

		}
		return null;
//		NodoABB<E> res = recuperar(e, this.raiz);
//
//		if (res == null) {
//			return null;
//		} else {
//			return res.dato;
//		}

	}

	protected NodoABB<E> insertar(E e, NodoABB<E> actual) {
		NodoABB<E> res = actual;
		if (actual != null) {
			int resC = actual.dato.compareTo(e);
			if (resC > 0) {
				res.izq = insertar(e, actual.izq);
			} else if (resC < 0) {
				res.der = insertar(e, actual.der);
			} else {
				res.talla = 1 + talla(res.izq) + talla(res.der);// se actualiza la talla
			}
		} else {
			res = new NodoABB<E>(e);// se inicializa la talla a uno
		}
		return res;
	}

	public void insertar(E e) {
		this.raiz = insertar(e, this.raiz);
	}

	protected NodoABB<E> eliminar(E e, NodoABB<E> actual) {
		NodoABB<E> res = actual;
		if (actual != null) {
			int resC = actual.dato.compareTo(e);
			if (resC > 0) {
				res.izq = eliminar(e, actual.izq);
			} else if (resC < 0) {
				res.der = eliminar(e, actual.der);
			} else {
				// eliminar actual
				if (actual.izq == null) {
					return actual.der;
				} else if (actual.der == null) {
					return actual.izq;
				} else {
					res.dato = recuperarMin(actual.der).dato;
					res.der = eliminarMin(actual.der );
				}
			}
			res.talla = 1 + talla(res.izq) + talla(res.der);

		}
		return res;

	}

	public void eliminar(E e) {
		this.raiz = eliminar(e, this.raiz);
	}

	// SII actual != null: devuelve el Nodo de actual que contiene a su minimo
	protected NodoABB<E> recuperarMin(NodoABB<E> actual) {
		if (actual.izq == null) {
			return actual;
		}
		return recuperarMin(actual.izq);
	}

	protected NodoABB<E> recuperarMax(NodoABB<E> actual) {
		if (actual.der == null) {
			return actual;
		}
		return recuperarMax(actual.der);
	}

	// SII !esVacio()
	public E recuperarMin() {
		return recuperarMin(raiz).dato;
	}

	public E recuperarMax() {
		return recuperarMax(raiz).dato;
	}

	// SII actual != null: devuelve el nodo Actual tras eliminar su minimo,
	// copiando el dato que este contiene en nodoMin(paso por referencia)
	protected NodoABB<E> eliminarMin(NodoABB<E> actual) {
//		NodoABB<E> aux = actual, padreAux = null;
//		while (aux.izq != null) {
////			aux.talla--;
//			padreAux = aux;
//			aux = aux.izq;
//
//		}
//		nodoMin.dato = aux.dato;
//		if (padreAux == null) {
//			actual = actual.der;
//		} else {
//			padreAux.izq = aux.der;
//		}
//		return actual;
		if (actual.izq == null) {
			return actual.der;
		}
		actual.izq = eliminarMin(actual.izq);
		actual.talla--;
		return actual;

	}

	// SII !esVacio()
	public E eliminarMin() {
//		NodoABB<E> nodoMin = new NodoABB<E>(null);
//		this.raiz = eliminarMin(this.raiz, nodoMin);
//		return nodoMin.dato;
		E res = recuperarMin();
		this.raiz = eliminarMin(this.raiz);
		return res;
	}

	protected NodoABB<E> sucesor(E e, NodoABB<E> actual) {
		NodoABB<E> res = null;
		if (actual != null) {
			int resC = actual.dato.compareTo(e);
			if (resC > 0) {
				res = sucesor(e, actual.izq);// va a la izq
				// vuelve de la izq donde está el sucesor
				if (res == null) {
					res = actual; // actualiza el sucesor
				}
			} else {
				res = sucesor(e, actual.der);
			} // va a la derecha
				// vuelve de la derecha , luego el sucesor no varia
		}
		return res;
	}

	protected NodoABB<E> predecesor(E e, NodoABB<E> actual) {
		NodoABB<E> res = null;
		if (actual != null) {
			int resC = actual.dato.compareTo(e);
			if (resC < 0) {
				res = predecesor(e, actual.der);
				if (res == null)
					res = actual;
			} else {
				res = predecesor(e, actual.izq);
			}
		}
		return res;
	}

	public E predecesor(E e) {
		NodoABB<E> res = predecesor(e, this.raiz);
		if (res == null)
			return null;
		else
			return res.dato;
	}

	public E sucesor(E e) {
		NodoABB<E> res = sucesor(e, this.raiz);
		if (res == null)
			return null;
		else
			return res.dato;
	}

	protected NodoABB<E> seleccionar(int k, NodoABB<E> actual) {
		int tallaI = talla(actual.izq);
		if (k == tallaI + 1) {
			return actual;
		} else if (k <= tallaI) {
			return seleccionar(k, actual.izq);
		} else {
			return seleccionar(k - tallaI - 1, actual.der);
		}
	}

	public E seleccionar(int k) {
		return seleccionar(k, this.raiz).dato;
	}
	
	 /** devuelve un String con los Datos de un ABB en In-Orden */
    public ListaConPI<E> toListaConPI() {  
        ListaConPI<E> res = new LEGListaConPI<>();
        if (raiz != null) { toListaConPI(raiz, res); }
        return res;
    }
    // SII actual != null: actualiza res con los Datos del Nodo actual  
    // en In-Orden (Recorrido In-Orden con caso base Nodo Hoja implicito)
    protected void toListaConPI(NodoABB<E> actual, ListaConPI<E> res) {
        if (actual.izq != null) {
            toListaConPI(actual.izq, res); 
           
        }
        res.insertar(actual.dato);
        if (actual.der != null) {
            toListaConPI(actual.der, res);
        }
    }

    protected int enQueNivel(E e, NodoABB<E> actual, int nivelActual) {
    	int res = -1;
    	int resC = actual.dato.compareTo(e);
    	if(resC == 0) {res = nivelActual;}
    	else {
    		if(actual.izq != null && resC > 0) {
    			res = enQueNivel(e, actual.izq, nivelActual+1);
    		}
    		else if (actual.der != null && resC < 0) {
    			res = enQueNivel(e, actual.der, nivelActual+1);
    		}
    	}
    	return res;
    }

    public int enQueNivel(E e) {
    	if(this.raiz == null) {return -1;}
    	return enQueNivel(e, this.raiz, 0);
    }
    /** devuelve un String con los Datos de un ABB en In-Orden */
    public String toStringInOrden() {  
        StringBuilder res = new StringBuilder().append("[");
        if (raiz != null) { toStringInOrden(raiz, res); }
        return res.append("]").toString();
    }
    // SII actual != null: actualiza res con los Datos del Nodo actual  
    // en In-Orden (Recorrido In-Orden con caso base Nodo Hoja implicito)
    protected void toStringInOrden(NodoABB<E> actual, StringBuilder res) {
        if (actual.izq != null) {
            toStringInOrden(actual.izq, res); 
            res.append(", ");
        }
        res.append(actual.dato.toString()); 
        if (actual.der != null) {
            res.append(", ");
            toStringInOrden(actual.der, res);
        }
    }
    
    protected String datosEnNivel(int k, NodoABB<E> actual) {
    	String res = "";
    	if(actual != null) {
    		if(k == 0) {res = actual.dato.toString();}
    		else {
    			res = datosEnNivel(k - 1, actual.izq) + "," + datosEnNivel(k-1, actual.der);
    		}
    	}
    	return res;
    }
    
    public String datosEnNivel(int k) {
    	return "[" + datosEnNivel(k, this.raiz) + "]";
    }
    
    public static void main(String[] args) {
    	ABB<Integer> a = new ABB<>();
    	a.insertar(5);
    	
    	a.insertar(7);
    	
    	a.insertar(6);
    	a.insertar(9);
    	
    	System.out.println(a.eliminarMin());
    	System.out.println(a.toStringInOrden());
    }
}
