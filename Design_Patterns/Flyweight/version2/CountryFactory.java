package Flyweight2;

import java.util.HashMap;

public class CountryFactory {

	private static HashMap<String, Country> countries = new HashMap<>();
	
	public static Country getNationality(String countryCode, String country) {
		if (countries.containsKey(country)) {
			return countries.get(country);
		}
		else {
			Country newNat = new Nationality(countryCode, country);
			countries.put(country, newNat);
			return newNat;
		}
	}
	
	public static void updateCountry(String countryCode, String country) {
		
	}
}
