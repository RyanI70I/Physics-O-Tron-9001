package Ryan.Testing;
import java.util.ArrayList;



public class Main {
    public static ArrayList<double[]> slopes = new ArrayList<double[]>();

    public static void main(String[] args) throws InterruptedException {



        double[] ActVolt = {.66, 418, 7, 65};
//        double[] ActVolt = {.57, 301, 6.5, 55};
//        double[] ActVolt = {.55, 309, 5.1, 55};

        //{radius, omega, F tesnion, theta)
        double[] uncert = {.05,15,.1,7.5};
//        double[] uncert = {.05,15,.1,5};
//        double[] uncert = {.05,15,.1,5};

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
        double Fmax2 = -9999;
        double Fmin2 = 99999;
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
                            System.out.println(Fmax2);
                            System.out.println(Fmin2);
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
                                        double Fnet2 = Math.sin(Math.toRadians(ActVolts[3][o])) * ActVolts[2][n];
                                        if(Fnet2 > Fmax2) {
                                            Fmax2 = Fnet;
                                        }
                                        else if(Fnet2 < Fmin2) {
                                            Fmin2 = Fnet2;
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
        double out = Math.pow(Math.toRadians(ActVolt[1]), 2) * (((Math.cos(Math.toRadians(ActVolt[3]))) * ActVolt[2])/9.8) * ActVolt[0];
        double out2 = Math.sin(Math.toRadians(ActVolt[3])) * ActVolt[2];
        double mass = ((Math.cos(Math.toRadians(ActVolt[3]))) * ActVolt[2])/9.8;
        System.out.println("FINAL MAX MASS " + massMax);
        System.out.println("FINAL MIN MASS " + + massMin);
        System.out.println("FINAL MAX FNET " + Fmax);
        System.out.println("FINAL MIN FNEt " + + Fmin);
        System.out.println("FINAL MAX FNET2 " + Fmax2);
        System.out.println("FINAL MIN FNEt2 " + + Fmin2);
        System.out.println("Final FNET " + out);
        System.out.println("Up Add " + (Fmax - out));
        System.out.println("Down Add " + (out - Fmin));
        System.out.println("Final FNET2 " + out2);
        System.out.println("Up Add2 " + (Fmax2 - out2));
        System.out.println("Down Add2 " + (out2 - Fmin2));
        System.out.println("Final Mass " + mass);
        System.out.println("Up Add2 " + (massMax - mass));
        System.out.println("Down Add2 " + (mass - massMin));
    }

            }


