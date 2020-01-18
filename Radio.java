/**********************************************************
Radio.java					Fecha de creación: 16/01/2020
							Última fecha de modificación: 16/01/2020
							
Lleva el control del estado del radio.
**********************************************************/
import java.util.*;

public class Radio implements Funcionalidades{
	/*Declaración de atributos*/
	private String canal;
	private float estacion;
	private boolean estado;
	private ArrayList<String> favoritas;

	/*Método constructor sin parámetros con valores default*/
	public Radio(){
		this.canal = "FM";
		this.estacion = 88.0;
		this.estado = true;
		this.favoritas = new ArrayList();
	}

	/*Método constructor con parámetros*/
	public Radio(String canal, float estacion, boolean estado, ArrayList favoritas){
		this.canal = canal;
		this.estacion = estacion;
		this.estado = estado;
		this.favoritas = favoritas;
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
	public void toString(){
		return "Canal: "+this.canal+" Estacion: "+this.estacion+" Estado: "+this.estado+" Favoritas:"+this.favoritas;
	}
}