package Observer;

public class StockObserver implements Observer {

	private double ibmPrice;
	private double aaplPrice;
	private double googPrice;
	
	private Subject stockGrabber;
	
	public StockObserver(Subject stockGrabber) {
		
		this.stockGrabber = stockGrabber;
		
		// add the observer to the subjects arraylist
		stockGrabber.register(this);
	}

	@Override
	public void update(double ibmPrice, double aaplPrice, double googPrice) {

		this.ibmPrice = ibmPrice;
		this.aaplPrice = aaplPrice;
		this.googPrice = googPrice;
		
		printThePrices();
		
	}
	
	public void printThePrices() {
		
		System.out.println("ibm : " + ibmPrice + 
				"\naapl : " + aaplPrice +
				"\ngoog : " + googPrice);
		
	}
		
}
