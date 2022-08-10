import java.util.Scanner;

public class Id {
//    String[] course= {'CST','IIT','MRT','SCT','ENM','ANS','EAG','HTE','BST','BET','HRD','AQT','PLT','TEA','ICT','STF'};
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public static String courseS(String patient){
        String fine = null;
        Scanner scn = new Scanner(System.in);
        System.out.print("=>\t" + patient + "number:");

        String input = scn.next();
        if (input.matches("['CST','IIT','MRT','SCT','ENM','ANS','EAG','HTE','BST','BET','HRD','AQT','PLT','TEA','ICT','STF']{3}[2-9]{1}[0-9]{4}")) {
            fine = input;

        } else {
            System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
            System.out.println("\t\t\tInvalid" + patient + input + "\nCheck the ID Eg:xxx");
            System.out.println("<-------------------------------------------------------------------------------------------------------->");
            fine=courseS(patient);
        }
        return fine;
    }
//    private static String Name()

}
