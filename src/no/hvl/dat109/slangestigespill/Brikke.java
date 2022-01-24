package no.hvl.dat109.slangestigespill;

public class Brikke {

    private Rute posisjon;

    /**
     * Oppretter konstuktøren for klassen Brikke
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
            brikkePos = (posisjon.getRuteNummer() + verdi) - 1;
            System.out.println("Brikken er flyttet til rute " + (brikkePos + 1));
        }
        else{
            brikkePos = posisjon.getRuteNummer();
            System.out.println("Spiller trilte for høyt og brikken kan dermed ikke flyttes." +
                    " Brikken står fortsatt på rute nr: " + brikkePos);
        }
        posisjon = brett.getRute().get(brikkePos);
    }

    /**
     * Metode for å flytte brikken til en spiller tilbake til start dersom spilleren
     * får tre 6ere etterhverandre.
     *
     * @param brett
     */
    public void flyttBrikkeTilFoersteRute(Brett brett) {
        int foersteRute = 0;
        posisjon = brett.getRute().get(foersteRute);
    }

    /**
     * Get-metode for å hente aktuelle posisjon til en brikke
     */
    public Rute getPosisjon() {
        return posisjon;
    }
}