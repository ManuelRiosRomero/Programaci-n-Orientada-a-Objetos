package co.edu.javeriana.citasembajada.modelo;
import co.edu.javeriana.citasembajada.controlador.*;
import co.edu.javeriana.citasembajada.persistencia.*;
import java.util.ArrayList;
import java.util.List;

public class Visa {
	private String tipo;
	private int id;
	private double tarifa;
	private String requisitos;
	
	public Visa() {
		
	}
	

	public Visa(String tipo, int id, double tarifa, String requisitos) {
		super();
		this.tipo = tipo;
		this.id = id;
		this.tarifa = tarifa;
		this.requisitos = requisitos;
	}


	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTarifa() {
		return tarifa;
	}

	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}
	
	public String getRequisitos() {
		return requisitos;
	}


	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

/**
 * <p>Agrega todos los atributos de una visa a un unico String para luego imprimir en interfaz consola 
 * </p>
 * @return String
 */
	public String imprimirVisa() {
		
		String visa = "\n"+"\n"+"Id: "+id+"\n"+"Tipo de Visa: "+tipo+"\n"+"Tarifa: "+tarifa +"\n"+"Requisitos: "+ requisitos;
		return visa;

	}
	

}
