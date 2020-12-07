package Alarming.Features;

import Alarming.DTG53;
import Alarming.VFDUnit;

public interface ArmableTerminal {
    void setTerminal(DTG53 dtg53);
}

class TerminalArmed implements ArmableTerminal {
    @Override
    public void setTerminal(DTG53 dtg53) {
        dtg53.setArmed(true);
    }
}

class TerminalUnarmed implements ArmableTerminal {
    @Override
    public void setTerminal(DTG53 dtg53) {
        dtg53.setArmed(false);
    }
}
