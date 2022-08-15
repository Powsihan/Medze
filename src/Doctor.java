import pradee.PradiArray;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;



public class Doctor implements Serializable{
    // Main Section for doctor Part
    public static void main() {DoctorPassword();}    //Calling doctor Password section

    //Enquire section
    public static void Enquire()
    {
        Scanner DoctorI=new Scanner(System.in);
        int ch=0;
        do{
            System.out.println("\n<========================================================================================================>");
            System.out.println("\t\t\t\t\t\t\t\t\t Welcome to Doctor Section");
            System.out.println("<========================================================================================================>");
            System.out.println("\t\t\t\t\t\t\t1.Student\t\t\t2.Staff\t\t\t0.Exit");
            System.out.println("<-------------------------------------------------------------------------------------------------------->");
            System.out.print("=>Enter your choice : ");
            ch= DoctorI.nextInt();
            switch (ch){
                case 1:
                    PatientV("Student","EnrollNo");

                    break;
                case 2:
                    PatientV("Staff","ID");
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
   //Case detail section
    public static void PatientV(String patient,String ID){
        try{
            Scanner scn=new Scanner(System.in);
            String idnum;
            System.out.println("\n<========================================================================================================>");
            System.out.println("\t\t\t\t\t\t\t\t\t Welcome to Case Details Section");
            System.out.println("<-------------------------------------------------------------------------------------------------------->");
            System.out.print("Enter the "+patient+" "+ID+" : ");
            idnum = scn.next();
            if (Admin.consist(patient,idnum)){
               report(idnum); // calling report section
            }else {
                System.out.println("<-------------------------------------------------------------------------------------------------------->");
                System.out.println("\t\t\t\t\t\t\t\t\t\t patient not found!");
                System.out.println("<-------------------------------------------------------------------------------------------------------->");

            }
            System.out.println("\n<========================================================================================================>");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }


    }

    // Doctor Password Section
    public static void DoctorPassword() {
        Scanner pass = new Scanner(System.in);
        int passV;
        do {
            System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
            System.out.print("=>\tEnter the Doctor Section Password : ");
            passV = pass.nextInt();

            if (passV == 222) {
                Enquire();    // Calling Enquire Section
            } else {
                System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
                System.out.println("\t\t\t\t\t\t\t\t\t\t  Invalid Password Try Again...");
                System.out.println("<-------------------------------------------------------------------------------------------------------->");
            }
        } while (passV != 222);

    }
    // report Section
    public static void report(String Id) throws IOException, ClassNotFoundException, ParseException {
        System.out.println("\n<========================================================================================================>");
        System.out.println("\t\t\t\t\t\t\t\t\t Welcome to Report Section");
        System.out.println("<-------------------------------------------------------------------------------------------------------->");
        Scanner scn = new Scanner(System.in);
        Scanner scnum = new Scanner(System.in);
        ObjectOutputStream oos = null;
        PradiArray<CaseDetail> sal = new PradiArray<>();
        File file =new File("DoctorFiles\\"+Id+".UWU");
        if(file.isFile()){
            ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(file));
            sal = (PradiArray<CaseDetail>) ois.readObject();
            ois.close();
            for (CaseDetail st : sal) {
                System.out.println(st);
                System.out.println("<========================================================================================>");
            }
        }
        System.out.println("\n<========================================================================================================>");
        System.out.println("Press 1 for Type Prescription");
        System.out.println("<------------------------------------------------------------------------------------------------->");
        System.out.println("\t\t1.Confirm\t\t\t0.Exit");
        System.out.println("<------------------------------------------------------------------------------------------------->");
            System.out.print("=>\tEnter Your choice : ");
            int a=scnum.nextInt();
            System.out.println("<------------------------------------------------------------------------------------------------->");
            if (a == 1) {
                CaseDetail report01 = new CaseDetail();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date dateV=new Date(); // current date and time
                report01.setCurrentDate(formatter.format(dateV));
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t Type report...");
                System.out.println("<------------------------------------------------------------------------------------------------->\n");
                System.out.print("Type Here : ");
                report01.setData(scn.nextLine());
                sal.add(report01);
                System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
                System.out.println("\t\t\t\t\t\t\t\t\t\t  Successfully Added...");
                System.out.println("<-------------------------------------------------------------------------------------------------------->");
                System.out.println("<========================================================================================================>");
                System.out.println("Press 1 to show the Drug Details");
                System.out.println("\t\t1.Confirm\t\t\t0.Exit");
                System.out.println("<------------------------------------------------------------------------------------------------->");
                System.out.print("=>\tEnter Your choice : ");
                int b = scnum.nextInt();
                System.out.println("<-------------------------------------------------------------------------------------------------------->");
                if (b == 1) {
                    Drug.Druglist(); // calling drug list
                }

            }
        oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(sal);
        oos.close();
        }


    }
