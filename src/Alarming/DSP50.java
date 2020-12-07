package Alarming;

public class DSP50 {
    public AlarmType receiveAlarm(VFDUnit vfdUnit,String alarm){
        String[]splittedAlarm=alarm.split(";");
        if(vfdUnit.getUnitName().equals(splittedAlarm[0])){
            switch (splittedAlarm[1]){
                    case "ALARM" -> {return AlarmType.ALARM;}
                    case "TEST" -> {return AlarmType.TEST;}
                default -> {return AlarmType.UNKNOWN;}
            }
        }
        return AlarmType.ERROR;
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
