import static org.junit.Assert.*;

import org.junit.Test;

public class RadioTest4 {

	@Test
	public void test() {
		Radio test4 = new Radio();
		
		test4.guardar(1); //Se guarda la emisora en el botón 1
		int boton = 1; //Se selecciona el botón
		
		//SE ESPERA QUE LA RADIO MUESTRE EL BOTÓN SELECCIONADO
		assertEquals("FM-88.0", test4.emisoraFav(boton));
	}

}
