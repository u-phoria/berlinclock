package u_phoria.berlinclock;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BerlinClockFactoryTest {
	@Rule public ExpectedException thrown = ExpectedException.none();
	private BerlinClockFactory berlinClockFactory = new BerlinClockFactory();
	
	@Test
	public void failForInvalidFormatEmpty() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Invalid time format");
		
		berlinClockFactory.createFromTime("");
	}
	
	@Test
	public void failForInvalidFormatSingleColon() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Invalid time format");
		
		berlinClockFactory.createFromTime("12:00 00");
	}
	
	@Test
	public void failForInvalidHours() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Invalid time format");
		
		berlinClockFactory.createFromTime("25:00:00");
	}
	
	@Test
	public void createFromZeroTimeString() {
		BerlinClock bc = berlinClockFactory.createFromTime("00:00:00");
		
		assertEquals(new BerlinClock(true, 0, 0, 0, 0), bc);
	}
	
	@Test
	public void createFromTwentyFourHundred() {
		BerlinClock bc = berlinClockFactory.createFromTime("24:00:00");
		
		assertEquals(new BerlinClock(true, 4, 4, 0, 0), bc);
	}
	
	@Test
	public void createFromOneSecondToMidnight() {
		BerlinClock bc = berlinClockFactory.createFromTime("23:59:59");
		
		assertEquals(new BerlinClock(false, 4, 3, 11, 4), bc);
	}
}
