package Alarming.Features;

import Firefighters.Firefighter;

import java.util.ArrayList;

public class TerminalUnarmed implements DTG53 {

    public TerminalUnarmed(ArrayList<Firefighter> firefighters, String sms){
        System.out.println("Terminal unarmed");
        sendSms(firefighters,  sms);
    }

    @Override
    public void sendSms(ArrayList<Firefighter> firefighters, String sms) {
            System.out.println("Can't send SMS, terminal unarmed");
    }
}
