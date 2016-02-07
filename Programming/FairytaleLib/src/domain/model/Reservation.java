package domain.model;

import java.util.Date;
import java.util.Calendar;

public class Reservation {

	private Date date;

	private Person person;

	private Item item;

	public Reservation(Person person, Item item) {
		this.person = person;
		this.item = item;
		
		// Gets current date
		Date d = new Date();
		// Instantiates a calendar to manipulate the date object
		Calendar resdate = Calendar.getInstance();
		resdate.setTime(d);
		
		// Checks the item and person type to define the return date
		if(item instanceof Article) // Case : Article
		{
			// Add 14 days
			resdate.add(Calendar.DATE, 14);
			this.date = resdate.getTime();
		}
		else
		{
			if(item instanceof Cd || item instanceof Dvd) // Case : CD/DVD
			{
				Cd cd = (Cd)item;
				// We subtract one year to check if the CD/DVD is older than one year
				resdate.add(Calendar.YEAR, -1); 
				
				if(cd.getDate().before(resdate.getTime()))
				{
					if(person instanceof Student) 		 // Case-Old CD + Student
					{
						// Add back one year, then one month from now
						resdate.add(Calendar.YEAR, 1); 
						resdate.add(Calendar.MONTH, 1);
						this.date = resdate.getTime();
					}
					else						  		 // Case-Old CD + Lecturer
					{
						// Add back one year, then six months from now
						resdate.add(Calendar.YEAR, 1); 
						resdate.add(Calendar.MONTH, 6);
						this.date = resdate.getTime();
					}
					
				}
				else 							  		 // Case-Recent CD
				{
					// Add back one year, then 14 days from now
					resdate.add(Calendar.YEAR, 1); 
					resdate.add(Calendar.DATE, 14);
					this.date = resdate.getTime();
				}

			}
			else // Case : Book
			{
				if(person instanceof Student) 	  		 // Case Book-Student
				{
					// Add one month
					resdate.add(Calendar.MONTH, 1);
					this.date = resdate.getTime();
				}
				else 							  		 // Case Book-Lecturer
				{
					// Add 6 months
					resdate.add(Calendar.MONTH, 6);
					this.date = resdate.getTime();
				}

			}
			
		}
		
	}

	public Person getPerson() {
		return this.person;
	}

	public Item getItem() {
		return this.item;
	}
	
	public Date getDate() {
		return this.date;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
