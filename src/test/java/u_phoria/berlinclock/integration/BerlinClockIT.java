package u_phoria.berlinclock.integration;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import u_phoria.berlinclock.BerlinClock;
import u_phoria.berlinclock.BerlinClockFactory;
import u_phoria.berlinclock.BerlinClockFormatter;
import u_phoria.berlinclock.BerlinClockStringFormatter;

public class BerlinClockIT {
	@Rule public ExpectedException thrown = ExpectedException.none();
	private BerlinClockFactory berlinClockFactory = new BerlinClockFactory();
	private BerlinClockFormatter berlinClockFormatter = new BerlinClockStringFormatter();

	@Test
	public void representMinimumTime() {
		BerlinClock bc = berlinClockFactory.createFromTime("00:00:00");
		
		String res = berlinClockFormatter.format(bc);
		
		assertEquals("Y OOOO OOOO OOOOOOOOOOO OOOO", res);
	}
	
	@Test
	public void representIntraDayTime() {
		BerlinClock bc = berlinClockFactory.createFromTime("13:17:01");
		
		String res = berlinClockFormatter.format(bc);
		
		assertEquals("O RROO RRRO YYROOOOOOOO YYOO", res);
	}
	
	@Test
	public void representOneSecondToMidnight() {
		BerlinClock bc = berlinClockFactory.createFromTime("23:59:59");
		
		String res = berlinClockFormatter.format(bc);
		
		assertEquals("O RRRR RRRO YYRYYRYYRYY YYYY", res);
	}
	
	@Test
	public void representMaximumTime() {
		BerlinClock bc = berlinClockFactory.createFromTime("24:00:00");
		
		String res = berlinClockFormatter.format(bc);
		
		assertEquals("Y RRRR RRRR OOOOOOOOOOO OOOO", res);
	}
	
	@Test
	public void rejectInvalidTimeFormat() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Invalid time format: 7-8-9");
		BerlinClock bc = berlinClockFactory.createFromTime("7-8-9");
		
		berlinClockFormatter.format(bc);
	}

	@Test
	public void rejectInvalidTimeValue() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Invalid time format: 27:00:00");
		BerlinClock bc = berlinClockFactory.createFromTime("27:00:00");
		
		berlinClockFormatter.format(bc);
	}
}
