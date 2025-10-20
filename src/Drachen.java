import java.util.concurrent.ThreadLocalRandom;

public class Drachen extends Charakter {


    public Drachen(String name, int leben, boolean Spezialfaehigkeit) {
        super(name, leben, Spezialfaehigkeit);

    }

    public void angreifen(Charakter gegner) {
        int angriff = ThreadLocalRandom.current().nextInt(20, 25 + 1);

        gegner.schadenNehmen(angriff);
        System.out.println("Klauenangriff des " + getName() + ":" + angriff);
        System.out.println(gegner.getName() + "hat noch " + getLeben() + "Leben");
    }

    @Override
    public void spezialfaehigkeitAktivieren() {
        if (!isSpezialFaehigkeitAktiv()){
            setSpezialFaehigkeitAktiv(true);
            setLeben(getLeben() + 10);

        }
    }


    @Override
    public void spezialfaehigkeitDeaktivieren() {

    }

}
