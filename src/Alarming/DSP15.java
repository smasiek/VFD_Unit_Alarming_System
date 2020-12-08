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


    public ResponseCode receiveResponse(String response){

        String[]splittedAlarm=response.split(";");

        switch (splittedAlarm[1]) {
            case "TEST_OK" -> {
                System.out.println("Jednostka " + splittedAlarm[0]+" wykonała test");
                return ResponseCode.TEST_OK;
            }
            case "ALARM_OK" -> {
                System.out.println("Jednostka " + splittedAlarm[0]+" odebrala alarm i jedzie na akcje");
                return ResponseCode.ALARM_OK;
            }
        }
        System.out.println("Jednostka " + splittedAlarm[0]+" ma niedziałające urządzenie.");
        return ResponseCode.ERROR;
    }
}
