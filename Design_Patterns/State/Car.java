package State;

public class Car implements CarConstants {

	private CarState state;
	
	public Car() {
		state = STOPPED;
	}
	
	public void powerOn() {
		state.powerOn(this);
	}
	
	public void powerOff() {
		state.powerOff(this);
	}
	
	public void setState(CarState newState) {
		state = newState;
	}
}
