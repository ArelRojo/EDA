package ejemplos.tema3;

//para poder usar Map y ListaConPI
import librerias.estructurasDeDatos.modelos.*; 

//para poder usar TablaHash, la Implementacion de Map
import librerias.estructurasDeDatos.deDispersion.*; 
public class map11{

	
	
	/**Obtiene la moda de un array generico v
	 * (i.e devuelve el primer elemento de v que se repite más veces)
	 */

	public static void main(String[] args) {
		Integer M[] = {3,6,7,5,8,0,1,8,9,10,0,5,7,9,3,4,3,10,10,0,2,8,6,5,5};
//		TablaHash<Integer, Integer> m = new TablaHash<Integer, Integer>(M.length);
		System.out.println("La moda es:" + TablaHash.modaDe(M) );
	

		
		
		
	
	}

}
