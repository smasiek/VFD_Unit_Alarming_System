package Alarming.Features;

import Alarming.DTG53;
import Firefighters.Firefighter;

import java.util.ArrayList;

public class CantSendSMS implements  SendsSMS{

    public CantSendSMS(DTG53 dtg53, ArrayList<Firefighter> firefighters, String sms){
        sendSMS(dtg53,firefighters,sms);
    }

    @Override
    public void sendSMS(DTG53 dtg53, ArrayList<Firefighter> firefighters, String sms) {
        System.out.println("Nie można wysłac wiadomości - terminal nieuzbrojony.");
    }
}
