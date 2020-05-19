package ejemplos.tema3;

public class User {
	private String name;
	private String password;

	public User(String name) {this(name, null);}
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public String getPassword() {
		return this.password;
	}

	public String toString() {
		return "User: " + name + "password: " + password;
	}

	public boolean equals(Object o) {
		return (this.name.equals( ((User) o).getName()));
	}

	public int hashCode() {
		return (name + password).hashCode();
	}
}