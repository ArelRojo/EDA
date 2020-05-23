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
    
    /** Diseñar un metodo estatico, generico e iterativo entradas 
     *  que devuelva una ListaConPI con las Entradas de un Map m 
     *  ordenadas ascendentemente. 
     */
    public static <C extends Comparable<C>, V> 
    ListaConPI<EntradaMap<C, V>> entradas(MapOrdenado<C, V> m) 
    {
        ListaConPI<EntradaMap<C, V>> l = new LEGListaConPI<EntradaMap<C, V>>();
        // COMPLETAR
        
        /** Obtener primera Entrada del Map Ordenado por claves,
         *  i.e. la Entrada de clave minima del Map 
         */
        EntradaMap<C, V> e = m.recuperarEntradaMin();
       
        /** Insertar primer elemento de la lista de Entradas 
         *  ordenada ascendentemente por clave 
         */
        l.insertar(e);
        
        /** Para obtener siguientes Entradas de la lista resultado,
         *  recorrer el Map Ordenado por claves 
         */
        ListaConPI<C> lista = m.claves();
        for (lista.inicio(); !lista.esFin();lista.siguiente()) {
        	C c = e.getClave();
        	
            /** Obtener siguiente Entrada del Map Ordenado por claves,
             *  i.e. el sucesor de la Entrada e 
             */
        	EntradaMap<C, V> f = m.sucesorEntrada(c);
            
            /** Insertar siguiente elemento de la lista de Entradas
             *  ordenada ascendentemente por clave 
             */
            l.insertar(f);
        }
        return l;
    }
    
    /** Disenyar un metodo estatico, generico e iterativo mapSort 
     *  que, con la ayuda de un MapOrdenado, 
     *  ordene los elementos (Comparable) de un array v.  
     */
    public static <C extends Comparable<C>> void mapSort(C[] v) {
    	MapOrdenado<C, C> map = new ABBMapOrdenado<C,C>();
    	for(int i = 0; i < v.length; i++) {
    		map.insertar(v[i], v[i]);
    	}
    	C c = map.recuperarMin();
    	for(int i = 0; i<v.length; i++) {
    		v[i] = c;
    		c = map.sucesor(c);
    	}
    }
    /** Diseñar un metodo estatico, generico e iterativo hayDosQueSuman 
     *  que, dados un array v de enteros y un entero k, 
     *  determine si existen en v dos numeros cuya suma sea k. 
     *  Usar un Map Ordenado como EDA auxiliar.
     */
    public static boolean hayDosQueSuman(Integer[] v, int k) {
        // COMPLETAR
    	MapOrdenado<Integer, Integer> aux = null;
    	for(int i = 0; i<v.length;i++) {
    		aux.insertar(v[i], i);
    	}
    	Integer min = aux.recuperarMin(), max = aux.recuperarMax();
    	boolean res = false;
    	for(int i =0; i<v.length;i++) {
    		if(min+max == k) {res = true;}
    		else if(min+max < k) {min=aux.sucesor(min);}
    		else {max = aux.predecesor(max);}
    	}
		return res;
    	
    }
}
