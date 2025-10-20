import java.util.concurrent.ThreadLocalRandom;

public class Speerkobold extends Charakter{

    public Speerkobold(String name, int leben, boolean spezialFaehigkeitAktiv) {
        super(name, leben, spezialFaehigkeitAktiv);
    }

    @Override
    public void angreifen(Charakter gegner) {
        int angriff = ThreadLocalRandom.current().nextInt(15, 21); // 15–20 Schaden

        if (isSpezialFaehigkeitAktiv()) {
            double chance = ThreadLocalRandom.current().nextDouble(0.0, 1.0);

            if ((getLeben() <= 10 && chance < 0.7)
                    || (getLeben() <= 20 && chance < 0.5)
                    || (getLeben() <= 50 && chance < 0.3)) {

                angriff += 5;
                System.out.println(getName() + " wirft einen tödlichen Giftspeer! (+5 Giftschaden, insgesamt " + angriff + ")");
            } else {

                System.out.println(getName() + " wirft einen Giftspeer, aber das Gift zeigt kaum Wirkung. (" + angriff + " Schaden)");
            }
        } else {
            System.out.println(getName() + " wirft einen Speer auf " + gegner.getName() + "! (" + angriff + " Schaden)");
        }

        gegner.schadenNehmen(angriff);
    }


    @Override
    public void spezialfaehigkeitAktivieren(Zwerge zwerg) {

    }

    @Override
    public void spezialfaehigkeitDeaktivieren() {

    }
}
