package co.edu.javeriana.citasembajada.modelo;
import co.edu.javeriana.citasembajada.controlador.*;
import co.edu.javeriana.citasembajada.persistencia.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.edu.javeriana.citasembajada.controlador.ControladorCitasEmbajada;
/**
 * 
 * @author Manuel Alejandro Rios
 *
 */

public class InterfazConsola {
		
	public static int menu(){ 
		   int opcion;
		   
		   /**
		    * este es el menu interfaz, donde el usuario puede hacer la selección 
		    */
		   System.out.println("\n"+"\n");
		   System.out.println("----Menu de Opciones---");
		   System.out.println("Opcion 0: Asociar país a la embajada");
		   System.out.println("Opcion 1: Ingresar solicitantes");
		   System.out.println("Opcion 2: Ingresar tipos de visa");
		   System.out.println("Opcion 3: Haccer solicitud de cita para visa Turismo");
		   System.out.println("Opcion 4: Hacer solicitud de cita para visa Diferente de Turismo");
		   System.out.println("Opcion 5: Calcular valor visa");
		   System.out.println("Opcion 6: Reporte de citas para una determinada fecha");
		   System.out.println("Opcion 7: Consultar la lista de requisitos de un tipo de Visa");
		   System.out.println("Opcion 8: Salir");
		   
		   
		   System.out.println("Escriba la opcion: ");
		   /**
		    * se crea el scaner con el que posterior mente guardaremos todas las variables 
		    * y se crea la variable que controlara el menu
		    */
		   Scanner scan=new Scanner(System.in);
		   opcion=scan.nextInt();
		   scan.nextLine();
		   return opcion;
		}
	
	
	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
        int op=11; //opcion
        int opAux;
        
        ControladorCitasEmbajada c = new ControladorCitasEmbajada();
        /**
         * Se crean variables auxiliares que se utilizaran a travez de la captura de datos como parametros de los metodos
         */
        String Saux, nomArchivo;
        int numPass;
        
        
        while (op!=8){
        	switch(op){
        	
        	case 0:
        		
        		System.out.println("Ingrese el nombre del pais de la embajada: ");
        		//Saux=scan.nextLine();
        		System.out.println("Ingrese el nombre del archivo de texto con los datos básicos de los paises: ");
        		System.out.println("...archivo incluido Default -Embajada.txt- ... : ");
        		//nomArchivo=scan.nextLine();
        		c.adicionarEmbajada(c.leerEmbajadas("Embajada.txt", "USA"));
        		break;
        		
        	case 1:
        		System.out.println("Ingrese el nombre del archivo de texto con los datos de los solicitantes: ");
        		System.out.println("...archivo incluido Default -Solicitantes.txt- ... : ");
        		//nomArchivo=scan.nextLine();
        		c.adicionarSolicitante(c.leerSolicitantes("Solicitantes.txt"));
        		//System.out.println(c.imprimirUsuarios());
        		break;
        		
        	case 2:
        		System.out.println("Ingrese el nombre del archivo de texto con los datos de las Visas: ");
        		System.out.println("...archivo incluido Default -TipoVisa.txt- ... : ");
        		//nomArchivo=scan.nextLine();
        		c.adicionarVisa(c.leerVisas("TipoVisa.txt"));
        		
        		break;
        	
        	case 3:
        		System.out.println("Ingrese su numero de pasaporte: ");
        		numPass=scan.nextInt();
        		scan.nextLine();
        		//c.buscarUsuario(numPass);
        		System.out.println("Viaja solo o acompañado? (solo/acomp): ");
        		Saux=scan.nextLine();
        		if(Saux.equalsIgnoreCase("acomp")) {
        			System.out.println("Ingrese el nombre del archivo de texto con los datos de los viajeros adicionales: ");
            		System.out.println("...archivo incluido Default -acompañantes1.txt-... : ");
            		nomArchivo=scan.nextLine();
            		System.out.println("Codigo de Solicitud: "+c.crearSolicitudTurismo(c.leerAcompañantes("acompañantes1.txt", numPass)));
        		}
        		else {
        			List<Integer> usuario = new ArrayList();
        			usuario.add(numPass);
        			c.crearSolicitudTurismo(usuario);
        		}
        		 //System.out.println(c.imprimirSolicitud());
        		break;
        	
        	case 4:
        		System.out.println("Ingrese el tipo de visa que desea solicitar informacion: ");
        		System.out.println(c.imprimirTiposVisa());
        		Saux=scan.nextLine();
        		System.out.println("Ingrese su numero de pasaporte: ");
        		numPass=scan.nextInt();
        		scan.nextLine();
        		System.out.println("Codigo de Solicitud: "+c.crearSolicitudOtrasVisas(Saux, numPass));
        		//System.out.println(c.imprimirSolicitud());
        		
        		break;
        		
        	case 5:
        		System.out.println("Consulta por numero de pasaporte o codigo de solicitud? (num/cod): ");
        		Saux=scan.nextLine();
        		if(Saux.equalsIgnoreCase("num")) {
        			System.out.println("Ingrese el numero de Pasaporte ya asociado a una solicitud: ");
            		numPass=scan.nextInt();
            		System.out.println(c.calcularValorVisaPass(numPass));
        		}
        		else {
        			System.out.println("Ingrese el codigo de solicitud: ");
            		numPass=scan.nextInt();
            		System.out.println(c.calcularValorVisaCod(numPass));
        		}
        		
        		
        		
        		break;
        		
        	case 6:
        		System.out.println("Ingrese la fecha que desea buscar la solicitud(aaaa-mm-dd): ");
        		Saux=scan.nextLine();
        		scan.nextLine();
        		c.crearArchivoSolicitudes(c.imprimirSolicitudesFecha(Saux),Saux+".txt");
        		System.out.println(c.imprimirSolicitudesFecha(Saux));
        		break;
        		
        	case 7:
        		System.out.println("Ingrese el tipo de visa que desea consultar los requisitos...");
        		System.out.println(c.imprimirTiposVisa());
        		Saux=scan.nextLine();
        		System.out.println(c.imprimirRequisitos(Saux));
        		break;
        		
        	}
        	 op=menu();
        }
       
	}

}
