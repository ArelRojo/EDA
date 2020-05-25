package ejemplos.tema5;

import librerias.estructurasDeDatos.modelos.ColaPrioridad;
import librerias.estructurasDeDatos.jerarquicos.MonticuloBinario;
import librerias.estructurasDeDatos.modelos.ListaConPI;
import librerias.estructurasDeDatos.lineales.LEGListaConPI;

/**
 * class UsosColaPrioridad.
 * 
 * @author FTG 
 * @version 1.0
 */

public class UsosColaPrioridad {
    
    /** Problema 1: 
     *  Disenyar un metodo estatico e iterativo cPSort 
     *  que, con la ayuda de una Cola de Prioridad, 
     *  ordene un array v de elementos Comparable. 
     */
    public static <E extends Comparable<E>> void cPSort(E[] v) {
       ColaPrioridad<E> cola = new MonticuloBinario<>();
       for(int i = 0; i<v.length;i++) {
    	   cola.insertar(v[i]);
       }
       v[0] = cola.recuperarMin();
       cola.eliminarMin();
       for(int i = 1; i < v.length; i++) {
    	   v[i] = cola.recuperarMin();
    	   cola.eliminarMin();
       }
    }
    
    /** Problema 2:
     *  Disenyar un metodo estatico, generico e iterativo cPFusionar 
     *  que devuelva una ListaConPI con los datos de 2 Colas de Prioridad dadas, 
     *  cP1 y cP2, ordenados ascendentemente. 
     *  El metodo no puede usar ninguna EDA auxiliar para calcular su resultado 
     *  y, ademas, cP1 y cP2 deben quedar vacias al concluir su ejecucion.
     */
    public static <E extends Comparable<E>> ListaConPI<E> cPFusionar(
        ColaPrioridad<E> cP1, ColaPrioridad<E> cP2) 
    {
        ListaConPI<E> res = new LEGListaConPI<>();
        while(!cP1.esVacia() || !cP2.esVacia()) {
        	if(cP1.esVacia()) {
        		res.insertar(cP2.recuperarMin());
        		cP2.eliminarMin();
        	}
        	else if(cP2.esVacia()) {
        		res.insertar(cP1.recuperarMin());
        		cP1.eliminarMin();
        	}
        	else {
        		E minCp1 = cP1.recuperarMin();
                E minCp2 = cP2.recuperarMin();
                int aux = minCp1.compareTo(minCp2);
                if(aux > 0) {
                	res.insertar(minCp2);
                	res.insertar(minCp1);
                }
                else if(aux < 0) {
                	res.insertar(minCp1);
                	res.insertar(minCp2);
                }
                else {
                	res.insertar(minCp1);
                }
                cP2.eliminarMin();
            	cP1.eliminarMin();
        	}
        }
        return res;
    }
    
    /** Problema 3:
     *  Disenyar un metodo estatico e iterativo cPEsLineal 
     *  que determine si un conjunto de valores reales se ajusta (aprox.) 
     *  a una funcion lineal creciente usando el siguiente algoritmo: 
     *  comprobar si la diferencia entre todo par de valores consecutivos, 
     *  en orden ascendente, esta acotada por un epsilon dado. 
     */
    public static boolean cPEsLineal(ColaPrioridad<Double> cP, double epsilon) {
        // COMPLETAR
    }
    
    /** Problema 4:
     *  Disenyar un metodo estatico, generico e iterativo cPTopK 
     *  que, dado un array de datos v y un entero k, 
     *  devuelva una Cola de Prioridad con los k mejores (Top K) datos de v. 
     *  El metodo debe tener un coste O(X log k), siendo X la longitud de v.
     */
    public static <E extends Comparable<E>> ColaPrioridad<E> cPTopK(
        E[] v, int k) 
    {
        // COMPLETAR
    }
    
}