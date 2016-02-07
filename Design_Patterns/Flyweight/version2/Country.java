package Flyweight2;

public abstract class Country {

	private String countryCode;
	private String country;

	public Country(String countryCode, String country) {
		setCountryCode(countryCode);
		setCountry(country);
	}

	public void setCountryCode(String countryCode) {
		if (countryCode == null || countryCode.length() != 2
				|| !Character.isLetter(countryCode.charAt(0))
				|| !Character.isLetter(countryCode.charAt(1))) {
			throw new IllegalArgumentException(
					"CountryCode should contain two leters");
		}
		this.countryCode = countryCode.toUpperCase();
	}

	public void setCountry(String country) {
		if (country == null || country.length() == 0) {
			throw new IllegalArgumentException(
					"Country cannot be null or empty");
		}
		this.country = country.substring(0, 1).toUpperCase()
				+ country.substring(1);
	}

	public String getCountryCode() {
		return countryCode;
	}

	public String getCountry() {
		return country;
	}

	public String toString() {
		return country + " (" + countryCode + ")";
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Nationality)) {
			return false;
		}
		Nationality other = (Nationality) obj;
		return country.equals(other.getCountry())
				&& countryCode.equals(other.getCountryCode());
	}
}
