package Alarming.Features;

public class TestBlink implements DiodesBlinks {

    public TestBlink(){
        diodeState();
    }

    @Override
    public void diodeState() {
        System.out.println("|   OK   |  TEST  |  ALARM  |");
        System.out.println("|--------|--------|---------|");
        System.out.println("|  [  ]  |  [><]  |   [  ]  |");
    }
}
