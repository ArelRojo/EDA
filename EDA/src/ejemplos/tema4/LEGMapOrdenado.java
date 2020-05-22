package ejemplos.tema4;

import librerias.estructurasDeDatos.lineales.LEGListaConPI;
import librerias.estructurasDeDatos.modelos.ListaConPI;
import librerias.estructurasDeDatos.modelos.MapOrdenado;
import ejemplos.tema4.EntradaMap;

public class LEGMapOrdenado<C extends Comparable<C>, V> implements MapOrdenado<C, V> {
	protected int talla;
	protected ListaConPI<EntradaMap<C, V>>[] elArray;

	@Override
	public V insertar(C c, V v) {
		V antiguoValor = null;
		// Búsqueda de la entrada de clave c
		ListaConPI<EntradaMap<C, V>> cubeta = (ListaConPI<EntradaMap<C, V>>) recuperar(c);
		if (cubeta.esFin()) {
			cubeta.insertar(new EntradaMap<C, V>(c, v));
			talla++;
		} else {
			antiguoValor = cubeta.recuperar().getValor();
			cubeta.recuperar().valor = v;
		}
		return antiguoValor;
	}

	private ListaConPI<EntradaMap<C, V>> localizar(C c) {
		int pos = indiceHash(c);
		ListaConPI<EntradaMap<C, V>> cubeta = elArray[pos];
		for (cubeta.inicio(); !cubeta.esFin() && !cubeta.recuperar().clave.equals(c); cubeta.siguiente())
			;
		return cubeta;
	}

	protected int indiceHash(C c) {
		int indiceHash = c.hashCode() % elArray.length;
		if (indiceHash < 0)
			indiceHash += elArray.length;
		return indiceHash;
	}

	@Override
	public V eliminar(C c) {
		V valor = null;
		ListaConPI<EntradaMap<C, V>> cubeta = localizar(c);
		if (!cubeta.esFin()) {
			valor = cubeta.recuperar().valor;
			cubeta.eliminar();
			talla--;
		}
		return valor;
	}

	@Override
	public V recuperar(C c) {
		V valor = null;
		ListaConPI<EntradaMap<C, V>> cubeta = localizar(c);
		if (!cubeta.esFin())
			valor = cubeta.recuperar().valor;
		return valor;
	}

	@Override
	public boolean esVacio() {
		return talla == 0;
	}

	@Override
	public int talla() {
		return talla;
	}

	@Override
	public ListaConPI<C> claves() {
		ListaConPI<C> l = new LEGListaConPI<C>();
		for (ListaConPI<EntradaMap<C, V>> cubeta : elArray)
			for (cubeta.inicio(); !cubeta.esFin(); cubeta.siguiente())
				l.insertar(cubeta.recuperar().clave);

		return l;
	}

	public ListaConPI<C> clavesConValor(V v) {
		ListaConPI<C> deClaves = new LEGListaConPI<C>();
		for (int i = 0; i < elArray.length; i++) {
			for (elArray[i].inicio(); !elArray[i].esFin(); elArray[i].siguiente()) {
				if (elArray[i].recuperar().valor.equals(v)) {
					deClaves.insertar(elArray[i].recuperar().clave);
				}
			}
		}
		return deClaves;
	}
	
	 /** SII !esVacio(): 
     *  recupera la Entrada de Clave minima de un Map Ordenado */
	@Override
	public EntradaMap<C, V> recuperarEntradaMin() {
		
			return null;
	}

	@Override
	public C recuperarMin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntradaMap<C, V> recuperarEntradaMax() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public C recuperarMax() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntradaMap<C, V> sucesorEntrada(C c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public C sucesor(C c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntradaMap<C, V> predecesorEntrada(C c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public C predecesor(C c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntradaMap<C, V> eliminarEntradaMin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public C eliminarMin() {
		// TODO Auto-generated method stub
		return null;
	}

}
