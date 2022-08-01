import java.io.*;
import java.util.*;


public class Vaccine implements Serializable{

    public static void main() {

        VaccinePassword();
    }

    public static void Vaccination1()  {
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
            System.out.println("\t1.Add Vaccine\t2.View Vaccine\t\t3.Vaccination\t\t0.Exit");
            System.out.println("\n<======================================================================================>");
            System.out.print("=>Enter your choice:");
            ch=Vaccine.nextInt();
            switch (ch){
                case 1:
                    VaccineCreate();
                    break;
                case 2:
                    VaccineList();
                    break;
                case 3:
                    System.out.println("<========================================================================================================>");
                    System.out.println("\t1.Student\t2.Staff\t\t0.Exit");
                    System.out.println("\n<======================================================================================>");
                    System.out.print("=>Enter your choice:");
                    ch=Vaccine.nextInt();
                    switch (ch){
                        case 1:
                            Student();
                            break;
                        case 2:
                            Staff();
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

    public static void VaccinePassword() {
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

        }catch (Exception e){
            System.out.println("Error");
        }


    }

    public static void Student()  {
        try{
            Scanner Student=new Scanner(System.in);
            System.out.print("Enter the Student EnrollNo:");
            String n1=Student.next();
            System.out.println("\n<=======================================VACCINE LIST===============================================>\n");
            VaccineList();
            System.out.println("\n<==================================================================================================>\n");
            System.out.print("Enter the Vaccine Code:");
            String n2=Student.next();
            File VaccineName=new File(n2+".txt");

            if(VaccineName.isFile()){
                BufferedReader ois;
                ois=new BufferedReader(new FileReader(VaccineName));
                String li=ois.readLine();
                boolean found=false;
                while (li.isBlank()) {
                    if (n1.equals(li)) {
                        found = true;
                    } else {
                        li = n1;
                        FileWriter oos;
                        oos = new FileWriter(VaccineName, true);
                        BufferedWriter ops = new BufferedWriter(oos);
                        ops.write(li);
                        ops.newLine();
                        ops.flush();
                        ops.close();
                        System.out.println("Successfully Vaccinated....");
                    }
                }
                if(found){
                    System.out.println("Already Vaccinated....");
                }

            }else{
                System.out.println("file is not exist!");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void Staff()  {
        try{
            Scanner Staff=new Scanner(System.in);
            System.out.print("Enter the Staff EnrollNo:");
            String n1=Staff.next();
            System.out.println("\n<=======================================VACCINE LIST===============================================>\n");
            VaccineList();
            System.out.println("\n<==================================================================================================>\n");
            System.out.print("Enter the Vaccine Code:");
            String n2=Staff.next();
            File VaccineName=new File(n2+".txt");

            if(VaccineName.isFile()){
                BufferedReader ois;
                ois=new BufferedReader(new FileReader(VaccineName));
                String li=ois.readLine();
                boolean found=false;
                while (li.isBlank()) {
                    if (n1.equals(li)) {
                        found = true;
                    } else {
                        li = n1;
                        FileWriter oos;
                        oos = new FileWriter(VaccineName, true);
                        BufferedWriter ops = new BufferedWriter(oos);
                        ops.write(li);
                        ops.newLine();
                        ops.flush();
                        ops.close();
                        System.out.println("Successfully Vaccinated....");
                    }
                }
                if(found){
                    System.out.println("Already Vaccinated....");
                }

            }else{
                System.out.println("file is not exist!");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

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
