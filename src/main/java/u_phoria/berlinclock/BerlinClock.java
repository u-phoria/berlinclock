package u_phoria.berlinclock;

public class BerlinClock {
	private final boolean isSecondsLampOn;
	private final int upperHours;
	private final int lowerHours;
	private final int upperMinutes;
	private final int lowerMinutes;

	public BerlinClock(boolean isSecondsLampOn, int upperHours, int lowerHours,
			int upperMinutes, int lowerMinutes) {
		this.isSecondsLampOn = isSecondsLampOn;
		this.upperHours = upperHours;
		this.lowerHours = lowerHours;
		this.upperMinutes = upperMinutes;
		this.lowerMinutes = lowerMinutes;
	}

	public boolean isSecondsLampOn() {
		return isSecondsLampOn;
	}
	
	public int getUpperHours() {
		return upperHours;
	}
	
	public int getLowerHours() {
		return lowerHours;
	}
	
	public int getUpperMinutes() {
		return upperMinutes;
	}
	
	public int getLowerMinutes() {
		return lowerMinutes;
	}
}
