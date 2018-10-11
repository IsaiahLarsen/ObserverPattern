package program2;

import java.io.*;
import java.util.ArrayList;

//Class to handle Average price
public  class AverageSnap implements Observer, Display {
    private Subject localStocks;

    private ArrayList<Snap> snapList = new ArrayList();

    //Register as Observer
    //@params Subject
    public AverageSnap(Subject localStocks){
        this.localStocks = localStocks;
        localStocks.registerObserver(this);
    }

    //update list
    //@params ArrayList
    public void update(ArrayList snapList){
        this.snapList = snapList;
        display();
    }

    //Write Average to file
    //@params NONE
    public void display() {
        float total = 0;
        for(Snap s: snapList){
            total += s.getCurrentPrice();
        }

        total /= snapList.size();
        String writeToFile = snapList.get(0).getUpdateDate() + "Average: " + total;
        try {
            FileWriter fw = new FileWriter("AverageData.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(writeToFile);
            bw.newLine();

            bw.close();
        }catch (Exception e){
            System.out.println(e.getCause());
        }
    }
}



