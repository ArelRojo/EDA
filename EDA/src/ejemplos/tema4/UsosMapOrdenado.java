package ejemplos.tema4;

import librerias.estructurasDeDatos.modelos.MapOrdenado;
import librerias.estructurasDeDatos.modelos.ListaConPI;
import librerias.estructurasDeDatos.lineales.LEGListaConPI;
import librerias.estructurasDeDatos.jerarquicos.ABBMapOrdenado;

/**
 * class UsosMapOrdenado.
 * 
 * @author FTG
 * @version 1.0
 */

public class UsosMapOrdenado {

	/**
	 * Diseñar un metodo estatico, generico e iterativo entradas que devuelva una
	 * ListaConPI con las Entradas de un Map m ordenadas ascendentemente.
	 */
	public static <C extends Comparable<C>, V> ListaConPI<EntradaMap<C, V>> entradas(MapOrdenado<C, V> m) {
		ListaConPI<EntradaMap<C, V>> l = new LEGListaConPI<EntradaMap<C, V>>();
		// COMPLETAR

		/**
		 * Obtener primera Entrada del Map Ordenado por claves, i.e. la Entrada de clave
		 * minima del Map
		 */
		EntradaMap<C, V> e = m.recuperarEntradaMin();

		/**
		 * Insertar primer elemento de la lista de Entradas ordenada ascendentemente por
		 * clave
		 */
		l.insertar(e);

		/**
		 * Para obtener siguientes Entradas de la lista resultado, recorrer el Map
		 * Ordenado por claves
		 */
		for (int i = 0; i < m.talla(); i++) {

			/**
			 * Obtener siguiente Entrada del Map Ordenado por claves, i.e. el sucesor de la
			 * Entrada e
			 */
			
			e = m.sucesorEntrada(e.clave);
			/**
			 * Insertar siguiente elemento de la lista de Entradas ordenada ascendentemente
			 * por clave
			 */
			l.insertar(e);

		}

	}

	/**
	 * Diseñar un metodo estatico, generico e iterativo mapSort que, con la ayuda
	 * de un MapOrdenado, ordene los elementos (Comparable) de un array v.
	 */
	public static <C extends Comparable<C>> void mapSort(C[] v) {

	}

	/**
	 * Diseñar un metodo estatico, generico e iterativo hayDosQueSuman que, dados
	 * un array v de enteros y un entero k, determine si existen en v dos numeros
	 * cuya suma sea k. Usar un Map Ordenado como EDA auxiliar.
	 */
	public static boolean hayDosQueSuman(Integer[] v, int k) {
		// COMPLETAR

	}
}
