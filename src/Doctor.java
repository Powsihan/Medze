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

            System.out.println("<=============================================Prescription Section=============================================>");
            System.out.println("<==============================================================================================================>\n");
        //  File PatientName=null;
            Patient.search(patient, ID);
            System.out.print("Display Patient details");

          //  if (PatientName.isFile()) {
                FileWriter PatientName=new FileWriter(ID+".txt");
          //  }

            System.out.println("\n<===================================================================================>\n");
            PatientName.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }


    }

    public static void DoctorPassword() {
        Scanner pass= new Scanner(System.in);
        int passV;
        do{
            System.out.print("===> Enter the Doctor Unit Password : ");
            passV=pass.nextInt();

            if(passV==222){
                System.out.println("\n\n");
                Enquire();
                System.out.println("\n\n");
            }
            else{
                System.out.println("Invalid Password.......Try Again.");
                System.out.println("\n<======================================================================================>");

            }
        }while(passV !=222);
    }
}