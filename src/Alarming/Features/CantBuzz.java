package Alarming.Features;

import Alarming.Siren;

public class CantBuzz implements  Buzz{

    public CantBuzz(Siren siren){
        setAlarmSiren(siren);
    }

    @Override
    public void setAlarmSiren(Siren siren) {
        siren.setSiren(false);
        System.out.println("Siren turned off.");
    }
}
