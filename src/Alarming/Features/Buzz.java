package Alarming.Features;

import Alarming.Siren;

public interface Buzz {
     void setAlarmSiren(Siren siren);
}

class CanBuzz implements  Buzz{

    @Override
    public void setAlarmSiren(Siren siren) {
        siren.setSiren(true);
        siren.buzz();
    }
}

class CantBuzz implements  Buzz{

    @Override
    public void setAlarmSiren(Siren siren) {
        siren.setSiren(false);
        System.out.println("Siren turned off.");
    }
}