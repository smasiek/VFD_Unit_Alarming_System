package Alarming;

public class TestState implements UnitState {

    VFDUnit vfdUnit;

    public TestState(VFDUnit vfdUnit){
        this.vfdUnit=vfdUnit;
    }

    @Override
    public void setTerminalDTG53(boolean terminalState) {
        vfdUnit.getDTG53().setArmed(terminalState);
    }

    @Override
    public void sendSMS() {
        if(vfdUnit.getDTG53().getArmed()) {
            String sms = "Test wysylania wiadomości SMS z terminala DTG53";
            vfdUnit.getDTG53().sendSms(vfdUnit.getFirefighters(), sms);
        }else{
            System.out.println("Wysłanie wiadomosci niemożliwe. Terminal nieuzbrojony");
        }
    }

    @Override
    public void setAlarmSiren(boolean setSiren) {
        vfdUnit.getSiren().setSiren(setSiren);
    }

    @Override
    public void diodeState() {
        System.out.println("|   OK   |  TEST  |  ALARM  |");
        System.out.println("|--------|--------|---------|");
        System.out.println("|  [  ]  |  [><]  |   [  ]  |");
    }
}
