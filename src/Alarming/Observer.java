package Alarming;

public interface Observer {
    String getUnitName();
    String getTestCode();
    String getAlarmCode();
    void observe(Subject districtCommandant);
    void stopObserving();
    void alarm(String toString);
}
