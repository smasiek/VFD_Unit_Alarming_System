package Alarming.Features;

import Alarming.DTG53;

public class TerminalArmed implements ArmableTerminal {

    public TerminalArmed(DTG53 dtg53){
        setTerminal(dtg53);
    }

    @Override
    public void setTerminal(DTG53 dtg53) {
        dtg53.setArmed(true);
        System.out.println("Terminal uzbrojony");
    }
}
