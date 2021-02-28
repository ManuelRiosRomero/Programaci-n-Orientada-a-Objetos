package co.edu.javeriana.citasembajada.persistencia;
import co.edu.javeriana.citasembajada.controlador.*;
import co.edu.javeriana.citasembajada.modelo.*;
	import java.io.*;
import java.time.LocalDate;
import java.util.*;

import co.edu.javeriana.citasembajada.controlador.ControladorCitasEmbajada;
import co.edu.javeriana.citasembajada.modelo.Requisito;
import co.edu.javeriana.citasembajada.modelo.SistemaCitasEmbajada;
import co.edu.javeriana.citasembajada.modelo.Usuario;
import co.edu.javeriana.citasembajada.modelo.Visa;
	
public class ManejoArchivos implements Serializable{
	
	public static final String CARPETA_DATA = ".\\data\\";
	
		private static ManejoArchivos ma=new ManejoArchivos();
		static ControladorCitasEmbajada c = new ControladorCitasEmbajada();
		
		/**
		 * <p>Metodo que permite leer un archivo txt con las embajadas, y selecionar aquella que contiene el pais ingresado como parametro
		 * </p>
		 * @param nom
		 * @param pais
		 */
		public static SistemaCitasEmbajada LeerEmbajadas(String nom, String pais){
		
			ManejoArchivos manejoArchivo=new ManejoArchivos();
			SistemaCitasEmbajada sce = new SistemaCitasEmbajada();
			try{
			
				InputStreamReader input=new InputStreamReader(new FileInputStream(nom));
					
				BufferedReader bufferReader =new BufferedReader(input);
				String linea=bufferReader.readLine();
			
				linea=bufferReader.readLine();
				linea=bufferReader.readLine();
				while (!linea.equalsIgnoreCase("#FIN")){	
					String [] partes = linea.split("\\*");
					if(pais.equalsIgnoreCase(partes[1].trim())) {
						
						sce.setId(Integer.parseInt(partes[0].trim()));
						sce.setPaisEmbajada(partes[1].trim());
						sce.setMoneda(partes[2].trim());
						String impuesto =partes[3].trim();
						String impuesto2 = impuesto.substring(0,impuesto.length()-1);
						sce.setImpuesto(Float.parseFloat(impuesto2));
						sce.setCambioOficial(Double.parseDouble(partes[4].trim()));
					}						
					linea=bufferReader.readLine();
										
				}// Fin del while
				//System.out.println(c.imprimirEmbajadas());
			}
			catch (Exception e){
				System.out.println("Ocurrio un problema al cargar el archivo de texto " + e);
			}
			return sce;
		}

