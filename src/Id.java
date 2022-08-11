import java.util.Scanner;

public class Id {
//    String[] course= {'CST','IIT','MRT','SCT','ENM','ANS','EAG','HTE','BST','BET','HRD','AQT','PLT','TEA','ICT','STF'};
    public static String courseS(String patient){
        String fine = null;
        Scanner scn = new Scanner(System.in);
        String input = scn.next();
        if (namecheck(input)) {
            if (input.matches("[A-z]{3}[2-9]{1}[0-9]{4}")) {
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
private static boolean namecheck(String name){
        boolean grant = false ;
    String[] course= {"CST","IIT","MRT","SCT","ENM","ANS","EAG","HTE","BST","BET","HRD","AQT","PLT","TEA","ICT","STF"};
    for (int i = 0; i < 16; i++) {
        if (course[i].equalsIgnoreCase(name.substring(0, 3))) {
            grant = true;
            break;
        }
    }
        return grant;
}
}
