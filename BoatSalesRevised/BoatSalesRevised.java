//Ashley Lindquist
//12-11-18
//Boat Sales
//Asks user for boat information, calculates subtotal, tax, and total sales.



	import java.text.NumberFormat;
	import java.util.Scanner;
	
	
public class BoatSalesRevised {
	
	// variables
	static double iBoatCost;
	static double iPrepCost;
	static double iMarkup;
	static double cMarkup;
	static double cAccessCost;
	static double cSubtotal;
	static double cTax;
	static double cTotalSales;
	static double cGTtotalSales = 0;
	static int    cGTsalesCtr = 0;
	static int    iQty;
	static String iBoatType;
	static String oBoatType;
	static String oBoatCost;
	static String iAccessType;
	static String oAccessType;
	static String oAccessCost;
	static String oPrepCost;
	static String oMarkup;
	static String oSubtotal;
	static String oTax;
	static String oTotalSales;
	static String oGTtotalSales;
	static char   Another = 'Y';
	static Scanner myScanner;
	static NumberFormat nf;	
	static boolean valid = true;
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		init();
		
		while (Another =='Y') {
		
		input();
		
		calcs();
		
		output();
	
			if (Another == 'N') {
					grandtotal();
			}
		}
		
		
	}

	
	

	private static void grandtotal() {
		// TODO Auto-generated method stub
		
		oGTtotalSales = nf.format(cGTtotalSales);
		
		
		System.out.format("%-23s%15s%n", "Grand Total Sales: ", oGTtotalSales);
		System.out.format("%-23s%15s%n", "Numer of Sales: ", cGTsalesCtr);
	}




	private static void input() {
		// TODO Auto-generated method stub
			
		do {	
			System.out.print("Enter Boat Type (B, P, C, S): ");
			iBoatType = myScanner.next();
		

			switch(iBoatType.toUpperCase()) {
				case "B":
					oBoatType = "Bass";
					cMarkup = .33;
					valid = true;
					break;
				case "P":
					oBoatType = "Pontoon";
					cMarkup = .25;
					valid = true;
					break;
				case "C":
					oBoatType = "Canoe";
					cMarkup = .20;
					valid = true;
					break;
				case "S":
					oBoatType = "Ski";
					cMarkup = .425;
					valid = true;
					break;
				default:
					valid = false;
					System.out.println("Choose Boat Type: B, P, C, or S. Try again");
				}
		} while (!valid);
			
		
		
		
		do {
			System.out.print("Enter Accessory Type (1, 2, 3): ");
			iAccessType = myScanner.next();
			
			switch(iAccessType) {
					case "1":
						oAccessType = "Electronics";
						cAccessCost = 5415.30;
						valid = true;
						break;
					case "2":
						oAccessType = "Ski Package";
						cAccessCost = 3980;
						valid = true;
						break;
					case "3":
						oAccessType = "Fishing Package";
						cAccessCost = 345.45;
						valid = true;
						break;
					default:
						valid = false;
						System.out.println("Access Type must be 1 - 3. Try again");

						
				}
			} while (!valid);
			
			
		
	
		do {
			try {
				System.out.print("Enter Quantity: ");
				iQty = Integer.parseInt(myScanner.next());
				
				if (iQty < 1 || iQty > 25) {
				System.out.println("Quantity must be 1 - 25, try again");
				}
			}
			catch (Exception e) {
			System.out.println("Quantity must be 1 - 25, try again");
			}
		} while(iQty < 1 || iQty > 25);
		
		// ------------------------------------------
		
		
		do {
			try {
		
				System.out.print("Enter Boat Cost: ");
				iBoatCost = Double.parseDouble(myScanner.next());
			
				if(iBoatCost < 2500 || iBoatCost > 150000) {
				System.out.println("Boat Cost must be 2,500 - 150,000, try again");
				}
			}
			catch (Exception e) {
				System.out.println("Boat Cost must be 2,500 - 150,000, try again");
			}
		} while(iBoatCost < 2500 || iBoatCost > 150000);
		
		// ------------------------------------------
		
		
		do {
			try {
		
				System.out.print("Enter Prep Cost: ");
				iPrepCost = Double.parseDouble(myScanner.next());
			
				if(iPrepCost < 100 || iPrepCost > 9999) {
				System.out.println("Prep Cost must be 100 - 9,999, try again");
				}
			}
			catch (Exception e) {
				System.out.println("Boat Cost must be 100 - 9,999, try again");
			}
		} while (iPrepCost < 100 || iPrepCost > 9999);
	}
	
	
	
	
	private static void calcs() {
		// TODO Auto-generated method stub
		
		cMarkup = cMarkup * iBoatCost;
		cSubtotal = iBoatCost + cAccessCost + iPrepCost + (cMarkup * iQty);
		cTax = cSubtotal * .06;
		cTotalSales = cSubtotal + cTax;
		// add to Grand Totals
		cGTtotalSales = cGTtotalSales + cTotalSales;
		cGTsalesCtr = cGTsalesCtr + 1;
	}
	


	
	private static void output() {
		// TODO Auto-generated method stub
		
		// nf.format Rounds?
		oBoatCost = nf.format(iBoatCost);
		oPrepCost = nf.format(iPrepCost);
		oAccessCost = nf.format(cAccessCost);
		oMarkup = nf.format(cMarkup);
		oSubtotal = nf.format(cSubtotal);
		oTax = nf.format(cTax);
		oTotalSales = nf.format(cTotalSales);
		
		System.out.println("---------------------------");
		
		System.out.format("%-23s%15s%n", "Boat Type: ", oBoatType);
		System.out.format("%-23s%15s%n", "Accessory Type: ", oAccessType);
		System.out.format("%-23s%15s%n", "Quantity: ", iQty);
		System.out.format("%-23s%15s%n", "Accessory Cost: ", oAccessCost);
		System.out.format("%-23s%15s%n", "Prep Cost: ", oPrepCost);
		System.out.format("%-23s%15s%n", "Boat Cost: ", oBoatCost);
		System.out.format("%-23s%15s%n", "Markup Amount: ", oMarkup);
		System.out.format("%-23s%15s%n", "Subtotal: " , oSubtotal);
		System.out.format("%-23s%15s%n", "Tax: ", oTax);
		System.out.format("%-23s%15s%n", "Total Sales: ", oTotalSales);
		
		System.out.println("----------------------------");
		System.out.println("Choose 'Y' to enter another boat.");
		System.out.println("Choose 'N' to view Grand Totals.");
		System.out.println("----------------------------");
		
		Another = myScanner.next().toUpperCase().charAt(0);
		
	}
	
	
	
	
	private static void init() {
		// TODO Auto-generated method stub
		
		// set scanner to the console
		myScanner = new Scanner(System.in);
				
		// change delimiter from blank space to Enter key
		// allow space in a string
		myScanner.useDelimiter(System.getProperty("line.separator"));
				
		// set formatter to use as currency format
		nf = NumberFormat.getCurrencyInstance(java.util.Locale.US);
			
	}
	
}