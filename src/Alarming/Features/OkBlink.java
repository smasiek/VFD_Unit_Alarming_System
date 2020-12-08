package Alarming.Features;

public class OkBlink implements DiodesBlinks{
    public OkBlink(){
        diodeState();
    }
    @Override
    public void diodeState() {
        System.out.println("|   OK   |  TEST  |  ALARM  |");
        System.out.println("|--------|--------|---------|");
        System.out.println("|  [><]  |  [  ]  |   [  ]  |");
    }
}
