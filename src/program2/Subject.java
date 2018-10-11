package program2;

public interface Subject {
   void registerObserver(Observer o);
   void removeObserver(Observer o);
   void notifyObservers() throws Exception;
}
