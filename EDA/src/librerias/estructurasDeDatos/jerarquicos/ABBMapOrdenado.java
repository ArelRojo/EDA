package librerias.estructurasDeDatos.jerarquicos;

import librerias.estructurasDeDatos.modelos.MapOrdenado;
import librerias.estructurasDeDatos.modelos.ListaConPI;
import librerias.estructurasDeDatos.modelos.Map;
import librerias.estructurasDeDatos.deDispersion.TablaHash;
import librerias.estructurasDeDatos.lineales.LEGListaConPI;
import ejemplos.tema4.EntradaMap;
import librerias.estructurasDeDatos.modelos.ListaConPI;
import librerias.estructurasDeDatos.modelos.MapOrdenado;

public class ABBMapOrdenado<C extends Comparable<C>, V> implements MapOrdenado<C, V> {

	// Un ABBMapOrdenado TIENE UN...
	protected ABB<EntradaMap<C, V>> abb;

	/** Crea un map ordenado con talla 0 */
	public ABBMapOrdenado() {
		abb = new ABB<EntradaMap<C, V>>();
	}

	/**
	 * Sobrescribe el metodo de Map: inserta la Entrada (c, v) en un Map y devuelve
	 * null; si ya existe una Entrada de Clave c en el Map, devuelve su valor
	 * asociado y lo substituye por v (o actualiza la Entrada)
	 */
	@Override
	public V insertar(C c, V v) {
		EntradaMap<C, V> e = new EntradaMap<C, V>(c, null);
		EntradaMap<C, V> eC = abb.recuperar(e);
		abb.insertar(new EntradaMap<C, V>(c, v));
		if (eC != null) {
			return eC.getValor();
		} else {
			return null;
		}
	}

	/**
	 * Sobrescribe el metodo de Map: elimina la Entrada con Clave c de un Map y
	 * devuelve su valor asociado, null si no existe una Entrada con tal clave
	 */
	@Override
	public V eliminar(C c) {
		EntradaMap<C, V> e = new EntradaMap<C, V>(c, null);
		EntradaMap<C, V> eR = abb.recuperar(e);
		abb.eliminar(new EntradaMap<C, V>(c, null));
		if (e != null) {
			return e.getValor();
		} else {
			return null;
		}
	}

	/**
	 * Sobrescribe el metodo de Map: devuelve el valor asociado a la clave c en un
	 * Map, null si no existe una Entrada con dicha clave
	 */

	@Override
	public V recuperar(C c) {
		EntradaMap<C, V> e = abb.recuperar(new EntradaMap<C, V>(c, null));
		if (e != null) {
			return e.getValor();
		}
		return null;
	}

	/**
	 * Sobreescribe el metodo del map: comprueba si un map está vacio
	 */

	@Override
	public boolean esVacio() {
		return abb.esVacio();
	}

	/**
	 * Sobrescribe el metodo de Map: devuelve la talla, o numero de Entradas, de un
	 * Map
	 */
	@Override
	public int talla() {
		return abb.talla();
	}

	@Override
	public ListaConPI<C> claves() {
		Map<C, V> map = null;
		ListaConPI<C> deClaves = new LEGListaConPI<C>();
		EntradaMap<C, V> e = abb.recuperarMin();
		for (int i = 0; i < abb.talla(); i++) {
			EntradaMap<C, V> ek = abb.sucesor(e);
			C c = ek.getClave();
			map.insertar(c, null);
		}
		deClaves = map.claves();
		return deClaves;
	}

	/** SII !esVacio(): recupera la Entrada de Clave minima de un Map */
	@Override
	public EntradaMap<C, V> recuperarEntradaMin() {
		return abb.recuperarMin();
	}

	/** SII !esVacio(): recupera la Clave minima de un Map */
	@Override
	public C recuperarMin() {
		return abb.recuperarMin().getClave();
	}

	@Override
	public EntradaMap<C, V> recuperarEntradaMax() {
		return abb.recuperarMax();
	}

	@Override
	public C recuperarMax() {
		return abb.recuperarMax().getClave();
	}

	/**
	 * SII !esVacio(): recupera la Entrada siguiente a c segun el orden establecido
	 * entre claves, null si no existe
	 */
	@Override
	public EntradaMap<C, V> sucesorEntrada(C c) {

		EntradaMap<C, V> res = new EntradaMap<C, V>(c, null);
		return abb.sucesor(res);
	}

	@Override
	public C sucesor(C c) {
		EntradaMap<C, V> map = abb.sucesor(new EntradaMap<C, V>(c, null));
		C clave = map.getClave();
		return clave;
	}

	@Override
	public EntradaMap<C, V> predecesorEntrada(C c) {
		EntradaMap<C, V> res = new EntradaMap<C, V>(c, null);
		return abb.predecesor(res);
	}

	@Override
	public C predecesor(C c) {
		EntradaMap<C, V> res = abb.predecesor(new EntradaMap<C, V>(c, null));
		C clave = res.getClave();
		return clave;
	}

	@Override
	public EntradaMap<C, V> eliminarEntradaMin() {
		return abb.eliminarMin();
	}

	@Override
	public C eliminarMin() {
		return abb.eliminarMin().getClave();
	}
	
    /** devuelve el String con las Entradas de un Map ordenadas por clave */
    public String toString() { 
        return abb.toStringInOrden(); 
    }
}
