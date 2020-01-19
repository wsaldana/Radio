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
		this.estacion = 88.0f;
		this.estado = false;
		this.favoritas = new ArrayList();
		for(int i=0; i<12; i++){
			favoritas.add("");
		}
	}

	/*Método constructor con parámetros*/
	public Radio(String canal, float estacion, boolean estado, ArrayList favoritas){
		this.canal = canal;
		this.estacion = estacion;
		this.estado = estado;
		this.favoritas = favoritas;
	}

	/*Implementación de métodos*/

	public String estacionActual(){
		return getCanal()+"-"+String.format("%.1f",getEstacion());
	}

	public boolean estado(){
		return getEstado();
	}

	public void onOff(){
		if(getEstado()){
			setEstado(false);
		}else{
			setEstado(true);
		}
	}

	public void cambiarFrecuencia(){
		if(this.canal.equals("AM")){
			this.canal = "FM";
			this.estacion = 88.0f;
		}else if(this.canal.equals("FM")){
			this.canal = "AM";
			this.estacion = 530;
		}
	}

	public void avanzar(){
		if(this.canal.equals("AM")){
			if(this.estacion >= 1609){
				this.estacion = 530;
			}else{
				this.estacion += 10;
			}
		}else if(this.canal.equals("FM")){
			if(this.estacion >= 107.99){
				this.estacion = 88.0f;
			}else{
				this.estacion += 0.2f;
			}
		}
	}

	public void guardar(int boton){
		if(boton>=1 && boton<=12){
			this.favoritas.set(boton-1,this.canal+"-"+String.format("%.1f",this.estacion));
		}
	}

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
		String cad = "Canal: "+(this.canal)+" Estacion: "+String.valueOf(this.estacion)+" Estado: "+String.valueOf(this.estado)+" Favoritas:"+this.favoritas.toString();
		return cad;
	}
}