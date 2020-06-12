package ejemplos.tema2;

public class tema2 {

	/*SII 0<= inicio <= v.length AND fin == v.length-1*/
	public static int sumar(int[] v, int inicio, int fin) {
		if(inicio>fin) {return 0;}
		else {
			return v[inicio] + sumar(v,inicio+1,fin);
		}	
	}
	
	/* SII 0<= inicio <= v.length AND fin == v.length-1*/
	public static <T> int buscar (T[] v, T b, int inicio, int fin) {
		if(inicio>fin) {return -1;}
		else {
			if(v[inicio].equals(b)) {return inicio;}
			else {return buscar(v,b,inicio+1,fin);}
		}
	}	
		/*SII 0<=fin <v.length AND inicio == 0*/
		public static <T extends Comparable<T>> T maximo(T[] v, int inicio, int fin ) {
			T res = v[fin];
			if(inicio <fin) {
				res = maximo(v, inicio, fin-1);
				if(res.compareTo(v[fin])<0) {res = v[fin];}
			}
			return res;
		}
	
	public static void main(String[] args) {
	// TODO Auto-generated method stub

	}

}
