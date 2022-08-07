package pradee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MedzeUtil {
    public static String dateinsert(String x){
        String D=null;
        Scanner scn = new Scanner(System.in);
        System.out.print(x);
        String d = scn.next();
        if (d.matches("[0-3]{1}[0-9]{1}[/]{1}[0,1]{1}[0-9]{1}[/]{1}[1-9]{1}[0-9]{3}")) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date date1 = sdf.parse(d);
                D = d;
            } catch (ParseException e) {
                System.out.println("invalid date format" + d);
                dateinsert(x);
            }

        } else {
            System.out.println("invalid date format" + d+"\ncheck the digits of date MM-02 correct MM-18 wrong");
            dateinsert(x);
        }
        return D;
    }
    public static String gender(){
        int i;
        String g =null;
        Scanner scn =  new Scanner(System.in);
        System.out.print("1.male\t 2.female\t Gender:");
        i = scn.nextInt();
        switch (i) {
            case 1:
                g="MALE";
                break;
            case 2:
                g="FEMALE";
                break;
            default:
                System.out.println("invalid input!");
                g=gender();
                break;
        }
        return g;
    }
    public static String bloodinsert(){
        String r= null;
        Scanner scn = new Scanner(System.in);
        System.out.print("blood group:");
        String blood = scn.next();
        if(blood.equalsIgnoreCase("ab+")||blood.equalsIgnoreCase("ab-")||blood.equalsIgnoreCase("a+")||blood.equalsIgnoreCase("a-")||blood.equalsIgnoreCase("b+")||blood.equalsIgnoreCase("b-")||blood.equalsIgnoreCase("o+")||blood.equalsIgnoreCase("o-")){
            r = blood.toUpperCase();
        }else {
            System.out.println("ivalid input try again!");
            r = bloodinsert();
        }
        return r;
    }
    public static String dateViwe(Date x){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
        return sdf.format(x);
    }
    public static int iteration(){
        Scanner scn = new Scanner(System.in);
        System.out.println("\n1.next \t0.back choise:");
        int ch = 0;
        ch = scn.nextInt();
        if (ch == 1){
            System.out.println("====================================new====================================");
        } else if (ch == 0) {
            System.out.println("thank you");
        }else {
            System.out.print("invalid input");
            iteration();
        }
        return ch;
    }
}
