package librerias.estructurasDeDatos.lineales;

import librerias.estructurasDeDatos.modelos.*;
import librerias.excepciones.ElementoNoEncontrado;

public class LEGPila<E> implements Pila<E> {
        
    protected NodoLEG<E> tope;
    protected int talla;

    /** crea una Pila vacia **/
    public LEGPila() {
        /*COMPLETAR*/
    	tope = null;
    	talla = 0;
    }
      
    /** inserta el Elemento e en una Pila, o lo situa en su tope **/
    public void apilar(E e) {
        tope = new NodoLEG<E>(e, tope);
        talla++;
    }
      
    /** SII !esVacia(): 
     * obtiene y elimina de una Pila el Elemento que ocupa su tope 
     * @throws ElementoNoEncontrado 
     */
    public E desapilar() throws ElementoNoEncontrado{
        /*COMPLETAR Y CORREGIR*/
    	if(tope == null) throw new ElementoNoEncontrado("pila vacia");
    	E x = tope.dato;
    	tope = tope.siguiente;
    	return x;
    }
      
    /** SII !esVacia(): 
     * obtiene el Elemento que ocupa el tope de una Pila 
     * @throws ElementoNoEncontrado 
     */
    public E tope() throws ElementoNoEncontrado {
       if(tope == null) throw new ElementoNoEncontrado("pila vacia");
       return tope.dato;
    }
      
    /** comprueba si una Pila esta vacia **/
    public boolean esVacia() {
    	return tope == null;
    }
      
    /** obtiene un String con los Elementos de una Pila en orden LIFO, 
     *  inverso al de insercion, 
     *  y con el formato que se usa en el estandar de Java. 
     *  Asi, por ejemplo, si se tiene una Pila con los Integer del 1 al 4, 
     *  en orden LIFO, toString devuelve [4, 3, 2, 1]; 
     *  si la Pila esta vacia, entonces devuelve [] 
     */
    public String toString() { 
        StringBuilder res = new StringBuilder();
        res.append("["); 
        NodoLEG<E> aux = tope.siguiente;
        for (int i = 1; i < talla; i++, aux = aux.siguiente) {            
            res.append(aux.dato.toString() + ", ");
        }
        if (talla != 0) {
            res.append(aux.dato.toString() + "]"); 
        } else { res.append("]"); }
        return res.toString();
    }
}