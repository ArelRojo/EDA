package ejemplos.tema6;
import librerias.estructurasDeDatos.jerarquicos.*;
import librerias.estructurasDeDatos.lineales.*;
import librerias.estructurasDeDatos.modelos.*;

public class Tramo {
	

	private int pueblo1, pueblo2;
	private String fecha;
	public Tramo(int p1, int p2, String f) {
		this.pueblo1 = p1;
		this.pueblo2 = p2;
		this.fecha = f;
	}
	public int getPueblo1() {return pueblo1;}
	public int getPueblo2() {return pueblo2;}
	public String getFecha() {return fecha;}
	
	public static String sePuede(int x, int y, ListaConPI<Tramo> l) {
		UFSet f = new ForestUFSet(200);
		for(l.inicio(); !l.esFin(); l.siguiente()) {
			Tramo t = l.recuperar(); 
			int clase1 = t.getPueblo1();
			int clase2 = t.getPueblo2();
			if(f.find(x) == f.find(y)) {
				return t.getFecha();
			}
			if(clase1 != clase2) {f.union(clase1, clase2);}
		}
		
		return null;
	}
}
