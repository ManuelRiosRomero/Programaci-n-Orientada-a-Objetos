package co.edu.javeriana.citasembajada.modelo;
import co.edu.javeriana.citasembajada.presentacion.*;
import co.edu.javeriana.citasembajada.persistencia.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Solicitud {

	private int codigo;
	private int consecutivo=0;
	private String estado;
	private LocalDate fecha;
	private List<Usuario> usuarios;
	private Visa visa;
	
	public Solicitud() {
		super();
		consecutivo+=1;
		estado= "PENDIENTE";
		usuarios = new ArrayList();
	}
	
	
	
	public Solicitud(int codigo, int consecutivo, String estado, LocalDate fecha, List<Usuario> usuarios, Visa visa) {
		super();
		this.codigo = codigo;
		this.consecutivo = consecutivo;
		this.estado = estado;
		this.fecha = fecha;
		this.usuarios = usuarios;
		this.visa = visa;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getConsecutivo() {
		return consecutivo;
	}

	public void setConsecutivo(int consecutivo) {
		this.consecutivo = consecutivo;
	}

	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public Visa getVisa() {
		return visa;
	}
	public void setVisa(Visa visa) {
		this.visa = visa;
	}
	
	public void agregarUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}
	
	/**
	 * <p> imprime los usuarios de una solicitud 
	 * </p>
	 * @return String con todos los usuarios y sus datos
	 */
	public String imprimirUsuarios() {
		String s= "\n"+"Usuarios: ";
		
		for(Usuario u: usuarios) {
			if(u!=null) {
				s+="\n"+"\n"+"Numero Pasaporte: "+ Integer.toString(u.getNumPasaporte()) +"\n"+"Nombre: "+u.getNombre()+
						"\n"+"Pais de Origen: "+u.getPaisNacimiento()+"\n"+"Ciudad de Nacimiento: "+u.getCiudadNacimiento()
						+"\n"+"Fecha de Nacimiento: "+u.getFechaNacimiento().toString()+"\n"+"Email: "+u.getEmail();
			}
		}
		
		
		return s;
	}
	
	/**
	 * <p> Permite asociar una fecha de cita al atribuda de fecha de la solicitud
	 * </p>
	 * @param sol
	 * @return LocalDate
	 */
	public LocalDate fechaDiscponible(Solicitud sol) {
		LocalDate fecha= LocalDate.now();
		
		return fecha;
	}


/**
 * retorna lista con todos los beneficiarios debido a su edad
 * @return
 */
	public String imprimirBeneficiarios() {
		String lista="";
		Double total=0.0;
		for(Usuario u: usuarios) {
			if(u!=null) {
				if(u instanceof Niño0a2) {
					lista+=u.imprimirDatos();
					total+=u.calcularValorVisa(visa.getTarifa());
				}
				if(u instanceof Niño2a12) {
					lista+=u.imprimirDatos();
					total+=u.calcularValorVisa(visa.getTarifa());
				}
				if(u instanceof AdultoMayor) {
					lista+=u.imprimirDatos();
					total+=u.calcularValorVisa(visa.getTarifa());
				}
			}
		}
		lista+="\n"+"Total perdido por beneficiarios: "+total;
		return lista;
	}
	
	
}
