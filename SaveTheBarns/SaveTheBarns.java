// Ashley Lindquist
// 01-16-19
// Save The Barns
// Collects user for info and contribution and displays grand totals


import java.io.*;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;



public class SaveTheBarns {
	
	// variables
	static String  iName;
	static String  iAddress;
	static String  iCity;
	static String  iState;
	static String  iZip;
	static double  cZip;
	static String  iParty;
	static String  iGender;
	static String  iContribution;
	static double  cContribution;
	
	static String  record;
	static Scanner myScanner;
	static PrintWriter pw;
	static NumberFormat nf;
	
	static int     cMenCtr = 0;
	static double  cMenTotal = 0;
	static double  cMenAvg = 0;
	static int     cWomenCtr = 0;
	static double  cWomenTotal = 0;
	static double  cWomenAvg = 0;
	static int     cDemoCtr = 0;
	static double  cDemoTotal = 0;
	static double  cDemoAvg = 0;
	static int     cRepubCtr = 0;
	static double  cRepubTotal = 0;
	static double  cRepubAvg = 0;
	static int     cIndCtr = 0;
	static double  cIndTotal = 0;
	static double  cIndAvg = 0;
	static int     cDemoMenCtr = 0;
	static double  cDemoMenTotal = 0;
	static double  cDemoMenAvg = 0;
	static int     cDemoWomenCtr = 0;
	static double  cDemoWomenTotal = 0;
	static double  cDemoWomenAvg = 0;
	static int     cRepubMenCtr = 0;
	static double  cRepubMenTotal = 0;
	static double  cRepubMenAvg = 0;
	static int     cRepubWomenCtr = 0;
	static double  cRepubWomenTotal = 0;
	static double  cRepubWomenAvg = 0;
	static int     cIndMenCtr  = 0;
	static double  cIndMenTotal = 0;
	static double  cIndMenAvg = 0;
	static int     cIndWomenCtr = 0;
	static double  cIndWomenTotal = 0;
	static double  cIndWomenAvg = 0;
	static int     cOverallCtr = 0;
	static double  cOverallTotal = 0;
	static double  cOverallAvg = 0;
	
	static String oMenAvg, oWomenAvg, oDemoAvg, oRepubAvg, oIndAvg, oDemoMenAvg, oDemoWomenAvg, oRepubMenAvg, oRepubWomenAvg, oIndMenAvg, oIndWomenAvg, oOverallAvg;
	
	static String oMenTotal, oWomenTotal, oDemoTotal, oRepubTotal, oIndTotal, oDemoMenTotal, oDemoWomenTotal, oRepubMenTotal, oRepubWomenTotal, oIndMenTotal, oIndWomenTotal, oOverallTotal;
	
	static String  oErrorMsg = "";
	static boolean partyValid = false;
	static boolean eof = false;
	static boolean valid = true;
	
	static LocalDate today = LocalDate.now();
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	

	
	
	
	public static void main(String[] args) {
					
		init();
		
		//loop until no more records
		while(!eof) {	
			
			validation();
			
			if (valid = true) {
				calcs();	
				input();
			}
			else {
				error();
				input();
			}
		}
		
		output();
		
		//close the print writer
		pw.close();
		
	}
	
	
		public static void init() {
		
		try {
			myScanner = new Scanner(new File("contributors.dat"));
			myScanner.useDelimiter(System.getProperty("line.separator"));
		} catch (FileNotFoundException e1) {
			System.out.println("File error");
			System.exit(1);
		}
		
		
		//initialize the PrintWriter object
		try {
			pw = new PrintWriter(new File ("error.prt"));
		} catch (FileNotFoundException e) {
			System.out.println("Output file error");
		}
		
		input();
	}
	
		
	
