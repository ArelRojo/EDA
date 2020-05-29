package librerias.estructurasDeDatos.grafos;

import librerias.estructurasDeDatos.modelos.ListaConPI; 
import librerias.estructurasDeDatos.lineales.LEGListaConPI;

/** Clase GrafoDirigido: 
 *  implementacion de un grafo Dirigido (Ponderado o no) 
 *  mediante Listas de Adyacencia.
 */

public class GrafoDirigido extends Grafo { 
    
    protected int numV, numA;
    protected ListaConPI<Adyacente>[] elArray;
    
    /** Construye un grafo Dirigido vacio con numVertices. 
     *  @param numVertices, Numero de vertices del grafo vacio
     */
    @SuppressWarnings("unchecked")
    public GrafoDirigido(int numVertices) {
        numV = numVertices; 
        numA = 0;
        elArray = new ListaConPI[numVertices]; 
        for (int i = 0; i < numV; i++) {
            elArray[i] = new LEGListaConPI<Adyacente>();
        }
    }
    /**grado salida del grafo*/
    public int gradoSalida() {
    	//crear e inicializar el array de contadores
    	int[] cont = new int[numV];
    	for(int i = 0; i<numV; i++) {
    		//actualizar el contador de grados con la talla de cada elemento del array 
    		ListaConPI<Adyacente> v = elArray[i];
    		cont[i] = v.talla();
    	}
    	return maximo(cont);
    }
    /**grado salida de un vertice*/
    public int gradoSalida(int i) {
    	return elArray[i].talla();
    }
    /**grado entrada del grafo*/
    public int gradoEntrada() {
    	int[] cont  = new int[numV];//crear e inicializar el array de contadores
    	for(int i = 0; i<numV; i++) {
    		//actualizaar el contador del grado de Entrada de cada vertice
    		//de la lista adyacenteDe(i)
    		ListaConPI<Adyacente> a = elArray[i];
    		for(a.inicio(); !a.esFin(); a.siguiente()) {
    		cont[a.recuperar().getDestino()]++;
    		}
    	}
    	return maximo(cont);
    }
    
    /**grado entrada de un vertice
     */
    public int gradoEntrada(int i) {
    	int grado = 0;
    	for(int j = 0; j < numV; j++) {
    		if(existeArista(j, i)) grado ++;
    	}
    	return grado; //el grado es el valor del grado de entrada de i
    }
    
    /**metodo alternativo para devolver el grado del grafo*/
    public int gradoAlt() {
    	int[] gradosEntr = new int[numV];
    	int[] gradosSal = new int[numV];
    	for(int i = 0; i<numV; i++) {
    		gradosEntr[i] = gradoEntrada(i);
    		gradosSal[i] = gradoSalida(i);
    	}
    	int[] contGrado = new int[numV];
    	for(int i = 0; i<numV; i++) {
    		contGrado[i] = gradosEntr[i] + gradosSal[i];
    	}
    	 return maximo(contGrado);                          
    }
    /**Devuelve el grado del grafo
     * 
     * @return
     */
    public int grado() {
    	//Paso 1: almacenar en un array los grados de todos los vertices
    	//Paso 2: sacar el maximo grado de los vertices
    	
    	int[] v = getArrayGrados();
    	return maximo(v);
    	
    	
    }
    
    protected int[] getArrayGrados() {
    	int[] gradosV = new int[numV];
    	for(int i =0; i<numV; i++) {
    		ListaConPI<Adyacente> l = elArray[i];
    		//Actualizar grado vérticce i con su grado de salida
    		gradosV[i] += l.talla();
    		//Actualizar grado vertices *adyacentes* a i con "parte" de su grado de entrada
    		for(l.inicio();!l.esFin();l.siguiente())
    			gradosV[l.recuperar().getDestino()]++;
    	}
    	return gradosV;
    }
    
    protected int maximo(int[] v) {
    	int max = v[0];
    	for(int i =1; i < v.length; i++) {
    		if(v[i]>max) {max = v[i];}
    	}
    	return max;
    }
    
