package no.hvl.dat109.slangestigespill;

import java.util.Scanner;

/**
 * Definerer en spiller for spillet.
 *
 * @author Lars Martin Taraldset
 */
public class Spiller {

    private String navn;
    private Brikke brikke;

    /**
     * Konstruktør for Spiller-klassen.
     *
     * @param navn
     * @param brikke
     */
    public Spiller(String navn, Brikke brikke) {
        this.navn = navn;
        this.brikke = brikke;
    }

    /**
     * Get-metode som returnerer navnet på spilleren.
     */
    public String getNavn() {
        return navn;
    }

    /**
     * Get-metode som returnerer brikken som er tildelt spilleren.
     */
    public Brikke getBrikke() {
        return brikke;
    }

    /**
     * Metode som utfører trekkene til spillerene i spillet.
     *
     * @param terning
     * @param brett
     */
    public void spillTrekk(Terning terning, Brett brett) {
        System.out.println("Det er " + getNavn() + " sin tur til å trille!");
        System.out.println("Trykk Q for å trille: ");

        //Tar inn en character som bruker-input som lar brukeren trille terningen når runden starter
        Scanner sc = new Scanner(System.in);
        Character trill = sc.next().charAt(0);

        //Sjekker at bruker-inputen er gyldig(altså q/Q) slik at spilleren kan trille.
        boolean gyldig = false;
        while(!gyldig) {
            switch(trill) {
                case 'Q':
                    gyldig = true;
                    break;
                case 'q':
                    gyldig = true;
                    break;
                //Dersom spiller taster inn annet enn q/Q, er input ugyldig og må trille på nytt
                default:
                    System.out.println("Ugyldig input, prøv igjen: ");
                    trill = sc.next().charAt(0);
            }
        }

        //Når bruker taster riktig input, triller terningen og gir en verdi mellom 1 og 6.
        terning.trillTerning(1, 6);
        System.out.println(getNavn() + " triller terningen og får verdien: " + terning.getVerdi());
        if((brikke.getPosisjon().getRuteNummer() + terning.getVerdi()) <= 100) {
            brikke.flyttBrikke(terning.getVerdi(), brett);  //oppdaterer posisjonen til spilleren
        }

        //Dersom en spiller triller 6-ere
        if(terning.getVerdi() == 6) {
            int sumAvSeksere = 6;
            for (int i = 1; i <= 2; i++) {
                switch (terning.getVerdi()) {
                    case 6: //Triller på nytt dersom spiller får en 6-er
                        System.out.println("Spiller kan trille på nytt!");
                        terning.trillTerning(1, 6);
                        System.out.println("Får verdien: " + terning.getVerdi() + " på nytt kast!");

                        sumAvSeksere += terning.getVerdi(); //øker sumAvSeksere med ny verdi
                        //flytter brikke tilbake til første rute dersom spiller triller 3 6-ere på rad
                        if (sumAvSeksere == 18) {   //6*3=18
                            brikke.flyttBrikkeTilFoersteRute(brett);
                        }
                        //oppdaterer posisjonen til spilleren
                        if((brikke.getPosisjon().getRuteNummer() + terning.getVerdi()) <= 100) {
                            brikke.flyttBrikke(terning.getVerdi(), brett);
                        }
                        break;
                    default:
                        break;  //Dersom spiller ikke får 6, avbrytes løkken og runden er over
                }
            }
        }
        System.out.println("------------------------------");
    }
}
