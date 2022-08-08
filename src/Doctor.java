import pradee.MedzeUtil;
import pradee.PradiArray;

import java.io.*;
import java.util.Scanner;


public class Doctor implements Serializable{
    public static void main(){
        DoctorPassword();
    }

    public static void Enquire()
    {
        Scanner DoctorI=new Scanner(System.in);

        int ch;

        do{
            System.out.println("<==============================================================================================================>");
            System.out.println("<================================================Doctor Section================================================>");
            System.out.println("<==============================================================================================================>");
            System.out.println("\t1.Student\t2.Staff\t\t0.Exit");
            System.out.println("\n<========================================================================================>");
            System.out.print("=>Enter your choice:");
            ch= DoctorI.nextInt();
            System.out.println("<==============================================================================================================>");
            switch (ch){
                case 1:
                    PatientV("Student","EnrollNo");

                    break;
                case 2:
                    PatientV("Staff","ID");
                    break;


                default:
                    break;

            }
        }while(ch!=0);
    }

    public static void PatientV(String patient,String ID){
        try{
            Scanner Presc=new Scanner(System.in);
            Scanner scn=new Scanner(System.in);
            String idnum;

            System.out.println("<=============================================Prescription Section=============================================>");
            System.out.println("<==============================================================================================================>\n");
        //  File PatientName=null;
           // Patient.search(patient, ID);
            System.out.print("enter"+ID+":");
            idnum = scn.next();
            if (Admin.consist(patient,idnum)){

                FileWriter PatientName=new FileWriter(ID+".txt");
            }else {
                System.out.println("<-------------------------------------------------------------------------------------------------------->");
                System.out.println("\t\t\t\t\t\t\t\t\t patient not found!");
                System.out.println("<-------------------------------------------------------------------------------------------------------->");

            }
            System.out.println("\n<===================================================================================>\n");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }


    }

    public static void DoctorPassword() {
        Scanner pass = new Scanner(System.in);
        int passV;
        do {
            System.out.print("===> Enter the Doctor Unit Password : ");
            passV = pass.nextInt();

            if (passV == 222) {
                System.out.println("\n\n");
                Enquire();
                System.out.println("\n\n");
            } else {
                System.out.println("Invalid Password.......Try Again.");
                System.out.println("\n<======================================================================================>");

            }
        } while (passV != 222);

    }
    private static void patientsearch(String patient,String id) throws IOException, ClassNotFoundException {
        File file = new File(patient+".txt");
        ObjectInputStream ois = null;
        PradiArray<Patient> sal = new PradiArray<>();
        Scanner scn = new Scanner(System.in);
        System.out.println("\n<========================================================================================================>");
        System.out.println("\t\t\t\t\t\t\t\t\t Welcome to Data Search Section");
        System.out.println("<-------------------------------------------------------------------------------------------------------->");
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            sal = (PradiArray<Patient>) ois.readObject();
            ois.close();
            boolean found = false;
            System.out.print("Enter "+id+" Number to Search : ");
            String search = scn.nextLine();
            for (Patient st : sal) {
                if (search.equalsIgnoreCase(st.getE_no())) {
                    System.out.println("\n<========================================================================================================>");
                    System.out.println("Patient Details :\t"+st.getE_no() + " " + st.getName() + " " + MedzeUtil.dateViwe(st.getDate()) + " " + st.getGender() + " " + st.getBlood() + " " + st.getContact() + " " + st.getAllergy());
                    System.out.println("<========================================================================================================>");
                    found = true;
                }
            }
            if (!found) {
                System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
                System.out.println("\t\t\t\t\t\t\t\t\t\t  "+patient+" not found...");
                System.out.println("<-------------------------------------------------------------------------------------------------------->");
            }
        }else {
            System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
            System.out.println("\t\t\t\t\t\t\t\t\t\t  File is not Exist...");
            System.out.println("<-------------------------------------------------------------------------------------------------------->");
        }
        System.out.println("\n<========================================================================================================>");
    }
}