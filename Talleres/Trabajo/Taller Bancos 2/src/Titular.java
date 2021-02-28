import java.time.LocalDate;

public class Titular {
//----------------------Atributos---------------
	private LocalDate fechaNacimiento;
	private String nombre;
	private int edad;

	public Titular() {
		// TODO Auto-generated constructor stub
		
	}

	public Titular(LocalDate fechaNacimiento, String nombre, int edad) {
		super();
		this.fechaNacimiento = fechaNacimiento;
		this.nombre = nombre;
		this.edad=edad;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public void crearTitular (String nombre, int edad, String fechaNacimiento){
		
	}
	

	

}
