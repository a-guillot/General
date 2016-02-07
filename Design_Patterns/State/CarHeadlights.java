package State;

public class CarHeadlights implements CarState {

	@Override
	public void powerOn(Car car) {
		
	}

	@Override
	public void powerOff(Car car) {
		car.setState(STOPPED3);
		System.out.println("The car stopped");

	}
}
