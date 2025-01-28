
public class ConditionsMet {

    // parameters should not be an int but this works for now
    public boolean Condition(int conditionNumber, int parameters, double[] X, double[] Y, int numpoints) {
        switch (conditionNumber) {
            case 0:
                return conditionZero(parameters);

            case 1:
                return conditionOne(parameters);

            case 2:
                return conditionTwo(parameters);

            case 3:
                return conditionThree(parameters);

            case 4:
                return conditionFour(parameters);

            case 5:
                return conditionFive(X, numpoints);

            case 6:
                return conditionSix(parameters);

            case 7:
                return conditionSeven(parameters);

            case 8:
                return conditionEight(parameters);

            case 9:
                return conditionNine(parameters);

            case 10:
                return conditionTen(parameters);

            case 11:
                return conditionEleven(parameters);

            case 12:
                return conditionTwelve(parameters);

            case 13:
                return conditionThirteen(parameters);

            case 14:
                return conditionFourteen(parameters);

            // Behöver fixa en faktiskt error hantering och inte bara return false här
            default:
                return false;
        }
    }

    private boolean conditionZero(int parameters) {
        return false;
    }

    private boolean conditionOne(int parameters) {
        return false;
    }

    private boolean conditionTwo(int parameters) {
        return false;
    }

    private boolean conditionThree(int parameters) {
        return false;
    }

    private boolean conditionFour(int parameters) {
        return false;
    }

    public static boolean conditionFive(double[] X, int numpoints) {

        if (X.length == numpoints) {

            for (int i = 0; i < numpoints - 1; i++) {
                if (X[i + 1] - X[i] < 0) {
                    return true;
                }
            }
        } else {
            throw new IllegalArgumentException("The length of X should be equal to numpoints");
        }

        return false;
    }

    private boolean conditionSix(int parameters) {
        return false;
    }

    private boolean conditionSeven(int parameters) {
        return false;
    }

    private boolean conditionEight(int parameters) {
        return false;
    }

    private boolean conditionNine(int parameters) {
        return false;
    }

    private boolean conditionTen(int parameters) {
        return false;
    }

    private boolean conditionEleven(int parameters) {
        return false;
    }

    private boolean conditionTwelve(int parameters) {
        return false;
    }

    private boolean conditionThirteen(int parameters) {
        return false;
    }

    private boolean conditionFourteen(int parameters) {
        return false;
    }

}