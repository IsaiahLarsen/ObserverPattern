package program2;

import java.util.ArrayList;

public class LocalStocks implements Subject {
    private ArrayList observers;
    private ArrayList<Snap> snapList = new ArrayList();

    //constructor
    //initialize observers list
    public LocalStocks(){
        observers = new ArrayList();

    }

    //method to register a observer
    public void registerObserver(Observer o){
        observers.add(o);
        System.out.println("Observer added");
    }

    //method to remove an observer
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if(i>=0){
            observers.remove(i);
        }
        System.out.println("Observer removed.");
    }

    //call to notify observers of a change
    public void notifyObservers() {
        for(int i = 0; i < observers.size(); i++){
            Observer observer = (Observer)observers.get(i);
            observer.update(snapList);
        }

    }

    public void setSnap(ArrayList snapList) {
        this.snapList = snapList;
        notifyObservers();
    }


}
