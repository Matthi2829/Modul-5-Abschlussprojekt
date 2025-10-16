public class Charakter {
    private String name;
    private int leben = 100;

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
}
