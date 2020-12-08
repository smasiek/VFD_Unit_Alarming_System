package Alarming;

import Alarming.Features.*;

public class OkState implements UnitState {

    VFDUnit vfdUnit;

    public OkState(VFDUnit vfdUnit){
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
        vfdUnit.setDTG53(new TerminalUnarmed(vfdUnit.getFirefighters(),"This text shouldn't be sent" ));
    }

    @Override
    public void setAlarmSiren() {
        vfdUnit.setBuzz(new CantBuzz());
    }

    @Override
    public void diodeState() {
        vfdUnit.setDiodesBlinks(new OkBlink());
    }
}
