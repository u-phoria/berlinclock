package u_phoria.berlinclock;

import static org.junit.Assert.*;

import org.junit.Test;

public class BerlinClockTest {

	@Test
	public void basicConstructionAndPropertyRetrieval() {
		BerlinClock bc = new BerlinClock(false, 0, 1, 2, 3);
		
		assertEquals(false, bc.isSecondsLampOn());
		assertEquals(0, bc.getUpperHours());
		assertEquals(1, bc.getLowerHours());
		assertEquals(2, bc.getUpperMinutes());
		assertEquals(3, bc.getLowerMinutes());
	}

}
