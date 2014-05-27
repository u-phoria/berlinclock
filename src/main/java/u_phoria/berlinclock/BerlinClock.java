package u_phoria.berlinclock;

import java.util.Objects;

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
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof BerlinClock))
			return false;
		BerlinClock bc = (BerlinClock)obj;
		return Objects.equals(isSecondsLampOn, bc.isSecondsLampOn)
				&& Objects.equals(upperHours, bc.upperHours)
				&& Objects.equals(lowerHours, bc.lowerHours)
				&& Objects.equals(upperMinutes, bc.upperMinutes)
				&& Objects.equals(lowerMinutes, bc.lowerMinutes);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(isSecondsLampOn, upperHours, lowerHours, upperMinutes, lowerMinutes);
	}
	
	@Override
	public String toString() {
		return String.format("BerlinClock[%s %s %s %s %s]", isSecondsLampOn, upperHours, lowerHours, upperMinutes, lowerMinutes);
	}
}
