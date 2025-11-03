public class Main {

    public static void main(String[] args) {
        Zwerge raphael_prosen = new Zwerge("Raphael Prosen", 100, false);
        Drachen erion_prenaj = new Drachen("Erion Prenaj", 100, false);

        Kampfarena arena = new Kampfarena(raphael_prosen, erion_prenaj);
        arena.kampfStarten();
    }
}

