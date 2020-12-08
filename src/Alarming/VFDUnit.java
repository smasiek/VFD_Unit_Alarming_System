package Alarming;

import Alarming.Features.ArmableTerminal;
import Alarming.Features.Buzz;
import Alarming.Features.DiodesBlinks;
import Alarming.Features.SendsSMS;
import Firefighters.Firefighter;

import java.util.ArrayList;

public class VFDUnit implements IVFDUnit, Observer {

    Subject districtCommandant;

    DSP15 dsp15 = new DSP15();
    DSP50 dsp50 = new DSP50();
    DTG53 dtg53 = new DTG53();

    Siren siren = new Siren();

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

    ArmableTerminal armableTerminal;
    Buzz buzz;
    DiodesBlinks diodesBlinks;
    SendsSMS sendsSMS;


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

    public DTG53 getDTG53() {
        return this.dtg53;
    }

    public ArrayList<Firefighter> getFirefighters() {
        return firefighters;
    }

    public Siren getSiren() {
        return siren;
    }

    public ArmableTerminal getArmableTerminal() {
        return armableTerminal;
    }

    public void setArmableTerminal(ArmableTerminal armableTerminal) {
        this.armableTerminal = armableTerminal;
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

    public SendsSMS getSendsSMS() {
        return sendsSMS;
    }

    public void setSendsSMS(SendsSMS sendsSMS) {
        this.sendsSMS = sendsSMS;
    }
}
