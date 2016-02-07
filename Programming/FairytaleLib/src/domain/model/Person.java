package domain.model;

public abstract class Person {

	private String name;
	private String mail;

	public Person(String name, String mail) {
		this.name = name;
		this.mail = mail;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMail() {
		return this.mail;
	}

}
