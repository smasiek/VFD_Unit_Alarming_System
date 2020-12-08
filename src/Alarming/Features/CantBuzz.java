package Alarming.Features;

public class CantBuzz implements  Buzz{

    public CantBuzz(){
        buzz();
    }

    @Override
    public void buzz() {
        System.out.println("Buzz turned off.");
    }
}
