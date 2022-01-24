package no.hvl.dat109.slangestigespill;

import java.util.*;

public class Brett {

    private static final Integer ANTALL_RUTER = 100;
    private List<Rute> ruter;

    /**
     * Konstruktøren til klassen Brett
     */
    public Brett() {
        this.ruter = new ArrayList(ANTALL_RUTER);
    }

    /**
     * Metode for å legge til ruter i brettspillet
     */
    public void leggTilRuter() {
        for(int i = 1; i <= ANTALL_RUTER; i++) {
            getRute().add(new Rute(i));
        }
    }

    /**
     * Get-metode for å hente aktuelle ruter
     */
    public List<Rute> getRute() {
        return ruter;
    }
}
