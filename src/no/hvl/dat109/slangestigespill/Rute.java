package no.hvl.dat109.slangestigespill;

public class Rute {

    private int ruteNummer;

    /**
     * Oppretter konstruktøren rute for klassen Rute
     *
     * @param nummer
     */
    public Rute(int nummer) {
        ruteNummer = nummer;
    }

    /**
     * Oppretter getRuteNummer for å kunne hente aktuelle ruter
     */
    public int getRuteNummer() {
        return ruteNummer;
    }


}
