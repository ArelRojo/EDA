package librerias.estructurasDeDatos.modelos;


/**Una cola de prioridad es una colección homogenea de datos que solo se puede gestionar 
 * accediendo al dato que tiene maxima prioridad
 * 
 * El dato de mayor prioridad es el que requiere minimo tiempo de espera para ser tratado
 *, el dato más prioritario de una coleccion es su minimo
 *
 *A igualdad de prioridad acceso FIFO
 * @author lisas
 *
 * @param <E>
 */
public interface ColaPrioridad<E extends Comparable<E>> {
	void insertar(E e);
	
	/**SII !esVacia() */ E eliminarMin();
	/** SII !esVacia() */ E recuperarMin();
	boolean esVacia();

}
