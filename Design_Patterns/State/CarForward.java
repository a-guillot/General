package State;

public class CarForward implements CarState {
	@Override
	public void powerOff(Car car) {
		car.setState(STOPPED2);
		System.out.println("The car stopped");
	}

	@Override
	public void powerOn(Car car) {
		System.out.println("already on");
		
	}
}
