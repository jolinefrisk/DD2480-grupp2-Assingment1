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
        public void testVectorProjection(){
                //public static double[] vectorProjection(double x1, double y1, double x2, double y2)
                double x1 = 1;
                double y1 = 2;
                double x2 = 2;
                double y2 = 2;

                double[] expected = {1.5, 1.5};
                assertArrayEquals(expected, ConditionsMet.vectorProjection( x1,  y1,  x2, y2));
        }
        @Test
        public void testPositiveCondidtionZero() {

                double[] X = { 0.0, 1.0, 2.0, 3.0 };
                double[] Y = { 0.0, 1.0, 2.0, 3.0 };
                int numpoints = 4;
                Parameters parameter = new Parameters();
                parameter.setLength1(1.0);

                assertTrue(ConditionsMet.conditionZero(parameter, X, Y, numpoints));
        }
        
        
        @Test
        public void testNegativeCondidtionZero() {

                double[] X = {1.0, 1.5, 0.5, 3.0};
                double[] Y = { 1.0, 1.5, 0.5 , 1.0};
                int numpoints = 4;
                Parameters parameter = new Parameters();
                parameter.setLength1(1.0);

                assertFalse(ConditionsMet.conditionZero(parameter, X,Y, numpoints));
        }

        @Test
        public void  testCondidtionZeroIllegalArgument(){
        
                double[] X = {1.0, 1.5, 0.5, 3.0};
                double[] Y = { 1.0, 1.5, 0.5 , 1.0};
                int numpoints = 0;

                Parameters parameter = new Parameters();
                parameter.setLength1(1.0);
                String expected= "The number of points should be at least 2";
                Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        ConditionsMet.conditionZero(parameter, X, Y, numpoints);
                });

                String message = exception.getMessage();

                assertEquals(expected, message);


        }

        @Test
        public void testPositiveConditionOne() {

                double[] X = { 0.0, 1.0, 2.0, 3.0 };
                double[] Y = { 0.0, 1.0, 2.0, 3.0 };
                int numpoints = 4;
                Parameters parameter = new Parameters();
                parameter.setRadius1(1.0);

                assertTrue(ConditionsMet.conditionOne(parameter, X, Y, numpoints));
        }

        @Test
        public void testNegativeCondidtionOne() {

                double[] X = {1.0, 1.5, 0.5, 3.0};
                double[] Y = { 1.0, 1.5, 0.5 , 1.0};
                int numpoints = 4;
                Parameters parameter = new Parameters();
                parameter.setRadius1(1.0);

                assertTrue(ConditionsMet.conditionOne(parameter, X,Y, numpoints));
        }




        @Test
        public void testPositiveCondidtionTwo() {
                double[] X = {0, 1, 1, 3, 4}; 
                double[] Y = {0, 5, 1, 3, 6}; 
                int numpoints = 5;
                Parameters parameter = new Parameters();
                parameter.setEpsilon(2.0);

                assertTrue(ConditionsMet.conditionTwo(parameter, X,Y, numpoints));
        }
        @Test
        public void testNegativeCondidtionTwo() {

                double[] X = {0, 1, 2, 3, 4};
                double[] Y = {0, 0, 0, 0, 0}; // All points in a straight line
                int numpoints = 5;
                Parameters parameter = new Parameters();
                parameter.setEpsilon(2.0);

                assertFalse(ConditionsMet.conditionTwo(parameter, X,Y, numpoints));
        }
        @Test
        public void testPositiveCondidtionThree() {

                double[] X = {0, 1, 1.1, 10}; 
                double[] Y = {0, 0, 10, 0}; 
                int numpoints = 4;
                Parameters parameter = new Parameters();
                parameter.setArea1(3.0);

                assertTrue(ConditionsMet.conditionThree(parameter, X,Y, numpoints));
        }       
        @Test
        public void testNegativeCondidtionThree() {

                double[] X = {0, 1, 2, 3, 4}; // Points lie on a straight line
                double[] Y = {0, 0, 0, 0, 0}; 
                int numpoints = 4;
                Parameters parameter = new Parameters();
                parameter.setArea1(3.0);

                assertFalse(ConditionsMet.conditionThree(parameter, X,Y, numpoints));
        }
        @Test
        public void testPositiveCondidtionFour() {

                double[] X = {1, -1, -1, 2};
                double[] Y = {1, 1, -1, -1}; 
                int numpoints = 4;
                Parameters parameter = new Parameters();
                parameter.setQPts(3);
                parameter.setQuads(2);

                assertTrue(ConditionsMet.conditionFour(parameter, X,Y, numpoints));
        }
        @Test
        public void testNegativeCondidtionFour() {

                double[] X = {0.0, 1.0, 2.0, 3.0};
                double[] Y = { 0.0, 1.0, 2.0, 3.0};
                int numpoints = 4;
                Parameters parameter = new Parameters();
                parameter.setQPts(3);
                parameter.setQuads(2);

                assertFalse(ConditionsMet.conditionFour(parameter, X,Y, numpoints));
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
        public void testPositiveCondidtionSix() {

                Parameters parameters = new Parameters();
                parameters.setDist(1.0);

                double[] X = { 0.0, 1.0, 2.0, 1.0 };
                double[] Y = { 0.0, 1.0, 3.0 ,2.0 };
                int numpoints = 4;

                assertTrue(ConditionsMet.conditionSix(parameters, X, Y, numpoints));
        }
        
        @Test
        public void testPositiveConditionSeven() {

                double[] X = {3.0, 5.0, 2.0};
                double[] Y = {5.0, 3.0, 1.0};

                int numpoints = 3;

                Parameters parameters = new Parameters();
                parameters.setKPts(1);
                parameters.setLength1(3);
                
                assertTrue(ConditionsMet.conditionSeven(parameters, X, Y, numpoints));
        }

        @Test
        public void testNegativeConditionSeven() {

                double[] X = {3.0, 5.0, 2.0};
                double[] Y = {5.0, 3.0, 1.0};

                int numpoints = 3;

                Parameters parameters = new Parameters();
                parameters.setKPts(1);
                parameters.setLength1(5);
                
                assertFalse(ConditionsMet.conditionSeven(parameters, X, Y, numpoints));
        }

        @Test
        public void testConditionSevenIllegalArgument() {

                double[] X = {1.0, 2.0, 3.0, 4.0, 2.0};
                double[] Y = {5.0, 3.0, 1.0, 6.0, 3.0};

                Parameters parameters = new Parameters();
                parameters.setKPts(1);
                parameters.setLength1(3);

                int numpoints = 2;

                Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        ConditionsMet.conditionFive(X, numpoints);
                });

                String expected = "The length of X should be equal to numpoints";
                String message = exception.getMessage();

                assertEquals(expected, message);
        }

        @Test
        public void testPositiveConditionEight() {

                double[] X = {3.0, 5.0, 2.0, 7.0, 4.0};
                double[] Y = {5.0, 3.0, 1.0, 6.0, 3.0};

                int numpoints = 5;

                Parameters parameters = new Parameters();
                parameters.setAPts(1);
                parameters.setBPts(1);
                parameters.setRadius1(2);
                
                assertTrue(ConditionsMet.conditionEight(parameters, X, Y, numpoints));
        }

        @Test
        public void testNegativeConditionEight() {

                double[] X = {3.0, 5.0, 2.0, 7.0, 4.0};
                double[] Y = {5.0, 3.0, 1.0, 6.0, 3.0};

                int numpoints = 5;

                Parameters parameters = new Parameters();
                parameters.setAPts(1);
                parameters.setBPts(1);
                parameters.setRadius1(5);
                
                assertFalse(ConditionsMet.conditionEight(parameters, X, Y, numpoints));
        }

        @Test
        public void testConditionEightIllegalArgument() {

                double[] X = {3.0, 5.0, 2.0, 7.0, 4.0};
                double[] Y = {5.0, 3.0, 1.0, 6.0, 3.0};

                int numpoints = 5;

                Parameters parameters = new Parameters();
                parameters.setAPts(6);
                parameters.setBPts(4);
                parameters.setRadius1(5);

                Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        ConditionsMet.conditionEight(parameters, X, Y, numpoints);
                });

                String expected = "Invalid parameters!";
                String message = exception.getMessage();

                assertEquals(expected, message);
        }

        @Test
        public void testNegativeCondidtionNine() {

                Parameters parameters = new Parameters();
                parameters.setEpsilon(3.1415926535 / 2);
                parameters.setCPts(1);
                parameters.setDPts(1);

                double[] X = { 0.0, 1.0, 2.0, 3.0, 4.0 };
                double[] Y = { 0.0, 2.0, 0.0, -1.0, -2.0 };
                int numpoints = 5;

                assertFalse(ConditionsMet.conditionNine(parameters, X, Y, numpoints));
        }

        public void testPositiveCondidtionNine() {

                Parameters parameters = new Parameters();
                parameters.setEpsilon(0);
                parameters.setCPts(1);
                parameters.setDPts(1);

                double[] X = { 0.0, 1.0, 2.0, 3.0, 4.0 };
                double[] Y = { 0.0, 2.0, 0.0, -1.0, -2.0 };
                int numpoints = 5;

                assertTrue(ConditionsMet.conditionNine(parameters, X, Y, numpoints));
        }

        @Test
        public void testCondidtionNineIllegalArgument() {

                Parameters parameters = new Parameters();
                parameters.setEpsilon(0);
                parameters.setCPts(1);
                parameters.setDPts(1);

                double[] X = { 0.0, 1.0, 2.0, 3.0, 4.0 };
                double[] Y = { 0.0, 2.0 };
                int numpoints = 5;

                Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        ConditionsMet.conditionNine(parameters, X, Y, numpoints);
                });

                String expected = "The length of X and Y should be equal to numpoints";
                String message = exception.getMessage();

                assertEquals(expected, message);
        }

        @Test
        public void testPositiveCondidtionTen() {

                Parameters parameters = new Parameters();
                parameters.setArea1(1.0);
                parameters.setEPts(1);
                parameters.setFPts(1);

                double[] X = { 0.0, 1.0, 2.0, 3.0, 1.0 };
                double[] Y = { 0.0, 2.0, 0.0, -1.0, 2.0 };
                int numpoints = 5;

                assertTrue(ConditionsMet.conditionTen(parameters, X, Y, numpoints));
        }

        @Test
        public void testNegativeCondidtionTen() {

                Parameters parameters = new Parameters();
                parameters.setArea1(1.0);
                parameters.setEPts(1);
                parameters.setFPts(1);

                double[] X = { 0.0, 1.0, 0.5, 3.0, 0.25 };
                double[] Y = { 0.0, 2.0, 0.0, -1.0, 0.5 };
                int numpoints = 5;

                assertFalse(ConditionsMet.conditionTen(parameters, X, Y, numpoints));
        }

        @Test
        public void testCondidtionTenIllegalArgument() {

                Parameters parameters = new Parameters();
                parameters.setArea1(1.0);
                parameters.setEPts(1);
                parameters.setFPts(1);

                double[] X = { 0.0, 1.0, 2.0, 3.0, 4.0 };
                double[] Y = { 0.0, 2.0 };
                int numpoints = 5;

                Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        ConditionsMet.conditionTen(parameters, X, Y, numpoints);
                });

                String expected = "The length of X and Y should be equal to numpoints";
                String message = exception.getMessage();

                assertEquals(expected, message);
        }
  
        @Test
        public void testPositiveCondidtionEleven() {
                Parameters parameters = new Parameters();
                parameters.setGPts(1);
                double[] X = { 6.0, 4.0, 5.0, 3.0 };

                int numpoints = 4;

                assertTrue(ConditionsMet.conditionEleven(parameters, X, numpoints));
        }

        @Test
        public void testNegativeCondidtionEleven() {
                Parameters parameters = new Parameters();
                parameters.setGPts(1);
                double[] X = { 0.0, 0.0, 0.0, 0.0};

                int numpoints = 4;

                assertFalse(ConditionsMet.conditionEleven(parameters, X, numpoints));
        }

        @Test
        public void testCondidtionElevenIllegalArgument() {

                Parameters parameters = new Parameters();
                parameters.setGPts(1);
                double[] X = { 0.0};

                int numpoints = 1;

                assertFalse(ConditionsMet.conditionEleven(parameters, X, numpoints));
        }
        
          public void testPositiveConditionTwelve() {

                double[] X = {1.0, 5.0, 4.0};
                double[] Y = {1.0, 3.0, 5.0};

                int numpoints = 3;

                Parameters parameters = new Parameters();
                parameters.setKPts(1);
                parameters.setLength1(3);
                parameters.setLength2(6);
                
                assertTrue(ConditionsMet.conditionTwelve(parameters, X, Y, numpoints));
        }
        
        @Test
          public void testLength1TooLongConditionTwelve() {

                double[] X = {1.0, 5.0, 4.0};
                double[] Y = {1.0, 3.0, 5.0};

                int numpoints = 3;

                Parameters parameters = new Parameters();
                parameters.setKPts(1);
                parameters.setLength1(5);
                parameters.setLength2(6);
                
                assertFalse(ConditionsMet.conditionTwelve(parameters, X, Y, numpoints));
        }

        @Test
          public void testLength2TooShortConditionTwelve() {

                double[] X = {1.0, 5.0, 4.0};
                double[] Y = {1.0, 3.0, 5.0};

                int numpoints = 3;

                Parameters parameters = new Parameters();
                parameters.setKPts(1);
                parameters.setLength1(3);
                parameters.setLength2(5);
                
                assertFalse(ConditionsMet.conditionTwelve(parameters, X, Y, numpoints));
        }

        @Test
          public void testPositiveConditionThirteen() {

                double[] X = {3.0, 5.0, 2.0, 7.0, 4.0};
                double[] Y = {5.0, 3.0, 1.0, 6.0, 3.0};

                int numpoints = 5;

                Parameters parameters = new Parameters();
                parameters.setAPts(1);
                parameters.setBPts(1);
                parameters.setRadius1(2);
                parameters.setRadius2(5);
                
                assertTrue(ConditionsMet.conditionThirteen(parameters, X, Y, numpoints));
        }

        @Test
          public void testRadius1FitsConditionThirteen() {

                double[] X = {3.0, 5.0, 2.0, 7.0, 4.0};
                double[] Y = {5.0, 2.0, 3.0, 6.0, 3.0};

                int numpoints = 5;

                Parameters parameters = new Parameters();
                parameters.setAPts(1);
                parameters.setBPts(1);
                parameters.setRadius1(4);
                parameters.setRadius2(5);
                
                assertFalse(ConditionsMet.conditionThirteen(parameters, X, Y, numpoints));
        }

        @Test
          public void testRadius2NoFitConditionThirteen() {

                double[] X = {3.0, 5.0, 2.0, 7.0, 4.0};
                double[] Y = {5.0, 3.0, 1.0, 6.0, 3.0};

                int numpoints = 5;

                Parameters parameters = new Parameters();
                parameters.setAPts(1);
                parameters.setBPts(1);
                parameters.setRadius1(2);
                parameters.setRadius2(2);
                
                assertFalse(ConditionsMet.conditionThirteen(parameters, X, Y, numpoints));
        }
  
        @Test
          public void testPositiveConditionFourteen() {

                // Expected area is 4
                double[] X = {5.0, 9.0, 7.0, 2.0, 8.0};
                double[] Y = {5.0, 5.0, 7.0, 8.0, 2.0};

                int numpoints = 5;

                Parameters parameters = new Parameters();
                parameters.setEPts(1);
                parameters.setFPts(1);
                parameters.setArea1(2);
                parameters.setArea2(7);
                
                assertTrue(ConditionsMet.conditionFourteen(parameters, X, Y, numpoints));
        }

        @Test
        public void testFalseArea1ConditionFourteen() {

                double[] X = {5.0, 4.0, 9.0, 2.0, 1.0};
                double[] Y = {5.0, 5.0, 7.0, 6.0, 2.0};

                int numpoints = 5;

                Parameters parameters = new Parameters();
                parameters.setEPts(1);
                parameters.setFPts(1);
                parameters.setArea1(5);
                parameters.setArea2(7);

                assertFalse(ConditionsMet.conditionFourteen(parameters, X, Y, numpoints));
        }

        @Test
        public void testFalseArea2ConditionFourteen() {

                // Expected area is 4
                double[] X = {5.0, 9.0, 7.0};
                double[] Y = {5.0, 5.0, 7.0};

                int numpoints = 3;

                Parameters parameters = new Parameters();
                parameters.setEPts(1);
                parameters.setFPts(1);
                parameters.setArea1(2);
                parameters.setArea2(3);
                

                assertFalse(ConditionsMet.conditionFourteen(parameters, X, Y, numpoints));
        }

        @Test
        public void testFUVfalsePUV() {

                boolean[] PUV = { false, false, false };

                boolean[][] PUM = {
                                { true, false, true },
                                { false, true, true },
                                { true, true, true }
                };

                boolean[] expected = { true, true, true };

                assertArrayEquals(expected, Main.FUV(PUM, PUV));
        }

        @Test
        public void testFUVtruePUM() {

                boolean[] PUV = { true, true, true };

                boolean[][] PUM = {
                                { true, true, true },
                                { true, true, true },
                                { true, true, true }
                };

                boolean[] expected = { true, true, true };

                assertArrayEquals(expected, Main.FUV(PUM, PUV));
        }

        @Test
        public void testFUVfalsePUM() {

                boolean[] PUV = { true, true, true };

                boolean[][] PUM = {
                                { false, false, false },
                                { false, false, false },
                                { false, false, false }
                };

                boolean[] expected = { false, false, false };

                assertArrayEquals(expected, Main.FUV(PUM, PUV));
        }

        @Test
        public void testFUVonefalsePUM() {

                boolean[] PUV = { true, true, true };

                boolean[][] PUM = {
                                { true, true, true },
                                { true, true, false },
                                { true, true, true }
                };

                boolean[] expected = { true, false, true };

                assertArrayEquals(expected, Main.FUV(PUM, PUV));
        }

        @Test
        public void testLAUNCHtrue() {

                boolean[] FUV = { true, true, true };
                boolean expected = true;

                assertEquals(expected, Main.launch(FUV));
        }

        @Test
        public void testLAUNCHfalse() {

                boolean[] FUV = { false, false, false };
                boolean expected = false;

                assertEquals(expected, Main.launch(FUV));
        }
}