package librerias.estructurasDeDatos.lineales;

import librerias.estructurasDeDatos.modelos.Cola;

public class LEGColaOrdenada<E extends Comparable<E>> extends LEGCola<E> implements Cola<E> {
	

		public void encolar(E element) {
	        if (esVacia()){ 
	            first = last = new NodoLEG<E>(element);
	        }else {
	            for (NodoLEG<E> n = first; n != null; n = n.siguiente){
	                if(element.compareTo(n.dato) > 0){
	                    n.siguiente=n;
	                    n.dato=element;
	                }
	            }
	        }
	    }
}
