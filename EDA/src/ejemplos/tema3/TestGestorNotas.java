package ejemplos.tema3;
import librerias.excepciones.*;

public class TestGestorNotas {

	public static void main(String[] args) throws NotaNoEncontradaException {
		GestorNotas gn = new GestorNotas(10);
		
		gn.guardarNota("Lisa Saliasi", "Mates", 10);
		gn.guardarNota("Sara Saliasi", "Info", 10);
		gn.guardarNota("Lisa Saliasi", "Info", 5);
		
		gn.consultaNota("Lisa Saliasi", "Info");

	}

}
