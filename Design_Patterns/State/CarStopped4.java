package State;

public class CarStopped4 implements CarState {

	@Override
	public void powerOn(Car car) {
		car.setState(HEADLIGHTS2);
		System.out.println("the headlights shine");
	}

	@Override
	public void powerOff(Car car) {
		// TODO Auto-generated method stub
		
	}

}
