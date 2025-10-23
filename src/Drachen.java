import java.util.concurrent.ThreadLocalRandom;

public class Drachen extends Charakter {

    public Drachen(String name, int leben, boolean spezialfaehigkeit) {
        super(name, leben, spezialfaehigkeit);
    }

    @Override
    public void angreifen(Charakter gegner) {
        // Überprüfen, ob der Drache lebt
        if (getLeben() <= 0) {
            System.out.println(getName() + " ist besiegt und kann nicht mehr angreifen!\n");
            return;
        }

        // Überprüfen, ob der Gegner noch lebt
        if (gegner.getLeben() <= 0) {
            System.out.println("Gegner " + gegner.getName() + " wurde bereits besiegt! Angriff nicht möglich.\n");
            return;
        }

        // Angriffswert zufällig bestimmen (20–25)
        int angriff = ThreadLocalRandom.current().nextInt(20, 26);

        // Falls Spezialfähigkeit aktiv → Malus berechnen
        if (isSpezialFaehigkeitAktiv()) {
            int malus = ThreadLocalRandom.current().nextInt(5, 11); // 5–10
            angriff = Math.max(0, angriff - malus);
            System.out.println(getName() + " fliegt und verliert " + malus + " Angriffspunkte!");
        }

        // Angriff ausführen
        gegner.schadenNehmen(angriff);
        System.out.println("Klauenangriff des " + getName() + ": " + angriff + " Schaden");
        System.out.println(gegner.getName() + " hat noch " + gegner.getLeben() + " Leben.\n");

        // Siegmeldung
        if (gegner.getLeben() <= 0) {
            System.out.println(gegner.getName() + " wurde besiegt!\n");
        }
    }

    @Override
    public void spezialfaehigkeitAktivieren(Charakter charakter) {
        if (!isSpezialFaehigkeitAktiv()) {
            setSpezialFaehigkeitAktiv(true);
            setLeben(getLeben() + 10);
            System.out.println(getName() + " aktiviert die Spezialfähigkeit 'Fliegen'! (+10 Leben)");
        } else {
            System.out.println("Spezialfähigkeit 'Fliegen' ist bereits aktiv!");
        }
    }

    @Override
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
