package lab5;

import Alarming.AlarmType;
import Alarming.DistrictCommandantUnit;
import Alarming.VFDUnit;
import Firefighters.Firefighter;

public class Lab5 {

    public static void main(String[] args) {
        // TODO code application logic here

        DistrictCommandantUnit districtCommandantUnit=new DistrictCommandantUnit("komendant","1","1");

        VFDUnit unit1=new VFDUnit("unit1","2","2",districtCommandantUnit);

        Firefighter firefighter1=new Firefighter("jan","kowal","1");
        Firefighter firefighter2=new Firefighter("jane","kowals","12");
        Firefighter firefighter3=new Firefighter("janek","kowalski","123");

        unit1.addFirefighter(firefighter1);
        unit1.addFirefighter(firefighter2);
        unit1.addFirefighter(firefighter3);

        VFDUnit unit2=new VFDUnit("unit2","3","3",districtCommandantUnit);

        Firefighter firefighter4=new Firefighter("ad","now","1");
        Firefighter firefighter5=new Firefighter("ada","nowa","12");
        Firefighter firefighter6=new Firefighter("adam","nowak","123");

        unit2.addFirefighter(firefighter4);
        unit2.addFirefighter(firefighter5);
        unit2.addFirefighter(firefighter6);

        districtCommandantUnit.notifyUnit("unit1", AlarmType.TEST);
        districtCommandantUnit.notifyEveryUnit(AlarmType.ALARM);



    }
    
}
