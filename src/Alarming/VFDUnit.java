package Alarming;

import Alarming.Features.DTG53;
import Alarming.Features.Buzz;
import Alarming.Features.DiodesBlinks;
import Alarming.Features.TerminalUnarmed;
import Firefighters.Firefighter;

import java.util.ArrayList;

public class VFDUnit implements IVFDUnit, Observer {

    Subject districtCommandant;

    DSP15 dsp15 = new DSP15();
    DSP50 dsp50 = new DSP50();

    ArrayList<Firefighter> firefighters = new ArrayList<>();

    String unitName;
    String testCode;
    String alarmCode;

    //States
    UnitState ok;
    UnitState alarmed;
    UnitState test;

    UnitState unitState;

    //Features
    DTG53 DTG53;
    Buzz buzz;
    DiodesBlinks diodesBlinks;


    protected VFDUnit() {

    }

    public VFDUnit(String unitName, String testCode, String alarmCode, DistrictCommandantUnit districtCommandantUnit) {
        this.unitName = unitName;
        this.testCode = testCode;
        this.alarmCode = alarmCode;
        this.districtCommandant = districtCommandantUnit;
        this.districtCommandant.addObserver(this);


        ok = new OkState(this);
        alarmed = new AlarmState(this);
        test = new TestState(this);

        unitState = ok.setState();
    }

    public void addFirefighter(Firefighter firefighter) {
        firefighters.add(firefighter);
    }

    private void setUnitState(UnitState unitState) {
        this.unitState = unitState.setState();
    }

    public String getUnitName() {
        return unitName;
    }

    @Override
    public void alarm(String toString) {
        AlarmType alarmType = dsp50.receiveAlarm(this, toString);
        ResponseCode responseCode = ResponseCode.ERROR;
        try {

            switch (alarmType) {
                case ALARM -> {
                    //Zmiana stanu na ALARM
                    setUnitState(alarmed);
                    responseCode = ResponseCode.ALARM_OK;
                }

                case TEST -> {
                    //Zmiana stanu na TEST
                    setUnitState(test);
                    responseCode = ResponseCode.TEST_OK;
                }
            }

        } catch (RuntimeException ex) {
            System.out.println("Jednostka: " +
                    getUnitName() + " ma zepsuty terminal. Sygnał nie został odpowiednio odebrany.");
            responseCode = ResponseCode.ERROR;
        }

        notify(responseCode);

    }

    public void setOkState() {
        setUnitState(ok);
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getTestCode() {
        return testCode;
    }

    public void setTestCode(String testCode) {
        this.testCode = testCode;
    }

    public String getAlarmCode() {
        return alarmCode;
    }

    public void setAlarmCode(String alarmCode) {
        this.alarmCode = alarmCode;
    }


    @Override
    public void notify(ResponseCode responseCode) {
        dsp50.respond(districtCommandant, this, responseCode);
    }


    public ArrayList<Firefighter> getFirefighters() {
        return firefighters;
    }

    public void setDTG53(DTG53 DTG53) {
        this.DTG53 = DTG53;
    }

    public Buzz getBuzz() {
        return buzz;
    }

    public void setBuzz(Buzz buzz) {
        this.buzz = buzz;
    }

    public DiodesBlinks getDiodesBlinks() {
        return diodesBlinks;
    }

    public void setDiodesBlinks(DiodesBlinks diodesBlinks) {
        this.diodesBlinks = diodesBlinks;
    }

}
