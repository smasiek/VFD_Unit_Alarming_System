package Alarming;

public interface UnitState {
    void setTerminal();
    void setAlarmSiren();
    void diodeState();
    UnitState setState();
}
