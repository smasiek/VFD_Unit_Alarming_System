package Alarming;

public class VFDUnit implements IVFDUnit, Observer {

    Subject districtCommandant;

    DSP15 dsp15 = new DSP15();
    DSP50 dsp50 = new DSP50();


    String unitName;
    String testCode;
    String alarmCode;

    public VFDUnit(String unitName, String testCode, String alarmCode, DistrictCommandantUnit districtCommandantUnit) {
        this.unitName = unitName;
        this.testCode = testCode;
        this.alarmCode = alarmCode;
        this.districtCommandant= districtCommandantUnit;
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


    @Override
    public void notify(ResponseCode responseCode) {
        dsp15.respond(districtCommandant,responseCode);
        //return ResponseCode.ERROR;
    }

}
