import static org.junit.Assert.*;

import org.junit.Test;

public class RadioTest1 {

	@Test
	public void test() {
		Radio test1 = new Radio();
		
		boolean onOff = test1.onOff();
		
		//SE ESPERA QUE ENCIENDA LA RADIO
		assertEquals(true, onOff);
	}

}
