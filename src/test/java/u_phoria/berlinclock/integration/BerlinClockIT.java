package u_phoria.berlinclock.integration;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import u_phoria.berlinclock.BerlinClock;
import u_phoria.berlinclock.BerlinClockFactory;
import u_phoria.berlinclock.BerlinClockFormatter;

public class BerlinClockIT {
	
	
	private BerlinClockFactory berlinClockFactory;
	private BerlinClockFormatter berlinClockFormatter;

	@Test
	public void mapZeroTime() {
		BerlinClock bc = berlinClockFactory.fromTime("00:00:00");
		
		String res = berlinClockFormatter.format(bc);
		
		assertEquals("Y OOOO OOOO OOOOOOOOOOO OOOO", res);
	}

}
