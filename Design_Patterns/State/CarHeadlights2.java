package State;

public class CarHeadlights2 implements CarState {

	@Override
	public void powerOn(Car car) {
		
		
	}

	@Override
	public void powerOff(Car car) {
		car.setState(STOPPED);
		System.out.println("The car stopped");

		
	}

}
