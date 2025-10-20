import java.util.Random;

import java.util.concurrent.ThreadLocalRandom;

public class Drachen extends Charakter {

    public Drachen(String name, int leben, boolean spezialfaehigkeit) {
        super(name, leben, spezialfaehigkeit);
    }


    public void angreifen(Charakter gegner) {
        int angriff = ThreadLocalRandom.current().nextInt(20, 25 + 1); // 20-25

        if (isSpezialFaehigkeitAktiv()) {
            int malus = ThreadLocalRandom.current().nextInt(5, 10 + 1);
            angriff = Math.max(0, angriff - malus);
            System.out.println(getName() + " fliegt und verliert " + malus + " Angriffspunkte!");
        }

        gegner.schadenNehmen(angriff);
        System.out.println("Klauenangriff des " + getName() + ": " + angriff + " Schaden");
        System.out.println(gegner.getName() + " hat noch " + gegner.getLeben() + " Leben.\n");
    }


    public void spezialfaehigkeitAktivieren(Charakter charakter) {
        if (!isSpezialFaehigkeitAktiv()) {
            setSpezialFaehigkeitAktiv(true);
            setLeben(getLeben() + 10);
            System.out.println(getName() + " aktiviert die Spezialfähigkeit 'Fliegen'! (+10 Leben)");
        } else {
            System.out.println("Spezialfähigkeit 'Fliegen' ist bereits aktiv!");
        }
    }


    public void spezialfaehigkeitDeaktivieren() {
        if (isSpezialFaehigkeitAktiv()) {
            setSpezialFaehigkeitAktiv(false);
            setLeben(Math.max(0, getLeben() - 10));
            System.out.println(getName() + " deaktiviert 'Fliegen'. (-10 Leben)");
        } else {
            System.out.println("Spezialfähigkeit 'Fliegen' ist nicht aktiv!");
        }
    }
}
