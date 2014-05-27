package u_phoria.berlinclock;

public class BerlinClockStringFormatter implements BerlinClockFormatter {
	private static final char SPACE = ' ';
	private static final char R = 'R';
	private static final char Y = 'Y';
	private static final char O = 'O';

	public String format(BerlinClock bc) {
		StringBuilder sb = new StringBuilder()
			.append(bc.isSecondsLampOn() ? Y : O)
			.append(SPACE)
			.append(repeat(R, bc.getUpperHours()))
			.append(repeat(O, 4 - bc.getUpperHours()))
			.append(SPACE)
			.append(repeat(R, bc.getLowerHours()))
			.append(repeat(O, 4 - bc.getLowerHours()))
			.append(SPACE)
			.append(formatUpperMinutes(bc.getUpperMinutes()))
			.append(SPACE)
			.append(repeat(Y, bc.getLowerMinutes()))
			.append(repeat(O, 4 - bc.getLowerMinutes()));
		
		return sb.toString();
	}

	private StringBuilder formatUpperMinutes(int upperMinutes) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 11; i++) {
			if (upperMinutes <= 0) {
				sb.append(O);
				continue;
			}
			sb.append(i % 3 == 2 ? R : Y);
			upperMinutes--;
		}
		return sb;
	}

	private String repeat(char c, int n) {
		return new String(new char[n]).replace('\0', c);
	}

}
