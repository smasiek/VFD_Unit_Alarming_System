package Alarming;

import Alarming.Features.*;

public class OkState implements UnitState {

    VFDUnit vfdUnit;

    public OkState(VFDUnit vfdUnit){
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
        vfdUnit.setArmableTerminal(new TerminalUnarmed(vfdUnit.getDTG53()));

    }

    @Override
    public void sendSMS() {
        //Poniższa linijka powinna sie nie wykonać poprawnie i zwrócić na sout informacje o błedzie
        vfdUnit.setSendsSMS(new CantSendSMS(vfdUnit.getDTG53(),vfdUnit.getFirefighters(),"Test wysyłania SMS przez" +
                " terminal"));
    }

    @Override
    public void setAlarmSiren() {
        vfdUnit.setBuzz(new CantBuzz(vfdUnit.getSiren()));
    }

    @Override
    public void diodeState() {
        vfdUnit.setDiodesBlinks(new OkBlink());
    }
}
