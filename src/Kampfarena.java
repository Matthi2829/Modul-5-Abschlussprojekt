import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Kampfarena {

    private Charakter rival1;
    private Charakter rival2;
    private Scanner scanner;

    public Kampfarena(Charakter rival1, Charakter rival2) {
        this.rival1 = rival1;
        this.rival2 = rival2;
    }

    public void kampfStarten()
    {
        Charakter aktuellerSpieler;
        Charakter gegner;

        if (ThreadLocalRandom.current().nextBoolean()) {
            aktuellerSpieler = rival1;
            gegner = rival2;
        } else {
            aktuellerSpieler = rival2;
            gegner = rival1;
        }

        System.out.println("Der Kampf zwischen " + rival1.getName() + " und " + rival2.getName() + "startet nun");
        System.out.println(aktuellerSpieler.getName() + " beginnt \n");

    }


}
