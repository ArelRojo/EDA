package ejemplos.tema3;

public class Student {
	private String id;
	private Double grade;

	public Student(String id) {
		this.id = id;
	}

	public Student(String id, Double grade) {
		this.id = id;
		this.grade = grade;
	}

	public String getId() {
		return id;
	}

	public Double getGrade() {
		return grade;
	}

	public String toString() {
		return "Alumno: " + id + "con nota: " + grade;
	}
	
	public boolean equals(Object o) {
		return (this.id.equals( ((Student) o).getId()));
	}
	
	public int hashCode() {
		return id.hashCode();
	}
}
