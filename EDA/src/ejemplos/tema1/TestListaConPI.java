package ejemplos.tema1;
import librerias.estructurasDeDatos.lineales.LEGListaConPI;
import librerias.estructurasDeDatos.modelos.ListaConPI;

public class TestListaConPI {

	public static void main(String[] args) {
		ListaConPI<Integer> l = new LEGListaConPI<Integer>();
		l.insertar(1);
		l.insertar(2);
		l.insertar(3);
//		l.insertar(4);
		l.insertar(5);
		l.insertar(6);
		//l.fin();
		l.inicio();
		for(int i =0; i<3; i++) {
			l.siguiente();
		}
		l.insertar(4);
		System.out.println(l.toString());
		l.eliminar();
		System.out.println(l.toString());
		l.eliminar();
		System.out.println(l.toString());
	}

}
