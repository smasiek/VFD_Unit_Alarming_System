package Alarming;

import Alarming.Features.*;

public class TestState implements UnitState {

    VFDUnit vfdUnit;

    public TestState(VFDUnit vfdUnit){
        this.vfdUnit=vfdUnit;
    }

    public UnitState setState(){
        setTerminal();
        setAlarmSiren();
        diodeState();
        return this;
    }

    @Override
    public void setTerminal() {
        vfdUnit.setDTG53(new TerminalArmed(vfdUnit.getFirefighters(),"Test wysyłania SMS przez" +
                " terminal"));
    }


    @Override
    public void setAlarmSiren() {
        vfdUnit.setBuzz(new CanBuzz());
    }

    @Override
    public void diodeState() {
        vfdUnit.setDiodesBlinks(new TestBlink());
    }
}
