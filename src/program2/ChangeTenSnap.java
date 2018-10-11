package program2;

import java.io.*;
import java.util.ArrayList;


//Class to handle more than 10% change
public class ChangeTenSnap implements Observer {
    private Subject localStocks;
    private ArrayList<Snap> snapList = new ArrayList();

    //Register as an Observer
    //@params Subject
    public ChangeTenSnap(Subject localStocks){
        this.localStocks = localStocks;
        localStocks.registerObserver(this);
    }

    //Update method to update snaps list
    //@params ArrayList of snaps
    public void update(ArrayList snapList){
        this.snapList = snapList;
        display();
    }

    //Method to write data to file ChangeTen.txt
    //@params none
    public void display() {

        try {
            FileWriter fw = new FileWriter("ChangeTen.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(snapList.get(0).getUpdateDate());
            bw.newLine();

            //Iterate through the list
            for (Snap s : snapList) {
                if (s.getPercentChange() > 10.0) {
                    String writeToFile = s.getTicker() + " " + s.getCurrentPrice() +  " " + s.getPercentChange();
                    bw.write(writeToFile);
                    bw.newLine();
                }
            }
            bw.close();
        } catch (Exception e) {
            System.out.println(e.getCause());
        }

    }
}
