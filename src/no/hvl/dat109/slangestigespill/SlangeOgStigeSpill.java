package no.hvl.dat109.slangestigespill;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Definerer selve slange- og stige-spillet.
 *
 * @author Lars Martin Taraldset
 */
public class SlangeOgStigeSpill {

    private List<Spiller> spillere;
    private Brett brett;
    private Terning terning;
    private int antallSpillere;

    /**
     * Metode som setter opp spillet med ønsket antall spillere, brett med 100 ruter og en terning
     */
    public void spill() {

        System.out.println("----------Vi setter opp et slange-stige-spill----------");
        //Tar inn en bruker-input som avgjør antall spillere
        Scanner sc = new Scanner(System.in);
        System.out.print("Antall spillere(2-4): ");
        antallSpillere = sc.nextInt();

        //Sjekker at antall spillere er gyldig
        boolean gyldig = true;
        while(gyldig) {
            if(antallSpillere == 2 || antallSpillere == 3 || antallSpillere == 4) {
                gyldig = false;
            }
            else {
                System.out.println("Du må velge et gyldig antall spillere, prøv igjen!!!");
                antallSpillere = sc.nextInt();
            }
        }
        //Oppretter spillet før spillet kan startes
        System.out.println("------------------------------");
        System.out.println("Oppretter brett...");
        brett = new Brett();
        brett.leggTilRuter();
        System.out.println("Oppretter terning...");
        terning = new Terning();
        System.out.println("Oppretter spillere...");
        spillere = new ArrayList<Spiller>();

        int nr = 1;
        //Tildeler alle spillere et navn og en brikke hver
        for(int i = 0; i < antallSpillere; i++) {
            spillere.add(new Spiller("Spiller" + nr, new Brikke(brett)));
            System.out.println(spillere.get(i).getNavn() + " er nå opprettet!");
            nr++;
        }
        System.out.println("------------------------------");
        System.out.println("Starter spill:");
        System.out.println("Alle spillere starter på rute: " + brett.getRute().get(0).getRuteNummer());
        start();    //starter spillrundene
    }

    /**
     * Metode som starter spillet og kjører alle spiller-trekkene.
     */
    private void start() {
        boolean ferdig = false;
        String vinner = "";
        while(!ferdig) {
            for (Spiller s : spillere) {    //rullerer gjennom spillerne som får trille etter tur
                s.spillTrekk(terning, brett);
                if(s.getBrikke().getPosisjon().getRuteNummer() == 100) {
                    vinner = s.getNavn();   //Bestemmer en vinner dersom brikken lander på rute 100
                    ferdig = true;
                    break;
                }
            }
        }
        System.out.println("Vinneren av slange-stigespillet er: " + vinner);
    }
}
