import java.io.*;
import java.util.ArrayList;
import java.util.*;


public class Vaccine {
    String E_No;
    Vaccine(String e_No){
        this.E_No=e_No;
    }


    public static void main() throws IOException, ClassNotFoundException {

        VaccinePassword();
    }

    public static void Vaccination1() throws IOException, ClassNotFoundException {
        System.out.println("<================================================Welcome================================================>");
        System.out.println(".........................................................................................................");
        System.out.println(".........................................................................................................");
        System.out.println(".........................................................................................................");
        System.out.println("......................................Student\'s Union Campaign(Vaccination)-2022........................");
        System.out.println(".........................................Uva Wellassa University.........................................");
        System.out.println(".........................................................................................................");
        System.out.println("This is Annual student\'s Union Campaign for Vaccination of Uva Wellassa University of 2022.");
        System.out.println("Please note the following during Vaccination......\n");
        System.out.println("\t=>\tVaccination will be open from 10.00am to 3 pm ,Every Saturday \n");
        System.out.println("\t=>\tVaccination for only UWU university Students and Staffs\n");
        System.out.println("<========================================================================================================>");
        Scanner Vaccine=new Scanner(System.in);

        int ch;

        do{
            System.out.println("<========================================================================================================>");
            System.out.println("\t1.Student\t2.Staff\t\t3.Add Vaccine\t4.Display Vaccine List\t\t0.Exit");
            System.out.println("\n<======================================================================================>");
            System.out.print("=>Enter your choice:");
            ch=Vaccine.nextInt();
            switch (ch){
                case 1:
                    Student();

                    break;
                case 2:
                    Student();
                    break;
                case 3:
                    VaccineCreate();
                    break;
                case 4:
                    VaccineList();
                    break;

                default:
                    break;



            }

        }while(ch!=0);



    }



    public static void VaccinePassword() throws IOException, ClassNotFoundException {
        Scanner pass= new Scanner(System.in);
        int passV;
        do{
            System.out.print("===> Enter the Vaccine Unit Password : ");
            passV=pass.nextInt();

            if(passV==333){
                System.out.println("\n\n");
                Vaccination1();
                System.out.println("\n\n");
            }
            else{
                System.out.println("Invalid Password.......Try Again.");
                System.out.println("\n<======================================================================================>");

            }
        }while(passV !=333);


    }

    public static void VaccineCreate(){
        try{

            int n, i;
            Scanner VAC=new Scanner(System.in);
            System.out.println("\n<=======================================CREATE LIST===============================================>\n");
            System.out.print("Enter how many vaccine you want to add:");
            n=VAC.nextInt();
            FileWriter Vac=new FileWriter("Vaccinelist.txt",true);
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

        }catch (Exception e){
            System.out.println("Error");
        }


    }

    public static void Student() throws IOException, ClassNotFoundException {

        Scanner Student=new Scanner(System.in);
        System.out.print("Enter the Student EnrollNo:");
        String n1=Student.next();
        System.out.println("\n<=======================================VACCINE LIST===============================================>\n");
        VaccineList();
        System.out.println("\n<==================================================================================================>\n");
        System.out.print("Enter the Vaccine Code:");
        String n2=Student.next();
        File file=new File(n2+".txt");

        // Scanner VaccineDet=new Scanner(VAcc);
        if (file.isFile()) {
            ArrayList<Vaccine> sal = new ArrayList<>();
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));


            sal = (ArrayList<Vaccine>) ois.readObject();
            ois.close();
            boolean found = false;
            //String search = VaccineDet.nextLine();


            for (Vaccine st : sal) {
                if (n1.equals(st.E_No)) {
                    System.out.println("Already Vaccinated....");
                    found = true;
                }
                else{
                    Vaccine StD=new Vaccine(n1);
                    sal.add(StD);

                    // PrintWriter Student1=new PrintWriter(VAcc);
                    // Student1.println(n1);

                    ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(file));

                    System.out.println("Successfully Vaccinated....");
                    oos.close();

                    //Student1.close();
                }
                // VaccineDet.close();
            }
            if (!found) {
                System.out.println("Patient not found");
            }
        }else {
            System.out.println("file is not exist!");
        }


        System.out.println("=============================================================================================================");





    }

    public static void VaccineList(){
        try{

            File VAc=new File("Vaccinelist.txt");
            Scanner Vaccine=new Scanner(VAc);
            while(Vaccine.hasNextLine()){

                System.out.println(Vaccine.nextLine());
            }
        }catch(Exception e){
            System.out.println("Error");
        }
    }
}
