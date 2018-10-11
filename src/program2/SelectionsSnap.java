package program2;

import java.io.*;
import java.util.ArrayList;

public class SelectionsSnap implements Observer {
    private Subject localStocks;
    private ArrayList<Snap> snapList = new ArrayList();

    public SelectionsSnap(Subject localStocks) {
        this.localStocks = localStocks;
        localStocks.registerObserver(this);
    }

    public void update(ArrayList snapList) {
        this.snapList = snapList;
        display();
    }


    public void display() {
        // only write these tickers ALL, BA, BC, GBEL, KFT, MCD, TR, WAG
        try {
            FileWriter fw = new FileWriter("Selections.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(snapList.get(0).getUpdateDate());
            bw.newLine();

            for (Snap s : snapList) {
                if (s.getTicker().compareTo("ALL") == 0 || s.getTicker().compareTo("BA") == 0 || s.getTicker().compareTo("BC") == 0 || s.getTicker().compareTo("GBEL") == 0
                || s.getTicker().compareTo("KFT") == 0 || s.getTicker().compareTo("MCD") == 0 || s.getTicker().compareTo("TR") == 0 || s.getTicker().compareTo("WAG") == 0) {
                    String writeToFile = s.getCompany() + " " + s.getTicker() + " " + s.getCurrentPrice() + " " + s.getDollarChange() + " " + s.getPercentChange() +
                            " " + s.getYearToDateChange() + " " + s.getWeekHigh() + " " + s.getWeekLow() + " " + s.getRatio();
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

