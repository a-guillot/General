package State;

public interface CarState extends CarConstants {
	public void powerOn(Car car);
	public void powerOff(Car car);
}
