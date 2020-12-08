package Alarming.Features;

import Alarming.DTG53;
import Firefighters.Firefighter;

import java.util.ArrayList;

public interface SendsSMS {
    void sendSMS(DTG53 dtg53, ArrayList<Firefighter> firefighters, String sms);
}

