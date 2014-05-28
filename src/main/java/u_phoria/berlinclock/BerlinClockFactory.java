package u_phoria.berlinclock;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class BerlinClockFactory {
	private static final String HH_MM_SS = "HH:mm:ss";
	private static final String COLON = ":";
	private final DateFormat dateFormat;
	
	public BerlinClockFactory() {
		dateFormat = createDateFormat();
	}

	public BerlinClock createFromTime(String time) {
		// Berlin clock has a valid representation for 24:00:00
		// which is different from 00:00:00 - handle this explicitly
		if (!"24:00:00".equals(time)) {
			try {
				dateFormat.parse(time);
			} catch (ParseException e) {
				throw new IllegalArgumentException(String.format("Invalid time format: %s - expected hh:mm:ss", time));
			}
		}
		
		String[] parts = time.split(COLON);		
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

	protected DateFormat createDateFormat() {
		DateFormat df = new SimpleDateFormat(HH_MM_SS);
		df.setLenient(false);
		return df;
	}
}
