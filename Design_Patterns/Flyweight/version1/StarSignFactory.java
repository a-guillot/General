package Flyweight;

import java.util.Calendar;
import java.util.HashMap;

public class StarSignFactory {

	private static HashMap<String, StarSign> signs = new HashMap<>(12);
	
	public static AbstractStarSign getStarSign(String name) {
		boolean found = false;
		for (int i = 0; i < LEGAL_NAMES.length; i++) {
			if (LEGAL_NAMES[i].equals(name)) {
				found = true;
				break;
			}
		}
		if (!found)
			return getStarSign(name, Calendar.getInstance(), "china");
		
		if (signs.containsKey(name)) {
			return signs.get(name);
		}
		else {
			StarSign newSign = new StarSign(name);
			signs.put(name, newSign);
			return newSign;
		}
	}
	
	public static AbstractStarSign getStarSign(String name, Calendar birthday, String location) {
		return new StarSignWithInterpretation(name, birthday, location);
	}
	
	// the following class variable is not shown in the class diagram:
		public static final String[] LEGAL_NAMES = { "Aries", "Taurus", "Gemini",
				"Cancer", "Leo", "Virgo", "Libra", "Scorpio", "Sagittarius",
				"Capricorn", "Aquarius", "Pisces" };
}
