package Alarming;

public class Siren {
    boolean turnedOn;

    public Siren(){
        turnedOn=false;
    }

    public void setSiren(boolean turnedOn) {
        this.turnedOn = turnedOn;
    }
    public void buzz(){
        System.out.println("Bzzzzzzzzzzzzzzzzzzzzzzzzz");
    }

}
