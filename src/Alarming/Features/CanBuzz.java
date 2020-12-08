package Alarming.Features;

public class CanBuzz implements  Buzz{

    public CanBuzz(){
        buzz();
    }
    @Override
    public void buzz() {
        System.out.println("Bzzzzzzzzzzzzzzzzzzzzzzzzz");
    }
}
