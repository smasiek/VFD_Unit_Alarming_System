package lab5;

import Alarming.*;
import Firefighters.Firefighter;

public class Lab5 {

    public static void main(String[] args) {
        Subject districtCommandantUnit=new DistrictCommandantUnit("komendant");

        System.out.println("---------------------------------------------");
        VFDUnit unit1=new VFDUnit("unit1","TEST","Alarm");
        System.out.println("---------------------------------------------");
        unit1.observe(districtCommandantUnit);


        Firefighter firefighter1=new Firefighter("jan","kowal","1");
        Firefighter firefighter2=new Firefighter("jane","kowals","12");
        Firefighter firefighter3=new Firefighter("janek","kowalski","123");

        unit1.addFirefighter(firefighter1);
        unit1.addFirefighter(firefighter2);
        unit1.addFirefighter(firefighter3);

        System.out.println("---------------------------------------------");
        VFDUnit unit2=new VFDUnit("unit2","TEScik","Aaalaaarm");
        System.out.println("---------------------------------------------");
        unit2.observe(districtCommandantUnit);
        System.out.println("---------------------------------------------");

        Firefighter firefighter4=new Firefighter("ad","now","1");
        Firefighter firefighter5=new Firefighter("ada","nowa","12");
        Firefighter firefighter6=new Firefighter("adam","nowak","123");

        unit2.addFirefighter(firefighter4);
        unit2.addFirefighter(firefighter5);
        unit2.addFirefighter(firefighter6);


        System.out.println("---------------------------------------------");
        System.out.println("Test single unit");
        System.out.println("---------------------------------------------");
        districtCommandantUnit.notifyUnit("unit1", AlarmType.TEST);

        //Zmiana stanu jako oddzielna metoda bo odpowiedz Response codem wcale nie oznacza zakończenia przygotowań
        //do wyruszenia z akcją ratunkową i wyłączeniem alarmu.
        System.out.println("---------------------------------------------");
        unit1.setOkState();
        System.out.println("---------------------------------------------");
        System.out.println("Alarm every unit");
        System.out.println("---------------------------------------------");
        districtCommandantUnit.notifyEveryUnit(AlarmType.ALARM);
        System.out.println("---------------------------------------------");
        unit1.setOkState();
        System.out.println("---------------------------------------------");
        unit2.setOkState();
        System.out.println("---------------------------------------------");
        unit1.stopObserving();



    }
    
}
