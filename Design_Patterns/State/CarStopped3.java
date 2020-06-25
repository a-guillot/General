package State;

public class CarStopped3 implements CarState {

	@Override
	public void powerOn(Car car) {
		car.setState(BACKWARD);
		System.out.println("The car is moving backward with headlights on");
	}

	@Override
	public void powerOff(Car car) {
		// TODO Auto-generated method stub
		
	}

}
