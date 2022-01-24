package no.hvl.dat109.slangestigespill;

/**
 * Klasse for å opprette en terning til spillet
 *
 * @Author Lars Martin Taraldset
 */
public class Terning {

    private int verdi;

    /**
     * Standard konstruktør for klassen Terning
     */
    public Terning() {

    }

    /**
     * Get-metode for å hente verdien til terningen
     *
     * @return verdi
     */
    public int getVerdi() {
        return verdi;
    }

    /**
     * Metode for å trille terningen i spillet. Genererer et tilfeldig nummer mellom 1-6
     *
     * @return verdi
     */
    public int trillTerning(int min, int max) {

        int intervall = (max-min) + 1;
        verdi = (int) ((Math.random() * intervall) + min);
        return verdi;
    }
}