	public static void input() {
		String record;	//string used to hold entire record being read
		//as long as there are more records to be read
		if (myScanner.hasNext()) {
			record = myScanner.next();
			iName = record.substring(0,25);	     //file position 1 - 25
			iAddress = record.substring(25,50);	 //file position 26 - 50
			iCity = record.substring(50,65);     //file position 51 - 65
			iState = record.substring(65,68);    //file position 66 - 68
			iZip = record.substring(68,73);      //file position 69 - 73
			//cZip = Double.parseDouble(iZip);     
			iParty = record.substring(73,74);    //file position 73 - 74
			iGender = record.substring(74,75);   //file position 75 - 75
			iContribution = record.substring(75,82); //file position 76 - 82
			//cContribution = Double.parseDouble(iContribution);
		}
		else {
			eof=true;	//no more records so set eof to true
		}	
	}
	
	
	
	

	public static void calcs() {

		
		iParty = myScanner.next();
		
		switch(iParty) {
		
			case "D":
				cDemoCtr += 1;
				cOverallCtr +=1;
				cDemoTotal += cContribution;
				cOverallTotal += cContribution;
				if (iGender.equals("F")) {
					cDemoWomenCtr += 1;
					cWomenCtr += 1;
					cDemoWomenTotal += cContribution;
					cWomenTotal += cContribution;
				}
				else {
					cDemoMenCtr += 1;
					cMenCtr += 1;
					cDemoMenTotal += cContribution;
					cMenTotal += cContribution;
				}
				partyValid = true;
				break;
				
			case "I":
				cIndCtr += 1;
				cOverallCtr +=1;
				cIndTotal += cContribution;
				cOverallTotal += cContribution;
				if (iGender.equals("F")) {
					cIndWomenCtr += 1;
					cWomenCtr += 1;
					cIndWomenTotal += cContribution;
					cWomenTotal += cContribution;
				}
				else {
					cIndMenCtr += 1;
					cMenCtr += 1;
					cIndMenTotal += cContribution;
					cMenTotal += cContribution;
				}
				partyValid = true;
				break;
				
			case "R":
				cRepubTotal += cContribution;
				cOverallTotal += cContribution;
				cRepubCtr += 1;
				cOverallCtr +=1;
				if (iGender.equals("F")) {
					cRepubWomenCtr += 1;
					cWomenCtr += 1;
					cRepubWomenTotal += cContribution;
					cWomenTotal += cContribution;
				}
				else {
					cRepubMenCtr += 1;
					cMenCtr += 1;
					cRepubMenTotal += cContribution;
					cMenTotal += cContribution;
				}
				partyValid = true;
				break;
				
			default:
				partyValid = false;
				oErrorMsg = "Incorrect Party. Choose D, I, or R.";
		}
		
		
		
		
		// average calcs
		cMenAvg = cContribution / cMenCtr;
		cWomenAvg = cContribution / cWomenCtr;
		cDemoAvg = cContribution / cDemoCtr;
		cRepubAvg = cContribution / cRepubCtr;
		cIndAvg = cContribution / cIndCtr;
		cDemoMenAvg = cContribution / cDemoMenCtr;
		cDemoWomenAvg = cContribution / cDemoWomenCtr;
		cRepubMenAvg = cContribution / cRepubMenCtr;
		cRepubWomenAvg = cContribution / cRepubWomenCtr;
		cIndMenAvg = cContribution / cIndMenCtr;
		cIndWomenAvg = cContribution / cIndCtr;
		cOverallAvg = cContribution / cOverallCtr;
	}
	
	
	
	
	public static void validation() {
		
			if (iName.isEmpty()) {
				oErrorMsg = "Name is empty.";
				valid = false;
			}
		
			if (iAddress.isEmpty()) {
				oErrorMsg = "Address is empty.";
				valid = false;
			}
		
			if (iCity.isEmpty()) {
				oErrorMsg = "City is empty";
				valid = false;
		
				}
		
			if (iState.isEmpty()) {
				oErrorMsg = "State is empty";
				valid = false;
			
			}
		

			// CONTRIBUTION VALIDATION
			do {
				try {
		
					cContribution = Double.parseDouble(myScanner.next());
			
					if(cContribution < 0.01 || cContribution > 9999.99) {
						oErrorMsg = "Contribution should be between 0.01 and 9999.99.";
					}
				}
				catch (Exception e) {
					oErrorMsg = "Contribution should be between 0.01 and 9999.99.";
				}
			} while(cContribution < 0.01 || cContribution > 9999.99);
		
		
			// ZIP VALIDATION
			do {
				try {
		
					cZip = Double.parseDouble(myScanner.next());
			
					if(cZip > 99999 || cZip < 00001 ) {
						oErrorMsg = "Zip Code is invalid, is empty or contains letters.";
					}
				}
				catch (Exception e) {
					oErrorMsg = "Zip Code is invalid, is empty or contains letters.";
				}
			} while(cZip > 99999 || cZip > 00001);
	}
	
	
	
	
	