    public double pesoMax() {
    	double res = -1;
    	for(int i = 0; i<numV; i++) {
    		ListaConPI<Adyacente> lista = elArray[i];
    		for(lista.inicio();!lista.esFin(); lista.siguiente()) {
    			double a = lista.recuperar().getPeso();
    			if(a > res) res = a;
    		}
    	}
    	return res;
    }
    /** Devuelve el numero de vertices de un grafo. 
     *  @return int, Numero de vertices de un grafo
     */
    public int numVertices() { return numV; }
     
    /** Devuelve el numero de aristas de un grafo.
     *  @return int, Numero de aristas de un grafo
     */
    public int numAristas() { return numA; }
    
    /** Comprueba si la arista (i,j) esta en un grafo.
     *  @param i, Vertice origen
     *  @param j, Vertice destino
     *  @return boolean, true si (i,j) esta y false en caso contrario
     */
    public boolean existeArista(int i, int j) {
       ListaConPI<Adyacente> l = elArray[i]; 
       for (l.inicio(); !l.esFin(); l.siguiente())
            if (l.recuperar().getDestino() == j) return true;
       return false;   
    }
    
    /** Devuelve el peso de la arista (i,j) de un grafo, 
     *  0 si dicha arista no esta en el grafo.
     *  @return double, Peso de la arista (i,j), 0 si no existe.
     */
    public double pesoArista(int i, int j) {
        ListaConPI<Adyacente> l = elArray[i];
        for (l.inicio(); !l.esFin(); l.siguiente())
            if (l.recuperar().getDestino() == j) 
                return l.recuperar().getPeso();
       return 0.0;
    }
    
    /** Si no esta, inserta la arista (i, j) en un grafo no Ponderado 
     *  (al principio de la Lista de adyacentes a i).
     *  @param i, Vertice origen
     *  @param j, Vertice destino
     */    
    public void insertarArista(int i, int j) {
        insertarArista(i, j, 1);
        /*if (!existeArista(i, j)) { 
            elArray[i].insertar(new Adyacente(j, 1)); 
            numA++; 
        }*/
    }

    /** Si no está, inserta la arista (i, j) de peso p en un grafo Ponderado 
     *  (al principio de la Lista de adyacentes a i).
     *  @param i, Vertice origen
     *  @param j, Vertice destino
     *  @param p, Peso de (i, j)
     */ 
    public void insertarArista(int i, int j, double p) {
        if (!existeArista(i, j)) { 
            elArray[i].insertar(new Adyacente(j, p)); 
            numA++; 
        }
    }
        
    /** Devuelve una Lista Con PI que contiene los adyacentes al vertice i de un grafo.
     *  @param i, Vertice del que se obtienen los adyacentes
     *  @return ListaConPI, con los vertices adyacentes a i
     */
    public ListaConPI<Adyacente> adyacentesDe(int i) { 
        return elArray[i]; 
    }
    
    public int gradoV(int i) {
    	return gradoEntrada(i) + gradoSalida(i);
    }
    
    public boolean esRegular() {
    	int grado = gradoEntrada(0) + gradoSalida(0);
    	
    	for(int i = 1; i<numV; i++) {
    		int g = gradoEntrada(i) + gradoSalida(i);
    		if(grado != g) return false;
    	}
    	return true;
    }
    
    public int getVerticeReceptivo() {
    	
    	for(int i = 0; i<numV; i++) {
    		if(gradoEntrada(i) == numV - 1) return i;
    	}
    	return -1;
    }
    
    public int getSumideroU() {
    	for(int i = 0; i<numV; i++) {
    		if(gradoEntrada(i) == numV-1 && gradoSalida(i) == 0) return i;
    	}
    	return -1;
    }
    
    public boolean esSumidero(int i) {
    	if(gradoEntrada(i) > 0 && gradoSalida(i) == 0) return true;
    	else return false;
    }
    
    public int getFuenteU() {
    	for(int i = 0; i<numV; i++) {
    		if(gradoEntrada(i) == 0 && gradoSalida(i) == numV - 1)return i;
    	}
    	return -1;
    }
    
    public boolean esCompleto() {
    	return numA == numV * (numV - 1);
    }
    
 
}