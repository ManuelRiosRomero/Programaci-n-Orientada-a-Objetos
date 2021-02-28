import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Manuel Rios & Camilo Bustos
 *
 */
public class InterfazConsola {
	
	private static Cuenta c;

	public static int menu(){ 
	   int opcion;
	   
	   
	   System.out.println("Bienvenido al Banco JaviBank");
	   System.out.println("Opcion 1: Crear cuenta");
	   System.out.println("Opcion 2: Consignar");
	   System.out.println("Opcion 3: Retirar");
	   System.out.println("Opcion 4: Transferir de una cuenta a otra");
	   System.out.println("Opcion 5: Cambiar estado");
	   System.out.println("Opcion 6: Consultar cuenta");
	   System.out.println("Opcion 7: Consultar cuenta (por titular)");
	   System.out.println("Opcion 8: Informacion numero entero mayor que edad");
	   System.out.println("Opcion 9: Informacion fecha de creacion");
	   System.out.println("Opcion 10: Consultar cuentas con con varios titulares");
	   System.out.println("Opcion 11: Salir del Programa");
	   System.out.println("Escriba la opcion: ");
	   
	   Scanner scan=new Scanner(System.in);
	   opcion=scan.nextInt();
	   
	   return opcion;
	}
	
	public static void main(String[] args) {
		
		 Banco b = new Banco(); //objeto banco
		 Titular tit = new Titular();// objeto titular 1
		 Titular tit2 = new Titular();// objeto titular 2
		 Cuenta cuenta = new Cuenta(); //objeto Cuenta Auxiliar

        String nomTit, estado, nacimiento;// nombre del titular, estado de cuenta, nacimiento del titular
        LocalDate fechaNacimiento;//fecha nacimiento de tipo localdate
        LocalDate fecha; //fecha actual 
        int nc, edad; //numero de cuenta y edad
        float s, monto; //saldo y monto ()cuanto se va mover en una cuenta
        Scanner scan=new Scanner(System.in); //scanner
        int op=0; //opcion
       
        
        int a=0; //contador para el arreglo
        int aux=0, aux2=0, numTit=0; //numeros auxiliares
        String S_aux; //string auxiliar
        Cuenta[] cuentaaux = new Cuenta[5];
        
        while (op!=11){
        
        switch (op){ // 
        	case 1: 	//--------------------------------Crear cuentas------------------------------
        				System.out.println("Escriba el numero de cuenta");
        				nc=scan.nextInt();
        				System.out.println("Ingrese el saldo de la cuenta: ");
        				s=scan.nextFloat();
        				System.out.println("Esta cuenta pertenece a 1 o 2 titulares?: ");
        				numTit=scan.nextInt();
        				scan.nextLine();
        				if(numTit==1) {
        					System.out.println("Escriba el nombre del titular");
            				nomTit=scan.nextLine();
            				tit.setNombre(nomTit);
            				
            				System.out.println("Escriba el edad del titular");
            				edad=scan.nextInt();
            				tit.setEdad(edad);
            				scan.nextLine();
            				System.out.println("Escriba el fecha de nacimiento del titular aa-mm-dd");
            				nacimiento=scan.nextLine();
            				fechaNacimiento =LocalDate.parse(nacimiento);
            				tit.setFechaNacimiento(fechaNacimiento);
            				
            				
            				tit2.setFechaNacimiento(null);
            				tit2.setNombre(null);
            				
        				}
        				else {
        					System.out.println("Escriba el nombre del titular 1: ");
            				nomTit=scan.nextLine();
            				tit.setNombre(nomTit);
            				
            				System.out.println("Escriba el edad del titular 1: ");
            				edad=scan.nextInt();
            				tit.setEdad(edad);
            				scan.nextLine();
            				
            				System.out.println("Escriba el fecha de nacimiento del titular 1 aa-mm-dd: ");
            				nacimiento=scan.nextLine();
            				fechaNacimiento =LocalDate.parse(nacimiento);
            				tit.setFechaNacimiento(fechaNacimiento);
        					
        					System.out.println("Escriba el nombre del titular 2: ");
        					nomTit=scan.nextLine();
            				tit2.setNombre(nomTit);
            				
            				System.out.println("Escriba el edad del titular 2: ");
            				edad=scan.nextInt();
            				tit2.setEdad(edad);
            				scan.nextLine();
            				
            				System.out.println("Escriba el fecha de nacimiento del titular 2 aa-mm-dd: ");
            				fechaNacimiento =LocalDate.parse(nacimiento);
            				tit2.setFechaNacimiento(fechaNacimiento);
        				}
        				
        				b.crearCuenta(nc, tit, tit2, s);
        				
        				
        				
        				
        				
        				break;
        				
        	case 2: 	// ----------------------------------CONSIGNAR A UNA CUENTA---------------------------------------------
        		
        			System.out.println("Ingrese el numero de cuenta que desea Consignar: ");
        			aux=scan.nextInt();
        			System.out.println("Ingrese el monto que se desea consignar: ");
        			monto=scan.nextFloat();
        			b.consigarCuenta(aux, monto);
        			        		
					break;
						
        	case 3: 	//----------------------------RETIRAR DE UNA CUENTA--------------------------
        		System.out.println("Ingrese el numero de cuenta que desea retirar: ");
    			aux=scan.nextInt();
    			System.out.println("Ingrese el monto que se desea retirar: ");
    			monto=scan.nextFloat();
				b.retirarCuenta(aux, monto);
				
				break;
						
        	case 4: //---------------------TRANSFERIR ENTRE CUENTAS --------------------
        		System.out.println("Ingrese el numero de cuenta que desea retirar: ");
    			aux=scan.nextInt();
    			System.out.println("Ingrese el numero de cuenta que desea consignar: ");
    			aux2=scan.nextInt();
    			System.out.println("Ingrese el monto que se desea retirar: ");
    			monto=scan.nextFloat();
				b.transferirCuenta(aux, aux2, monto);
				
        		break;
        		
        	case 5: // -----------------------CAMBIAR ESTADO----------------------
        		System.out.println("Ingrese el numero de cuenta que desea cambiar el estado: ");
        		aux=scan.nextInt();
        		b.cambiarEstado(aux);
        		
        		break;
        			
        	case 6:		//----------------------CONSULTA CUENTA CON NUMERO DE CUENTA----------------
        		System.out.println("Ingrese el numero de cuenta que desea obtener informacion: ");
        		aux=scan.nextInt();
        		cuenta = b.retornaCuentaArreglo(aux);
        		if(cuenta!=null) {
        			System.out.println("Nombre titular 1 de Cuenta: ");
            		System.out.println(cuenta.getTit().getNombre());
            		System.out.println("Fecha de Nacimiento titular 1: ");
            		System.out.println(cuenta.getTit().getFechaNacimiento());
            		System.out.println("Edad titular 1: ");
            		System.out.println(cuenta.getTit().getEdad());
            		if(cuenta.getTit2().getNombre()!=null) {
            			System.out.println("Nombre titular 2 de Cuenta: ");
                		System.out.println(cuenta.getTit2().getNombre());
                		System.out.println("Fecha de Nacimiento titular 2: ");
                		System.out.println(cuenta.getTit2().getFechaNacimiento());
                		System.out.println("Edad titular 2: ");
                		System.out.println(cuenta.getTit2().getEdad());
            		}
            		System.out.println("Saldo de cuenta: ");
            		System.out.println(cuenta.getSaldo());
            		System.out.println("Estado de cuenta: ");
            		System.out.println(cuenta.getEstado());
            		System.out.println("Fecha de Creacion de cuenta: ");
            		System.out.println(cuenta.getFechaCreacion());
        		}
        		else {
        			System.out.println("Cuenta no existente...");
        		}
        		
        				break;
        				
        	case 7: //-----------------------CONSULTA DE CUENTA CON NUMERO DE TITULAR---------------------
        		System.out.println("Ingrese el nombre de titular a buscar: ");
        		S_aux=scan.nextLine();
        		
        		cuenta = b.retornarCuentaTitular(S_aux);
        		if(cuenta!=null) {
        			System.out.println("Nombre titular 1 de Cuenta: ");
            		System.out.println(cuenta.getTit().getNombre());
            		System.out.println("Fecha de Nacimiento titular 1: ");
            		System.out.println(cuenta.getTit().getFechaNacimiento());
            		System.out.println("Edad titular 1: ");
            		System.out.println(cuenta.getTit().getEdad());
            		if(cuenta.getTit2().getNombre()!=null) {
            			System.out.println("Nombre titular 2 de Cuenta: ");
                		System.out.println(cuenta.getTit2().getNombre());
                		System.out.println("Fecha de Nacimiento titular 2: ");
                		System.out.println(cuenta.getTit2().getFechaNacimiento());
                		System.out.println("Edad titular 2: ");
                		System.out.println(cuenta.getTit2().getEdad());
            		}
            		System.out.println("Saldo de cuenta: ");
            		System.out.println(cuenta.getSaldo());
            		System.out.println("Estado de cuenta: ");
            		System.out.println(cuenta.getEstado());
            		System.out.println("Fecha de Creacion de cuenta: ");
            		System.out.println(cuenta.getFechaCreacion());
        		}
        		else {
        			System.out.println("Cuenta no existente...");
        		}
        		
        		break;
        		
        	case 8: //-----------------------CONSULTAR CUENTA SI EDAD ES MENOR QUE ENTERO----------------
        		System.out.println("Ingrese el numero de referencia para la edad: ");
        		aux=scan.nextInt();
        		cuentaaux=b.retornarCuentaEdad(aux);
        		
        		for(int i=0; i<5; i++) {
        			
        			if(cuentaaux[i]!=null) {
        				System.out.println("Nombre titular 1 de Cuenta: ");
                		System.out.println(cuentaaux[i].getTit().getNombre());
                		System.out.println("Fecha de Nacimiento titular 1: ");
                		System.out.println(cuentaaux[i].getTit().getFechaNacimiento());
                		System.out.println("Edad titular 1: ");
                		System.out.println(cuentaaux[i].getTit().getEdad());
                		if(cuentaaux[i].getTit2().getNombre()!=null) {
                			System.out.println("Nombre titular 2 de Cuenta: ");
                    		System.out.println(cuentaaux[i].getTit2().getNombre());
                    		System.out.println("Fecha de Nacimiento titular 2: ");
                    		System.out.println(cuentaaux[i].getTit2().getFechaNacimiento());
                    		System.out.println("Edad titular 2: ");
                    		System.out.println(cuentaaux[i].getTit2().getEdad());
                		}
                		System.out.println("Saldo de cuenta: ");
                		System.out.println(cuentaaux[i].getSaldo());
                		System.out.println("Estado de cuenta: ");
                		System.out.println(cuentaaux[i].getEstado());
                		System.out.println("Fecha de Creacion de cuenta: ");
                		System.out.println(cuentaaux[i].getFechaCreacion());
        			}
        		}
        		Arrays.fill(cuentaaux, null); //dejar el arreglo en null para uso futuro
        		
        		break;
        		
        	case 9: //-----------------------CONSULTAR CUENTA SI FUE CREADA ANTES QUE FECHA DE REFERENCIA--------------------
        		System.out.println("Ingrese la fecha (aa-mm-dd): ");
        		S_aux=scan.nextLine();
        		
        		cuentaaux=b.retornarCuentaFechaCreacion(S_aux);
        		for(int i=0; i<5; i++) {
        			
        			if(cuentaaux[i]!=null) {
        				System.out.println("Nombre titular 1 de Cuenta: ");
                		System.out.println(cuentaaux[i].getTit().getNombre());
                		System.out.println("Fecha de Nacimiento titular 1: ");
                		System.out.println(cuentaaux[i].getTit().getFechaNacimiento());
                		System.out.println("Edad titular 1: ");
                		System.out.println(cuentaaux[i].getTit().getEdad());
                		if(cuentaaux[i].getTit2().getNombre()!=null) {
                			System.out.println("Nombre titular 2 de Cuenta: ");
                    		System.out.println(cuentaaux[i].getTit2().getNombre());
                    		System.out.println("Fecha de Nacimiento titular 2: ");
                    		System.out.println(cuentaaux[i].getTit2().getFechaNacimiento());
                    		System.out.println("Edad titular 2: ");
                    		System.out.println(cuentaaux[i].getTit2().getEdad());
                		}
                		System.out.println("Saldo de cuenta: ");
                		System.out.println(cuentaaux[i].getSaldo());
                		System.out.println("Estado de cuenta: ");
                		System.out.println(cuentaaux[i].getEstado());
                		System.out.println("Fecha de Creacion de cuenta: ");
                		System.out.println(cuentaaux[i].getFechaCreacion());
        			}
        		}
        		
        		Arrays.fill(cuentaaux, null);
        		
        		break;
        		
        		
        	case 10://----------------------------TODA CUENTA CON 2 TITULARES ------------------------------
        		
        		System.out.println("Las cuentas con dos o mas titulares son......");
        		cuentaaux=b.retornarCuentaDosTitulares();
        		for(int i=0; i<5; i++) {
        			
        			if(cuentaaux[i]!=null) {
        				System.out.println("Nombre titular 1 de Cuenta: ");
                		System.out.println(cuentaaux[i].getTit().getNombre());
                		System.out.println("Fecha de Nacimiento titular 1: ");
                		System.out.println(cuentaaux[i].getTit().getFechaNacimiento());
                		System.out.println("Edad titular 1: ");
                		System.out.println(cuentaaux[i].getTit().getEdad());
                		if(cuentaaux[i].getTit2().getNombre()!=null) {
                			System.out.println("Nombre titular 2 de Cuenta: ");
                    		System.out.println(cuentaaux[i].getTit2().getNombre());
                    		System.out.println("Fecha de Nacimiento titular 2: ");
                    		System.out.println(cuentaaux[i].getTit2().getFechaNacimiento());
                    		System.out.println("Edad titular 2: ");
                    		System.out.println(cuentaaux[i].getTit2().getEdad());
                		}
                		System.out.println("Saldo de cuenta: ");
                		System.out.println(cuentaaux[i].getSaldo());
                		System.out.println("Estado de cuenta: ");
                		System.out.println(cuentaaux[i].getEstado());
                		System.out.println("Fecha de Creacion de cuenta: ");
                		System.out.println(cuentaaux[i].getFechaCreacion());
        			}
        		}
        		
        		Arrays.fill(cuentaaux, null); 
        		
        		
        		break;
        		
        }
        op=menu();
		
        }
	}

}
