/**********************************************************
*Radio.java					Fecha de creación: 16/01/2020
*							Última fecha de modificación: 18/01/2020
*							
*Lleva el control del estado del radio.
*Importa el paquete java.util
*
*@author Andrea Amaya #19357
*@author Walter Saldaña #19897
**********************************************************/
import java.util.*;

public class Radio implements Funcionalidades{
	/**Declaración de atributos*/
	private String canal;
	private float estacion;
	private boolean estado;
	private ArrayList<String> favoritas;

	/**
	 * Método constructor sin parámetros con valores default
	*/
	public Radio(){
		this.canal = "FM";
		this.estacion = 88.0f;
		this.estado = false;
		this.favoritas = new ArrayList();
		for(int i=0; i<12; i++){
			favoritas.add("");
		}
	}

	/**
	 * Método constructor con parámetros
	 * @param canal		Si es AM o FM
	 * @param estacion  El número de la estación de radio
	 * @param estado	True para encendida y False para apagado
	 * @param favoritas Arraylist que almacena las estaciones favoritas
	*/
	public Radio(String canal, float estacion, boolean estado, ArrayList favoritas){
		this.canal = canal;
		this.estacion = estacion;
		this.estado = estado;
		this.favoritas = favoritas;
	}

	/**Implementación de métodos*/

	/**
	 * Método para obtener los valores actuales del canal y estacion de la radio.
	 * @return String de Canal y estacion de radio cocatenados
	 */
	public String estacionActual(){
		return this.canal+"-"+String.format("%.1f",this.estacion)+"\nFavoritas:" + this.favoritas.toString();
	}

	/**
	 * Metodo para verificar si el radio esta encendido o apagado.
	 * @return true(encendido) o false(apagado)
	 */
	public boolean estado(){
		return this.estado;
	}

	/**
	 * Método para encender y apagar la radio. 
	 * Si esta encendida la apaga y viceversa.
	 */
	public void onOff(){
		if(this.estado){
			this.estado = false;
		}else{
			this.estado = true;
		}
	}

	/**
	 * Método que cambia el canal de la radio.
	 * Si esta en AM lo cambia a FM y viceversa.
	 * Ya que AM y FM tienen distintos formatos de estaciones, estas también se cambian.
	 */
	public void cambiarFrecuencia(){
		if(this.canal.equals("AM")){
			this.canal = "FM";
			this.estacion = 88.0f;
		}else if(this.canal.equals("FM")){
			this.canal = "AM";
			this.estacion = 530;
		}
	}

	/**
	 * Método que permite cambiar a la siguiente estación de radio
	 */
	public void avanzar(){
		//Evaluar el tipo de canal por sus diferentes formatos
		if(this.canal.equals("AM")){
			//Por la pérdida de precisión decimal, 1609 se aproxima a 1610
			if(this.estacion >= 1609){
				this.estacion = 530;
			}else{
				this.estacion += 10;
			}
		}else if(this.canal.equals("FM")){
			//Por la pérdida de presición decimal, 107.99 aproxima a 108.0
			if(this.estacion >= 107.99){
				this.estacion = 88.0f;
			}else{
				this.estacion += 0.2f;
			}
		}
	}

	/**
	 * Método para guardar la estación actual en la lista de favoritos.
	 * @param boton  Número entero de la posición de lista donde se guardará la estación 
	 */
	public void guardar(int boton){
		if(boton>=1 && boton<=12){
			this.favoritas.set(boton-1,this.canal+"-"+String.format("%.1f",this.estacion));
		}
	}

	/**
	 * Método para poner una de las estaciones guardadas como favoritas.
	 * @param boton  Posición en la lista de la estación a poner en radio.
	 */
	public void seleccionarEmisora(int boton){
		String seleccion = this.favoritas.get(boton-1);
		if(!seleccion.equals("")){
			String[] separacion = seleccion.split("-");
			this.canal = separacion[0];
			this.estacion = Float.parseFloat(separacion[1]);
		}
	}


	/*Setters y Getters*/

	public String getCanal(){
		return this.canal;
	}

	public void setCanal(String canal){
		this.canal = canal;
	}

	public float getEstacion(){
		return this.estacion;
	}

	public void setEstacion(float estacion){
		this.estacion = estacion;
	}

	public boolean getEstado(){
		return this.estado;
	}

	public void setEstado(boolean estado){
		this.estado = estado;
	}

	public ArrayList getFavoritas(){
		return this.favoritas;
	}

	public void setFavoritas(ArrayList favoritas){
		this.favoritas = favoritas;
	}

	/*Método toString */
	public String toString(){
		return "Canal: "+(this.canal)+" Estacion: "+String.valueOf(this.estacion)+" Estado: "+String.valueOf(this.estado)+" Favoritas:"+String.valueOf(this.favoritas);
	}
}