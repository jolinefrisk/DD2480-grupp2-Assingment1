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
    public static int NUMPOINTS;  // The number of planar data points
    public static double[] POINTS; // Array containing the coordinates of data points
<<<<<<< HEAD
    public static CONNECTORS[][] LCM = new CONNECTORS[15][15]; // Logical connector Matrix
    public static boolean[] PUV = new boolean[NUMPOINTS]; // Preliminary Unlocking Vector

    // PARAMETERS = 0;  // Parameters for LIC, fix later

=======
    // PARAMETERS = 0;  // Parameters for LIC, fix later
    public static CONNECTORS[][] LCM = new CONNECTORS[15][15]; // Logical connector Matrix
    public static boolean[] PUV = new boolean[NUMPOINTS]; // Preliminary Unlocking Vector

>>>>>>> 562d118e61f98f8412602d1f8c800226812db52c
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

      
      public static boolean[] CMV() {
        boolean[] CMV = new boolean[15];
        ConditionsMet conditionsMet = new ConditionsMet();

        for (int i = 0; i <= 14; i++) {
            CMV[i] = conditionsMet().condition(i);
        }
      
      return CMV;
      }

    public static boolean[][] PUM(CONNECTORS[][] LCM, boolean[] CMV) {

        int n = CMV.length;
        boolean[][] PUM_matrix = new boolean[n][n];

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
