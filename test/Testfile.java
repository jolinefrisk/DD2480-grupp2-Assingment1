import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Testfile {
    @Test
    public void testPUMmixedConnectors() {

        Main.CONNECTORS[][] LCM = {
                { Main.CONNECTORS.NOTUSED, Main.CONNECTORS.ANDD, Main.CONNECTORS.ORR },
                { Main.CONNECTORS.ANDD, Main.CONNECTORS.NOTUSED, Main.CONNECTORS.ORR },
                { Main.CONNECTORS.ORR, Main.CONNECTORS.ORR, Main.CONNECTORS.NOTUSED }
        };

        boolean[] CMV = { true, false, true };

        boolean[][] expected = {
                { true, false, true },
                { false, true, true },
                { true, true, true }
        };

        assertArrayEquals(expected, Main.PUM(LCM, CMV));
    }

    @Test
    public void testPUMWithANDConnectors() {

        Main.CONNECTORS[][] LCM = {
                { Main.CONNECTORS.ANDD, Main.CONNECTORS.ANDD, Main.CONNECTORS.ANDD },
                { Main.CONNECTORS.ANDD, Main.CONNECTORS.ANDD, Main.CONNECTORS.ANDD },
                { Main.CONNECTORS.ANDD, Main.CONNECTORS.ANDD, Main.CONNECTORS.ANDD }
        };

        boolean[] CMV = { false, false, false };

        boolean[][] expected = {
                { false, false, false },
                { false, false, false },
                { false, false, false }
        };

        assertArrayEquals(expected, Main.PUM(LCM, CMV));
    }
}