package librerias.estructurasDeDatos.jerarquicos;

import librerias.estructurasDeDatos.modelos.UFSet;

/**
 * Clase que implementa el interfaz MFSet con coste amortizado pr�cticamente
 * constante Cada subconjunto se guarda como un �rbol: - Los nodos del �rbol son
 * los elementos del subconjunto: 0, 1, 2, .., talla - En cada nodo guardamos
 * una referencia al padre - El elemento ra�z del �rbol se usa para representar
 * el subconjunto
 */
public class ForestUFSet implements UFSet {
	protected int[] elArray;
	// si elArray[i] < 0 i es la ra�z de un �rbol y |elArray[i]| � 1 su altura

	/**
	 * Crea un UFSet de n clases (subconjuntos) de un elemento cuyos identificadores
	 * son 0, 1, �, n-1
	 */
	public ForestUFSet(int n) {
		elArray = new int[n];
		// crea n clases de equivalencia de 1 elemento
		for (int i = 0; i < elArray.length; i++) {
			elArray[i] = -1; // el Rango de una Hoja es -1
		}
	}

	/**
	 * Devuelve el identificador de la clase de equivalencia a la que pertenece el
	 * elemento i, tras realizar una compresion de caminos
	 */
	public int find(int i) {
		if (elArray[i] < 0) {
			return i;
		}
		return elArray[i] = find(elArray[i]);
	}

	/**
	 * PRECONDICION: claseI != claseJ AND claseI = find(i) AND claseJ = find(j) Une
	 * las clases de equivalencia con identificadores claseI y claseJ mediante
	 * combinacion por rango
	 */
	public void union(int claseI, int claseJ) {
		if (elArray[claseI] == elArray[claseJ]) { // Mismo Rango
			elArray[claseI] = claseJ; // Colgar claseI de claseJ
			elArray[claseJ]--; // Incrementar Rango de claseJ
		} else { // Clases con distinto Rango -> NO se incrementa su rango
			if (elArray[claseI] < elArray[claseJ]) { // Negativos!!
				elArray[claseJ] = claseI; // Colgar claseJ de claseI
			} else {
				elArray[claseI] = claseJ; // Colgar claseI de claseJ
			}
		}
	}

	public String toIdentificadores() {
		String res = "";
		for (int i = 0; i < elArray.length; i++) {
			if (elArray[i] < 0) {
				res += find(i) + " ";
			}
		}
		return res;
	}

	/**
	 * Devuelve un String con los elementos de la clase de equivalencia a la que
	 * pertenece el elemento a
	 * 
	 * @param a
	 * @return String
	 */
	public String toClaseEq(int a) {
		String res = "";
		for (int i = 0; i < elArray.length; i++) {
			if (find(i) == find(a)) {
				res += " " + i;
			}
		}
		return res;
	}

	/**
	 * que devuelve el n�mero de elementos que tiene el conjunto de la clase de
	 * equivalencia a la que pertenece el elemento a
	 * 
	 * @param a
	 * @return int
	 */

	public int cardinal(int a) {
		int cont = 0;
		for (int i = 0; i < elArray.length; i++) {
			if (find(i) == find(a)) {
				cont++;
			}
		}
		return cont;
	}

	/**
	 * que devuelve el n�mero de elementos que tendr�a el conjunto uni�n de las
	 * clases de equivalencia a las que pertenecen los elementos a y b.
	 * 
	 * @param a, b
	 * @return int
	 */
	public int cardinalUnion(int a, int b) {
		int cont = 0;
		for(int i = 0; i<elArray.length; i++) {
			if(find(a) == find(i) || find(b) == find(i)) {
				cont++;
			}
		}
		return cont;
	}
}