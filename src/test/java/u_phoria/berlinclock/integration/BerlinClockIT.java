package u_phoria.berlinclock.integration;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import u_phoria.berlinclock.BerlinClock;
import u_phoria.berlinclock.BerlinClockFactory;
import u_phoria.berlinclock.BerlinClockFormatter;
import u_phoria.berlinclock.BerlinClockStringFormatter;

public class BerlinClockIT {
	
	
	private BerlinClockFactory berlinClockFactory = new BerlinClockFactory();
	private BerlinClockFormatter berlinClockFormatter = new BerlinClockStringFormatter();

	@Test
	public void mapZeroTime() {
		BerlinClock bc = berlinClockFactory.createFromTime("00:00:00");
		
		String res = berlinClockFormatter.format(bc);
		
		assertEquals("Y OOOO OOOO OOOOOOOOOOO OOOO", res);
	}

}
