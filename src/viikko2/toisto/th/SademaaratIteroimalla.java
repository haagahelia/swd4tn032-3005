package viikko2.toisto.th;

import java.util.Scanner;

public class SademaaratIteroimalla {
    public static void main(String[] args) {
        String sademaarat = "10 15 8 5 100";
        Scanner lukija = new Scanner(sademaarat);

        System.out.println("Luetaan tilasto sademääristä (" + sademaarat + ")");

        // nextInt lukee tietovirtaa, kunnes löytää ekan kokonaisluvun
        int sademaara = lukija.nextInt();

        int summa = sademaara;
        int minimi = sademaara;
        int maksimi = sademaara;
        int paivia = 1;

        // hasNextInt() kertoo, onko tietovirrassa odottamassa int
        while (lukija.hasNextInt()) {
            int seuraava = lukija.nextInt();
            summa += seuraava;
            minimi = Math.min(minimi, seuraava);
            maksimi = Math.max(maksimi, seuraava);
            paivia++;
        }

        System.out.println();
        System.out.println("Yhteensä: " + summa);
        System.out.println("Päiviä: " + paivia);
        System.out.println("Maksimi: " + maksimi);
        System.out.println("Minimi: " + minimi);
        System.out.println("Keskiarvo: " + (1.0 * summa / paivia));

        lukija.close();
    }
}
