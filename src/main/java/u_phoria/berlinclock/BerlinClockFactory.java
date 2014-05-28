package u_phoria.berlinclock;

public class BerlinClockFactory {

	private static final String COLON = ":";

	public BerlinClock createFromTime(String time) {
		String[] parts = time.split(COLON);
		if (parts.length != 3)
			throw new IllegalArgumentException(String.format("Invalid time format: %s - expected hh:mm:ss", time));
		
		int hours = Integer.parseInt(parts[0]);
		int mins = Integer.parseInt(parts[1]);
		int secs = Integer.parseInt(parts[2]);
		return createFromTime(hours, mins, secs);
	}

	protected BerlinClock createFromTime(int hours, int mins, int secs) {
		return new BerlinClock(secs % 2 == 0,
				hours / 5,
				hours % 5,
				mins / 5,
				mins % 5);
	}

}
