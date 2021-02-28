/**
 * 
 */

/**
 * @author angela.carrillo
 *
 */
public class Cuenta {
	//--------------Atributos------------
	private int numCuenta;
	private String nomTit;
	private float saldo;
	private String estado;
	
	public Cuenta() { //activar cuenta
		//Constructores
		estado=new String("ACTIVA");
	}

	public Cuenta(int numCuenta, String nomTit, float saldo, String estado) { //guardar estado de cuenta
		//Constructores
		super();
		this.numCuenta = numCuenta;
		this.nomTit = nomTit;
		this.saldo = saldo;
		this.estado = estado;
	}

	public Cuenta(int numCuenta, String nomTit, float saldo) {
		
		super();
		this.numCuenta = numCuenta;
		this.nomTit = nomTit;
		this.saldo = saldo;
		this.estado = new String("ACTIVA");
	}
	
	
	public int getNumCuenta() {
		//getters y setters
		return numCuenta;
	}

	
	public void setNumCuenta(int numCuenta) {
		//getters y setters
		this.numCuenta = numCuenta;
	}

	
	public String getNomTit() {
		
		return nomTit;
	}

	
	public void setNomTit(String nomTit) {
		this.nomTit = nomTit;
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
		return "Cuenta [numCuenta=" + numCuenta + ", nomTit=" + nomTit
				+ ", saldo=" + saldo + ", estado=" + estado + "]";
	}
	
	
	
	
	
	
	
	
	
}
