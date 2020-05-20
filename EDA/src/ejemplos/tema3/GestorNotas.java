package ejemplos.tema3;

import librerias.estructurasDeDatos.deDispersion.TablaHash;
import librerias.estructurasDeDatos.lineales.LEGListaConPI;
import librerias.estructurasDeDatos.modelos.Map;
import librerias.excepciones.UsuarioExistente;

public class GestorNotas {
//	LEGListaConPI<Student> listStudents = new LEGListaConPI<>();
	private Map<String, LEGListaConPI<Student>> m;

	public GestorNotas(int n) {
		m = new TablaHash<>(n);
	}

	public void saveNote(String id, String subject, Double grade) {
		Student s = new Student(id, grade);
		LEGListaConPI<Student> listStudents = new LEGListaConPI<>();
		listStudents.insertar(s);
		m.insertar(subject, listStudents);
	}

	public Double consultaNota(String id, String subject) {
		LEGListaConPI<Student> listStudents = (LEGListaConPI<Student>) m.recuperar(subject);
		Double notaDevolver = null;
		listStudents.inicio();
		String dni = "";
		while (!listStudents.esFin() && dni != id) {
			dni = listStudents.recuperar().getId();
			if (dni != id) {
				listStudents.siguiente();
			} else {
				 notaDevolver = listStudents.recuperar().getGrade();
			}
		}
		if (notaDevolver != null) {
			return notaDevolver;
		} else {
		
			
			return notaDevolver;
		}
		

	}

//	private Map<String, Map<String, Integer>> m;
//	Map<String, Integer> s = null;
//
//
//	public GestorNotas(int n) {
//		m = new TablaHash<String, Map<String, Integer>>(n);
//	}
//
//	public void guardarNota(String alumno, String asignatura, int nota) {
//
//		s.insertar(alumno, nota);
//		m.insertar(asignatura, s);
//
//	}
//
//	public double consultaNota(String alumno, String asignatura) throws NotaNoEncontradaException {
//
//		Map<String, Integer> n = m.recuperar(asignatura);
//		int grade = n.recuperar(alumno);
//
//		if (enteroNull(grade) == true) {
//			throw new NotaNoEncontradaException("La nota buscada no existe");
//		} else {
//			return grade;
//		}
//	}
//
//	private boolean enteroNull(double a) {
//		int c = (int) a;
//		Integer b = new Integer(c);
//		if (b == null)
//			return true;
//		else
//			return false;
//
//	}
}
