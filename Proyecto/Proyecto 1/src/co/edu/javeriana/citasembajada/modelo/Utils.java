package co.edu.javeriana.citasembajada.modelo;
import co.edu.javeriana.citasembajada.controlador.*;
import co.edu.javeriana.citasembajada.persistencia.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils {
	
	/**
	 * <p> Calcula la edad en años a partir de una fecha ingresada y la fecha actual retorna la diferencia en años
	 * </p>
	 * @param f1
	 * @return LocalDate
	 */
	public static int edadEnAnnos(LocalDate f1 ) { //F1 ES LA FECHA DE NACIMIENTO, F2 LA FECHA MAS RECIENTE A LA ACTUALIDAD
		LocalDate f2= LocalDate.now();
		return Period.between(f1, f2).getYears(); 
	}
	
	
	/**
	 * <p> Halla una fecha sin citas para que se agregue a una solicitud
	 * </p>
	 * @param sol
	 * @return LocalDate
	 */
	public static LocalDate nuevaFecha(List<Solicitud> sol) {
		LocalDate fecha = LocalDate.now();
		for(Solicitud s: sol) {
			if(s!=null) {
				fecha=fecha.plusDays(1);
			}
		}
		
		return fecha;
	}
	
	/**
	 * <p> Crea un numero aleatorio del 0 al 999
	 * </p>
	 * @return
	 */
	public static int aleatorio() {
		Random num = new Random();
		int n = num.nextInt(1000);
		return n;
	}
	
	
}

/*if(s.getFecha().isEqual(null)) {
System.out.println("Primer If");
fecha.plusDays(1).plusHours(1);
return fecha;
}

//else {
if(s.getFecha().isBefore(fecha)) {
	System.out.println("If del Else");
	fecha=s.getFecha();
}
}*/