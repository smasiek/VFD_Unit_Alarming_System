package Alarming;

public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyEveryUnit(AlarmType type);
    void notifyUnit(String unit, AlarmType type);
    String getUnitName();
    void receiveResponse(String CCIR_CODE);
}
