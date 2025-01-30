import java.lang.Math;

public class Main {

    // CONSTANT
    public static final double PI = 3.1415926535;

    // ENUMERATES
    public enum CONNECTORS {
        NOTUSED(777),
        ORR(1),
        ANDD(2);

        private final int value;

        CONNECTORS(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    // INPUT VARIABLES
    public static int NUMPOINTS; // The number of planar data points
    public static double[] POINTS; // Array containing the coordinates of data points
    public static CONNECTORS[][] LCM = new CONNECTORS[15][15]; // Logical connector Matrix
    public static boolean[] PUV = new boolean[NUMPOINTS]; // Preliminary Unlocking Vector

    // PARAMETERS = 0; // Parameters for LIC, fix later

    // OUTPUT VARIABLE
    public static boolean DECIDE() {
        /*
         * Call upon CMV, PUM, FUV, launch methods
         * with global variable as input
         * 
         * CMV & PUM uses LIC/LCM-matrix as input
         * 
         * FUV uses CMV and PUM return values as inputs
         */

        return false;
    }

    public static boolean[] CMV(Parameters parameters, double[] X, double[] Y, int numpoints) {
        try {
            if (X.length == numpoints && Y.length == numpoints) {
                boolean[] CMV = new boolean[15];
                ConditionsMet conditionsMet = new ConditionsMet();

                for (int i = 0; i <= 14; i++) {
                    CMV[i] = conditionsMet.Condition(i, parameters, X, Y, numpoints);
                }

                return CMV;
            } else {
                throw new IllegalArgumentException("The length of X and Y should be same as numpoints.");
            }

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    public static boolean[][] PUM(CONNECTORS[][] LCM, boolean[] CMV) {

        int n = CMV.length;
        boolean[][] PUM_matrix = new boolean[n][n];

        if (n == LCM[0].length && n == LCM[1].length) {

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {

                    if (LCM[i][j] == CONNECTORS.NOTUSED) {
                        PUM_matrix[i][j] = true;
                    }

                    else if (LCM[i][j] == CONNECTORS.ANDD) {
                        if (CMV[i] == true && CMV[j] == true) {
                            PUM_matrix[i][j] = true;
                        }
                    }

                    else if (LCM[i][j] == CONNECTORS.ORR) {
                        if (CMV[i] == true || CMV[j] == true) {
                            PUM_matrix[i][j] = true;
                        }
                    }

                }
            }
        }

        else {
            throw new IllegalArgumentException("The LCM should be a n x n vector, where n is the length of CMV");
        }

        return PUM_matrix;
    }

    // Returns boolean array

    /*
     * FUV()
     * input: - PUM[n][n] The Preliminary Unlocking Matrix with n x n elements
     * - PUV[n] The Preliminary Unlocking Vector with n elements
     * 
     * output: - FUV[n] - The Final Unlocking Vector with n elements
     * 
     * FUV[i] = true if PUV[i] = false or all elements in PUM row i: PUM[i][] = true
     */
    public static boolean[] FUV(boolean[][] PUM, boolean[] PUV) {
        int n = PUM.length;
        boolean[] FUV_vector = new boolean[n];

        if (n == PUV.length) {
            for (int i = 0; i < n; i++) {
                if (PUV[i] == false) {
                    FUV_vector[i] = true;
                    continue;
                }

                boolean no_false = true;
                for (int el = 0; el < n; el++) {
                    if (!PUM[i][el]) {
                        no_false = false;
                        break;
                    }
                }

                FUV_vector[i] = no_false;
            }
        } else {
            throw new IllegalArgumentException("The PUV should be a n x 1 vector, where n is the length of CMV");
        }

        return FUV_vector;
    }

    public static boolean launch(boolean[] FUV) {
        int n = FUV.length;
        boolean no_false = true;
        for (int i = 0; i < n; i++) {
            if (!FUV[i]) {
                no_false = false;
                break;
            }
        }
        boolean launch_decision = no_false;
        return launch_decision;
    }

    public static void main(String[] args) {
        Main main = new Main();

        main.DECIDE();
    }

}
