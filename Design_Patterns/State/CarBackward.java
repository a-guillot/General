package State;

public class CarBackward implements CarState {
	@Override
	public void powerOn(Car car) {
		System.out.println("the car is already on");
		
	}

	@Override
	public void powerOff(Car car) {
		car.setState(STOPPED4);
		System.out.println("The car stopped");

		
	}
}
