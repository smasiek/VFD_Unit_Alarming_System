package Firefighters;

public class Firefighter implements IFirefighter {
    private String name;
    private String surname;
    private String phoneNumber;

    public Firefighter(String name, String surname, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void sendSms(String content) {
        System.out.println("Sending SMS to "+this.name+" "+this.surname+": "+content);
    }
    
}