	public static void error() {
		
		pw.print(record + oErrorMsg);
	}
	
	
	
	
	public static void output() {
		
		// format average
		oMenAvg = nf.format(cMenAvg);
		oWomenAvg = nf.format(cWomenAvg);
		oDemoAvg = nf.format(cDemoAvg);
		oRepubAvg = nf.format(cRepubAvg);
		oIndAvg = nf.format(cIndAvg);
		oDemoMenAvg = nf.format(cDemoMenAvg);
		oDemoWomenAvg = nf.format(cDemoWomenAvg);
		oRepubMenAvg = nf.format(cRepubMenAvg);
		oRepubWomenAvg = nf.format(cRepubWomenAvg);
		oIndMenAvg = nf.format(cIndMenCtr);
		oIndWomenAvg = nf.format(cIndWomenAvg);
		oOverallAvg = nf.format(cOverallAvg);
		
		//format totals
		oMenTotal = nf.format(cMenTotal);
		oWomenTotal = nf.format(cWomenTotal);
		oDemoTotal = nf.format(cDemoTotal);
		oRepubTotal = nf.format(cRepubTotal);
		oIndTotal = nf.format(cIndTotal);
		oDemoMenTotal = nf.format(cDemoMenTotal);
		oDemoWomenTotal = nf.format(cDemoWomenTotal);
		oRepubMenTotal = nf.format(cRepubMenTotal);
		oRepubWomenTotal = nf.format(cRepubWomenTotal);
		oIndMenTotal = nf.format(cIndMenTotal);
		oIndWomenTotal = nf.format(cIndWomenTotal);
		oOverallTotal = nf.format(cOverallTotal);
		
		// print out to console
		System.out.format("%-6s%18%10s%7s%18s/n%30s%17", "Date:", today.format(dtf), "", "Company Title Line", "", "Report Name Line");
		System.out.format("%-5s%15s%5s%15s%5s%15s%7s", "Party", "", "Count", "", "Total", "", "Average");
		System.out.format("%-20s%25s%25s%25", "Men", cMenCtr, oMenTotal, oMenAvg);
		System.out.format("%-20s%25s%25s%25", "Women", cWomenCtr, oWomenTotal, oWomenAvg);
		System.out.format("%-20s%25s%25s%25", "Democrats", cDemoCtr, oDemoTotal, oDemoAvg);
		System.out.format("%-20s%25s%25s%25", "Republicans", cRepubCtr, oRepubTotal, oRepubAvg);
		System.out.format("%-20s%25s%25s%25", "Independents", cIndCtr, oIndTotal, oIndAvg);
		System.out.format("%-20s%25s%25s%25", "Democratic Men", cDemoMenCtr, oDemoMenTotal, oDemoMenAvg);
		System.out.format("%-20s%25s%25s%25", "Democratic Women", cDemoWomenCtr, oDemoWomenTotal, oDemoWomenAvg);
		System.out.format("%-20s%25s%25s%25", "Republican Men", cRepubMenCtr, oRepubMenTotal, oRepubMenAvg);
		System.out.format("%-20s%25s%25s%25", "Republican Women", cRepubWomenCtr, oRepubWomenTotal, oRepubWomenAvg);
		System.out.format("%-20s%25s%25s%25", "Independent Men", cIndMenCtr, oIndMenTotal, oIndMenAvg);
		System.out.format("%-20s%25s%25s%25", "Independent Women", cIndWomenCtr, oIndWomenTotal, oIndWomenAvg);
		System.out.format("%-20s%25s%25s%25", "Overall", cOverallCtr, oOverallTotal, oOverallAvg);
	
	}
}





