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

        @Test
        public void testPUMIllegalArgument() {

                Main.CONNECTORS[][] LCM = {
                                { Main.CONNECTORS.ANDD, Main.CONNECTORS.ANDD, Main.CONNECTORS.ANDD },
                                { Main.CONNECTORS.ANDD, Main.CONNECTORS.ANDD, Main.CONNECTORS.ANDD },
                                { Main.CONNECTORS.ANDD, Main.CONNECTORS.ANDD, Main.CONNECTORS.ANDD }
                };

                boolean[] CMV = { false, false };

                Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        Main.PUM(LCM, CMV);
                });

                String expected = "The LCM should be a n x n vector, where n is the length of CMV";
                String message = exception.getMessage();

                assertEquals(expected, message);
        }

        @Test
        public void testPositiveCondidtionFive() {

                double[] X = { 5.0, 4.0, 6.0, 3.0 };

                int numpoints = 4;

                assertTrue(ConditionsMet.conditionFive(X, numpoints));
        }

        @Test
        public void testNegativeCondidtionFive() {

                double[] X = { 1.0, 2.0, 3.0, 4.0 };

                int numpoints = 4;

                assertFalse(ConditionsMet.conditionFive(X, numpoints));
        }

        @Test
        public void testCondidtionFiveIllegalArgument() {

                double[] X = { 1.0, 2.0, 3.0, 4.0 };

                int numpoints = 2;

                Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        ConditionsMet.conditionFive(X, numpoints);
                });

                String expected = "The length of X should be equal to numpoints";
                String message = exception.getMessage();

                assertEquals(expected, message);
        }

        @Test
        public void testFUVfalsePUV() {

                boolean[] PUV = {false , false, false};

                boolean[][] PUM = {
                        { true, false, true },
                        { false, true, true },
                        { true, true, true }
                };

                boolean[] expected = {true, true, true};

                assertArrayEquals(expected, Main.FUV(PUM, PUV));
        }

        @Test
        public void testFUVtruePUM() {

                boolean[] PUV = {true , true, true};

                boolean[][] PUM = {
                        { true, true, true },
                        { true, true, true },
                        { true, true, true }
                };

                boolean[] expected = {true, true, true};

                assertArrayEquals(expected, Main.FUV(PUM, PUV));
        }

        @Test
        public void testFUVfalsePUM() {

                boolean[] PUV = {true , true, true};

                boolean[][] PUM = {
                        { false, false, false },
                        { false, false, false },
                        { false, false, false }
                };

                boolean[] expected = {false, false, false};

                assertArrayEquals(expected, Main.FUV(PUM, PUV));
        }

        @Test
        public void testFUVonefalsePUM() {

                boolean[] PUV = {true , true, true};

                boolean[][] PUM = {
                        { true, true, true },
                        { true, true, false },
                        { true, true, true }
                };

                boolean[] expected = {true, false, true};

                assertArrayEquals(expected, Main.FUV(PUM, PUV));
        }

        @Test
        public void testLAUNCHtrue() {

                boolean[] FUV = {true , true, true};
                boolean expected = true;

                assertEquals(expected, Main.launch(FUV));
        }

        @Test
        public void testLAUNCHfalse() {

                boolean[] FUV = {false , false, false};
                boolean expected = false;

                assertEquals(expected, Main.launch(FUV));
        }
}