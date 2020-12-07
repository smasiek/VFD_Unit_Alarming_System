package Alarming.Features;

public interface DiodesBlinks {
    void diodeState();
}

class OkBlink implements DiodesBlinks{

    @Override
    public void diodeState() {
        System.out.println("|   OK   |  TEST  |  ALARM  |");
        System.out.println("|--------|--------|---------|");
        System.out.println("|  [><]  |  [  ]  |   [  ]  |");
    }
}

class TestBlink implements DiodesBlinks{

    @Override
    public void diodeState() {
        System.out.println("|   OK   |  TEST  |  ALARM  |");
        System.out.println("|--------|--------|---------|");
        System.out.println("|  [  ]  |  [><]  |   [  ]  |");
    }
}


class AlarmBlink implements DiodesBlinks{

    @Override
    public void diodeState() {
        System.out.println("|   OK   |  TEST  |  ALARM  |");
        System.out.println("|--------|--------|---------|");
        System.out.println("|  [  ]  |  [  ]  |   [><]  |");
    }
}