		/**
		 * <p>Metodo que permite leer un archivo txt con los solicitantes </p>
		 * @param nom
		 */
		public static List <Usuario> LeerSolicitantes (String nom){
			
			List <Usuario> usuarios = new ArrayList();
				ManejoArchivos manejoArchivo=new ManejoArchivos();
				try{
				
					InputStreamReader input=new InputStreamReader(new FileInputStream(nom));
						
				 BufferedReader bufferReader =new BufferedReader(input);
				String linea=bufferReader.readLine();
				linea=bufferReader.readLine();
				linea=bufferReader.readLine();
				
				while (!linea.equalsIgnoreCase("#FIN")){	
					Usuario u = new Usuario();
					
						String [] partes = linea.split("\\*");
						u.setNumPasaporte(Integer.parseInt(partes[0].trim()));
						u.setNombre(partes[1].trim());
						u.setPaisNacimiento(partes[2].trim());
						u.setCiudadNacimiento(partes[3].trim());
						u.setFechaNacimiento(LocalDate.parse(partes[4].trim()));
						u.setEmail(partes[5].trim());
						linea=bufferReader.readLine();
					//System.out.println("nombre: "+nombre+" fecha nacimiento: "+fechaNac+" email: " +email);
						usuarios.add(u);
		            
				}// Fin del while
				//System.out.println(c.imprimirUsuarios());
			
				}
				catch (Exception e){
					System.out.println("Ocurrio un problema al cargar el archivo de texto " + e);
				}
				return usuarios;
			}
		/**
		 * <p>Metodo que permite leer un archivo txt con las visas  </p>
		 * @param nom
		 */
		public static List<Visa> LeerVisas (String nom){
			//	Controlador c = new Controlador;
				List<Visa> visas = new ArrayList();
				
				
				ManejoArchivos manejoArchivo=new ManejoArchivos();
				try{
				
					InputStreamReader input=new InputStreamReader(new FileInputStream(nom));
						
				BufferedReader bufferReader =new BufferedReader(input);
				String linea=bufferReader.readLine();
				
				linea=bufferReader.readLine();
				
				linea=bufferReader.readLine();
				
				while (!linea.equalsIgnoreCase("#FIN")){	
						Visa v = new Visa();
						//List<Requisito> requisito = new ArrayList();
						Requisito r = new Requisito();
						
						String requisitos="Requisitos: ";
						r.setDescripcion(requisitos);
						//requisito.add(r);
						
						String [] partes = linea.split("\\*");
						v.setId(Integer.parseInt(partes[0].trim()));
						v.setTipo(partes[1].trim());
						v.setTarifa(Double.parseDouble(partes[2].trim()));
						
						linea=bufferReader.readLine();
						
						while(!linea.equalsIgnoreCase("#VISA")&&!linea.equalsIgnoreCase("#FIN")) {
							
							if(linea.equalsIgnoreCase("#REQUISITOS")) {
								linea=bufferReader.readLine();
							}
							
							requisitos+="\n"+linea;
							//r.setDescripcion(requisitos);
							
							//requisito.add(r);
							linea=bufferReader.readLine();
						}
						v.setRequisitos(requisitos);
						//v.agregarRequisito(requisito);
						visas.add(v);
						//requisito.removeAll(requisito);
						//c.adicionarVisa(id, tipoVisa, tarifa, requisitos);
						
						if(!linea.equalsIgnoreCase("#FIN")) {
							linea=bufferReader.readLine();
						}
						if(!linea.equalsIgnoreCase("#FIN")) {
							linea=bufferReader.readLine();
						}
						

		            
				}// Fin del while
				}
				catch (Exception e){
					System.out.println("Ocurrio un problema al cargar el archivo de texto " + e);
				}
				return visas;
			}

		/**
		 *<p>Metodo que permite leer un archivo txt con acompañantes adiconales y asociarlos a un usuario primario </p> 
		 * @param nom
		 * @param numPasaporte
		 */
		public static List<Integer> LeerAcompañantes (String nom, int numPasaporte){
			
			List<Integer> pasaportes = new ArrayList();
				ManejoArchivos manejoArchivo=new ManejoArchivos();
				try{
					
					pasaportes.add(numPasaporte);
					InputStreamReader input=new InputStreamReader(new FileInputStream(nom));
						
				 BufferedReader bufferReader =new BufferedReader(input);
				String linea=bufferReader.readLine();
				
				linea=bufferReader.readLine();
				linea=bufferReader.readLine();
				
				while (!linea.equalsIgnoreCase("#FIN")){	
					
						String [] partes = linea.split("\\*");
						
						int numPass = Integer.parseInt(partes[0].trim());
						
						//System.out.println(numPass);
						pasaportes.add(numPass);
						
						linea=bufferReader.readLine();
		            
				}// Fin del while
				
				
				return pasaportes;
				//System.out.println("\n"+"-------------Impresion Manejo de Archivos----------"+"\n"+c.imprimirSolicitud());
				}
				catch (Exception e){
					System.out.println("Ocurrio un problema al cargar el archivo de texto " + e);
				}
				return null;
			}
		
		// Metodo que permite Escribir a un archivo de texto	
		public static void EscribirAArchivoTexto(String texto, String nombre){
		
			try{
	 	      	// Se crea el flujo de salida al archivo de nombre nomarch
	        	OutputStreamWriter out= new OutputStreamWriter(new FileOutputStream(nombre));
	        	//Escribe una cadena en el flujo        	
	        	out.write(texto);
	        	out.close();
	        }
	    		catch(Exception e){
	    			System.out.println("Ocurrio un error escribiendo a un archivo el reporte: " + e); 	
	        }
	    		
		}

		
		
}
