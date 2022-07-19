import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InterruptedException, IOException, ParseException {
        Scanner scn = new Scanner(System.in);
        animation();

int ch =-1;

        do{
            System.out.println("\n<========================================================================================================>");
            System.out.println("\t1.Admin\t\t2.Doctor\t\t3.Vaccine\t\t0.Exit");
            System.out.print("=>Enter your choice:");
            ch=scn.nextInt();
            switch (ch){
                case 1:
                    System.out.println("wel come to admin section");
                   admin();
                    break;
                case 2:
                    System.out.println("wel come doctor section");
                    break;
                case 3:
                   System.out.println("wel come");
                   Vaccine.main();
                    break;
                case 0:
                    System.out.println("thank you!");
                    break;
                default:
                    System.out.println("invalid input!");
                    break;



            }

        }while(ch!=0);



    }
    public static void loarding() throws InterruptedException {
        for (int i = 0; i < 24; i++)
        {
            System.out.print("#");
            Thread.sleep(100);
        }
    }
    public static void animation() throws InterruptedException {
        System.out.print("" +
                " \t\t\t#             #\n" +
                " \t\t\t##           ## \t######## \t#######   \t######## \t########\n" +
                " \t\t\t###         ### \t##       \t##     ## \t     ##  \t##\n" +
                " \t\t\t#####     ##### \t##       \t##     ## \t    ##   \t##\n" +
                " \t\t\t##  ##   ##  ## \t######   \t##     ## \t   ##    \t######\n" +
                " \t\t\t##    ###    ## \t##       \t##     ## \t  ##     \t##\n" +
                " \t\t\t##     #     ## \t##       \t##     ## \t ##      \t##\n" +
                " \t # #######           ## \t######## \t#######   \t######## \t########\n"+
                "\t\t\t             ##                                       \n"+
                "       \t\t\t         ");Main.loarding();System.out.print(" UWU ");Main.loarding();
                System.out.println("pradeee");
    }

    public static void admin() throws IOException, ParseException, ClassNotFoundException {
        Scanner scn = new Scanner(System.in);
        int ch =0;
        do {
            System.out.println("\n<========================================================================================================>");
            System.out.println("\t1.student\t\t2.satff\t\t3.drugs\t\t0.Exit");
            System.out.print("=>Enter your choice:");
            ch = scn.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("well come to student section");
                    Patient.main("Student", "enrollment number");
                    break;
                case 2:
                    System.out.println("well come to staff section");
                    Patient.main("staff", "staff ID");
                    break;
                case 3:
                    System.out.println("well come to drugs section");
                    Drug.main();
                    break;
                case 0:
                    System.out.println("thank you!");
                    break;
                default:
                    System.out.println("invalid input!");
                    break;
            }
        }while (ch != 0);
    }
}