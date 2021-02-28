import java.time.LocalDate;
import java.util.ArrayList;

public class Banco {
	private Cuenta[] cuentas ;
	private Cuenta cuenta;
	private int totalCuentas ;
	
	
	public Banco(Cuenta[] cuentas,Cuenta cuenta,  int totalCuentas) {
		super();
		this.cuentas = cuentas;
		this.cuenta=cuenta;
		this.totalCuentas = totalCuentas;
	}
	
	
	public Banco() { //inicializado
		super();
		this.cuentas = new Cuenta[5] ;
		this.totalCuentas = 0;
	}

	public Cuenta[] getCuentas() {
		return cuentas;
	}
	public void setCuentas(Cuenta[] cuentas) {
		this.cuentas = cuentas;
	}
	public int getTotalCuentas() {
		return totalCuentas;
	}
	public void setTotalCuentas(int totalCuentas) {
		this.totalCuentas = totalCuentas;
	}
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	public void crearCuenta(int numeroCuenta, Titular tit, Titular tit2, float saldo){
		
		if(totalCuentas<=5)
		{
			cuenta = new Cuenta(numeroCuenta, tit, tit2, saldo, "Activo", LocalDate.now());
			cuentas[totalCuentas]=cuenta;	
			totalCuentas++;
		}
		
	}
	public Cuenta retornarCuenta(int numeroCuenta) {
		return cuenta;
		
	}
	
	public void consigarCuenta(int numeroCuenta, float monto) {
		for(int i=0;i<totalCuentas;i++) {
			if(numeroCuenta==cuentas[i].getNumCuenta()) {
				cuentas[i].consignar(monto);
			}
		}
	}
	
	public void retirarCuenta(int numeroCuenta, float monto) {
		for(int i=0;i<totalCuentas;i++) {
			if(numeroCuenta==cuentas[i].getNumCuenta()) {
				cuentas[i].retirar(monto);
			}
		}
	}

	public void transferirCuenta(int numCuenta, int numCuenta2, float monto) {
		
		for(int i=0;i<totalCuentas;i++) {                //cuenta a retirar
			if(numCuenta==cuentas[i].getNumCuenta()) {
				cuentas[i].retirar(monto);
			}
		}
		for(int i=0;i<totalCuentas;i++) {                 //cuenta a consignar
			if(numCuenta2==cuentas[i].getNumCuenta()) {
				cuentas[i].consignar(monto);
			}
		}
	}
	public void cambiarEstado(int numeroCuenta) {
		for(int i=0;i<totalCuentas;i++) {                
			if(numeroCuenta==cuentas[i].getNumCuenta()) {
				if(cuentas[i].getEstado()=="ACTIVA") {
					cuentas[i].setEstado("NO ACTIVA");
				}
				else 
				{
					cuentas[i].setEstado("ACTIVA");
				}
			}
		}
	}
	public Cuenta retornaCuentaArreglo(int numeroCuenta) { //Retorna una unica cuenta que encuentre del arreglo apartir del numeroCuenta
		for(int i=0; i<totalCuentas; i++) {
			if(cuentas[i].getNumCuenta()==numeroCuenta) {
				cuenta=cuentas[i];
			}
			else {
				if(i==(totalCuentas-1)) {
					cuenta= null;
				}
			}
		}
		return cuenta;	
	}
	
	public Cuenta retornarCuentaTitular(String titNombre) {
		for(int i=0; i<totalCuentas; i++) {
			if(cuentas[i].getTit().getNombre() == titNombre) {
				cuenta=cuentas[i];
			}
			if(cuentas[i].getTit2().getNombre() == titNombre) {
				cuenta=cuentas[i];
			}
			else {
				if(i==(totalCuentas-1)) {
					cuenta= null;
				}
			}
		}
		return cuenta;
	}
	
	public Cuenta[] retornarCuentaEdad(int edad_aux) {
		Cuenta[] cuentaaux= new Cuenta[5];
		for(int i=0; i<totalCuentas;i++) {
			if(cuentas[i].getTit().getEdad() < edad_aux) {
				cuentaaux[i]=cuentas[i];
			}
			if(cuentas[i].getTit2().getEdad() < edad_aux) {
				cuentaaux[i]=cuentas[i];
			}
			else {
				if(i==(totalCuentas-1)) {
					cuenta = null;
				}
			}
		}
		return cuentaaux;
	}
	
	public Cuenta[] retornarCuentaFechaCreacion(String fecha) { 
		LocalDate fecha_aux;
		Cuenta[] cuentaaux= new Cuenta[5];
		fecha_aux=LocalDate.parse(fecha);
		
		for(int i=0; i<totalCuentas; i++) {
			if(cuentas[i].getFechaCreacion().isBefore(fecha_aux)) {
				cuentaaux[i]=cuentas[i];
			}
			
		}
		return cuentaaux;
	}
	
	public Cuenta[] retornarCuentaDosTitulares() {
		Cuenta[] cuentaaux= new Cuenta[5];
		for(int i=0; i<totalCuentas; i++) {
			if(cuentas[i].getTit2().getNombre() != null) {
				cuentaaux[i]=cuentas[i];
			}
		}
		return cuentaaux;
	}
	
	
	
	
}
