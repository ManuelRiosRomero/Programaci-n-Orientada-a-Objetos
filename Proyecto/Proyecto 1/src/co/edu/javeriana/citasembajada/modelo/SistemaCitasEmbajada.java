package co.edu.javeriana.citasembajada.modelo;
import co.edu.javeriana.citasembajada.controlador.*;
import co.edu.javeriana.citasembajada.persistencia.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SistemaCitasEmbajada {
	private int id;
	private String paisEmbajada;// País donde se encuentra la embajada
	private String moneda;
	private double cambioOficial;
	private float impuesto;
	private List<Visa> visasLista;
	private List<Solicitud> solicitudesLista;
	private List<Usuario> usuariosLista;
	
	
	
	public SistemaCitasEmbajada() {
		super();
		
		visasLista = new ArrayList();
		solicitudesLista = new ArrayList();
		usuariosLista = new ArrayList();
		
	}


	public SistemaCitasEmbajada(int id, String paisEmbajada, String moneda, double cambioOficial, float impuesto,
			List<Visa> visasLista, List<Solicitud> solicitudesLista, List<Usuario> usuariosLista) {
		super();
		this.id = id;
		this.paisEmbajada = paisEmbajada;
		this.moneda = moneda;
		this.cambioOficial = cambioOficial;
		this.impuesto = impuesto;
		this.visasLista = visasLista;
		this.solicitudesLista = solicitudesLista;
		this.usuariosLista = usuariosLista;
	}

	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getPaisEmbajada() {
		return paisEmbajada;
	}

	public void setPaisEmbajada(String paisEmbajada) {
		this.paisEmbajada = paisEmbajada;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public double getCambioOficial() {
		return cambioOficial;
	}

	public void setCambioOficial(double cambioOficial) {
		this.cambioOficial = cambioOficial;
	}

	public float getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(float impuesto) {
		this.impuesto = impuesto;
	}

	public List<Visa> getVisasLista() {
		return visasLista;
	}

	public void setVisasLista(List<Visa> visasLista) {
		this.visasLista = visasLista;
	}

	public List<Solicitud> getSolicitudesLista() {
		return solicitudesLista;
	}

	public void setSolicitudesLista(List<Solicitud> solicitudesLista) {
		this.solicitudesLista = solicitudesLista;
	}

	public List<Usuario> getUsuariosLista() {
		return usuariosLista;
	}

	public void setUsuariosLista(List<Usuario> usuariosLista) {
		this.usuariosLista = usuariosLista;
	}
	
	/**
	 * <p> metodo que permite asignar a una solicitud, una nueva fecha 
	 * </p>
	 * @param soli
	 */
	public void asignarFechaHora (Solicitud soli) {
		
		
	}
	
	
	/**
	 * <p> metood que permite adicionar un solicitante a la lista de Usuarios
	 * </p>
	 * @param numPass
	 * @param nombre
	 * @param paisOrigen
	 * @param ciudadNac
	 * @param fechaNac
	 * @param email
	 */
	public void adicionarSolicitante(List <Usuario> u) {
		usuariosLista.addAll(u);
		
	}
	
	/**
	 * Permite imprimir los datos de una embajada al retornarlos como String
	 * @return String
	 */
	public String imprimirDatos() {
		String embajada = "Id: "+id +" Pais: "+paisEmbajada+ " Moneda: "+moneda+" Impuesto: "+impuesto+" Tasa de Cambio: "+cambioOficial;
		return embajada;
	}
	/**
	 * <p> Permite imprimir los datos de los usuarios retornandolos como String
	 * </p>
	 * @return String
	 */
	public String imprimirUsuarios() {
		String usuarios="Usuarios: ";
		for(Usuario Uaux: usuariosLista) {
			if(Uaux!=null) {
				usuarios+=Uaux.imprimirDatos();
			}
		}
		
		return usuarios;
	}
	
	public String imprimirUsuario(int numPass) {
		String usuario= "Usuario Solicitado: ";
		for(Usuario u: usuariosLista) {
			if(u!=null) {
				if(u.getNumPasaporte()==numPass) {
					usuario+=u.imprimirDatos();
				}
			}
		}
		return usuario;
	}
	
	/**
	 * <p> Metodo que permite adicionar una Visa a la lista de visas
	 * </p>
	 * @param id
	 * @param tipo
	 * @param tarifa
	 * @param requisito
	 */
	public void adicionarVisa(List<Visa> visas) {
		visasLista.addAll(visas);
	}
	
	/**
	 * <p> Metodo que permite imprimir los datos de visas al retornarlas como String
	 * </p>
	 * @return
	 */
	public String imprimirVisas() {
		String visas= "Visas: ";
		for(Visa Vaux: visasLista) {
			if(Vaux!=null) {
				visas+=Vaux.imprimirVisa();
			}
		}
		return visas;
	}
	
	/**
	 * <p> Permite buscar una visa a partir del tipo de visa, y retornarla como un objeto de tipo Visa
	 * </p>
	 * @param tipoVisa tipo de visa
	 * @return Visa
	 */
	public Visa buscarVisa(String tipoVisa) {
		for(Visa v: visasLista) {
			if(v!=null) {
				if(v.getTipo().equalsIgnoreCase(tipoVisa)) {
					return v;
				}
			}
		}
		return null;		
	}
	
	/**
	 * <p> Metodo que permite retornar como String, los tipos de visa disponibles
	 * </p>
	 * @return String
	 */
	public String tiposVisa() {
		String tipos = "Tipos: ";
		for(Visa v: visasLista) {
			if(v!=null) {
				tipos += v.getTipo()+"-";
				
				}
			}
		return tipos;
		}
	
	/**
	 * <p> Permite buscar un usuario a partir del numero del pasaporte y retornar un objeto de tipo usuarios
	 * </p>
	 * @param numPass
	 * @return Usuario
	 */
	public Usuario buscarUsuario(int numPass) {
		for(Usuario u: usuariosLista) {
			if(u!=null) {
				if(numPass==u.getNumPasaporte()) {
					return u;
				}
			}
		}
		return null;
	}
	
	/**
	 * <p> Permite crear una solicitud de Visa de turismo a partir del numero del unico usuario que la solicito
	 * </p>
	 * @param num
	 */
	public int crearSolicitudTurismoIndi(int num){
		Usuario u = new Usuario();
		u = buscarUsuario(num);
		
		Solicitud s = new Solicitud();
		s.setVisa(buscarVisa("turismo"));
		s.setUsuarios(null);
		s.setUsuario(u);
		s.setCodigo(Utils.aleatorio());
		s.setConsecutivo(s.getConsecutivo());
		s.setFecha(asignarFecha(s));
		solicitudesLista.add(s);
		return s.getCodigo();
	}
	
	/**
	 * <p> permite crear una solicitud a visa de turismo a partir de una lista de usuarios
	 * </p>
	 * @param usuarios
	 */
	public int crearSolicitudTurismo(List<Integer> usuarios ) {
		List<Usuario> usrs = new ArrayList();
		for(int i: usuarios) {
			for(Usuario u: usuariosLista) {
				if(u!=null) {
					if(i==u.getNumPasaporte()) {
						usrs.add(u);
					}
				}
			}
		}
		Solicitud s = new Solicitud();
		s.setVisa(buscarVisa("turismo"));
		s.setUsuarios(usrs);
		s.setUsuario(null);
		s.setCodigo(sumaNumPass(usrs));
		s.setConsecutivo(s.getConsecutivo());
		s.setFecha(asignarFecha(s));
		solicitudesLista.add(s);
		return s.getCodigo();
	}
	
	/**
	 * <p> Permite sumar los numeros de pasaporte de los usuarios para asignar la suma al codigo de solicitud
	 * retorna el numero entero
	 * </p>
	 * @param lista de usuarios
	 * @return un entero creado a partir de la lista de usuarios
	 */
	public  int sumaNumPass(List<Usuario> usuarios) {
		int suma=0;
		for(Usuario u: usuarios) {
			if(u!=null) {
				suma+=u.getNumPasaporte();
			}
		}
		return suma;
	}
	
	/**
	 * <p> Permite retornar un String de todas las solicitudes creadas
	 * </p>
	 * @return String
	 */
	public String imprimirSolicitud() {
		String st = "Solicitudes: "+"\n";
		for(Solicitud s: solicitudesLista) {
			if(s!=null) {
				st+="\n"+"\n"+"Tipo de Visa: "+s.getVisa().getTipo()
						+"\n"+"Valor Consecutivo: "+s.getConsecutivo()
						+"\n"+"Estado de solicitud: "+s.getEstado()
						+"\n"+"Codigo de Solicitud: "+Integer.toString(s.getCodigo())
						+"\n"+"Fecha de Solicitud: "+s.getFecha().toString()
						+"\n"+s.imprimirUsuarios()
						+"\n-------------------------------------------------";
			}
		}
		
		return st;
	}
	
	/**
	 * <p> Permite crear una solicitud de visa de cualquier tipo menos turismo a un unico usuario
	 * </p>
	 * @param tipo
	 * @param numPass
	 */
	public int crearSolicitudOtrasVisas(String tipo, int numPass) {
		Usuario u = new Usuario();
		u=buscarUsuario(numPass);
		List<Usuario> usrs = new ArrayList();
		usrs.add(u);
		Solicitud s = new Solicitud();
		s.setVisa(buscarVisa(tipo));
		s.setUsuarios(usrs);
		s.setUsuario(null);
		s.setCodigo(Utils.aleatorio());
		s.setConsecutivo(s.getConsecutivo());
		s.setFecha(asignarFecha(s));
		solicitudesLista.add(s);
		return s.getCodigo();
	}
	
	/**
	 * <p> Permite buscar una solicitud a partir del usuario que se encuentre dentro de ella, retorna un objeto de tipo solicitud
	 * </p>
	 * @param usuario
	 * @return Solicitud
	 */
	public Solicitud buscarSolicitud(Usuario usuario) {
		for(Solicitud s: solicitudesLista) {
			if(s!=null) {
				for(Usuario u: s.getUsuarios()) {
					if(u!=null) {
						if(u.equals(usuario)) {
							return s;
						}
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * <p> Calcula el valor de una visa para un usuario a partir del numero de pasaporte del mismo
	 * </p>
	 * @param numPass numero de pasaporte asociado a la solicitud
	 */
	public String calcularValorVisaPass(int numPass) {
		int total=0;
		String valor="\n";
		Usuario u = new Usuario();
		u=buscarUsuario(numPass);
		Solicitud s = new Solicitud();
		s= buscarSolicitud(u);
		if(s.getUsuarios()!=null) {
			for(Usuario ux: s.getUsuarios()) {
				int edad= Utils.edadEnAnnos(ux.getFechaNacimiento());
				double tarifa= s.getVisa().getTarifa();
				if(60<edad&&edad<18) {
					tarifa=(tarifa/20)*100;
				}
				ux.setValorVisa(tarifa);
				total+=((impuesto/100)*ux.getValorVisa()+ux.getValorVisa());
			}
			for(Usuario ux: s.getUsuarios()) {
			valor+="\n"+"\n"+"Numero Pasaporte: "+ ux.getNumPasaporte() 
				+"\n"+"Nombre: "+ux.getNombre()
				+"\n"+"Fecha de Nacimiento: "+ux.getFechaNacimiento().toString()
				+"\n"+"Valor Visa: "+ux.getValorVisa()
				+"\n"+"Impuesto: "+((impuesto/100)*ux.getValorVisa())
				+"\n"+"Valor Total: "+((impuesto/100)*ux.getValorVisa()+ux.getValorVisa())
				+"\n";			
			}
			valor+="\n"+"-------------El valor Total de la visa es-------------"
					+"\n"+"Valor total: "+total+ " --- "
					+"Tasa de Cambio: "+cambioOficial+ " --- "
					+"Conversion("+moneda+"): "+ total/cambioOficial;
		}	
		return valor;
	}
	
	/**
	 * <p> Calcula el valor de una visa para un usuario a partir del codigo de solicitud
	 * </p>
	 * @param numPass numero de pasaporte asociado a la solicitud
	 */
	public String calcularValorVisaCod(int cod) {
		int total=0;
		String valor="\n";
		
		Solicitud s = new Solicitud();
		for(Solicitud ss: solicitudesLista) {
			if(ss!=null) {
				if(ss.getCodigo()==cod) {
					s=ss;
				}
			}
		}
		if(s.getUsuarios()!=null) {
			for(Usuario ux: s.getUsuarios()) {
				int edad= Utils.edadEnAnnos(ux.getFechaNacimiento());
				double tarifa= s.getVisa().getTarifa();
				if(60<edad&&edad<18) {
					tarifa=(tarifa/20)*100;
				}
				ux.setValorVisa(tarifa);
				total+=((impuesto/100)*ux.getValorVisa()+ux.getValorVisa());
			}
			for(Usuario ux: s.getUsuarios()) {
			valor+="\n"+"\n"+"Numero Pasaporte: "+ ux.getNumPasaporte() 
				+"\n"+"Nombre: "+ux.getNombre()
				+"\n"+"Fecha de Nacimiento: "+ux.getFechaNacimiento().toString()
				+"\n"+"Valor Visa: "+ux.getValorVisa()
				+"\n"+"Impuesto: "+((impuesto/100)*ux.getValorVisa())
				+"\n"+"Valor Total: "+((impuesto/100)*ux.getValorVisa()+ux.getValorVisa())
				+"\n";			
			}
			valor+="\n"+"-------------El valor Total de la visa es-------------"
					+"\n"+"Valor total: "+total+ " --- "
					+"Tasa de Cambio: "+cambioOficial+ " --- "
					+"Conversion("+moneda+"): "+ total/cambioOficial;
		}	
		return valor;
	}
	
	/**
	 * <p>Busca una unica solicitud de una fecha en especifico
	 * </p>
	 * @param fecha
	 * @return Solicitud
	 */
	public List<Solicitud> buscarSolicitudFecha(String fecha) {
		LocalDate fechaD;
		fechaD=LocalDate.parse(fecha);
		List<Solicitud> solicitudes = new ArrayList();
		for(Solicitud s: solicitudesLista) {
			if(s!=null) {
				if(s.getFecha().equals(fechaD)) {
					solicitudes.add(s);
				}
			}
		}
		return solicitudes;
	}
	
	/**
	 * <p> Retorna un String con las solicitudes de una determinada fecha como parametro
	 * </p>
	 * @param fecha
	 * @return String
	 */
	public String imprimirSolicitudesFecha(String fecha){
		List<Solicitud> s = new ArrayList();
		s.addAll(buscarSolicitudFecha(fecha));
		String st = "---------REPORTE DE SOLICITUDES---------"
				+"\n Reporte Fecha "+fecha+" : ";
		
		for(Solicitud sx: s) {
			for(Usuario ux: sx.getUsuarios()) {
				if(ux!=null) {
					st+="\n"+"\n"+"NumPass: "+Integer.toString(ux.getNumPasaporte())+
							"\n"+"Nombre: "+ux.getNombre()+	
							"\n"+"Tipo de Visa: "+sx.getVisa().getTipo()+
							"\n"+"Numero de Solicitud: "+sx.getCodigo();
				}
			}
		}
		return st;
	}
	
	/**
	 * <p> Retorna un String con los requisitos de un tipo de visa 
	 * </p>
	 * @param tipo
	 * @return String
	 */
	public String imprimirRequisitos(String tipo) {
		Visa v = new Visa();
		String s=null;
		v=buscarVisa(tipo);
		
		s= v.getRequisitos();
		
		return s;
	}
	
	/**
	 * <p> Permite asignarle una fecha de cita a una solicitud
	 * </p>
	 * @param sol
	 * @return
	 */
	public LocalDate asignarFecha(Solicitud sol) {
		return Utils.nuevaFecha(solicitudesLista);
	}
	
	
}
