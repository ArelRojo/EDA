package librerias.estructurasDeDatos.grafos;

import librerias.estructurasDeDatos.modelos.*;

/**
 * Clase abstracta Grafo: Base de la jerarquia Grafo, que define el
 * comportamiento de un grafo. No es una interfaz porque incluye el codigo de
 * aquellas operaciones de un grafo que son independientes tanto de su tipo como
 * de su implementacion.
 */

public abstract class Grafo {

	/**
	 * Devuelve el numero de vertices de un grafo.
	 * 
	 * @return int, numero de vertices de un grafo
	 */
	public abstract int numVertices();

	/**
	 * Devuelve el numero de aristas de un grafo.
	 * 
	 * @return int, numero de aristas de un grafo
	 */
	public abstract int numAristas();

	/**
	 * Comprueba si la arista (i,j) esta en un grafo.
	 * 
	 * @param i, Vertice origen
	 * @param j, Vertice destino
	 * @return boolean, true si (i,j) esta y false en caso contrario
	 */
	public abstract boolean existeArista(int i, int j);

	/**
	 * Devuelve el peso de la arista (i,j) de un grafo, 0 si dicha arista no esta en
	 * el grafo.
	 * 
	 * @return double, Peso de la arista (i,j), 0 si no existe.
	 */
	public abstract double pesoArista(int i, int j);

	/**
	 * Si no esta, inserta la arista (i, j) en un grafo no Ponderado.
	 * 
	 * @param i, Vertice origen
	 * @param j, Vertice destino
	 */
	public abstract void insertarArista(int i, int j);

	/**
	 * Si no esta, inserta la arista (i, j) de peso p en un grafo Ponderado.
	 * 
	 * @param i, Vertice origen
	 * @param j, Vertice destino
	 * @param p, Peso de la arista (i,j)
	 */
	public abstract void insertarArista(int i, int j, double p);

	/**
	 * Devuelve una Lista Con PI que contiene los adyacentes al vertice i de un
	 * grafo.
	 * 
	 * @param i, Vertice del que se obtienen los adyacentes
	 * @return ListaConPI, con los vertices adyacentes a i
	 */
	public abstract ListaConPI<Adyacente> adyacentesDe(int i);

	/**
	 * Devuelve un String con cada uno de los vertices de un grafo y sus adyacentes,
	 * en orden de insercion
	 * 
	 * @return String, que representa a un grafo
	 */
	public String toString() {
		String res = "";
		for (int i = 0; i < numVertices(); i++) {
			res += "Vertice: " + i;
			ListaConPI<Adyacente> l = adyacentesDe(i);
			res += (l.esVacia()) ? " sin adyacentes " : " con adyacentes: ";
			for (l.inicio(); !l.esFin(); l.siguiente()) {
				res += l.recuperar() + " ";
			}
			res += "\n";
		}
		return res;
	}

	// atributos "auxiliares"
	protected int[] visitados;
	protected int ordenVisita;

	
	//metodo toArrayDFS del grafo
	public int[] toArrayDFS() {
		int[]res =new int[numVertices()];
		ordenVisita=0;
		visitados =new int[numVertices()];
		for(int v = 0; v<numVertices(); v++) {
			if(visitados[v] == 0) {toArrayDFS(v, res);}
			
		}
		return res;
	}
	
	public int[] finDelDFS() {
		int[] res = new int[numVertices()]; ordenVisita = 0;
		visitados = new int[numVertices()];
		for(int v = 0; v<numVertices(); v++) {
			if(visitados[v] == 0) {finDelDFS(v, res);}
		}
		return res;
	}
	
	// metodo toArrayDFS de un vertice
		protected void toArrayDFS(int v, int[] res) {
			res[ordenVisita] = v;
			ordenVisita++;
			visitados[v] = 1;
			ListaConPI<Adyacente> l = adyacentesDe(v);
			for (l.inicio(); !l.esFin(); l.siguiente()) {
				int w = l.recuperar().getDestino();
				if (visitados[w] == 0) {
					toArrayDFS(w, res);
				}

			}
		}
		
	/** metodo finDelDFS 
	 */
	protected void finDelDFS(int v, int[] res) {
		visitados[v] = 1;
		ListaConPI<Adyacente> l = adyacentesDe(v);
		for(l.inicio(); !l.esFin(); l.siguiente()) {
			int w = l.recuperar().getDestino();
			if(visitados[w] == 0) {
				finDelDFS(w,res);
			}
		}
		visitados[v] = 2;
		res[ordenVisita] = v; ordenVisita++;
	}
	
	/**
	 * Se iran anyadiendo metodos y atributos "auxiliares" conforme avance el tema.
	 */
	public boolean esConexo() {
		visitados = new int[numVertices()];
		ordenVisita = 0;
		recorridoDFS(0);
		return ordenVisita == numVertices();
	}
	public void recorridoDFS(int v) {
		visitados[v] = 1;
		ordenVisita++;
		ListaConPI<Adyacente> l = adyacentesDe(v);
		for(l.inicio();!l.esFin(); l.siguiente()) {
			int w = l.recuperar().getDestino();
			if(visitados[w] == 0) {recorridoDFS(w);}
		}
	}

	public static void main(String[] args) {
//		GrafoDirigido g = new GrafoDirigido(4);
		GrafoNoDirigido g = new GrafoNoDirigido(4);
		g.insertarArista(0, 1);
		g.insertarArista(2, 0);
		g.insertarArista(2, 3);
		g.insertarArista(2, 1);
		

//		int[] a = g.finDelDFS();
		
		//System.out.println(g.gradoAlt());
		
//		for(int i= 0; i< a.length; i++)
//			System.out.println(a[i]);
//	}
		String[] s = g.spanningTree();
		
		for(int i=0; i<s.length;i++) {
			System.out.println(s[i]);
		}
		
		
}
	}