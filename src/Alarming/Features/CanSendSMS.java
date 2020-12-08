package Alarming.Features;

import Alarming.DTG53;
import Firefighters.Firefighter;

import java.util.ArrayList;

public class CanSendSMS implements  SendsSMS{

    public CanSendSMS(DTG53 dtg53, ArrayList<Firefighter> firefighters, String sms){
        sendSMS(dtg53,firefighters,sms);
    }


    @Override
    public void sendSMS(DTG53 dtg53, ArrayList<Firefighter> firefighters, String sms) {
        if(dtg53.getArmed()) {
            dtg53.sendSms(firefighters, sms);
        }else{
            System.out.println("Wysłanie wiadomosci niemożliwe. Terminal nieuzbrojony");
        }
    }
}
