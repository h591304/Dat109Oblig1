package no.hvl.dat109.slangestigespill;

import java.util.*;

/**
 * Definerer et monopolbrett.
 *
 * @author Lars Martin Taraldset
 */
public class Brett {

    private static final Integer ANTALL_RUTER = 100;
    private List<Rute> ruter;

    /**
     * Konstruktøren til klassen Brett.
     */
    public Brett() {
        this.ruter = new ArrayList(ANTALL_RUTER);
    }

    /**
     * Metode for å legge til ruter i brettspillet.
     */
    public void leggTilRuter() {
        for(int i = 1; i <= ANTALL_RUTER; i++) {//forløkke som legger til 100 ruter
            getRute().add(new Rute(i));
        }
    }

    /**
     * Get-metode som returnerer alle ruter i en liste med rute-objekter.
     */
    public List<Rute> getRute() {
        return ruter;
    }
}
