package ejemplos.tema1;

public class Comida<E extends Comparable<E>> {
	private double calorias;
	private int minutos;
	
	public Comida(double c, int m) {
		calorias = c;
		minutos = m;
	}
	
	public int compareTo(Comida otra) {
		if(this.calorias == otra.calorias) {
			if(this.minutos<otra.minutos) return 1;
			else if(this.minutos>otra.minutos) return -1;
			else return 0;
		}else {
			if(this.calorias > otra.calorias) return 1;
			else return -1;
		}
		
	}

}

