package Alarming.Features;

public class AlarmBlink implements DiodesBlinks{
    public AlarmBlink(){
        diodeState();
    }
    @Override
    public void diodeState() {
        System.out.println("|   OK   |  TEST  |  ALARM  |");
        System.out.println("|--------|--------|---------|");
        System.out.println("|  [  ]  |  [  ]  |   [><]  |");
    }
}
