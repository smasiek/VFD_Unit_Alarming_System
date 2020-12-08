package Alarming.Features;

import Alarming.DTG53;

public class TerminalUnarmed implements ArmableTerminal {

    public TerminalUnarmed(DTG53 dtg53){
        setTerminal(dtg53);
    }


    @Override
    public void setTerminal(DTG53 dtg53) {
        dtg53.setArmed(false);
        System.out.println("Terminal nieuzbrojony");
    }
}
