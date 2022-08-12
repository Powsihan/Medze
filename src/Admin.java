import java.io.*;                  //Deal with inputs and outputs
import java.text.ParseException;   //Pass string to dateformat & Dateformat to string
import java.text.SimpleDateFormat;//Define the format of the date as per wish
import java.util.*;//Scanner class etc....
import pradee.*;//This is an own package which consists of utilities,functions(MedzeUtil,PradiArray)

//Administration part
//we use the admin class for student & staff where accordingly student enrollment num & staff id will be displayed
public class Admin implements Serializable{  //we implement Serialization interface to manipulate object
    //Administration main section

    //The program will run based on patient referred to student & staff and ID referred to student enrollment number and staff ID.
    public static void main(String patient,String id) throws IOException, ClassNotFoundException, ParseException {
        Scanner scn = new Scanner(System.in);
        int ch = 0;

        do {
            System.out.println("\n<========================================================================================================>");
            System.out.println("\t\t\t\t\t\t\t\t\t\t Welcome to "+patient+" Section");//Start of Patient section
            System.out.println("<========================================================================================================>");
            System.out.println("\t\t\t1.Insert\t\t2.View\t\t3.Search\t\t4.Update\t\t5.Delete\t\t0.Exit");
            System.out.println("<-------------------------------------------------------------------------------------------------------->");
            System.out.print("=>\tEnter your Choice : ");
            ch = scn.nextInt();
            switch (ch){
                case 1:
                    insert(patient, id);
                    break;
                case 2:
                    patientlist(patient, id);
                    break;
                case 3:
                    search(patient, id);
                    break;
                case 4:
                    update(patient, id);
                    break;
                case 5:
                    delete(patient, id);
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
            } //According to the user input the relevant case will be running.
        }while (ch != 0);
    }
    //This is use for check existence of patient
    public static boolean consist (String patient,String search) throws IOException, ClassNotFoundException {
        File file = new File(patient+".UWU");     //defines the patient datafile
        boolean found = false;
        ObjectInputStream ois = null;      //To read the objects
        PradiArray<Patient> sal = new PradiArray<>();//Alternative for Array List from pradeepackge to store the objects in an array
        Scanner scn = new Scanner(System.in);
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file)); //Read the inputs from the file
            sal = (PradiArray<Patient>) ois.readObject(); //Store the object to the array.
            ois.close();
            for (Patient st : sal) {
                if (search.equalsIgnoreCase(st.getE_no())) {
                    System.out.println("\n<========================================================================================================>");
                    System.out.println(patient+" Details : "+st);
                    System.out.println("<========================================================================================================>");
                    found = true;
                } //Check the input throughout the file
            }
        }
        return found;
    }
    private static void delete(String patient,String id) throws IOException,ClassNotFoundException{
        File file = new File(patient+".UWU");
        ObjectInputStream ois = null;
        ObjectOutputStream oos =  null;
        PradiArray<Patient> sal;
        Scanner scn = new Scanner(System.in);
        System.out.println("\n<========================================================================================================>");
        System.out.println("\t\t\t\t\t\t\t\t\t Welcome to "+patient+" Delete Section");
        System.out.println("<-------------------------------------------------------------------------------------------------------->");
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            sal = (PradiArray<Patient>) ois.readObject();
            ois.close();
            boolean found = false;
            System.out.print("Enter the "+id+" to Delete : ");
            String search = Id.courseS(id);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
            for (Patient st : sal) {
                if (search.equalsIgnoreCase(st.getE_no())) {
                    System.out.println("\n<========================================================================================================>");
                    System.out.println("Patient Details :\t"+st.getE_no() + " " + st.getName() + " " + MedzeUtil.dateViwe(st.getDate()) + " " + st.getGender() + " " + st.getBlood() + " " + st.getContact() + " " + st.getAllergy());
                    System.out.println("<========================================================================================================>");
                    found = true;
                    sal.remove(st); //Remove the objects from the array
                }
            }

            if (!found) {
                System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
                System.out.println("\t\t\t\t\t\t\t\t\t\t  "+patient+" not Found...");
                System.out.println("<-------------------------------------------------------------------------------------------------------->");
            }else {
                System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
                System.out.println("\t\t\t\t\t\t\t\t\t  Successfully Deleted...");
                System.out.println("<-------------------------------------------------------------------------------------------------------->");
                oos = new ObjectOutputStream(new FileOutputStream(file));
                oos.writeObject(sal); //Write all the objects stored in the dynamic array list after the modification.
                oos.close();
            }
        }else {
            System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
            System.out.println("\t\t\t\t\t\t\t\t\t\t  File is not Exist...");
            System.out.println("<-------------------------------------------------------------------------------------------------------->");
        }
        System.out.println("\n<========================================================================================================>");
    }
        //Update Function

    private static void update(String patient, String id) throws IOException, ClassNotFoundException, ParseException {
        File file = new File(patient+".UWU");
        ObjectInputStream ois  = null;
        ObjectOutputStream oos =  null;
        PradiArray<Patient> sal = new PradiArray<>();
        Scanner scn = new Scanner(System.in);
        Scanner scnum = new Scanner(System.in);
        Patient oldPat = new Patient(); //sal contains the data of the existing patients. if a user need to update their details then the function will compare and check the difference and that details will be updated to oldPat
        System.out.println("\n<========================================================================================================>");
        System.out.println("\t\t\t\t\t\t\t\t\t Welcome to "+patient+" Update Section");
        System.out.println("<-------------------------------------------------------------------------------------------------------->");
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            sal = (PradiArray<Patient>) ois.readObject();
            ois.close();
            boolean found = false;
            System.out.print("Enter the "+id+" to Update:");
            String search = Id.courseS(id);
            for (Patient st : sal) {
                if (search.equalsIgnoreCase(st.getE_no())) {
                    System.out.println("\n<========================================================================================================>");
                    System.out.println("Patient Details :\t"+st.getE_no() + " " + st.getName() + " " + MedzeUtil.dateViwe(st.getDate()) + " " + st.getGender() + " " + st.getBlood() + " " + st.getContact() + " " + st.getAllergy());
                    System.out.println("--------------------------------------------------------------------------------------------------------------------");
                    oldPat = st;
                    found = true;
                }
            }
            if (!found) {
                System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
                System.out.println("\t\t\t\t\t\t\t\t\t\t  "+patient+" not found...");
                System.out.println("<-------------------------------------------------------------------------------------------------------->");
            } else {
                Patient patient1 = new Patient();
                patient1.setE_no(oldPat.getE_no()); //Enrollment no of the old patient is passed to the new patient while the updation process
                System.out.print("=>\t"+"Name : ");
                patient1.setName(scn.nextLine().toUpperCase());
                patient1.setDate(MedzeUtil.dateinsert("=>\t"+"Date of Birth (DD/MM/YYYY) : "));
                patient1.setGender(MedzeUtil.gender());
                patient1.setBlood(MedzeUtil.bloodinsert());
                System.out.print("=>\t"+"Contact Number (07XXXXXXXX): ");
                patient1.setContact(MedzeUtil.contact());
                System.out.print("=>\t"+"Special Disease or Allergy : ");
                patient1.setAllergy(scn.nextLine());
                sal.update(oldPat,patient1); //finally oldPat and patient1 will be sent to the function and oldPat details will be updated by the patient1 details.
                System.out.println("\n<========================================================================================================>");
                System.out.println("Patient Details : "+patient1);
                System.out.println("<========================================================================================================>");
                System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
                System.out.println("\t\t\t\t\t\t\t\t\t\t  Successfully Updated...");
                System.out.println("<-------------------------------------------------------------------------------------------------------->");
                oos = new ObjectOutputStream(new FileOutputStream(file));
                oos.writeObject(sal);
                oos.close();
            }
        } else {
            System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
            System.out.println("\t\t\t\t\t\t\t\t\t\t  File is not Exist...");
            System.out.println("<-------------------------------------------------------------------------------------------------------->");
        }
        System.out.println("\n<========================================================================================================>");
    }
    //Search Function
    private static void search(String patient,String id) throws IOException, ClassNotFoundException {
        File file = new File(patient+".UWU");
        ObjectInputStream ois = null;
        PradiArray<Patient> sal = new PradiArray<>();
        Scanner scn = new Scanner(System.in);
        System.out.println("\n<========================================================================================================>");
        System.out.println("\t\t\t\t\t\t\t\t\t Welcome to "+patient+" Search Section");
        System.out.println("<-------------------------------------------------------------------------------------------------------->");
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            sal = (PradiArray<Patient>) ois.readObject();
            ois.close();
            boolean found = false;
           System.out.print("Enter "+id+" Number to Search : ");
            String search = Id.courseS(id);
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
    //Display Patient List Function
    private static void patientlist(String patient,String id) throws IOException, ClassNotFoundException {
        File file = new File(patient+".UWU");
        ObjectInputStream ois = null;
        PradiArray<Patient> sal =  new PradiArray<>();
        System.out.println("\n<========================================================================================================>");
        System.out.println("\t\t\t\t\t\t\t\t\t Welcome to "+patient+" View Section");
        System.out.println("<-------------------------------------------------------------------------------------------------------->\n");
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            sal = (PradiArray<Patient>)ois.readObject();
            ois.close();
            System.out.println("Id\t\t\tName\t\tDate\t\t\tGender\t\tBloodGroup\t\tContactNot\t\tDisease");
            System.out.println("<------------------------------------------------------------------------------------------------->\n");
            for (Patient st : sal) {

                System.out.println(st.getE_no() + "\t" + st.getName() + "\t\t" + MedzeUtil.dateViwe(st.getDate()) + "\t\t" + st.getGender() + "\t\t" + st.getBlood() + "\t\t\t\t" + st.getContact()+ "\t\t" + st.getAllergy() );
                System.out.println("<-------------------------------------------------------------------------------------------->");
            }
        }else {
            System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
            System.out.println("\t\t\t\t\t\t\t\t\t\t  File is not Exist...");
            System.out.println("<-------------------------------------------------------------------------------------------------------->");
        }
        System.out.println("\n<========================================================================================================>");
    }
    //Insert Function

    private static void insert(String patient,String id) throws IOException, ParseException, ClassNotFoundException {
        System.out.println("\n<========================================================================================================>");
        System.out.println("\t\t\t\t\t\t\t\t\t Welcome to "+patient+" Insert Section");
        System.out.println("<-------------------------------------------------------------------------------------------------------->");
        Scanner scn = new Scanner(System.in);
        ObjectOutputStream oos = null;
        PradiArray<Patient> sal = new PradiArray<>();
        File file =new File(patient+".UWU");
        if(file.isFile()){
            ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(file));
            sal = (PradiArray<Patient>) ois.readObject();
            ois.close();
        }
        int ch =-1;
        while (ch != 0){
            Patient patient1 = new Patient();
            System.out.print("=>\t"+id+" (CSTXXXXX)"+" : ");
            String no =Id.courseS(id); //Validate whether the ID format is according to the specified format
            if (consist(patient,no)) //This is to check whether the patient records are available.
            {
                System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
                System.out.println("\t\t\t\t\t\t\t\t\t\t "+id+" Already Added...");
                System.out.println("<-------------------------------------------------------------------------------------------------------->");
            }else {
                patient1.setE_no(no.toUpperCase()); //Pass the data taken from no is set to the Enrollment no
                System.out.print("=>\t"+"Name : ");
                patient1.setName(scn.nextLine().toUpperCase());
                patient1.setDate(MedzeUtil.dateinsert("=>\t"+"Date of Birth (DD/MM/YYYY) : ")); //Check the date format
                patient1.setGender(MedzeUtil.gender()); //Check the gender format
                patient1.setBlood(MedzeUtil.bloodinsert()); //Check the Blood format
                patient1.setContact(MedzeUtil.contact()); //Check the Contact format
                System.out.print("=>\t"+"Special Disease or Allergy : ");
                patient1.setAllergy(scn.nextLine());
                sal.add(patient1); //Add all the objects to the dynamic array sal
                System.out.println("\n<========================================================================================================>");
                System.out.println("Patient Details :\t"+patient1); //Help the user to confirm what have been typed.
                System.out.println("<========================================================================================================>");
                System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
                System.out.println("\t\t\t\t\t\t\t\t\t\t  Successfully Added...");
                System.out.println("<-------------------------------------------------------------------------------------------------------->");
            }

            ch = MedzeUtil.iteration(); //There will be an iteration
        }
        oos = new ObjectOutputStream(new FileOutputStream(file)); //Write the objects
        oos.writeObject(sal); //Pass the dynamic array
        oos.close();

    }

}
