package librerias.estructurasDeDatos.lineales;

import  librerias.estructurasDeDatos.modelos.*;
import librerias.excepciones.ElementoNoEncontrado; 

public class ArrayPila<E> implements Pila<E> {    
    protected E[] elArray;
    protected int tope;
    protected static final int CAPACIDAD_POR_DEFECTO = 50;

    /** construye una Pila vacia **/
    @SuppressWarnings("unchecked")
    public ArrayPila() {
        /*COMPLETAR*/;
        elArray = (E[]) new Object[CAPACIDAD_POR_DEFECTO];
        tope = -1;
    }
      
    /** inserta el Elemento e en una Pila, o lo situa en su tope **/
    public void apilar(E e) {
        /*COMPLETAR*/
    	if(tope+1 == elArray.length) duplicarArray();
    	tope++;
    	elArray[tope] = e;
    }
      
    // duplica el tamagno actual de un array
    @SuppressWarnings("unchecked")
    protected void duplicarArray() {
        E[] nuevoArray = (E[]) new Object[elArray.length * 2];
        System.arraycopy(elArray, 0, nuevoArray, 0, tope);
        elArray = nuevoArray;
    }  
      
    /** SII !esVacia(): 
     * obtiene y elimina de una Pila el Elemento que ocupa su tope 
     * @throws ElementoNoEncontrado 
     */
    public E desapilar() throws ElementoNoEncontrado { 
        /*COMPLETAR Y CORREGIR*/
        if(tope<0) throw new ElementoNoEncontrado();
        E x = elArray[tope];
        tope--;
        return x;
    }
      
    /** SII !esVacia(): 
     * obtiene el Elemento que ocupa el tope de una Pila 
     * @throws ElementoNoEncontrado 
     */
    public E tope() throws ElementoNoEncontrado { 
    	if(tope<0) throw new ElementoNoEncontrado();
    	return elArray[tope];
    }
      
    /** comprueba si una Pila esta vacia **/
    public boolean esVacia() {
        return tope == -1;
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
        for (int i = 0; i < elArray.length-1; i++) {            
            res.append(elArray[i].toString() + ", ");
        }
        if (elArray.length != 0) {
            res.append(elArray[elArray.length-1]+ "]"); 
        } else { res.append("]"); }
        return res.toString();
    }
}