package librerias.estructurasDeDatos.grafos;

import librerias.estructurasDeDatos.modelos.ListaConPI;

/** Clase GrafoNoDirigido: 
 *  implementacion de un grafo No Dirigido (Ponderado o no) 
 *  mediante Listas de Adyacencia:
 *  un grafo No Dirigido ES UN Grafo Dirigido tal que 
 *  si la Arista (i, j) esta en la Lista de Adyacencia de i 
 *  entonces tambien esta la Arista (j, i) en la Lista de Adyacencia de j
 */

public class GrafoNoDirigido extends GrafoDirigido {
    
    /** Construye un grafo No Dirigido vacio con numVertices. 
     *  @param numVertices, Numero de vertices del grafo vacio
     */
    public GrafoNoDirigido(int numVertices) { super(numVertices); }
    
    /** Si no esta, inserta la arista (i, j) 
     *  en un grafo No Dirigido y No Ponderado; 
     *  por tanto, tambien inserta la arista (j, i).
     *  @param i, Vertice origen
     *  @param j, Vertice destino
     */ 
    public void insertarArista(int i, int j) {
        insertarArista(i, j, 1);
        /*if (!existeArista(i, j)) { 
            elArray[i].insertar(new Adyacente(j, 1)); 
            elArray[j].insertar(new Adyacente(i, 1));
            numA++; 
        }*/
    }

    public String toStringCC() {
    	String res = ""; visitados = new int[numVertices()];
    	int nCC = 0;
    	for(int v = 0; v<numVertices(); v++) {
    		if(visitados[v] == 0) {nCC++; res += " [" + toStringCC(v) + "] ";}
    	}
    	return "Hay " + nCC + " componentes conexas y son: " + res;
    }
    protected String toStringCC(int v) {
    	String res = "" +v; visitados[v] = 1;
    	ListaConPI<Adyacente> l = adyacentesDe(v);
    	for(l.inicio(); !l.esFin(); l.siguiente()) {
    		int w = l.recuperar().getDestino();
    		if(visitados[w]==0) {
    			res += toStringCC(w);
    		}
    		
    	}
    	return res;
    }
    
    protected String[] spanningTree(int v, String[] res) {
    	visitados[v] = 1;	
    	ListaConPI<Adyacente> l = adyacentesDe(v);
    	for(l.inicio(); !l.esFin(); l.siguiente()) {
    		int w = l.recuperar().getDestino();
    		if(visitados[w] == 0) {
    			res[aristasTree++] = "[" + v + ", " + w + "]";
    			spanningTree(w, res);
    		}
    	}
    	return res;
    }
    
    protected int aristasTree;
    
    public String[] spanningTree(){
    	visitados = new int[numVertices()];
    	String[] res = new String[numVertices() - 1];
    	aristasTree=0;
    	spanningTree(0, res);
    	if(aristasTree != numVertices() - 1) {return null;}
    	else return res;
    }
     
    /** Si no esta, inserta la arista (i, j) de peso p 
     *  en un grafo No Dirigido y Ponderado; 
     *  por tanto, tambien inserta la arista (j, i) de peso p.
     *  @param i, Vertice origen
     *  @param j, Vertice destino
     *  @param p, Peso de (i, j)
     */ 
    public void insertarArista(int i, int j, int p) {
        if (!existeArista(i, j)) { 
            elArray[i].insertar(new Adyacente(j, p)); 
            elArray[j].insertar(new Adyacente(i, p));
            numA++; 
        }
    }
}