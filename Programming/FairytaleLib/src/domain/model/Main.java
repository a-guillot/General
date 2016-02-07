package domain.model;

import java.util.Calendar;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		
		Date recent = new Date();
		Date old = new Date();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(recent);
		cal.set(2001, 9, 11);
		old = cal.getTime();
		
		
		
		Student s = new Student("s","s");
		Lecturer l = new Lecturer("l","l");
		
		Article a = new Article(1,"a","a","a");
		Book b = new Book(2,"b","b");
		
		// CD's and DVD's are equivalent
		Cd cOld = new Cd(3,"co","co",old);
		Cd cRecent = new Cd(4,"cr","cr",recent);
		
		Reservation r1 = new Reservation(s,a);
		Reservation r2 = new Reservation(s,b);
		Reservation r3 = new Reservation(s,cOld);
		Reservation r4 = new Reservation(s,cRecent);
		
		Reservation r5 = new Reservation(l,a);
		Reservation r6 = new Reservation(l,b);
		Reservation r7 = new Reservation(l,cOld);
		Reservation r8 = new Reservation(l,cRecent);
		
		System.out.println("Student-Article " + r1.getDate().toString());
		System.out.println("Student-Book " + r2.getDate().toString());
		System.out.println("Student-Old CD " + r3.getDate().toString());
		System.out.println("Student-Recent CD " + r4.getDate().toString());
		System.out.println("Lecturer-Article " + r5.getDate().toString());
		System.out.println("Lecturer-Book " + r6.getDate().toString());
		System.out.println("Lecturer-Old CD " + r7.getDate().toString());
		System.out.println("Lecturer-Recent CD " + r8.getDate().toString());
	}
}
