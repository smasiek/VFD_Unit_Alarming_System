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
        vfdUnit.setArmableTerminal(new TerminalUnarmed());
        vfdUnit.getArmableTerminal().setTerminal(vfdUnit.getDTG53());
    }

    @Override
    public void sendSMS() {
        vfdUnit.setSendsSMS(new CantSendSMS());
        //Poniższa linijka powinna sie nie wykonać i zwrócić na sout informacje o błedzie
        vfdUnit.getSendsSMS().sendSMS(vfdUnit.getDTG53(),vfdUnit.getFirefighters(),"Test wysyłania SMS przez" +
                " terminal");
    }

    @Override
    public void setAlarmSiren() {
        vfdUnit.setBuzz(new CantBuzz());
        vfdUnit.getBuzz().setAlarmSiren(vfdUnit.getSiren());
        //System.out.println("Syrena nieuzbrojona, nie mozna zmienic stanu");
    }

    @Override
    public void diodeState() {
        vfdUnit.setDiodesBlinks(new OkBlink());
        vfdUnit.getDiodesBlinks().diodeState();
    }
}
