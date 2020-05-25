package librerias.estructurasDeDatos.jerarquicos;
import librerias.estructurasDeDatos.modelos.UFSet;

/** Clase que implementa el interfaz MFSet con coste amortizado prácticamente constante
 *  Cada subconjunto se guarda como un árbol:
 *  - Los nodos del árbol son los elementos del subconjunto: 0, 1, 2, .., talla
 *  - En cada nodo guardamos una referencia al padre
 *  - El elemento raíz del árbol se usa para representar el subconjunto
 */
public class ForestUFSet implements UFSet {
     protected int[] elArray; 
    // si elArray[i] < 0 i es la raíz de un árbol y |elArray[i]| – 1 su altura
    
    /** Crea un UFSet de n clases (subconjuntos) de un
      * elemento cuyos identificadores son 0, 1, …, n-1 */ 
    public ForestUFSet(int n) {
        elArray = new int[n];
        // crea n clases de equivalencia de 1 elemento 
        for (int i = 0; i < elArray.length; i++) {
            elArray[i] = -1; // el Rango de una Hoja es -1
        }
    }

    /** Devuelve el identificador de la clase de 
      *  equivalencia a la que pertenece el elemento i,
      *  tras realizar una compresion de caminos */
    public int find(int i) {
        if (elArray[i] < 0) { return i; }
        return elArray[i] = find(elArray[i]);
    }

    /** PRECONDICION: claseI != claseJ 
      *                AND claseI = find(i) AND claseJ = find(j)
      *  Une las clases de equivalencia con identificadores
      *  claseI y claseJ mediante combinacion por rango */
    public void union(int claseI, int claseJ) {
        if (elArray[claseI] == elArray[claseJ]) { // Mismo Rango
            elArray[claseI] = claseJ; // Colgar claseI de claseJ 
            elArray[claseJ]--; // Incrementar Rango de claseJ
        } 
        else { // Clases con distinto Rango -> NO se incrementa su rango
            if (elArray[claseI] < elArray[claseJ]) { // Negativos!!
                elArray[claseJ] = claseI; // Colgar claseJ de claseI
            } else { 
                elArray[claseI] = claseJ; // Colgar claseI de claseJ
            }
        }
    }
}