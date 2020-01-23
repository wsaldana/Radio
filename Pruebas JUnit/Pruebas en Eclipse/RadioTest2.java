import static org.junit.Assert.*;

import org.junit.Test;

public class RadioTest2 {

	@Test
	public void test() {
		Radio test2 = new Radio();
		
		boolean estado = test2.estado(); 
		
		//SE ESPERA QUE LA RADIO ESTÉ APAGADA AL INICIO 
		assertEquals(false, estado);
	}

}