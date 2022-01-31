package no.hvl.dat109.slangestigespill;

/**
 * Definerer en terning til spillet.
 *
 * @Author Lars Martin Taraldset
 */
public class Terning {

    private int verdi;

    /**
     * Standard-konstruktør for klassen Terning.
     */
    public Terning() {

    }

    /**
     * Get-metode som returnerer verdien til terningen.
     *
     * @return verdi
     */
    public int getVerdi() {
        return verdi;
    }

    /**
     * Metode for å trille terningen i spillet. Tar inn en min og max-verdi og generer
     * et tilfeldig intreger i intervallet {min, max}.
     *
     * @param min
     * @param max
     * @return verdi
     */
    public int trillTerning(int min, int max) {
        int intervall = (max-min) + 1;
        verdi = (int) ((Math.random() * intervall) + min);
        return verdi;
    }
}
