package Alarming.Features;

import Alarming.Siren;

public class CanBuzz implements  Buzz{

    public CanBuzz(Siren siren){
        setAlarmSiren(siren);
    }

    @Override
    public void setAlarmSiren(Siren siren) {
        siren.setSiren(true);
        siren.buzz();
    }
}
