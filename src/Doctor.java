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
            System.out.println("\t1.View details\t2.prescription\t\t0.Exit");
            System.out.println("\n<========================================================================================>");
            System.out.print("=>Enter your choice:");
            ch= DoctorI.nextInt();
            System.out.println("<==============================================================================================================>");
            switch (ch){
                case 1:
                    System.out.println("x");

                    break;
                case 2:
                    prescription();
                    break;


                default:
                    break;

            }
        }while(ch!=0);
    }

    public static void prescription(){
        try{
            Scanner Presc=new Scanner(System.in);

            System.out.println("<=============================================Prescription Section=============================================>");
            System.out.println("<==============================================================================================================>\n");
            System.out.print("Enter the Student Enroll No:");
            String n=Presc.next();
            System.out.print("Display Patient details");
            FileWriter PatientName=new FileWriter(n+".txt");
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