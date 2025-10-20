import java.util.concurrent.ThreadLocalRandom;

public class Zwerge extends Charakter{


    public Zwerge(String name) {
        super(name);
    }




    @Override
    public void angreifen(Charakter gegner) {

        int angriff = ThreadLocalRandom.current().nextInt(15, 25 +1);

        gegner.setLeben(gegner.getLeben() - angriff);


        System.out.println(getName() + " greift " + gegner.getName() + " an und verursacht " + angriff + " Schaden!");
        System.out.println(gegner.getName() + " hat jetzt noch " + gegner.getLeben() + " Lebenspunkte.");
    }

    @Override
    public void spezialfaehigkeitAktivieren(Zwerge zwerg) {



        if (zwerg.getLeben() < 50)
        {

        }



    }

    @Override
    public void spezialfaehigkeitDeaktivieren() {

    }

}
