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
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t Main Section");
            System.out.println("<========================================================================================================>");
            System.out.println("\t\t\t\t\t1.Administration\t\t2.Doctor\t\t3.Vaccination\t\t0.Exit");
            System.out.println("<-------------------------------------------------------------------------------------------------------->");
            System.out.print("=>Enter your choice:");
            ch=scn.nextInt();
            switch (ch){
                case 1:
                    AdminPassword();
                    break;
                case 2:
                    System.out.println("\n<========================================================================================================>");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t Welcome to Doctor Section");
                    System.out.println("<========================================================================================================>");
                    Doctor.main();
                    break;
                case 3:
                    System.out.println("\n<========================================================================================================>");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t Welcome to Vaccination Section");
                    System.out.println("<========================================================================================================>");
                    Vaccine.main();
                    break;
                case 0:
                    System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t  Thank You...");
                    System.out.println("<-------------------------------------------------------------------------------------------------------->");
                    break;
                default:
                    System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t  Invalid Input...");
                    System.out.println("<-------------------------------------------------------------------------------------------------------->");
                    break;
            }

        }while(ch!=0);



    }
    //Lording loop Section....
    public static void loarding() throws InterruptedException {
        for (int i = 0; i < 24; i++)
        {
            System.out.print("#");
            Thread.sleep(30);
        }
    }
    //Animation Section....
    public static void animation() throws InterruptedException {
        System.out.println("\n<========================================================================================================>\n");
        System.out.print("" +
                " \t\t\t\t#             #\n" +
                " \t\t\t\t##           ## \t######## \t#######   \t######## \t########\n" +
                " \t\t\t\t###         ### \t##       \t##     ## \t     ##  \t##\n" +
                " \t\t\t\t#####     ##### \t##       \t##     ## \t    ##   \t##\n" +
                " \t\t\t\t##  ##   ##  ## \t######   \t##     ## \t   ##    \t######\n" +
                " \t\t\t\t##    ###    ## \t##       \t##     ## \t  ##     \t##\n" +
                " \t\t\t\t##     #     ## \t##       \t##     ## \t ##      \t##\n" +
                " \t\t # #######           ## \t######## \t#######   \t######## \t########\n"+
                "\t\t\t\t             ##                                       \n"+
                "       \t\t\t\t         ");Main.loarding();System.out.print(" UWU ");Main.loarding();
        System.out.println(" CST-Team-07");
        System.out.println("\t\t\t\t\t\t\t\tDigital Medical System of Uva Wellassa University");
        System.out.println("\t\t\t\t\t\t\t\t\tPradee\tNusnan\tPowsi\tThanu\tJoshi");
    }
    //Admin join Section....

    public static void admin() throws IOException, ParseException, ClassNotFoundException {
        Scanner scn = new Scanner(System.in);
        int ch =0;
        do {
            System.out.println("\n<========================================================================================================>");
            System.out.println("\t\t\t\t\t\t\t\t\t Welcome to Administration Section");
            System.out.println("<========================================================================================================>");
            System.out.println("\t\t\t\t\t\t\t1.Student\t\t2.Staff\t\t3.Drugs\t\t0.Exit");
            System.out.println("<-------------------------------------------------------------------------------------------------------->");
            System.out.print("=>Enter your choice:");
            ch = scn.nextInt();
            switch (ch) {
                case 1:
                    Admin.main("Student", "Enrollment number");
                    break;
                case 2:
                    Admin.main("Staff", "Staff ID");
                    break;
                case 3:
                    Drug.main();
                    break;
                case 0:
                    System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t  Thank You...");
                    System.out.println("<-------------------------------------------------------------------------------------------------------->");
                    break;
                default:
                    System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t  Invalid Input...");
                    System.out.println("<-------------------------------------------------------------------------------------------------------->");
                    break;
            }
        }while (ch != 0);
    }
    // Admin Password Section

    public static void AdminPassword()throws IOException, ParseException, ClassNotFoundException  {
        Scanner pass= new Scanner(System.in);
        int passV;
        do{
            System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
            System.out.print("===> Enter the Administration Section Password : ");
            passV=pass.nextInt();

            if(passV==111){
                admin();
            }
            else{
                System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
                System.out.println("\t\t\t\t\t\t\t\t\t\t  Invalid Password Try Again...");
                System.out.println("<-------------------------------------------------------------------------------------------------------->");

            }
        }while(passV !=111);


    }
}