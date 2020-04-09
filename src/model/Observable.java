package model;

public interface Observable {
    void notifyAllObservers();
    void attach(Observer var1);
}
