package pradee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*; //Get the local time
import java.util.Date; // Get the local Date
import java.util.Scanner;

public class MedzeUtil {
    public static String dateinsert(String x) { //Check the date format and returns the string
        String D = null;
        Scanner scn = new Scanner(System.in);
        System.out.print(x);
        String d = scn.next();
        if (d.matches("[0-3]{1}[0-9]{1}[/]{1}[0,1]{1}[0-9]{1}[/]{1}[1-9]{1}[0-9]{3}") && !d.matches("[3]{1}[2-9]{1}[/]{1}[0,1]{1}[0-9]{1}[/]{1}[1-9]{1}[0-9]{3}")) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date date1 = sdf.parse(d);
                D = d;
            } catch (ParseException e) {
                System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
                System.out.println("Invalid date format" + d + e);
                System.out.println("<-------------------------------------------------------------------------------------------------------->");
                D = dateinsert(x);
            }

        } else {
            System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
            System.out.println("\t\t\tInvalid Date Format" + d + "\nCheck the digits of date MM-02 correct MM-18 wrong");
            System.out.println("<-------------------------------------------------------------------------------------------------------->");

            D = dateinsert(x);
        }
        return D;
    }

    public static String gender() { //Input the gender
        int i;
        String g = null;
        Scanner scn = new Scanner(System.in);
        System.out.print("=>\t" + "Gender" + " (1.Male\t 2.Female\t)" + " : ");
        i = scn.nextInt();
        switch (i) {
            case 1:
                g = "MALE";
                break;
            case 2:
                g = "FEMALE";
                break;
            default:
                System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t  Invalid Input...");
                System.out.println("<-------------------------------------------------------------------------------------------------------->");
                g = gender();
                break;
        }
        return g;
    }

    public static String bloodinsert() { //Insert Blood group
        String r = null;
        Scanner scn = new Scanner(System.in);
        System.out.print("=>\t" + "Blood Group" + " (a+,a-,b+,b-,o+,o-,ab+,ab-)" + " : ");
        String blood = scn.next();
        if (blood.equalsIgnoreCase("ab+") || blood.equalsIgnoreCase("ab-") || blood.equalsIgnoreCase("a+") || blood.equalsIgnoreCase("a-") || blood.equalsIgnoreCase("b+") || blood.equalsIgnoreCase("b-") || blood.equalsIgnoreCase("o+") || blood.equalsIgnoreCase("o-")) {
            r = blood.toUpperCase();
        } else {
            System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t  Invalid Input...");
            System.out.println("<-------------------------------------------------------------------------------------------------------->");
            r = bloodinsert();
        }
        return r;
    }

    public static String dateViwe(Date x) { //View the date according to this format
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
        return sdf.format(x);
    }

    public static String age(Date dob) throws ParseException { //Calculate the age using the current date and DOB

        //Converting obtained Date object to LocalDate object
        Instant instant = dob.toInstant();
        ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
        LocalDate givenDate = zone.toLocalDate();
        Period period = Period.between(givenDate, LocalDate.now());

        String age1 = period.getYears() + " years " + period.getMonths() + " months ";
        return age1;
    }

    public static String contact() { //Check whether the contact number contains 10 digits
        String fine = null;
        Scanner scn = new Scanner(System.in);
        System.out.print("=>\t"+"Contact Number (07XXXXXXXX): ");
        String d = scn.next();
        if (d.matches("[0]{1}[0-9]{9}")) {
            fine = d;
        } else {
            System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
            System.out.println("\t\t\tInvalid Phone Number" + d + "\nCheck the number Eg:0771234567");
            System.out.println("<-------------------------------------------------------------------------------------------------------->");
            fine = contact();
        }
        return fine;
    }
    //Iterates until the user enter an input
    public static int iteration() {
        Scanner scn = new Scanner(System.in);
        System.out.println("\n<========================================================================================================>");
        System.out.println("\t\t\t\t\t\t\t\t1.Next \t\t0.Back Choice");
        System.out.println("<-------------------------------------------------------------------------------------------------------->");
        System.out.print("=>Enter Your Choice : ");
        int ch = 0;
        ch = scn.nextInt();
        if (ch == 1) {
            System.out.println("\n<======================================================New===============================================>");
        } else if (ch == 0) {
            System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t  Thank You...");
            System.out.println("<-------------------------------------------------------------------------------------------------------->");
        } else {
            System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t  Invalid Input...");
            System.out.println("<-------------------------------------------------------------------------------------------------------->");
            ch = iteration();
        }
        return ch;
    }
}
