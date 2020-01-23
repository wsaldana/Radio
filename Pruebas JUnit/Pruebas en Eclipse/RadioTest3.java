import static org.junit.Assert.*;

import org.junit.Test;

public class RadioTest3 {

	@Test
	public void test() {
		Radio test3 = new Radio();
		
		String canal = test3.cambiarFrecuencia(); 
		
		//SE ESPERA QUE LA RADIO CAMBIE DE FM A AM 
		assertEquals("AM", canal);
	}

}
