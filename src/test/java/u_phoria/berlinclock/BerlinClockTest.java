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

	@Test
	public void equalsAcrossAllFields() {
		BerlinClock bc = new BerlinClock(true, 1, 2, 3, 4);
		
		assertEquals(new BerlinClock(true, 1, 2, 3, 4), bc);
	}
	
	@Test
	public void equalsFalseForDifferentType() {
		assertFalse(new BerlinClock(true, 0,  1, 2, 3).equals(new Object()));
	}
	
	@Test
	public void equalsAndHashCodeSame() {
		BerlinClock bc1 = new BerlinClock(true, 1, 2, 3, 4);
		BerlinClock bc2 = new BerlinClock(true, 1, 2, 3, 4);
		
		assertEquals(bc2, bc1);
		assertEquals(bc2.hashCode(), bc1.hashCode());
	}
	
	@Test
	public void equalsAndHashCodeDifferent() {
		BerlinClock bc1 = new BerlinClock(true, 1, 2, 3, 4);
		BerlinClock bc2 = new BerlinClock(false, 4, 3, 2, 1);
		
		assertNotEquals(bc2, bc1);
		assertNotEquals(bc2.hashCode(), bc1.hashCode());
	}
	
	@Test
	public void toStringRepresentation() {
		BerlinClock bc = new BerlinClock(true, 0, 1, 2, 3);
		
		String res = bc.toString();
		
		assertEquals("BerlinClock[true 0 1 2 3]", res);
	}
}
