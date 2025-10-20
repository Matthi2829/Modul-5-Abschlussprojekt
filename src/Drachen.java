import java.util.Random;

public class Drachen extends Charakter {
    private Random rand = new Random();

    public Drachen(String name, int leben, boolean Spezialfaehigkeit) {
        super(name, leben, Spezialfaehigkeit);

    }

    public void angreifen(Charakter gegner) {
        int angriff = rand.nextInt(6) + 20; //gibt eine Zahl von 1-5 aus und dann + 20

        if (isSpezialFaehigkeitAktiv()) {
            int malus = rand.nextInt(6) + 5;
            angriff -= malus;

            System.out.println(getName() + " greift aus der Luft aus (Malus):" + malus);
        } else {
            System.out.println(getName() + " greift mit Feueratem an!");
        }


    }

}
