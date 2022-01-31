package no.hvl.dat109.slangestigespill;

/**
 * Definerer rutene til monopolbrettet.
 *
 * @author Lars Martin
 */
public class Rute {

    private int ruteNummer;

    /**
     * Konstruktøren rute for klassen Rute
     *
     * @param nummer
     */
    public Rute(int nummer) {
        ruteNummer = nummer;
    }

    /**
     * Get-metode som returnerer spesifikke rutenumre(ruter).
     */
    public int getRuteNummer() {
        return ruteNummer;
    }


}
