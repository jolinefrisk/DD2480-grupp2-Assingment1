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
        public void testPositiveConditionOne() {

                double[] X = {0.0, 1.0, 2.0, 3.0};
                double[] Y = { 0.0, 1.0, 2.0, 3.0};
                int numpoints = 4;
                int parameter = 2;

                assertTrue(ConditionsMet.conditionOne(parameter, X,Y, numpoints));
        }
        @Test
        public void testNegativeCondidtionOne() {

                double[] X = {0.0, 1.0, 2.0, 3.0};
                double[] Y = { 0.0, 1.0, 2.0, 3.0};
                int numpoints = 4;
                int parameter = 1;

                assertTrue(ConditionsMet.conditionOne(parameter, X,Y, numpoints));
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
}