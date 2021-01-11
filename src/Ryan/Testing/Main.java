package Ryan.Testing;
import java.util.ArrayList;



public class Main {
    public static ArrayList<double[]> slopes = new ArrayList<double[]>();

    public static void main(String[] args) throws InterruptedException {



        double[] ActVolt = {.58, 282, 4.9, 50};
        //{radius, omega, F tesnion, theta)
        double[] uncert = {.05,25,.3,10};
        // uncert of {radius, omega, F tesnion, theta)



        // Actvolts[n][m] n corresponds to what LED it is (ie 416nm 501nm) m is filled with 10 possible values for
        // the voltage of the LED based on the Uncertainty
        double[][] ActVolts = new double[4][10];
        for (int i = 0; i < ActVolt.length; i++) {
            for (int j = 0; j < 5; ) {
                j++;

                ActVolts[i][j-1] = ActVolt[i] + uncert[i] * .2 * j;
            }
            for (int j = 5; j < 10;) {
                j++;
                ActVolts[i][j-1] = ActVolt[i] - (uncert[i] * .2 * (j/2));
            }
        }
        //This Finds every possible compination of errors and their slope
        //and saves the min/max slope

        int count = 0;
        double massMax = -9999;
        double massMin = 99999;
        double Fmax = -9999;
        double Fmin = 99999;
        for (int j = 0; j < 10; j++) {
//            System.out.println(massMax);
//            System.out.println(massMin);
//            System.out.println(Fmax);
//            System.out.println(Fmin);
//            for (int k = 0; k < 10; k++) {
//                for (int l = 0; l < 10; l++) {
//                    for (int m = 0; m < 10; m++) {
                        for (int n = 0; n <10 ; n++) {

            System.out.println(massMax);
            System.out.println(massMin);
            System.out.println(Fmax);
            System.out.println(Fmin);
                            for (int o = 0; o < 10; o++) {
                                for (int p = 0; p < 10; p++) {
                                    for (int q = 0; q < 10; q++) {


//
                                        double mass = ((Math.cos(Math.toRadians(ActVolts[3][q]))) * ActVolts[2][p])/9.8;
                                        double Fnet = Math.pow(Math.toRadians(ActVolts[1][o]), 2) * mass * ActVolts[0][n];
                                        if(mass > massMax) {
                                            massMax = mass;
                                        } else if(mass<massMin) {
                                            massMin = mass;
                                        }
                                        if(Fnet > Fmax) {
                                            Fmax = Fnet;
                                        }
                                        else if(Fnet < Fmin) {
                                            Fmin = Fnet;
                                        }
//                                            System.out.println(ActVolts[1][k]);
//                                            System.out.println(ActVolts[0][j]);
//                                            System.out.println(ActVolts[2][l]);
//                                            System.out.println(ActVolts[3][m]);
//                                            System.out.println(ActVolts[4][m]);
//                                            System.out.println(ActVolts[5][o]);
//                                            System.out.println(ActVolts[6][p]);
//                                            System.out.println(InvLambda[0]);
//                                            System.out.println(InvLambda[1]);
//                                            System.out.println(InvLambda[2]);
//                                            System.out.println(InvLambda[3]);
//                                            System.out.println(InvLambda[4]);
//                                            System.out.println(InvLambda[5]);
//                                            System.out.println(InvLambda[6]);
//                                            System.out.println();
//                                            Thread.sleep(5000);
                                        //Debugging stuff

//                                            slopes.add(new double[] {ActVolts[0][j], ActVolts[1][k], ActVolts[0][l], ActVolts[1][m], ActVolts[0][n], ActVolts[1][o], ActVolts[0][p]});
                                    }


                                }

                            }

                        }

                    }
        System.out.println("FINAL MAX MASS " + massMax);
        System.out.println("FINAL MIN MASS " + + massMin);
        System.out.println("FINAL MAX FNET " + Fmax);
        System.out.println("FINAL MIN FNEt " + + Fmin);

                }

            }


