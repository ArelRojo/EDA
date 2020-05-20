package ejemplos.tema3;
import librerias.excepciones.UsuarioExistente;

public class TestGestorNotas {

	public static void main(String[] args){
		GestorNotas gn = new GestorNotas(10);
		
		gn.saveNote("Lisa Saliasi", "Mates", 10.0);
		gn.saveNote("Sara Saliasi", "Info", 10.0);
		gn.saveNote("Lisa Saliasi", "Info", 5.6);
		gn.saveNote("Lila", "Mates", null);
		
		System.out.println(gn.consultaNota("Lisa Saliasi", "Info"));
		System.out.println(gn.consultaNota("Lila", "Mates"));
	}

}
