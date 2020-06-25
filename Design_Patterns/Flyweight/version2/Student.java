package Flyweight2;

public class Student {
	private int studyNumber;
	private Name name;
	private Country country;

	public Student(int studyNumber, String firstName, String lastName,
			String countryCode, String country) {
		this.setStudyNumber(studyNumber);
		this.setName(new Name(firstName, lastName));
		this.setCountry(CountryFactory.getNationality(countryCode, country));
	}

	public Name getName() {
		return name;
	}

	public Country getCountry() {
		return country;
	}

	public int getStudyNumber() {
		return studyNumber;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public void setStudyNumber(int studyNumber) {
		this.studyNumber = studyNumber;
	}

	public String toString() {
		return studyNumber + " - " + name + " - " + country;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Student)) {
			return false;
		}
		Student other = (Student) obj;
		return studyNumber == other.studyNumber && name.equals(other.name)
				&& country.equals(other.country);
	}
}
