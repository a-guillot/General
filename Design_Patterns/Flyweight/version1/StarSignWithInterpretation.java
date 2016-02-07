package Flyweight;

import java.util.Calendar;

public class StarSignWithInterpretation extends AbstractStarSign {

	private String location;
	private Calendar birthday;
	
	public StarSignWithInterpretation(String name, Calendar birthday, String location) {
		super(name);
		this.birthday = birthday;
		this.location = location;
	}

	public String getInterpretation() {
		return ("In " + location + " , your sign is " + super.getName() + "when you were born on the " + birthday.toString() + ".");
	}
}
