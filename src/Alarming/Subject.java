package Alarming;

public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    ResponseCode notify(String CCIR_CODE);
    String getUnitName();
    void receiveResponse(String CCIR_CODE);
}
