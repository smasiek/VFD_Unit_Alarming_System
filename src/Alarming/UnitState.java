package Alarming;

public interface UnitState {
    void setTerminal();
    void sendSMS();
    void setAlarmSiren();
    void diodeState();
    UnitState setState();
}
