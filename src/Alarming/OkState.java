package Alarming;

public class OkState implements UnitState {

    VFDUnit vfdUnit;

    public OkState(VFDUnit vfdUnit){
        this.vfdUnit=vfdUnit;
    }

    @Override
    public void setTerminal(boolean terminalState) {
        System.out.println("Terminal nieuzbrojony, używanie niemożliwe");
    }

    @Override
    public void sendSMS() {
        System.out.println("Nie można wysłac SMS, terminal nieuzbrojony.");
    }

    @Override
    public void setAlarmSiren(boolean setSiren) {
        System.out.println("Syrena nieuzbrojona, nie mozna zmienic stanu");
    }

    @Override
    public void diodeState() {
        System.out.println("|   OK   |  TEST  |  ALARM  |");
        System.out.println("|--------|--------|---------|");
        System.out.println("|  [><]  |  [  ]  |   [  ]  |");

    }
}
