package Alarming;

import java.util.ArrayList;

public class DistrictCommandantUnit extends VFDUnit implements Subject {

    ArrayList<Observer> vfdUnits = new ArrayList<>();

    public DistrictCommandantUnit(String unitName, String testCode, String alarmCode, DistrictCommandantUnit districtCommandantUnit) {
        super(unitName, testCode, alarmCode, districtCommandantUnit);
    }

    @Override
    public void addObserver(Observer observer) {
        vfdUnits.add(observer);
        System.out.println("Do listy obserwatorow dodano jednostke o nazwie: " + observer.getUnitName());
    }

    @Override
    public void removeObserver(Observer observer) {
        int index = vfdUnits.indexOf(observer);
        System.out.println("Usuwam obserwatora o id: " + index + ", nazwa usuwanej jednostki: " + observer.getUnitName() + "....");
        vfdUnits.remove(observer);
        System.out.println("Usunięto");
    }

    @Override
    public ResponseCode notify(String CCIR_CODE) {
        return null;
    }


    private void notifyObservers(String unit, AlarmType type) {
        if (unit.equals("all")) {
            for (Observer vfdUnit : vfdUnits) {
                dsp15.notify(vfdUnit, type);
            }
        } else {
            for (Observer vfdUnit : vfdUnits) {
                if (vfdUnit.getUnitName().equals(unit)) {
                    dsp15.notify(vfdUnit, type);
                }
            }
        }
    }

    public void notifyEveryUnit(AlarmType type){
        notifyObservers("all",type);
    }

    public void notifyUnit(String unit, AlarmType type){
        notifyObservers(unit,type);
    }

    public void receiveResponse(String CCIR_CODE){
        ResponseCode responseCode=dsp50.receiveResponse(CCIR_CODE);
    }
}
