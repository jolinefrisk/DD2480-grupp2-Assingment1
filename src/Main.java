

import java.lang.Math;

public class Main {

    // CONSTANT
    public static final double PI = 3.1415926535;

    // ENUMS
    public enum CONNECTORS {
        NOTUSED(777), ORR(1), ANDD(2);

        private final int value;

        CONNECTORS(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum COMPTYPE {
        LT(1111), EQ(0), GT(1);

        private final int value;

        COMPTYPE(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    // TYPE DECLARATIONS

    // Array of 100 doubles
    public static class Coordinate {
        public double[] coordinates = new double[100];
    }

    // 2D array of [15][15] CONNECTORS
    public static class CMatrix {
        public CONNECTORS[][] matrix = new CONNECTORS[15][15];
    }

    // Boolean class (always in range [0..1])
    public static class BooleanWrapper {
        public boolean value;

        public BooleanWrapper(boolean value) {
            this.value = value;
        }
    }

    // 2D array of [15][15] booleans
    public static class BMatrix {
        public boolean[][] matrix = new boolean[15][15];
    }

    // Array of 15 booleans
    public static class Vector {
        public boolean[] vector = new boolean[15];
    }

    // PARAMETERS class equivalent to PARAMETERS.T in C
    public static class Parameters {
        public double LENGTH1;  // Length in LICs 0, 7, 12
        public double RADIUS1;  // Radius in LICs 1, 8, 13
        public double EPSILON;  // Deviation from PI in LICs 2, 9
        public double AREA1;    // Area in LICs 3, 10, 14
        public int Q_PTS;       // No. of consecutive points in LIC 4
        public int QUADS;       // No. of quadrants in LIC 4
        public double DIST;     // Distance in LIC 6
        public int N_PTS;       // No. of consecutive points in LIC 6
        public int K_PTS;       // No. of int. pts. in LICs 7, 12
        public int A_PTS;       // No. of int. pts. in LICs 8, 13
        public int B_PTS;       // No. of int. pts. in LICs 8, 13
        public int C_PTS;       // No. of int. pts. in LIC 9
        public int D_PTS;       // No. of int. pts. in LIC 9
        public int E_PTS;       // No. of int. pts. in LICs 10, 14
        public int F_PTS;       // No. of int. pts. in LICs 10, 14
        public int G_PTS;       // No. of int. pts. in LIC 11
        public double LENGTH2;  // Maximum length in LIC 12
        public double RADIUS2;  // Maximum radius in LIC 13
        public double AREA2;    // Maximum area in LIC 14
    }

    // GLOBAL VARIABLES
    public static Parameters PARAMETERS = new Parameters();
    public static Parameters PARAMETERS2 = new Parameters();

    public static Coordinate X = new Coordinate();
    public static Coordinate X2 = new Coordinate();

    public static Coordinate Y = new Coordinate();
    public static Coordinate Y2 = new Coordinate();

    public static int NUMPOINTS;
    public static int NUMPOINTS2;

    public static CMatrix LCM = new CMatrix();
    public static CMatrix LCM2 = new CMatrix();

    public static void main(String[] args) {
       
    }
}
