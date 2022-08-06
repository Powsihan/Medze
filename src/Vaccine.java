import java.io.*;
import java.util.*;

public class Vaccine implements Serializable{


    // Main Section for Vaccination Part
    public static void main() {

        VaccinePassword();  // Calling VaccinePassword section
    }

    public static void Vaccination()  {
        System.out.println("<================================================Welcome================================================>");
        System.out.println(".........................................................................................................");
        System.out.println(".........................................................................................................");
        System.out.println(".........................................................................................................");
        System.out.println("..................................Student's Union Campaign(Vaccination)-2022.............................");
        System.out.println("...........................................Uva Wellassa University.......................................");
        System.out.println(".........................................................................................................");
        System.out.println("This is Annual student's Union Campaign for Vaccination of Uva Wellassa University of 2022.");
        System.out.println("Please note the following during Vaccination......\n");
        System.out.println("\t=>\tVaccination will be open from 10.00am to 3 pm ,Every Saturday \n");
        System.out.println("\t=>\tVaccination for only UWU university Students and Staffs\n");
        System.out.println("<========================================================================================================>");
        Scanner Vaccine=new Scanner(System.in);

        int ch;

        do{
            System.out.println("\n<========================================================================================================>");
            System.out.println("\t\t\t\t\t\t\t\t\tMain Section...");
            System.out.println("<========================================================================================================>");
            System.out.println("\t1.Add Vaccine\t2.View Vaccine\t\t3.Vaccination\t\t0.Exit");
            System.out.println("\n<======================================================================================>");
            System.out.print("=>Enter your choice:");
            ch=Vaccine.nextInt();
            switch (ch){
                case 1:
                    VaccineCreate();  // Calling VaccineCreate section
                    break;
                case 2:
                    VaccineList();   // Calling VaccineList section
                    break;
                case 3:
                    System.out.println("<=============================================================>");
                    System.out.println("\t\t\t\tVaccination Section...");
                    System.out.println("<=============================================================>");
                    System.out.println("\t1.Student\t2.Staff\t\t0.Exit");
                    System.out.println("<=============================================================>");
                    System.out.print("=>Enter your choice:");
                    ch=Vaccine.nextInt();
                    switch (ch){
                        case 1:
                            Patient("Student","EnrollNo");   // Calling Student section
                            break;
                        case 2:
                            Patient("Staff","ID");     // Calling Staff section
                            break;
                        default:
                            break;
                    }
                    break;

                default:
                    break;

            }

        }while(ch!=0);

    }

    // VaccinePassword Section
    public static void VaccinePassword() {
        Scanner pass= new Scanner(System.in);
        int passV;
        do{
            System.out.print("===> Enter the Vaccine Unit Password : ");
            passV=pass.nextInt();

            if(passV==333){
                System.out.println("\n\n");
                Vaccination();              // Calling Vaccination Section
                System.out.println("\n\n");
            }
            else{
                System.out.println("Invalid Password.......Try Again.");
                System.out.println("\n<======================================================================================>");

            }
        }while(passV !=333);


    }

    // VaccineCreate Section
    public static void VaccineCreate(){
        try{
            int n, i;
            Scanner VAC=new Scanner(System.in);
            System.out.println("\n<=======================================CREATE LIST===============================================>\n");
            System.out.print("Enter how many vaccine you want to add:");
            n=VAC.nextInt();
            FileWriter Vac=new FileWriter("Vaccine-list.txt",true);
            PrintWriter Vaccine=new PrintWriter(Vac);
            System.out.println("\n<=======================================CREATE LIST===============================================>\n");
            for(i=0;i<n;i++){
                System.out.print("Enter the Vaccine Code:");
                String code=VAC.next();
                Vaccine.print(code+"\t\t============>\t\t");
                System.out.print("Enter the Vaccine Name:");
                String name=VAC.next();
                Vaccine.print(name+"\t\t\t\t============>\t\t");
                System.out.print("Enter the Vaccine Count:");
                int count=VAC.nextInt();
                Vaccine.println(count);
                FileWriter VaccineName=new FileWriter(code+".txt");
                System.out.println("\n<===================================================================================>\n");
                VaccineName.close();

            }
            System.out.println("Successfully Added..");
            System.out.println("\n<===================================================================================================>\n");

            Vaccine.close();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }


    }


    // Student Vaccination Section
    public static void Patient(String patient,String ID)  {
        try{
            Scanner Patients=new Scanner(System.in);
            System.out.print("Enter the "+patient+" "+ID+" :");
            String n1=Patients.next();
            System.out.println("\n<=======================================VACCINE LIST===============================================>\n");
            VaccineList();
            System.out.println("\n<==================================================================================================>\n");
            System.out.print("Enter the Vaccine Code:");
            String n2=Patients.next();
            File VaccineName=new File(n2+".txt");

            if(VaccineName.isFile()){

                BufferedReader ois;
                ois=new BufferedReader(new FileReader(VaccineName));
                String li=ois.readLine();
                //  Scanner Vc=new Scanner(VaccineName);

                boolean found=false;
                //  while (Vc.hasNextLine()) {
                if (n1.equals(li)) {
                    found = true;


                } else {
                    System.out.println("<===========================================================================>\n");
                    System.out.println("Press 1 for your Conformation");
                    System.out.println("\t1.Confirm\t\t0.Exit");
                    System.out.print("Enter Your choice : ");
                    int a=Patients.nextInt();
                    System.out.println("\n<===========================================================================>");
                    if (a == 1) {
                        li = n1;
                        FileWriter oos;
                        oos = new FileWriter(VaccineName, true);
                        BufferedWriter ops = new BufferedWriter(oos);
                        ops.write(li);
                        ops.newLine();
                        ops.flush();
                        ops.close();
                        System.out.println("Successfully Vaccinated....");
                        //Vc.nextLine();


                    }

                }
                // }
                if(found){
                    System.out.println("Already Vaccinated....");
                    // Vc.nextLine();

                }

            }else{
                System.out.println("file is not exist!");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    // VaccinationList Section
    public static void VaccineList(){
        try{

            File VAc=new File("Vaccine-list.txt");
            Scanner Vaccine=new Scanner(VAc);
            while(Vaccine.hasNextLine()){

                System.out.println(Vaccine.nextLine());
            }
        }catch(Exception e){
            System.out.println("Error");
        }
    }
}
