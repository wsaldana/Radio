import java.util.*;

public class Radio{
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
	 * Método para encender y apagar la radio. 
	 * Si esta encendida la apaga y viceversa.
	 */
	public boolean onOff(){
		if(this.estado){
			this.estado = false;
		}else{
			this.estado = true;
		}
		return estado;
	}
	
	/**
	 * Metodo para verificar si el radio esta encendido o apagado.
	 * @return true(encendido) o false(apagado)
	 */
	public boolean estado(){
		return this.estado;
	}
	
	public String cambiarFrecuencia(){
		if(this.canal.equals("AM")){
			this.canal = "FM";
			this.estacion = 88.0f;
		}else if(this.canal.equals("FM")){
			this.canal = "AM";
			this.estacion = 530;
		}
		return this.canal;
	}
	
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
	
	public String emisoraFav(int index) {
		System.out.println(favoritas.get(0));
		return favoritas.get(index-1);
	}


}