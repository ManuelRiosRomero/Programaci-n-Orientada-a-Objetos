package co.edu.javeriana.citasembajada.modelo;
import co.edu.javeriana.citasembajada.controlador.*;
import co.edu.javeriana.citasembajada.persistencia.*;
import java.time.LocalDate;

public class Usuario {
	private String nombre;
	private int numPasaporte;
	private String email;
	private LocalDate fechaNacimiento;
	private String paisNacimiento;
	private String ciudadNacimiento;
	private Solicitud solicitud;
	private double valorVisa;
	
	public Usuario() {
		
	}
	
	



	public Usuario(String nombre, int numPasaporte, String email, LocalDate fechaNacimiento, String paisNacimiento,
			String ciudadNacimiento, Solicitud solicitud, double valorVisa) {
		super();
		this.nombre = nombre;
		this.numPasaporte = numPasaporte;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.paisNacimiento = paisNacimiento;
		this.ciudadNacimiento = ciudadNacimiento;
		this.solicitud = solicitud;
		this.valorVisa = valorVisa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumPasaporte() {
		return numPasaporte;
	}

	public void setNumPasaporte(int numPasaporte) {
		this.numPasaporte = numPasaporte;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getPaisNacimiento() {
		return paisNacimiento;
	}

	public void setPaisNacimiento(String paisNacimiento) {
		this.paisNacimiento = paisNacimiento;
	}

	public String getCiudadNacimiento() {
		return ciudadNacimiento;
	}

	public void setCiudadNacimiento(String ciudadNacimiento) {
		this.ciudadNacimiento = ciudadNacimiento;
	}
	
	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}
	
	public double getValorVisa() {
		return valorVisa;
	}

	public void setValorVisa(double valorVisa) {
		this.valorVisa = valorVisa;
	}

	public void asociarSolicitud(Solicitud s) {
		solicitud=s;
	}

	/**
	 * <p> Agrega todos los valores de un usuario a un String para luego imprimir en Interfaz Consola
	 * </p>
	 * @return String
	 */
	public String imprimirDatos() {
		String usuario = "\n"+"\n"+"Numero Pasaporte: "+ Integer.toString(numPasaporte) +"\n"+"Nombre: "+nombre+"\n"+"Pais de Origen: "+paisNacimiento+"\n"+"Ciudad de Nacimiento: "+ciudadNacimiento
				+"\n"+"Fecha de Nacimiento: "+fechaNacimiento.toString() +"\n"+"Email: "+email;
		return usuario;
	}
	
	

}
