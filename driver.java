/**********************************************************
Driver.java					Fecha de creación: 16/01/2020
							Última fecha de modificación: 16/01/2020
Autores del programa:
		>Andrea Amaya 19357
		>Walter Saldana 19897							
Clase para interactuar con el usuario
**********************************************************/
import java.util.Scanner;

public class driver{
	public static void main(String[] args) {
		//Se manda a llamar el escaner y el controlador
		Scanner scan = new Scanner(System.in);
		Radio radio = new Radio();
		int opcion = 0;

		//Se correrá el programa mientras esté encendida la radio
		while(opcion!=7){
			//Se pide la opcion a realizar
			System.out.println("_______________________________________\n         ESCOJA LA ACCION A REALIZAR:          \n_______________________________________");
			System.out.println("1. Prender el radio\n2. Cambiar a AM/FM\n3. Siguiente emisora\n4. Guardar emisora\n5. Escoger emisora guardada\n6. Apagar el radio\nElija la opcion:");
			
			if (opcion==1) { //Encender radio
				System.out.println(" Hola :) ");
				radio.onOff();
			} else if (radio.estado()) { //Si la radio está encendida 
				System.out.println("\n_______________\nESTAS EN LA ESTACION " + radio.estacionActual() + "\n_______________\n");
				if (opcion == 2) { //Cambiar AM/FM
					radio.cambiarFrecuencia();
				} else if (opcion == 3) { //Siguiente emisora
					radio.avanzar();
				} else if (opcion == 4) { //Guardar emisora
					System.out.println("Elija el numero de boton donde se guardara: ");
					radio.guardar(scan.next());
				} else if (opcion == 5) { //Seleccionar emisora guardada
					System.out.println("Elija el numero de boton a escuchar: ");
					radio.seleccionarEmisora(scan.next());
				} else { //Apagar la radio
					System.out.println(" Adios :) ");
					radio.onOff();
				} 
			} else if (!radio.estado()) { //La radio está apagada
				System.out.println(" Primero enciende la radio ");
			} else if (opcion == 7) { //Se cierra el programa
				System.out.println(" Vuelve pronto :) ");
			} else { //Opcion inexistente
				System.out.println(" La opcion no existe ");
			}
		}
	}
}