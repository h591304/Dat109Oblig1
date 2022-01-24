package no.hvl.dat109.slangestigespill;

import java.util.Scanner;

public class Spiller {

    private String navn;
    private Brikke brikke;

    /**
     * Oppretter konstruktør for Spiller-klassen
     *
     * @param navn
     * @param brikke
     */
    public Spiller(String navn, Brikke brikke) {
        this.navn = navn;
        this.brikke = brikke;
    }

    /**
     * Oppretter getNavn() som henter navnet på spilleren
     */
    public String getNavn() {

        return navn;
    }

    /**
     * Oppretter getBrikke() for å hente brikken som er tildelt spilleren
     */
    public Brikke getBrikke() {
        return brikke;
    }

    /**
     * Oppretter spillTrekk() som utfører trekkene spillerene utfører i spillet
     *
     * @param terning
     * @param brett
     */
    public void spillTrekk(Terning terning, Brett brett) {
        System.out.println("Det er " + getNavn() + " sin tur til å trille!");
        System.out.println("Trykk Q for å trille: ");

        Scanner sc = new Scanner(System.in);
        Character trill = sc.next().charAt(0);

        boolean gyldig = false;
        while(!gyldig) {
            switch(trill) {
                case 'Q':
                    gyldig = true;
                    break;
                case 'q':
                    gyldig = true;
                    break;
                default:
                    System.out.println("Ugyldig input, prøv igjen: ");
                    trill = sc.next().charAt(0);
            }
        }

        terning.trillTerning(1, 6);
        System.out.println(getNavn() + " triller terningen og får verdien: " + terning.getVerdi());
        if((brikke.getPosisjon().getRuteNummer() + terning.getVerdi()) <= 100) {
            brikke.flyttBrikke(terning.getVerdi(), brett);
        }

        int sumAvSeksere = 0;
        if(terning.getVerdi() == 6) {
            for (int i = 0; i < 3; i++) {
                switch (terning.getVerdi()) {
                    case 6:
                        System.out.println("Spiller kan trille på nytt!");
                        terning.trillTerning(1, 6);
                        System.out.println("Får verdien: " + terning.getVerdi() + " på nytt kast!");

                        sumAvSeksere += terning.getVerdi();
                        if (sumAvSeksere == 18) {
                            brikke.flyttBrikkeTilFoersteRute(brett);
                        }
                        if((brikke.getPosisjon().getRuteNummer() + terning.getVerdi()) <= 100) {
                            brikke.flyttBrikke(terning.getVerdi(), brett);
                        }
                        System.out.println("");
                        break;
                    default:
                        break;
                }
            }
        }
        System.out.println("------------------------------");
    }
}
