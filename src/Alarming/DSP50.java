package Alarming;

public class DSP50 {
    public AlarmType receiveAlarm(VFDUnit vfdUnit, String alarm) {
        String[] splittedAlarm = alarm.split(";");
        if (vfdUnit.getUnitName().equals(splittedAlarm[0])) {
            if (splittedAlarm[1].equals(vfdUnit.getAlarmCode())) {
                return AlarmType.ALARM;
            } else if (splittedAlarm[1].equals(vfdUnit.getTestCode())) {
                return AlarmType.TEST;
            } else {
                return AlarmType.UNKNOWN;
            }
        }
        return AlarmType.ERROR;
    }

    public void respond(Subject commandant, VFDUnit vfdUnit, ResponseCode responseCode) {

        StringBuilder CCIR_CODE = new StringBuilder();
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

        commandant.receiveResponse(CCIR_CODE.toString());
    }
}
