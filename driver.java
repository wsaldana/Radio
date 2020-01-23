/**********************************************************
*Driver.java					Fecha de creación: 16/01/2020
*							    Última fecha de modificación: 19/01/2020						
*Clase para interactuar con el usuario

*@author Andrea Amaya #19357
*@author Walter Saldaña #19897
**********************************************************/
import java.util.Scanner;

public class driver{
	public static void main(String[] args) {
		//Se manda a llamar el escaner y el controlador
		Scanner scan = new Scanner(System.in);
		Funcionalidades radio = new Radio();

		//Se correrá el programa mientras esté encendida la radio
		while(true){
			//Se pide la opcion a realizar
			int opcion = 0;
			int boton = 1;

			System.out.println("_______________________________________\n         ESCOJA LA ACCION A REALIZAR:          \n_______________________________________");
			System.out.println("1. Prender el radio\n2. Cambiar a AM/FM\n3. Siguiente emisora\n4. Guardar emisora\n5. Escoger emisora guardada\n6. Apagar el radio\n7. Salir\nElija la opcion:");
			String posible = scan.next();
			//Defensiva
			try {
				opcion =Integer.parseInt(posible);
			} catch (Exception e){
				System.out.println("Ingresa un numero entero");	
			}
			
			if (radio.estado()) { //Si la radio está encendida 
				if (opcion==1) { //Encender radio
					System.out.println("La radio ya estaba encendida");
				} else if (opcion == 2) { //Cambiar AM/FM
					radio.cambiarFrecuencia();
				} else if (opcion == 3) { //Siguiente emisora
					radio.avanzar();
				} else if (opcion == 4) { //Guardar emisora
					System.out.println("Elija el numero de boton donde se guardara: ");
					String botonposible = scan.next();
					//Defensiva
					try {
						boton =Integer.parseInt(botonposible);
					} catch (Exception e){
						System.out.println("Ingresa un numero entero");	
					}
					//Se guarda
					radio.guardar(boton);
				} else if (opcion == 5) { //Seleccionar emisora guardada
					System.out.println("Elija el numero de boton a escuchar: ");
					String botonposible = scan.next();
					//Defensiva
					try {
						boton =Integer.parseInt(botonposible);
					} catch (Exception e){
						System.out.println("Ingresa un numero entero");	
					}
					//Se escucha
					radio.seleccionarEmisora(boton);
				} else if (opcion == 6){ //Apagar la radio
					System.out.println(" Adios :) ");
					radio.onOff();
				} else if (opcion == 7) { //Se cierra el programa
					System.out.println(" Vuelve pronto :) ");
					break;
				} else { //Opcion inexistente
					System.out.println(" La opcion no existe!!!!");
				}
				System.out.println("\n_______________\nESTAS EN LA ESTACION " + radio.estacionActual() + "\n_______________\n");

			} else if (!radio.estado()) { //La radio está apagada
				if (opcion==1) { //Encender radio
					System.out.println("_______________\n Hola :) \n_______________");
					radio.onOff();
					System.out.println("\n_______________\nESTAS EN LA ESTACION " + radio.estacionActual() + "\n_______________\n");
				} else if (opcion == 7) { //Se cierra el programa
					System.out.println("_______________\n Vuelve pronto :) \n_______________");
					break;
				} else{
					System.out.println("_______________\n Primero enciende la radio \n_______________");
				}
			}
			
		}
	}
}
