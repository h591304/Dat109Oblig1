package no.hvl.dat109.test;

import no.hvl.dat109.slangestigespill.Brett;
import no.hvl.dat109.slangestigespill.Terning;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Testklasse for logiske metoder.
 *
 * @author Lars Martin Taraldset
 */
public class TestKlasse {

    private static final Integer ANTALL_RUTER = 100;

    /**
     * Test for å trille en terning
     */
    @Test
    public void testTrillTerning() {
        Terning terning = new Terning();
        terning.trillTerning(1,6);

        assertTrue(terning.getVerdi() >= 1);
        assertTrue(terning.getVerdi() <= 6);
    }

    /**
     * Test for å sjekke om alle ruter blir lagt til brettet
     */
    @Test
    public void testLeggTilRuter() {
        Brett brett = new Brett();
        brett.leggTilRuter();
    }
}

