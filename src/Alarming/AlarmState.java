package Alarming;

import Alarming.Features.AlarmBlink;
import Alarming.Features.CanBuzz;
import Alarming.Features.TerminalArmed;

public class AlarmState implements UnitState {

    private VFDUnit vfdUnit;

    public AlarmState(VFDUnit vfdUnit){
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
        vfdUnit.setDTG53(new TerminalArmed(vfdUnit.getFirefighters(),"Alarm!" +
                " Prepare yourself for action!"));
    }

    @Override
    public void setAlarmSiren() {
        vfdUnit.setBuzz(new CanBuzz());
    }

    @Override
    public void diodeState() {
        vfdUnit.setDiodesBlinks(new AlarmBlink());
    }
}
