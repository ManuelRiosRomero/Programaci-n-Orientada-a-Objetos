package co.edu.javeriana.citasembajada.modelo;

public class Conyuge extends Visa {

	public Conyuge() {
		// TODO Auto-generated constructor stub
	}
	public String imprimirVisa() {
		String visa = "\n"+"\n"+"Id: "+super.getId()+"\n"+"Tipo de Visa: Conyuge"+"\n"+"Tarifa: "+super.getTarifa() +"\n"+ super.getRequisitos();
		return visa;
	}
}
