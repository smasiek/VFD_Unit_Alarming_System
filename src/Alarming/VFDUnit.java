package Alarming;

import Firefighters.Firefighter;

import java.util.ArrayList;

public class VFDUnit implements IVFDUnit, Observer {

    Subject districtCommandant;

    DSP15 dsp15 = new DSP15();
    DSP50 dsp50 = new DSP50();
    DTG53 dtg53 = new DTG53();

    Siren siren =new Siren();

    ArrayList<Firefighter> firefighters=new ArrayList<>();

    String unitName;
    String testCode;
    String alarmCode;

    //States
    UnitState ok;
    UnitState alarmed;
    UnitState test;

    UnitState unitState;


    public VFDUnit(String unitName, String testCode, String alarmCode, DistrictCommandantUnit districtCommandantUnit) {
        this.unitName = unitName;
        this.testCode = testCode;
        this.alarmCode = alarmCode;
        this.districtCommandant= districtCommandantUnit;

        ok=new OkState(this);
        alarmed=new AlarmState(this);
        test=new TestState(this);

        unitState=ok;
    }

    public void addFirefighter(Firefighter firefighter){
        firefighters.add(firefighter);
    }

    private void setUnitState(UnitState unitState){
        this.unitState=unitState;
    }

    public void setTerminalDTG53(boolean dtg53State){
        dtg53.setArmed(dtg53State);
    }

    public void sendSMS(String sms) {
        dtg53.sendSms(firefighters,sms);
    }

    public void alarmSiren(boolean setSiren){
        siren.setSiren(setSiren);
    }

    public void diodeState(){
        System.out.println("|   OK   |  TEST  |  ALARM  |");
        System.out.println("|--------|--------|---------|");
        System.out.println("|  [><]  |  [  ]  |   [  ]  |");
    }

    public String getUnitName() {
        return unitName;
    }

    @Override
    public void alarm(String toString) {
        //TODO zaimplementować metody do zmiany stanu i strategii
        AlarmType alarmType=dsp50.receiveAlarm(this,toString);
        ResponseCode responseCode;
        switch (alarmType){
            case ALARM -> {
                //Zmiana stanu na ALARM
                responseCode=ResponseCode.ALARM_OK;
            }

            case TEST -> {
                //Zmiana stanu na TEST
                responseCode=ResponseCode.TEST_OK;
            }

            case ERROR -> {
                System.out.println("Sygnał odebrany przez jednostkę: "+
                        getUnitName()+" był skierowany do innej jednostki");
                responseCode=ResponseCode.ERROR;
            }

            default ->  {
                System.out.println("Jednostka "+getUnitName()+": Odebrano nieznaną komende!");
                responseCode=ResponseCode.ERROR;
            }
        }
        notify(responseCode);
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

    public UnitState getOk() {
        return ok;
    }

    public UnitState getAlarmed() {
        return alarmed;
    }

    public UnitState getTest() {
        return test;
    }

    @Override
    public void notify(ResponseCode responseCode) {
        dsp15.respond(districtCommandant,responseCode);
        //return ResponseCode.ERROR;
    }

    public DTG53 getDTG53() {
        return this.dtg53;
    }

    public ArrayList<Firefighter> getFirefighters(){
        return firefighters;
    }

    public Siren getSiren() {
        return siren;
    }
}
