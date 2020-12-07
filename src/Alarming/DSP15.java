package Alarming;

public class DSP15 {
    public void notify(Observer vfdUnit, AlarmType alarmType){
        StringBuilder CCIR_CODE=new StringBuilder();
        CCIR_CODE.append(vfdUnit.getUnitName());
        CCIR_CODE.append(";");

        switch (alarmType) {
            case TEST -> {
                CCIR_CODE.append("TEST");
            }
            case ALARM -> {
                CCIR_CODE.append("ALARM");
            }
        }

        vfdUnit.alarm(CCIR_CODE.toString());
    }

    public void respond(Subject vfdUnit, ResponseCode responseCode){
        StringBuilder CCIR_CODE=new StringBuilder();
        CCIR_CODE.append(vfdUnit.getUnitName());
        CCIR_CODE.append(";");

        switch (responseCode) {
            case TEST_OK -> {
                CCIR_CODE.append("TEST_OK");
            }
            case ALARM_OK -> {
                CCIR_CODE.append("ALARM_OK");
            }
            case ERROR -> {
                CCIR_CODE.append("ERROR");
            }
        }

        vfdUnit.receiveResponse(CCIR_CODE.toString());
    }
}
