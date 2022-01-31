package no.hvl.dat109.slangestigespill;

/**
 * Definerer brikkene til spillerene.
 *
 * @author Lars Martin Taraldset
 */
public class Brikke {

    /**
     * Oppretter et enum for rutestatus(om en brikke lander på en stigerute/slangerute)
     */
    enum RuteStatus {
        STIGE2(36), STIGE4(10), STIGE8(23), STIGE21(21), STIGE28(56), STIGE36(8),
        STIGE51(16), STIGE71(20), STIGE80(20), SLANGE16(10), SLANGE47(21),
        SLANGE49(38), SLANGE56(3), SLANGE62(44), SLANGE64(4), SLANGE87(63),
        SLANGE93(20), SLANGE95(20), SLANGE98(20);

        int verdi;
        /**
         * Konstruktør for RuteStatus som gjør det mulig å tildele rutene verdier
         * slik at brikken kan klatre opp en stige(øker med tildelt verdi i antall ruter) eller falle ned en slange
         * (reduserer med tildelt verdi i antall ruter)
         */
        RuteStatus(int verdi) {
            this.verdi = verdi;
        }
    }

    private Rute posisjon;

    /**
     * Konstuktøren for klassen Brikke
     *
     * @param brett
     */
    public Brikke(Brett brett) {
        int foersteRute = 0;
        posisjon = brett.getRute().get(foersteRute);
    }

    /**
     * Metode som flytter brikken til en spiller utfra verdien på terningen
     *
     * @param brett
     */
    public void flyttBrikke(int verdi, Brett brett) {
        int brikkePos;
        if((posisjon.getRuteNummer() + verdi) <= 100) {
            brikkePos = (posisjon.getRuteNummer() + verdi);
            System.out.println("Brikken er flyttet til rute " + brikkePos);
        }
        else{
            brikkePos = posisjon.getRuteNummer();
            System.out.println("Spiller trilte for høyt og brikken kan dermed ikke flyttes." +
                    " Brikken står fortsatt på rute nr: " + brikkePos);
        }
        posisjon = brett.getRute().get(brikkePos-1);
        slangerOgStiger(brett);
        System.out.println("");
    }

    /**
     * Metode som flytter brikken til en spiller tilbake til start dersom spilleren
     * får tre 6ere etter hverandre.
     *
     * @param brett
     */
    public void flyttBrikkeTilFoersteRute(Brett brett) {
        int foersteRute = 0;
        posisjon = brett.getRute().get(foersteRute);
    }

    /**
     * Get-metode som returnerer den aktuelle posisjon til en brikke
     */
    public Rute getPosisjon() {
        return posisjon;
    }

    /**
     * Hardkodet metode som avgjør når en spiller lander på en stigerute/slangerute ved hjelp av
     * enum.
     *
     * @param brett
     */
    private void slangerOgStiger(Brett brett) {
        int brikkePos = posisjon.getRuteNummer();

        switch (brikkePos) {
            case 2:
                brikkePos = (posisjon.getRuteNummer() + RuteStatus.STIGE2.verdi);
                System.out.println("Spilleren landet på en stigerute og klatrer til rute: " + brikkePos);
                break;
            case 4:
                brikkePos = (posisjon.getRuteNummer() + RuteStatus.STIGE4.verdi);
                System.out.println("Spilleren landet på en stigerute og klatrer til rute: " + brikkePos);
                break;
            case 8:
                brikkePos = (posisjon.getRuteNummer() + RuteStatus.STIGE8.verdi);
                System.out.println("Spilleren landet på en stigerute og klatrer til rute: " + brikkePos);
                break;
            case 21:
                brikkePos = (posisjon.getRuteNummer() + RuteStatus.STIGE21.verdi);
                System.out.println("Spilleren landet på en stigerute og klatrer til rute: " + brikkePos);
                break;
            case 28:
                brikkePos = (posisjon.getRuteNummer() + RuteStatus.STIGE28.verdi);
                System.out.println("Spilleren landet på en stigerute og klatrer til rute: " + brikkePos);
                break;
            case 36:
                brikkePos = (posisjon.getRuteNummer() + RuteStatus.STIGE36.verdi);
                System.out.println("Spilleren landet på en stigerute og klatrer til rute: " + brikkePos);
                break;
            case 51:
                brikkePos = (posisjon.getRuteNummer() + RuteStatus.STIGE51.verdi);
                System.out.println("Spilleren landet på en stigerute og klatrer til rute: " + brikkePos);
                break;
            case 71:
                brikkePos = (posisjon.getRuteNummer() + RuteStatus.STIGE71.verdi);
                System.out.println("Spilleren landet på en stigerute og klatrer til rute: " + brikkePos);
                break;
            case 80:
                brikkePos = (posisjon.getRuteNummer() + RuteStatus.STIGE80.verdi);
                System.out.println("Spilleren landet på en stigerute og klatrer til rute: " + brikkePos);
                break;
            case 16:
                brikkePos = (posisjon.getRuteNummer() - RuteStatus.SLANGE16.verdi);
                System.out.println("Spilleren landet på en slangerute og sklir ned til rute: " + brikkePos);
                break;
            case 47:
                brikkePos = (posisjon.getRuteNummer() - RuteStatus.SLANGE47.verdi);
                System.out.println("Spilleren landet på en slangerute og sklir ned til rute: " + brikkePos);
                break;
            case 49:
                brikkePos = (posisjon.getRuteNummer() - RuteStatus.SLANGE49.verdi);
                System.out.println("Spilleren landet på en slangerute og sklir ned til rute: " + brikkePos);
                break;
            case 56:
                brikkePos = (posisjon.getRuteNummer() - RuteStatus.SLANGE56.verdi);
                System.out.println("Spilleren landet på en slangerute og sklir ned til rute: " + brikkePos);
                break;
            case 62:
                brikkePos = (posisjon.getRuteNummer() - RuteStatus.SLANGE62.verdi);
                System.out.println("Spilleren landet på en slangerute og sklir ned til rute: " + brikkePos);
                break;
            case 64:
                brikkePos = (posisjon.getRuteNummer() - RuteStatus.SLANGE64.verdi);
                System.out.println("Spilleren landet på en slangerute og sklir ned til rute: " + brikkePos);
                break;
            case 87:
                brikkePos = (posisjon.getRuteNummer() - RuteStatus.SLANGE87.verdi);
                System.out.println("Spilleren landet på en slangerute og sklir ned til rute: " + brikkePos);
                break;
            case 93:
                brikkePos = (posisjon.getRuteNummer() - RuteStatus.SLANGE93.verdi);
                System.out.println("Spilleren landet på en slangerute og sklir ned til rute: " + brikkePos);
                break;
            case 95:
                brikkePos = (posisjon.getRuteNummer() - RuteStatus.SLANGE95.verdi);
                System.out.println("Spilleren landet på en slangerute og sklir ned til rute: " + brikkePos);
                break;
            case 98:
                brikkePos = (posisjon.getRuteNummer() - RuteStatus.SLANGE98.verdi);
                System.out.println("Spilleren landet på en slangerute og sklir ned til rute: " + brikkePos);
                break;
            default:
                System.out.println("Spilleren landet på en vanlig rute, så ingenting skjer!");
        }
        posisjon = brett.getRute().get(brikkePos-1);
    }
}