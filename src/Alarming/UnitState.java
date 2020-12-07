package Alarming;

public interface UnitState {
    void setTerminal(boolean terminalState);
    void sendSMS();
    void setAlarmSiren(boolean setSiren);
    void diodeState();
}
