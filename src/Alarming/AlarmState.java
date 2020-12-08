package Alarming;

import Alarming.Features.AlarmBlink;
import Alarming.Features.CanBuzz;
import Alarming.Features.CanSendSMS;
import Alarming.Features.TerminalArmed;

public class AlarmState implements UnitState {

    VFDUnit vfdUnit;

    public AlarmState(VFDUnit vfdUnit){
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
        vfdUnit.setSendsSMS(new CanSendSMS(vfdUnit.getDTG53(),vfdUnit.getFirefighters(),"Alarm pożarniczy!" +
                " Przygotuj się do akcji!"));
    }

    @Override
    public void setAlarmSiren() {
        vfdUnit.setBuzz(new CanBuzz(vfdUnit.getSiren()));
    }

    @Override
    public void diodeState() {
        vfdUnit.setDiodesBlinks(new AlarmBlink());
    }
}
