package Alarming;

import java.util.ArrayList;

public class DistrictCommandant implements Subject {

    private ArrayList<Observer> vfdUnits = new ArrayList<>();
    private DSP15 dsp15 = new DSP15();
    private String unitName;

    public DistrictCommandant(String unitName) {
        this.unitName = unitName;
    }

    @Override
    public void addObserver(Observer observer) {
        vfdUnits.add(observer);
        System.out.println("Commandant: "+getUnitName()+" has another unit called: " + observer.getUnitName());
    }

    @Override
    public void removeObserver(Observer observer) {
        int index = vfdUnits.indexOf(observer);
        System.out.println("Deleting unit with id: " + index + ", unit name: " + observer.getUnitName() + "....");
        vfdUnits.remove(observer);
        System.out.println("Deleted");
    }

    @Override
    public String getUnitName() {
        return unitName;
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
        ResponseCode responseCode=dsp15.receiveResponse(CCIR_CODE);
    }
}
