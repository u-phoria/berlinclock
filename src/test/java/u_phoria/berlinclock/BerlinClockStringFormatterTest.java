package u_phoria.berlinclock;

import static org.junit.Assert.*;

import org.junit.Test;

public class BerlinClockStringFormatterTest {

	private BerlinClockStringFormatter berlinClocStringkFormatter = new BerlinClockStringFormatter();

	@Test
	public void topLampYellowAsY() {
		String res = berlinClocStringkFormatter.format(new BerlinClock(true, 0, 0, 0, 0));
		
		assertEquals('Y', res.charAt(0));
	}
	
	@Test
	public void topLampYellowAsO() {
		String res = berlinClocStringkFormatter.format(new BerlinClock(false, 0, 0, 0, 0));
		
		assertEquals('O', res.charAt(0));
	}
	
	@Test
	public void hoursTopOnBottomOff() {
		String res = berlinClocStringkFormatter.format(new BerlinClock(true, 4, 0, 0, 0));
		
		assertEquals("RRRR OOOO", res.substring(2, 11));
	}

	@Test
	public void hoursOnsAndOffs() {
		String res = berlinClocStringkFormatter.format(new BerlinClock(true, 2, 3, 0, 0));
		
		assertEquals("RROO RRRO", res.substring(2, 11));
	}
	
	@Test
	public void minsTopOffBottomOn() {
		String res = berlinClocStringkFormatter.format(new BerlinClock(true, 0, 0, 0, 4));
		
		assertEquals("OOOOOOOOOOO YYYY", res.substring(12, 28));
	}
	
	@Test
	public void minsTopOnBottomOff() {
		String res = berlinClocStringkFormatter.format(new BerlinClock(true, 0, 0, 11, 0));
		
		assertEquals("YYRYYRYYRYY OOOO", res.substring(12, 28));
	}
	
	@Test
	public void minsOnsAndOffs() {
		String res = berlinClocStringkFormatter.format(new BerlinClock(true, 0, 0, 7, 2));
		
		assertEquals("YYRYYRYOOOO YYOO", res.substring(12, 28));
	}
	
	@Test
	public void fullStringRepresentationWithCorrectSpacing() {
		String res = berlinClocStringkFormatter.format(new BerlinClock(true, 1, 2, 5, 3));
		
		assertEquals("Y ROOO RROO YYRYYOOOOOO YYYO", res);
	}
}
