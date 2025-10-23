import java.util.concurrent.ThreadLocalRandom;

public class Zwerge extends Charakter {

    public Zwerge(String name, int leben, boolean spezialFaehigkeitAktiv) {
        super(name, leben, spezialFaehigkeitAktiv);
    }

    @Override
    public void angreifen(Charakter gegner) {
        // Zuerst prüfen, ob der Angreifer selbst noch lebt
        if (getLeben() <= 0) {
            System.out.println(getName() + " ist besiegt und kann nicht mehr angreifen!\n");
            return; // Methode abbrechen
        }

        // Danach prüfen, ob der Gegner schon tot ist
        if (gegner.getLeben() <= 0) {
            System.out.println("Gegner " + gegner.getName() + " wurde bereits besiegt! Angriff nicht möglich.\n");
            return; // Methode abbrechen
        }

        // Angriffswert zwischen 15–25 Schaden
        int angriff = ThreadLocalRandom.current().nextInt(15, 25 + 1);

        if (isSpezialFaehigkeitAktiv()) {
            double chance = ThreadLocalRandom.current().nextDouble(0.0, 1.0); // Zufallszahl 0.0–1.0
            int basis = angriff;

            // Zwergenkopfnuss – Erfolg oder Fehlschlag je nach Lebenspunkten und Zufall
            if ((getLeben() <= 10 && chance < 0.7)
                    || (getLeben() <= 20 && chance < 0.5)
                    || (getLeben() <= 50 && chance < 0.3)) {
                angriff *= 2;
                System.out.println(getName() + " landet eine erfolgreiche Zwergenkopfnuss! (Basis: " + basis + ", verdoppelt auf " + angriff + ")");
            } else {
                angriff /= 2;
                System.out.println(getName() + " versucht eine Zwergenkopfnuss, aber sie misslingt! (Angriff halbiert auf " + angriff + ")");
            }
        } else {
            System.out.println(getName() + " greift an! (" + angriff + " Schaden)");
        }

        // Schaden zufügen
        gegner.schadenNehmen(angriff);

        // Wenn der Gegner jetzt besiegt ist, ausgeben
        if (gegner.getLeben() <= 0) {
            System.out.println(gegner.getName() + " wurde besiegt!\n");
        }
    }

    @Override
    public void spezialfaehigkeitAktivieren(Charakter charakter) {
        if (!isSpezialFaehigkeitAktiv() && getLeben() < 50) {
            setSpezialFaehigkeitAktiv(true);
            System.out.println(getName() + " aktiviert die Spezialfähigkeit 'Zwergenkopfnuss'!");
        } else if (isSpezialFaehigkeitAktiv()) {
            System.out.println(getName() + " hat 'Zwergenkopfnuss' bereits aktiviert!");
        } else {
            System.out.println(getName() + " kann 'Zwergenkopfnuss' nur unter 50 Lebenspunkten aktivieren!");
        }
    }

    @Override
    public void spezialfaehigkeitDeaktivieren() {
        if (isSpezialFaehigkeitAktiv()) {
            setSpezialFaehigkeitAktiv(false);
            System.out.println(getName() + " deaktiviert 'Zwergenkopfnuss'.");
        } else {
            System.out.println(getName() + " hat keine aktive Spezialfähigkeit.");
        }
    }
}
