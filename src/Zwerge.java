import java.util.concurrent.ThreadLocalRandom;

public class Zwerge extends Charakter {


    public Zwerge(String name, int leben, boolean spezialFaehigkeitAktiv) {
        super(name, leben, spezialFaehigkeitAktiv);
    }




    @Override
    public void angreifen(Charakter gegner) {
        int angriff = ThreadLocalRandom.current().nextInt(15,25 +1);// 15-25 SChaden

        if (gegner.getLeben() <= 0)
        {
            System.out.println("Gegner wurde bereits besiegt! Angriff nicht möglich.\n");
            return;
        }
        if (isSpezialFaehigkeitAktiv()) {
            double chance = ThreadLocalRandom.current().nextDouble(0.0,1.0); // Zufallszahl 0.0 - 1.0 generieren lassen
            int basis = angriff;


            if ((getLeben() <= 10 && chance < 0.7) // Chatgpt generiert, Hilfe!!!
                    || (getLeben() <= 20 && chance < 0.5)
                    || (getLeben() <= 50 && chance < 0.3)) {
                angriff *= 2;
                System.out.println(getName() + " landet eine erfolgreiche Zwergenkopfnuss! (Angriff verdoppelt auf " + angriff + ")"); // wird ausgeführt, wenn Zwergenkopfnuss erfolgreich war
            } else {
                angriff /= 2;
                System.out.println(getName() + " versucht eine Zwergenkopfnuss, aber sie misslingt! (Angriff halbiert auf " + angriff + ")"); //  wird ausgeführt, wenn Zwergenkopfnuss fehlschlug
            }
        } else {
            System.out.println(getName() + " greift an! (" + angriff + " Schaden)"); // Wird ausgeführt, wenn keine Spezialfähigkeit aktiv ist
        }

        gegner.schadenNehmen(angriff);
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