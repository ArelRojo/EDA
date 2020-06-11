package librerias.estructurasDeDatos.modelos;

import librerias.excepciones.ElementoNoEncontrado;

public interface Pila<E> {
// metodos Modificadores del estado de una Pila:
    /** inserta el Elemento e en una Pila, o lo situa en su tope 
     */
    void apilar(E e);
    
    /** SII !esVacia(): 
     * obtiene y elimina de una Pila el Elemento que ocupa su tope 
     * @throws ElementoNoEncontrado 
     */
    E desapilar() throws ElementoNoEncontrado;

// metodos Consultores del estado de una Pila:
    /** SII !esVacia(): 
     * obtiene el Elemento que ocupa el tope de una Pila 
     * @throws ElementoNoEncontrado 
     */
    E tope() throws ElementoNoEncontrado;
    
    /** comprueba si una Pila esta vacia 
     */
    boolean esVacia();
}