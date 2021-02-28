package co.edu.javeriana.citasembajada.controlador;
import co.edu.javeriana.citasembajada.modelo.*;
import co.edu.javeriana.citasembajada.persistencia.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import co.edu.javeriana.citasembajada.modelo.SistemaCitasEmbajada;
import co.edu.javeriana.citasembajada.modelo.Usuario;
import co.edu.javeriana.citasembajada.modelo.Visa;
import co.edu.javeriana.citasembajada.persistencia.ManejoArchivos;

public class ControladorCitasEmbajada {
	private SistemaCitasEmbajada  SCE;
	
	
	
	public ControladorCitasEmbajada() {
		super();
		SCE = SCE;
	}

	SistemaCitasEmbajada sce = new SistemaCitasEmbajada();
	ManejoArchivos m = new ManejoArchivos();
	/**
	 * <p>Este metodo agrega una embajada
	 * @param id
	 * @param pais
	 * @param moneda
	 * @param impuesto
	 * @param cambio
	 */
	
	public void adicionarEmbajada(SistemaCitasEmbajada aux) {
		sce.setId(aux.getId());
		sce.setPaisEmbajada(aux.getPaisEmbajada());
		sce.setMoneda(aux.getMoneda());
		sce.setImpuesto(aux.getImpuesto());
		sce.setCambioOficial(aux.getCambioOficial());
	}
	/**
	 * <p>Este metodo Agrega un solicitante a la lista de Usuarios
	 * </p>
	 * @param numPass
	 * @param nombre
	 * @param paisOrigen
	 * @param ciudadNac
	 * @param fechaNac
	 * @param email
	 */
	public void adicionarSolicitante(List <Usuario> usuarios) {
		sce.adicionarSolicitante(usuarios);
	}
	/**
	 * <p>Este metodo agrega una visa a la lista de Visas
	 * </p>
	 * @param id
	 * @param tipo
	 * @param tarifa
	 * @param requisito
	 */
	public void adicionarVisa(List<Visa> visas) {
		sce.adicionarVisa(visas);
	}
	/**
	 * <p>Este metodo crea una solicitud con tipo de visa de turismo a partir de una lista de usuarios para la solicitud
	 * </p>
	 * @param usuarios
	 */
	public int crearSolicitudTurismo( List<Integer> usuarios) {
		return sce.crearSolicitudTurismo(usuarios);
	}
	/**
	 * <p> Este metodo crea una solicitud de tipo turismo cuando unicamente existe 1 usuario en la solicitud
	 * </p>
	 * @param num
	 */
	public int crearSolicitudTurismoIndi(int num) {
		return sce.crearSolicitudTurismoIndi(num);
	}
	/**
	 * <p>Este metodo crea solicitudes para otros tipos de visa que no sea Turismo
	 * </p>
	 * @param tipo de visa
	 * @param numPass numero de pasaporte del usuario
	 */
	public int crearSolicitudOtrasVisas(String tipo, int numPass) {
		return sce.crearSolicitudOtrasVisas(tipo, numPass);
	}
	/**
	 * <p>Este metodo calcula el valor de la visa de una solicitud a partir del numero del pasaporte ingresado
	 * </p>
	 * @param numPass
	 */
	public String calcularValorVisaPass(int numPass) {
		return sce.calcularValorVisaPass(numPass);
	}
	/**
	 * <p>Este metodo calcula el valor de la visa de una solicitud a partir del codigo de solicitud
	 * </p>
	 * @param numPass
	 */
	public String calcularValorVisaCod(int cod) {
		return sce.calcularValorVisaCod(cod);
	}
	/**
	 * <p>Este metodo recibe una fecha, y retorna un string con los datos de la solicitud de dicha fecha para imprimir en consola
	 * </p>
	 * @param fecha de la solicitud
	 * @return String con solicitudes
	 */
	public String imprimirSolicitudesFecha(String fecha){
		return sce.imprimirSolicitudesFecha(fecha);
	}
	/**
	 * <p>Este metodo recibe un tipo de visa y retorna un string con los requisitos de esa visa
	 * </p>
	 * @param tipo
	 * @return String
	 */
	public String imprimirRequisitos(String tipo) {
		return sce.imprimirRequisitos(tipo);
	}
	/**
	 * <p> Este metodo busca una visa a partir del tipo que se le ingresa y retorna un objeto que contiene la visa
	 * </p>
	 * @param tipoVisa
	 * @return Visa 
	 */
	public Visa buscarVisa(String tipoVisa) {
		return sce.buscarVisa(tipoVisa);
	}
	/**
	 * <p> Este metodo busca un usuario a partir de su numero de pasaporte y retorna un objeto de tipo usuario
	 * @param numPass
	 * @return Usuario
	 */
	public Usuario buscarUsuario(int numPass) {
		return sce.buscarUsuario(numPass);
	}
	/**
	 * <p>metodo que lee archivo de txt que contiene las embajadas y seleciona 1 embajada a partir del pais que recibe
	 * </p>
	 * @param archivo
	 * @param pais
	 */
	public SistemaCitasEmbajada leerEmbajadas(String archivo, String pais) {
		return m.LeerEmbajadas(archivo, pais);
	}
	/**
	 * <p>Metodo que lee el archivo de txt que contiene todos los solicitantes 
	 * </p>
	 * @param archivo
	 */
	public List <Usuario> leerSolicitantes(String archivo) {
		return m.LeerSolicitantes(archivo);
	}
	/**
	 * <p>Metodo que lee el archivo de txt que contiene las visas y sus distintos tipos
	 * </p>
	 * @param archivo
	 */
	public List<Visa> leerVisas(String archivo) {
		return m.LeerVisas(archivo);
	}
	/**
	 * <p>Metodo que lee el archivo de txt que contiene los acompañantes adicionales que se necesiten
	 * @param archivo
	 * @param numPass
	 */
	public List<Integer> leerAcompañantes(String archivo, int numPass) {
		return m.LeerAcompañantes(archivo, numPass);
	}
	/**
	 * <p>Metodo que recibe un string y lo convierte en archivo de texto
	 * @param texto
	 */
	public void crearArchivoSolicitudes(String texto, String nombre) {
		m.EscribirAArchivoTexto(texto, nombre);
	}
	
	
	/**
	 * <p>Metodo que retorna un String con los datos de la embajada guardada
	 * </p>
	 * @return String
	 */
	public String imprimirEmbajadas() {
		return sce.imprimirDatos();
	}
	/**
	 * <p>Metodo que retorna un String con los datos de los usuarios almacenados</p>
	 * @return String
	 */
	public String imprimirUsuarios() {
		return sce.imprimirUsuarios();
	}
	
	public String imprimirUsuario(int numPass) {
		return sce.imprimirUsuario(numPass);
	}
	/**
	 * <p>Metodo que retorna un String con las los datos de las visas almacenadas </p>
	 * @return String
	 */
	public String imprimirVisas() {
		return sce.imprimirVisas();
	}
	/**
	 * <p>Metodo que retorna un String con los tipos de visa</p>
	 * @return String
	 */
	public String imprimirTiposVisa() {
		//System.out.println("Controlador: "+sce.tiposVisa());
		return sce.tiposVisa();
	}
	/**
	 * <p>Metodo que retorna todas las solicitudes almacenadas</p>
	 * @return String con las solicitudes
	 */
	public String imprimirSolicitud(){
		return sce.imprimirSolicitud();
	}
	
}
