public abstract class Charakter {


    private String name;
    private int leben;
    private boolean spezialFaehigkeitAktiv;
    public Charakter(String name, int leben, boolean spezialFaehigkeitAktiv) {
        this.name = name;
        this.leben = leben;
        this.spezialFaehigkeitAktiv = spezialFaehigkeitAktiv;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLeben() {
        return leben;
    }

    public void setLeben(int leben) {
        this.leben = leben;
    }

    public boolean isSpezialFaehigkeitAktiv() {
        return spezialFaehigkeitAktiv;
    }

    public void setSpezialFaehigkeitAktiv(boolean spezialFaehigkeitAktiv) {
        this.spezialFaehigkeitAktiv = spezialFaehigkeitAktiv;
    }

    public void schadenNehmen(int schaden) {
        this.leben = Math.max(0, this.leben - schaden);

        System.out.println(name + " hat " + schaden + " Schaden genommen und hat jetzt " + leben + " Lebenspunkte.");

        if (leben == 0) {
            System.out.println(name + " wurde besiegt!");
        }
    }

    public abstract void angreifen(Charakter gegner);
    public abstract void spezialfaehigkeitAktivieren(Charakter charakter);

    public abstract void spezialfaehigkeitDeaktivieren();





}
