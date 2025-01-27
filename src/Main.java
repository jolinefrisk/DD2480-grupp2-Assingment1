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

    /*
     * public static boolean[] CMV() {
     * boolean[] CMV = new boolean[15];
     * ConditionsMet conditionsMet = new ConditionsMet();
     * 
     * for (int i = 0; i <= 14; i++) {
     * CMV[i] = conditionsMet().condition(i);
     * }
     * 
     * return CMV;
     * }
     */

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
     * public static boolean[] FUV(boolean[] CMV, boolean[][] PUM) {
     * 
     * return false;
     * }
     */
    public static boolean launch(boolean[] FUV) {

        return false;
    }

    public static void main(String[] args) {
        Main main = new Main();

        main.DECIDE();
    }

}
