import java.util.concurrent.ThreadLocalRandom;

public class Speerkobold extends Charakter {

    public Speerkobold(String name, int leben, boolean spezialFaehigkeitAktiv) {
        super(name, leben, spezialFaehigkeitAktiv);
    }

    @Override
    public void angreifen(Charakter gegner) {
        // Prüfen, ob der Angreifer lebt
        if (getLeben() <= 0) {
            System.out.println(getName() + " ist besiegt und kann nicht mehr angreifen!\n");
            return;
        }

        // Prüfen, ob der Gegner schon tot ist
        if (gegner.getLeben() <= 0) {
            System.out.println("Gegner " + gegner.getName() + " wurde bereits besiegt! Angriff nicht möglich.\n");
            return;
        }

        // Angriffswert bestimmen (15–20)
        int angriff = ThreadLocalRandom.current().nextInt(15, 21); // inkl. 20

        // Angriff abhängig von Spezialfähigkeit
        if (isSpezialFaehigkeitAktiv()) {
            double chance = ThreadLocalRandom.current().nextDouble(0.0, 1.0);

            if ((getLeben() <= 10 && chance < 0.7)
                    || (getLeben() <= 20 && chance < 0.5)
                    || (getLeben() <= 50 && chance < 0.3)) {

                angriff += 5; // Spezialfähigkeit aktiv → +5 Schaden
                System.out.println(getName() + " wirft einen tödlichen Giftspeer! (+5 Giftschaden, insgesamt " + angriff + ")");
            } else {
                System.out.println(getName() + " wirft einen Giftspeer, aber das Gift zeigt kaum Wirkung. (" + angriff + " Schaden)");
            }
        } else {
            System.out.println(getName() + " wirft einen Speer auf " + gegner.getName() + "! (" + angriff + " Schaden)");
        }

        // Schaden anwenden
        gegner.schadenNehmen(angriff);

        // Siegmeldung falls Gegner besiegt
        if (gegner.getLeben() <= 0) {
            System.out.println(gegner.getName() + " wurde besiegt!\n");
        }
    }

    @Override
    public void spezialfaehigkeitAktivieren(Charakter charakter) {
        if (!isSpezialFaehigkeitAktiv()) {
            setSpezialFaehigkeitAktiv(true);
            setLeben(getLeben() + 15);
            System.out.println(getName() + " aktiviert die Spezialfähigkeit 'Giftpfeil'! (+15 Leben)");
        } else {
            System.out.println("Spezialfähigkeit 'Giftpfeil' ist bereits aktiv!");
        }
    }

    @Override
    public void spezialfaehigkeitDeaktivieren() {
        if (isSpezialFaehigkeitAktiv()) {
            setSpezialFaehigkeitAktiv(false);
            setLeben(Math.max(0, getLeben() - 15));
            System.out.println(getName() + " deaktiviert 'Giftpfeil'. (-15 Leben)");
        } else {
            System.out.println("Spezialfähigkeit 'Giftpfeil' ist nicht aktiv!");
        }
    }
}
