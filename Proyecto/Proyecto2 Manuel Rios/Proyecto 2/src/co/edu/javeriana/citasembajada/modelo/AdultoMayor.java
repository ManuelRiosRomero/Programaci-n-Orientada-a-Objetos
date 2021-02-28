package co.edu.javeriana.citasembajada.modelo;

public class AdultoMayor extends Usuario {

	public AdultoMayor() {
		// TODO Auto-generated constructor stub
	}

	public Double calcularValorVisa(double tarifa) {
		double total = 0.0;
		
		total += tarifa-(tarifa*(0.25));
		
		
		if(super.getSolicitud().getVisa() instanceof Turismo) {
			total += tarifa+(tarifa*(0.10));
		}
		
		return total;
	}
}