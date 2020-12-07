package Alarming;

public interface UnitState {
    void setTerminalDTG53(boolean terminalState);
    void sendSMS();
    void setAlarmSiren(boolean setSiren);
    void diodeState();
}
