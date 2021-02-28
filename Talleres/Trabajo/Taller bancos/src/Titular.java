
public class Titular {
//----------------------Atributos---------------
	private String fechaNacimiento;
	private String nombre;

	public Titular() {
		// TODO Auto-generated constructor stub
		
	}

	public Titular(String fechaNacimiento, String nombre) {
		super();
		this.fechaNacimiento = fechaNacimiento;
		this.nombre = nombre;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
