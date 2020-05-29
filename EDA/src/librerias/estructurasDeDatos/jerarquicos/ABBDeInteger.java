package librerias.estructurasDeDatos.jerarquicos;

public class ABBDeInteger extends ABB<Integer> {
	public ABBDeInteger() { super(); }
	
	public boolean caminoQueSuma(int s) {
		return caminoQueSuma(s, this.raiz);
		}
		protected boolean caminoQueSuma(int s, NodoABB<Integer> actual) {
		if (actual == null) { return false; }
		s -= actual.dato;
		if (s == 0) { return true; } // Encontrado
		if (s < 0) { return false; } // La suma del camino supera la buscada
		if (s <= actual.dato) { return caminoQueSuma(s, actual.izq); }
		return caminoQueSuma(s, actual.izq) || caminoQueSuma(s, actual.der);
		}
}
