
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
                return conditionFourteen(parameters, numpoints);

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

    private boolean conditionThirteen(Parameters parameters) {
        for (int i = 0; i <= numpoints - (parameters.getEPts() + parameters.getFPts()); i++) {
                    

        }

        return false;
    }

    private boolean conditionFourteen(Parameters parameters, double[] X, double[] Y, int numpoints) {
        // Initial conditions
        if (parameters.getArea2() <= 0 || numpoints >= 5) {
            return false;
        }  

        boolean greaterThanArea1 = false;
        boolean lesserThanArea2 = false;

        for (int i = 0; i <= numpoints - (parameters.getEPts() + parameters.getFPts()); i++) {
            double area = area(X[i], Y[i], X[i + parameters.getEPts()], 
                               Y[i + parameters.EPts()], 
                               X[i + parameters.EPts() + parameters.FPts()], 
                               Y[i + parameters.Epts() + parameters.FPts()]);

            if (area > parameters.getArea1()) {
                greaterThanArea1 = true;
            }

            if (area < parameters.getArea2()) {
                lesserThanArea2 = true;
            }

            if (greaterThanArea1 && lesserThanArea2) {
                return true;
            }
        }

        return false;
    }

}