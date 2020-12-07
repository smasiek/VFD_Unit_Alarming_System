package Alarming.Features;

import Alarming.DTG53;
import Firefighters.Firefighter;

import java.util.ArrayList;

public interface SendsSMS {
    void sendSMS(DTG53 dtg53, ArrayList<Firefighter> firefighters, String sms);
}

class CanSendSMS implements  SendsSMS{
    @Override
    public void sendSMS(DTG53 dtg53, ArrayList<Firefighter> firefighters, String sms) {
        if(dtg53.getArmed()) {
            dtg53.sendSms(firefighters, sms);
        }else{
            System.out.println("Wysłanie wiadomosci niemożliwe. Terminal nieuzbrojony");
        }
    }
}

class CantSendSMS implements  SendsSMS{
    @Override
    public void sendSMS(DTG53 dtg53, ArrayList<Firefighter> firefighters, String sms) {
        System.out.println("Nie można wysłac wiadomości.\nJednostka nie jest zaalarmowana ani testowana");
    }
}
