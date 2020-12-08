package Alarming;

public interface Observer {
    String getUnitName();
    String getTestCode();
    String getAlarmCode();
    void observe(Subject districtCommandantUnit);
    void stopObserving();
    void alarm(String toString);
}
