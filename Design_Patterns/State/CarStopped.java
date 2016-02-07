package State;

public class CarStopped implements CarState {
	@Override
	public void powerOn(Car car) {
		car.setState(FORWARD);
		System.out.println("The car is moving forward with headlights on");
	}

	@Override
	public void powerOff(Car car) {
		System.out.println("the car is aready off");
		
	}
}
