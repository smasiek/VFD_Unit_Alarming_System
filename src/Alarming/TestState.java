package Alarming;

import Alarming.Features.*;

public class TestState implements UnitState {

    VFDUnit vfdUnit;

    public TestState(VFDUnit vfdUnit){
        this.vfdUnit=vfdUnit;
    }

    public UnitState setState(){
        setTerminal();
        sendSMS();
        setAlarmSiren();
        diodeState();
        return this;
    }

    @Override
    public void setTerminal() {
        vfdUnit.setArmableTerminal(new TerminalArmed(vfdUnit.getDTG53()));
    }

    @Override
    public void sendSMS() {
        vfdUnit.setSendsSMS(new CanSendSMS(vfdUnit.getDTG53(),vfdUnit.getFirefighters(),"Test wysyłania SMS przez" +
                " terminal"));
    }

    @Override
    public void setAlarmSiren() {
        vfdUnit.setBuzz(new CanBuzz(vfdUnit.getSiren()));
    }

    @Override
    public void diodeState() {
        vfdUnit.setDiodesBlinks(new TestBlink());
        vfdUnit.getDiodesBlinks().diodeState();
    }
}
