package Alarming.Features;

import Firefighters.Firefighter;

import java.util.ArrayList;

public class TerminalArmed implements DTG53 {

    public TerminalArmed(ArrayList<Firefighter> firefighters, String sms){
        System.out.println("Terminal armed");
        sendSms(firefighters,  sms);
    }
 @Override
    public void sendSms(ArrayList<Firefighter> firefighters, String sms) {
            for (Firefighter firefighter : firefighters) {
                firefighter.sendSms(sms);
            }
    }
}
