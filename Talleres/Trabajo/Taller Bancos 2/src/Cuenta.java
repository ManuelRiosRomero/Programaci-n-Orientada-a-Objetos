import java.time.LocalDate;

/**
 * 
 */

/**
 * @author Manuel Rios & Camilo Bustos
 *
 */
public class Cuenta {
	//--------------Atributos------------
	private int numCuenta;
	private Titular tit;
	private Titular tit2;
	private float saldo;
	private String estado;
	private LocalDate fechaCreacion;
	
	

	public Cuenta() { //activar cuenta
		//Constructores
		estado=new String("ACTIVA");
	}

	public Cuenta(int numCuenta, Titular tit, Titular tit2, float saldo, String estado, LocalDate fechaCreacion) { //guardar estado de cuenta
		//Constructores
		super();
		this.numCuenta = numCuenta;
		this.tit = tit;
		this.tit2 = tit2;
		this.saldo = saldo;
		this.estado = estado;
		this.fechaCreacion = fechaCreacion; 
	}

	public Cuenta(int numCuenta, Titular tit, Titular tit2, float saldo, LocalDate fechaCreacion) {
		
		super();
		this.numCuenta = numCuenta;
		this.tit = tit;
		this.tit2 = tit2;
		this.saldo = saldo;
		this.estado = new String("ACTIVA");
		this.fechaCreacion = fechaCreacion;
	}
	
	
	public int getNumCuenta() {
		//getters y setters
		return numCuenta;
	}

	
	public void setNumCuenta(int numCuenta) {
		//getters y setters
		this.numCuenta = numCuenta;
	}

	public Titular getTit() {
		return tit;
	}

	public void setTit(Titular tit) {
		this.tit = tit;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public float getSaldo() {
		return saldo;
	}


	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	
	public String getEstado() {
		return estado;
	}

	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Titular getTit2() {
		return tit2;
	}

	public void setTit2(Titular tit2) {
		this.tit2 = tit2;
	}

	public void consignar (float monto){
		if (estado.equalsIgnoreCase("activa")){
			saldo+=monto;
		}
	}
	
	public void retirar (float monto){
		if (estado.equalsIgnoreCase("activa")){
			if (saldo>=monto){
				saldo-=monto;
			}
		}
	}

	
	public void transferir (float monto, Cuenta destino){
		this.retirar(monto);
		destino.consignar(monto);
	}
	
	
	@Override
	public String toString() {
		return "Cuenta [numCuenta=" + numCuenta + ", nomTit=" + tit
				+ ", saldo=" + saldo + ", estado=" + estado + "]";
	}
	
	
}
