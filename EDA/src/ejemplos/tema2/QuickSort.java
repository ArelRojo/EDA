package ejemplos.tema2;

/**
 * class QuickSort.
 * 
 * @author FTG 
 * @version 1.0
 */

public class QuickSort {
    
    public static <T extends Comparable<T>> void quickSort(T[] v) {
        quickSort(v, 0, v.length - 1);
    }
    
    private static <T extends Comparable <T>> void quickSort(
        T[] v, int i, int d) 
    {
        if (i < d) {                       /** SIN TENER QUE COMBINAR !!! */
            int indP = particion(v, i, d); /** DIVIDIR */
            quickSort(v, i, indP - 1);     /** VENCER  */
            quickSort(v, indP + 1, d);     /** VENCER  */
        }
    }
    
    public static <T extends Comparable<T>> void q3(T[] v) {
        q3(v, 0, v.length - 1);
    }
    private static <T extends Comparable<T>> void q3(T[] v, int i, int d) {
    	if(i<d) {
    		//DIVIDIR: ordenar el pivote, o particion de v[i...d]
    		T pivote = medianaDeTres(v,i,d);
    		intercambiar(v, (i+d)/2, d-1);
    		int indP = i, j = d-1;
    		for(;indP > j;) {
    			while(v[++indP].compareTo(pivote) < 0) {;}
    			while(v[--j].compareTo(pivote) > 0) {;}
    			intercambiar(v, indP, j);
    		}
    		intercambiar(v, indP, j); //por si acaso deshacer el ultimo cambio
    		intercambiar(v,indP,d-1);
    		
    		//VENCER
    		q3(v,i,indP-1);
    		q3(v,indP+1,d);
    	}
    }
    
    private static <T extends Comparable <T>> int particion(
        T[] v, int i, int d) 
    {
        /** medianaDeTres: indP = (i+d)/2; ordenados v[i] y v[d] */
        T pivote = medianaDeTres(v, i, d);
        /** Si longitud subarray <= 2, entonces ya está ordenado */
        if (d - i <= 2) return i + 1; 
        /** Esconder el pivote en d-1 */
        intercambiar(v, (i + d) / 2, d - 1); 
        /** Ordenar el pivote: Búsqueda de indP, su posición ordenada */
        int indP = i; 
        int j = d - 1;
        while (indP < j) {
            while (v[++indP].compareTo(pivote) < 0);
            while (v[--j].compareTo(pivote) > 0);
            intercambiar(v, indP, j);
        } 
        /** Deshacer último intercambio */
        intercambiar(v, indP, j);
        /** Restaurar el pivote escondido en d-1 */
        intercambiar(v, indP, d - 1); 
        return indP;
    }
    
    private static <T extends Comparable<T>> T medianaDeTres(
        T[] v, int i, int d) 
    {
        int m = (i + d) / 2;
        if (v[m].compareTo(v[i]) < 0) intercambiar(v, i, m);
        if (v[d].compareTo(v[i]) < 0) intercambiar(v, i, d);
        if (v[d].compareTo(v[m]) < 0) intercambiar(v, m, d);
        /** v[m] es la Mediana de Tres, 
         *  mayor (o igual) que v[i] y menor (o igual) que v[d] **/
        return v[m];
    }
    
    private static <T extends Comparable <T>> void intercambiar(
        T[] v, int i, int d) 
    {
        T aux = v[i];
        v[i] = v[d];
        v[d] = aux; 
    }

    public static <T extends Comparable<T>> T seleccionRapida(T[] v, int k) {
        seleccionRapida(v, k, 0, v.length - 1);
        return v[k - 1];
    }
    
    private static <T extends Comparable <T>> void seleccionRapida(
        T[] v, int k, int i, int d) 
    {
        if (i < d) {
            int indP = particion(v, i, d);
            if (k - 1 < indP)      seleccionRapida(v, k, i, indP - 1); 
            else if (k - 1 > indP) seleccionRapida(v, k, indP + 1, d); 
            //else, si indP == k – 1 … ¡Hemos encontrado el k-ésimo menor!
        }
    }
    
    public static void main(String[] args) {
    	Integer[] v = {86,66,24,78,100,106,46,53,89,69,5};
    	
    	q3(v);
    }
}