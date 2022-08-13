import pradee.PradiArray;

import java.io.*;
import java.text.ParseException;
import java.util.*;

public class Vaccine implements Serializable{
    private String E_No;

    public String getE_No() {
        return E_No;
    }

    public void setE_No(String e_No) {
        E_No = e_No;
    }

    // Main Section for Vaccination Part
    public static void main() throws IOException, ParseException, ClassNotFoundException {

        VaccinePassword();  // Calling VaccinePassword section
    }

    public static void Vaccination() throws IOException, ParseException, ClassNotFoundException {
        System.out.println("\n<========================================================================================================>\n");
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
        int ch=0;
        do{
            System.out.println("\n<========================================================================================================>");
            System.out.println("\t\t\t\t\t\t\t\t\t\t Welcome to Vaccination Camp Section");
            System.out.println("<========================================================================================================>");
            System.out.println("\t\t\t\t\t1.Add Vaccine\t\t2.View Vaccine\t\t3.Vaccination\t\t0.Exit");
            System.out.println("<-------------------------------------------------------------------------------------------------------->");
            System.out.print("=>Enter your choice:");
            ch=Vaccine.nextInt();
            switch (ch){
                case 1:
                    VaccineCreate();  // Calling VaccineCreate section
                    break;
                case 2:
                    System.out.println("\n<========================================================================================================>");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t Welcome to Vaccine View Section");
                    System.out.println("<-------------------------------------------------------------------------------------------------------->\n");
                    VaccineList();   // Calling VaccineList section
                    break;
                case 3:
                    System.out.println("\n<========================================================================================================>");
                    System.out.println("\t\t\t\t\t\t\t\t Welcome to Vaccination Section");
                    System.out.println("<-------------------------------------------------------------------------------------------------------->");
                    System.out.println("\t\t\t\t\t\t\t1.Student\t\t\t2.Staff\t\t\t0.Exit");
                    System.out.println("<-------------------------------------------------------------------------------------------------------->");
                    System.out.print("=>\tEnter your choice:");
                    int ch1=0;
                    ch1=Vaccine.nextInt();
                    switch (ch1){
                        case 1:
                            Patient("Student","EnrollNo");   // Calling Student section
                            break;
                        case 2:
                            Patient("Staff","ID");     // Calling Staff section
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
    // VaccinePassword Section
    public static void VaccinePassword()throws IOException, ParseException, ClassNotFoundException  {
        Scanner pass= new Scanner(System.in);
        int passV;
        do{
            System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
            System.out.print("=>\tEnter the Vaccination Camp Section Password : ");
            passV=pass.nextInt();

            if(passV==333){
                Vaccination();              // Calling Vaccination Section
            }
            else{
                System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
                System.out.println("\t\t\t\t\t\t\t\t\t\t  Invalid Password Try Again...");
                System.out.println("<-------------------------------------------------------------------------------------------------------->");

            }
        }while(passV !=333);


    }

    // VaccineCreate Section
    public static void VaccineCreate(){
        try{
            int n, i;
            Scanner VAC=new Scanner(System.in);
            System.out.println("\n<========================================================================================================>");
            System.out.println("\t\t\t\t\t\t\t\t\t Welcome to Vaccine Create Section");
            System.out.println("<-------------------------------------------------------------------------------------------------------->");
            System.out.print("Enter how many vaccine you want to add : ");
            n=VAC.nextInt();
            FileWriter Vac=new FileWriter("Vaccine-list.UWU",true);
            PrintWriter Vaccine=new PrintWriter(Vac);
            System.out.println("\n<========================================================================================================>");
            for(i=0;i<n;i++){
                System.out.println("\n<------------------------------------------------------------------------------------------------->");
                System.out.println("\t\t\t\t\t\t\t\t\t\tVaccine No "+(i+1)+"...");
                System.out.println("<------------------------------------------------------------------------------------------------->");
                System.out.print("=>\tEnter the Vaccine Code  : ");
                String code=VAC.next();
                Vaccine.print(code+"\t\t\t\t\t\t");
                System.out.print("=>\tEnter the Vaccine Name  : ");
                String name=VAC.next();
                Vaccine.print(name+"\t\t\t\t\t\t");
                System.out.print("=>\tEnter the Vaccine Count : ");
                int count=VAC.nextInt();
                Vaccine.println(count);
                FileWriter VaccineName=new FileWriter(code+".UWU");
                System.out.println("<------------------------------------------------------------------------------------------------->");
                VaccineName.close();

            }
            System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
            System.out.println("\t\t\t\t\t\t\t\t\t\t  Successfully Added...");
            System.out.println("<-------------------------------------------------------------------------------------------------------->");
            System.out.println("<========================================================================================================>");

            Vaccine.close();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }


    }


    // Student Vaccination Section
    public static void Patient(String patient,String ID)throws IOException, ParseException, ClassNotFoundException {

        Scanner scn=new Scanner(System.in);
        Scanner scnum=new Scanner(System.in);
        System.out.println("\n<========================================================================================================>");
        System.out.println("\t\t\t\t\t\t\t Welcome to "+patient+" Vaccination Section");
        System.out.println("<-------------------------------------------------------------------------------------------------------->");

        System.out.print("Enter the "+patient+" "+ID+" :");
        String n1=scn.next();
        System.out.println("\n<========================================================================================================>");
        System.out.println("\t\t\t\t\t\t\t\t\t\t  Vaccine List");
        System.out.println("<-------------------------------------------------------------------------------------------------------->\n");
        VaccineList();

        System.out.print("Enter the Vaccine Code : ");
        String n2 = scn.next();
        File VaccineName = new File(n2 + ".UWU");
        ObjectOutputStream oos=null ;
        ObjectInputStream ois=null; //To read the objects
        PradiArray<Vaccine> sal = new PradiArray<>();   //Alternative for Array List from pradee package to store the objects in an array
        if (VaccineName.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(VaccineName));  //Read the inputs from the file
            sal = (PradiArray<Vaccine>) ois.readObject(); //Store the object to the array.
            ois.close();
        }
        boolean found = false;

        for (Vaccine st : sal) {
            if (n1.equalsIgnoreCase(st.getE_No())) {
                found = true;
            }
        }
        if (!found) {
            System.out.println("\n<========================================================================================================>");
            System.out.println("Press 1 for your Conformation");
            System.out.println("<------------------------------------------------------------------------------------------------->");
            System.out.println("\t1.Confirm\t\t0.Exit");
            System.out.println("<------------------------------------------------------------------------------------------------->");
            System.out.print("Enter Your choice : ");
            int a = scnum.nextInt();
            System.out.println("<------------------------------------------------------------------------------------------------->");
            if (a == 1) {
                Vaccine nn=new Vaccine();
                nn.setE_No(n1);
                sal.add(nn);
                System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
                System.out.println("\t\t\t\t\t\t\t\t\t\t  Successfully Vaccinated...");
                System.out.println("<-------------------------------------------------------------------------------------------------------->");

            }

        }else{
            System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
            System.out.println("\t\t\t\t\t\t\t\t\t\t  Already Vaccinated...");
            System.out.println("<-------------------------------------------------------------------------------------------------------->");

        }
        oos = new ObjectOutputStream(new FileOutputStream(VaccineName));
        oos.writeObject(sal); //Write all the objects stored in the dynamic array list after the modification.
        oos.close();

    }

    // VaccinationList Section
    public static void VaccineList(){
        try{

            File VAc=new File("Vaccine-list.UWU");
            Scanner Vaccine=new Scanner(VAc);
            System.out.println("Vaccine ID\t\t\t\t\tVaccine Name\t\t\t\tQuantity");
            System.out.println("<------------------------------------------------------------------------------------------------->\n");
            while(Vaccine.hasNextLine()){
                System.out.println(Vaccine.nextLine());
                System.out.println("<--------------------------------------------------------------------------------------->\n");
            }
            System.out.println("\n<========================================================================================================>");
        }catch(Exception e){
            System.out.println("Error");
        }
    }
}