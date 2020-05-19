package ejemplos.tema3;

import librerias.estructurasDeDatos.deDispersion.TablaHash;
import librerias.estructurasDeDatos.modelos.Map;
import librerias.excepciones.NotaNoEncontradaException;

public class GestorNotas {

	private Map<String, Map<String, Integer>> m;
	Map<String, Integer> s = null;


	public GestorNotas(int n) {
		m = new TablaHash<String, Map<String, Integer>>(n);
	}

	public void guardarNota(String alumno, String asignatura, int nota) {

		s.insertar(alumno, nota);
		m.insertar(asignatura, s);

	}

	public double consultaNota(String alumno, String asignatura) throws NotaNoEncontradaException {

		Map<String, Integer> n = m.recuperar(asignatura);
		int grade = n.recuperar(alumno);

		if (enteroNull(grade) == true) {
			throw new NotaNoEncontradaException("La nota buscada no existe");
		} else {
			return grade;
		}
	}

	private boolean enteroNull(int a) {
		Integer b = new Integer(a);
		if (b == null)
			return true;
		else
			return false;

	}
}
