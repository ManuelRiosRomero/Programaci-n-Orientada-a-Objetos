import java.util.Scanner;

/**
 * 
 */

/**
 * @author angela.carrillo
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
	   System.out.println("Opcion 10: Salir");
	   
	   System.out.println("Escriba la opcion: ");
	   
	   Scanner s=new Scanner(System.in);
	   opcion=s.nextInt();
	   
	   return opcion;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

        String nomTit, estado;
        int nc;
        float s, monto;
        Scanner scan=new Scanner(System.in);
        
        int op=0;
        Cuenta [] cuentas = new Cuenta[5]; //arreglo de cuentas
        int a=0;
        int aux=0, aux2=0;
        String S_aux;
        
        
        while (op!=10){
        
        switch (op){ // Crear cuentas
        	case 1: 	System.out.println("Escriba el numero de cuenta");
        				nc=scan.nextInt();
        				System.out.println("Escriba el nombre del titular");
        				nomTit=scan.next();
        				System.out.println("Escriba el saldo");
        				s=scan.nextFloat();
        				cuentas[a]=new Cuenta(nc,nomTit,s);//aca se envian los datos almacenados del objeto
        				a++;
        				
        				break;
        				
        	case 2: 	// ----------------------------------CONSIGNAR------------------------
        		if(a<=1)// si solo hay una cuenta 
        		{ 
        			System.out.println("Escriba el monto a consignar");
					monto=scan.nextFloat();
					cuentas[0].consignar(monto);
        		}
        		else 
        		{
        			System.out.println("Ingrese el numero de cuenta que desea Consignar: ");
        			aux=scan.nextInt();
        			for(int i=0; i<a; i++)
        			{
        				if(cuentas[i].getNumCuenta()==aux)
        				{
        					System.out.println("Escriba el monto a consignar: ");
        					monto=scan.nextFloat();
        					cuentas[i].consignar(monto);
        				}
        			}
        		}
        				
					break;
						
        	case 3: 	//----------------------------RETIRAR--------------------------
        				if(a<=1)
        				{
        					System.out.println("Escriba el monto a retirar: ");
    						monto=scan.nextFloat();
    						c.retirar(monto);
        				}
        				else
        				{
        					System.out.println("Ingrese el numero de cuenta que desea Retirar: ");
                			aux=scan.nextInt();
                			for(int i=0; i<a; i++)
                			{
                				if(cuentas[i].getNumCuenta()==aux)
                				{
                					System.out.println("Escriba el monto a Retirar: ");
                					monto=scan.nextFloat();
                					cuentas[i].consignar(monto);
                				}
                			}
        				}
        				
						break;
						
        	case 4: //---------------------transferir de una cuenta a otra--------------------
        		if(a<=1)
        		{
        			System.out.println("Unicamente existe una cuenta, son necesarias 2 minimo para transferir entre cuentas...");
        		}
        		else
        		{
        			System.out.println("Ingrese el numero de la cuenta que recibe: ");
        			aux=scan.nextInt();
        			System.out.println("Ingrese el numero de la cuenta que da: ");
        			aux2=scan.nextInt();
        			System.out.println("Ingrese la cantidad que desea transferir: ");
        			monto=scan.nextFloat();
        			
        			for(int i=0; i<a; i++)
        			{
        				if(cuentas[i].getNumCuenta()==aux)//cuenta que recibe
        				{
        					cuentas[i].consignar(monto);
        				}
        				if(cuentas[i].getNumCuenta()==aux2)//cuenta que da
        				{
        					cuentas[i].retirar(monto);
        				}
        			}
        		}
        		
        		break;
        		
        	case 5: // -----------------------CAMBIAR ESTADO----------------------
        		if(a<=1)
        		{
        			System.out.println("Estado previo: "+cuentas[0].getEstado() );
        			if(cuentas[0].getEstado()=="ACTIVA")
        			{
        				cuentas[0].setEstado("NO ACTIVA");
        				System.out.println("Estado actual: "+cuentas[0].getEstado() );
        			}
        			else
        			{
        				cuentas[0].setEstado("ACTIVA");
        				System.out.println("Estado actual: "+cuentas[0].getEstado() );
        			}
        		}
        		else
        		{
        			System.out.println("Ingrese el numero de cuenta que desea cambiar el estado: ");
        			aux=scan.nextInt();
        			for(int i=0; i<a; i++)
        			{
        				if(cuentas[i].getNumCuenta()==aux)
        				{
        					System.out.println("Estado previo: "+cuentas[i].getEstado() );
                			if(cuentas[0].getEstado()=="ACTIVA")
                			{
                				cuentas[0].setEstado("NO ACTIVA");
                				System.out.println("Estado actual: "+cuentas[i].getEstado() );
                			}
                			else
                			{
                				cuentas[0].setEstado("ACTIVA");
                				System.out.println("Estado actual: "+cuentas[i].getEstado() );
                			}
        				}
        			}
        		}
        		break;
        			
        	case 6:		//----------------------CONSULTA BASICA CUENTA----------------
        				if(a<=1)
        				{
        					System.out.println(cuentas[0].toString());
        				}
        				else
        				{
        					System.out.println("Ingrese el numero de cuenta que desea consultar: ");
                			aux=scan.nextInt();
                			for(int i=0; i<a; i++)
                			{
                				if(cuentas[i].getNumCuenta()==aux)
                				{
                					System.out.println(cuentas[i].toString());
                					
                				}
                			}
        				}
        				break;
        				
        	case 7: //-----------------------Consulta de cuenta con nombre de titular---------------------
        		System.out.println("Ingrese el nombre del titular a buscar: ");
        		S_aux=scan.nextLine();
        		
        		for(int i=0; i<a; i++)
        		{
        			if(cuentas[i].getNomTit()==S_aux)
        			{
        				System.out.println(cuentas[i].toString());
        				aux2=99;
        			}
        			else
        			{
        				if(aux2!=99&&i==a-1)
        				{
        					System.out.println("ERROR: Cuenta Inexistente");
        				}
        			}
        		}
        		
        		break;
        		
        	case 8: //-----------------------Consultar cuenta si edad es menor a un entero----------------
        	
        		break;
        		
        	case 9: //-----------------------Consultar cuenta si esta fue creada antes de una fecha-------
        		break;
    
        		
        }
        op=menu();
		
        }
	}

}
