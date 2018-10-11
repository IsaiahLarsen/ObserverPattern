package program2;

import java.io.*;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		LocalStocks localStocks = new LocalStocks();

		//add observers
		AverageSnap averageSnap = new AverageSnap(localStocks);
		ChangeTenSnap changeTenSnap = new ChangeTenSnap(localStocks);
		SelectionsSnap selectionsSnap = new SelectionsSnap(localStocks);

		//Get snapShots
		getSnaps(localStocks);

		//remove observers
		localStocks.removeObserver(averageSnap);
		localStocks.removeObserver(changeTenSnap);
		localStocks.removeObserver(selectionsSnap);

	}


	//method to open a read a Stocks file
	//@params a LocalStocks obj
	public static void getSnaps(LocalStocks localStocks) throws IOException {

		//Local Vars
		String strLine;
		String name = "";
		String temp;
		String[] data;
		int lineNumber = 1;
		int size = 0;
		String regex = "\\s+";
		int totalSize;
		boolean incompleteData = false;
		ArrayList snaps = new ArrayList();

		//open file for reading
		FileInputStream fstream = new FileInputStream("Ticker.dat");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		//Read File Line By Line
		while ((strLine = br.readLine()) != null) {
			//if blank line update snaps and reset the List
			if (strLine.compareTo("") == 0) {
				localStocks.setSnap(snaps);
				snaps = new ArrayList();
				strLine= br.readLine();
			}
			Snap snap = new Snap();
			//Check to see if it is the update date
			if (strLine.startsWith("Last")) {
				snap.setUpdateDate(strLine);
				strLine = br.readLine();
			}
			data = strLine.split(regex);
			size = data.length - 1;
			//Catch any data that is invalid or missing and skip that line
			try {
				snap.setRatio(Float.parseFloat(data[size]));
				snap.setWeekLow(Float.parseFloat(data[--size]));
				snap.setWeekHigh(Float.parseFloat(data[--size]));
				snap.setYearToDateChange(Float.parseFloat(data[--size]));
				snap.setPercentChange(Float.parseFloat(data[--size]));
				snap.setDollarChange(Float.parseFloat(data[--size]));
				snap.setCurrentPrice(Float.parseFloat(data[--size]));
				snap.setTicker(data[--size]);
			} catch (Exception e) {
				System.out.println("incomplete data @ line number: " + lineNumber);
				incompleteData = true;
				lineNumber++;
			}

			//If all data is there the rest is the company name
			if (!incompleteData) {
				totalSize = size;
				for (int i = 0; i < totalSize; i++) {
					temp = data[--size];
					name = temp + " " + name;
				}
				snap.setCompany(name);
				name = "";
				snaps.add(snap);
				lineNumber++;
			}

			//reset boolean
			incompleteData = false;

		}
		//Close the File
		fstream.close();
	}//End of method
}//End of class

