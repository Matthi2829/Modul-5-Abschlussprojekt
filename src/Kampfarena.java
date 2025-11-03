import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Kampfarena {

    private Charakter rival1;
    private Charakter rival2;
    private Scanner scanner = new Scanner(System.in);

    public Kampfarena(Charakter rival1, Charakter rival2) {
        this.rival1 = rival1;
        this.rival2 = rival2;
    }

    public void kampfStarten() {
        Charakter aktuellerSpieler;
        Charakter gegner;

        if (ThreadLocalRandom.current().nextBoolean()) {
            aktuellerSpieler = rival1;
            gegner = rival2;
        } else {
            aktuellerSpieler = rival2;
            gegner = rival1;
        }

        System.out.println("⚔️ Der Kampf zwischen " + rival1.getName() + " und " + rival2.getName() + " startet!");
        System.out.println("👉 " + aktuellerSpieler.getName() + " beginnt.\n");

        while (rival1.getLeben() > 0 && rival2.getLeben() > 0) {
            System.out.println("----- Neue Runde -----");
            System.out.println("Am Zug: " + aktuellerSpieler.getName());
            System.out.println("1 - Angreifen");
            System.out.println("2 - Spezialfähigkeit aktivieren");
            System.out.println("3 - Spezialfähigkeit deaktivieren");
            System.out.print("Wähle eine Aktion: ");

            int wahl = scanner.nextInt();
            System.out.println();

            switch (wahl) {
                case 1:
                    aktuellerSpieler.angreifen(gegner);
                    break;
                case 2:
                    aktuellerSpieler.spezialfaehigkeitAktivieren(gegner);
                    break;
                case 3:
                    aktuellerSpieler.spezialfaehigkeitDeaktivieren();
                    break;
                default:
                    System.out.println("Ungültige Eingabe! Runde übersprungen.");
            }

            // Prüfen, ob Kampf vorbei ist
            if (gegner.getLeben() <= 0) {
                System.out.println("\n🏆 " + aktuellerSpieler.getName() + " hat gewonnen!");
                break;
            }

            // Spieler wechseln
            Charakter temp = aktuellerSpieler;
            aktuellerSpieler = gegner;
            gegner = temp;
        }
    }
}

