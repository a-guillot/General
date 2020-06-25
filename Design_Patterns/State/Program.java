package State;

public class Program {

	public static void main(String[] args) {

		Car car = new Car();
		
		
		System.out.println("------------beginning of the cycle");
		// fwd
		car.powerOn();
		car.powerOff();
		// lights
		car.powerOn();
		car.powerOff();
		// bwd	
		car.powerOn();
		car.powerOff();
		// lights
		car.powerOn();
		car.powerOff();
		// fwd
		car.powerOn();
		System.out.println("------------cycle over");

	}
}
