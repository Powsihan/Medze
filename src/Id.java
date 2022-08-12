import java.util.Scanner;
//This is to validate the ID
public class Id {

    public static String courseS(String patient){
        String fine = null;
        Scanner scn = new Scanner(System.in);
        String input = scn.next();
        if (namecheck(input)) { //Call the namecheck function to validate the ID
            if (input.matches("[A-z]{3}[2-9]{1}[0-9]{4}")) { //Validate ID as the ID should contain 5 characters it cannot be more or less than 5. It should be as three characters and 5 numbers
                fine = input;

            } else {
                System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
                System.out.println("Invalid " + patient +" "+input + "\nCheck the ID Eg : (CSTXXXXX)");
                System.out.println("<-------------------------------------------------------------------------------------------------------->");
                System.out.print("=>\t"+patient+" (CSTXXXXX)"+" : ");
                fine=courseS(patient);
            }
        }
        else {
            System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
            System.out.println("Invalid " + patient +" "+input + "\nCheck the ID Eg : (CSTXXXXX)");
            System.out.println("<-------------------------------------------------------------------------------------------------------->");
            System.out.print("=>\t"+patient+" (CSTXXXXX)"+" : ");
            fine=courseS(patient);
        }

        return fine;
    }
    //All the course names are saved in a string array and compared using a string.
private static boolean namecheck(String name){
        boolean grant = false ;
    String[] course= {"CST","IIT","MRT","SCT","ENM","ANS","EAG","HTE","BST","BET","HRD","AQT","PLT","TEA","ICT","STF"};
    for (int i = 0; i < 16; i++) {
        if (course[i].equalsIgnoreCase(name.substring(0, 3))) { //Checks only the first three characters of the inputed string
            grant = true;
            break;
        }
    }
        return grant;
}
}
