package Alarming;

import Firefighters.Firefighter;

import java.util.ArrayList;

public class DTG53 {
    private boolean armed;
    public DTG53(){
        armed =false;
    }

    public void setArmed(boolean dtg53State) {
        armed =dtg53State;
    }

    public void sendSms(ArrayList<Firefighter> firefighters,String sms) {
        for (Firefighter firefighter : firefighters) {
            firefighter.sendSms(sms);
        }
    }

    public boolean getArmed() {
        return armed;
    }
}
