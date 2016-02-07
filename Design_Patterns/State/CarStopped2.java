package State;

public class CarStopped2 implements CarState {

	@Override
	public void powerOn(Car car) {
		car.setState(HEADLIGHTS);
		System.out.println("The headlights shines");
	}

	@Override
	public void powerOff(Car car) {
		// TODO Auto-generated method stub
		
	}

	
}
