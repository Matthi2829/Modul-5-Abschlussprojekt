import java.util.concurrent.ThreadLocalRandom;

public class Zwerge extends Charakter {


    public Zwerge(String name, int leben, boolean spezialFaehigkeitAktiv) {
        super(name, leben, spezialFaehigkeitAktiv);
    }

    @Override
    public void angreifen(Charakter gegner) {
        int angriff = ThreadLocalRandom.current().nextInt(15,25 +1);

        if (isSpezialFaehigkeitAktiv()) {
            double chance = ThreadLocalRandom.current().nextDouble(0.0,1.0);
            int basis = angriff;


            if ((getLeben() <= 10 && chance < 0.7)
                    || (getLeben() <= 20 && chance < 0.5)
                    || (getLeben() <= 50 && chance < 0.3)) {
                angriff *= 2;
                System.out.println(getName() + " landet eine erfolgreiche Zwergenkopfnuss! (Angriff verdoppelt auf " + angriff + ")");
            } else {
                angriff /= 2;
                System.out.println(getName() + " versucht eine Zwergenkopfnuss, aber sie misslingt! (Angriff halbiert auf " + angriff + ")");
            }
        } else {
            System.out.println(getName() + " greift an! (" + angriff + " Schaden)");
        }

        gegner.schadenNehmen(angriff);
    }

    @Override
    public void spezialfaehigkeitAktivieren(Zwerge zwerg) {
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
    }
}