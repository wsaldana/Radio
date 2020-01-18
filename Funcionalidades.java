/**********************************************************
Funcionalidades.java		Fecha de creación: 16/01/2020
							Última fecha de modificación: 16/01/2020

Interfaz que contiene las operaciones que puede realizar el Radio
**********************************************************/
public interface Funcionalidades{
	public String estacionActual();
	public boolean estado();
	public void onOff();
	public void cambiarFrecuencia();
	public void avanzar();
	public void guardar(int boton);
	public void seleccionarEmisora(int boton);
}