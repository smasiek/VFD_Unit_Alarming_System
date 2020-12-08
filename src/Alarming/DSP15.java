package Alarming;

public class DSP15 {
    public void notify(Observer vfdUnit, AlarmType alarmType){
        StringBuilder CCIR_CODE=new StringBuilder();
        CCIR_CODE.append(vfdUnit.getUnitName());
        CCIR_CODE.append(";");

        switch (alarmType) {
            case TEST -> {
                CCIR_CODE.append(vfdUnit.getTestCode());
            }
            case ALARM -> {
                CCIR_CODE.append(vfdUnit.getAlarmCode());
            }
        }
        vfdUnit.alarm(CCIR_CODE.toString());
    }


    public ResponseCode receiveResponse(String response){

        String[]splittedAlarm=response.split(";");

        switch (splittedAlarm[1]) {
            case "TEST_OK" -> {
                System.out.println("Unit " + splittedAlarm[0]+" received TEST SIGNAL properly");
                return ResponseCode.TEST_OK;
            }
            case "ALARM_OK" -> {
                System.out.println("Unit " + splittedAlarm[0]+" received ALARM SIGNAL properly");
                return ResponseCode.ALARM_OK;
            }
        }
        System.out.println("Unit " + splittedAlarm[0]+" has broken terminal.");
        return ResponseCode.ERROR;
    }
}
