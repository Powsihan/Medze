import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import pradee.*;


public class Admin implements Serializable{
    public static void main(String patient,String id) throws IOException, ClassNotFoundException, ParseException {
        Scanner scn = new Scanner(System.in);
        int ch = 0,n=-1;

        do {
            System.out.println("\n<========================================================================================================>");
            System.out.println("\t\t\t\t\t\t\t\t\t\t Welcome to "+patient+" Section");
            System.out.println("<========================================================================================================>");
            System.out.println("\t\t\t1.Insert\t\t2.View\t\t3.Search\t\t4.Update\t\t5.Delete\t\t0.Exit");
            System.out.println("<-------------------------------------------------------------------------------------------------------->");
            System.out.print("Enter your Choice : ");
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
            }
        }while (ch != 0);
    }
    public static boolean consist (String patient,String search) throws IOException, ClassNotFoundException {
        File file = new File(patient+".txt");
        boolean found = false;
        ObjectInputStream ois = null;
        PradiArray<Patient> sal = new PradiArray<>();
        Scanner scn = new Scanner(System.in);
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            sal = (PradiArray<Patient>) ois.readObject();
            ois.close();
            for (Patient st : sal) {
                if (search.equalsIgnoreCase(st.getE_no())) {
                    found = true;
                }
            }
        }
        return found;
    }
    private static void delete(String patient,String id) throws IOException,ClassNotFoundException{
        File file = new File(patient+".txt");
        ObjectInputStream ois = null;
        ObjectOutputStream oos =  null;
        PradiArray<Patient> sal;
        Scanner scn = new Scanner(System.in);
        System.out.println("\n<========================================================================================================>");
        System.out.println("\t\t\t\t\t\t\t\t\t Welcome to Data Delete Section");
        System.out.println("<-------------------------------------------------------------------------------------------------------->");
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            sal = (PradiArray<Patient>) ois.readObject();
            ois.close();
            boolean found = false;
            System.out.print("Enter the "+id+" to Delete : ");
            String search = scn.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
            for (Patient st : sal) {
                if (search.equalsIgnoreCase(st.getE_no())) {
                    System.out.println("\n<========================================================================================================>");
                    System.out.println("Patient Details :\t"+st.getE_no() + " " + st.getName() + " " + MedzeUtil.dateViwe(st.getDate()) + " " + st.getGender() + " " + st.getBlood() + " " + st.getContact() + " " + st.getAllergy());
                    System.out.println("<========================================================================================================>");
                    found = true;
                    sal.remove(st);
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
                oos.writeObject(sal);
                oos.close();
            }
        }else {
            System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
            System.out.println("\t\t\t\t\t\t\t\t\t\t  File is not Exist...");
            System.out.println("<-------------------------------------------------------------------------------------------------------->");
        }
        System.out.println("\n<========================================================================================================>");
    }

    private static void update(String patient, String id) throws IOException, ClassNotFoundException, ParseException {
        File file = new File(patient+".txt");
        ObjectInputStream ois  = null;
        ObjectOutputStream oos =  null;
        PradiArray<Patient> sal = new PradiArray<>();
        Scanner scn = new Scanner(System.in);
        Scanner scnum = new Scanner(System.in);
        Patient oldPat = new Patient();
        System.out.println("\n<========================================================================================================>");
        System.out.println("\t\t\t\t\t\t\t\t\t Welcome to Data Update Section");
        System.out.println("<-------------------------------------------------------------------------------------------------------->");
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            sal = (PradiArray<Patient>) ois.readObject();
            ois.close();
            boolean found = false;
            System.out.print("Enter the "+id+" to Update:");
            String search = scn.nextLine();
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
                patient1.setE_no(oldPat.getE_no());
                System.out.print("=>\t"+"Name : ");
                patient1.setName(scn.nextLine().toUpperCase());
                patient1.setDate(MedzeUtil.dateinsert("=>\t"+"Date of Birth (DD/MM/YYYY) : "));
                patient1.setGender(MedzeUtil.gender());
                patient1.setBlood(MedzeUtil.bloodinsert());
                System.out.print("=>\t"+"Contact Number (07XXXXXXXX): ");
                patient1.setContact(MedzeUtil.contact());
                System.out.print("=>\t"+"Special Disease or Allergy : ");
                patient1.setAllergy(scn.nextLine());
                sal.update(oldPat,patient1);
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

    private static void search(String patient,String id) throws IOException, ClassNotFoundException {
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

    private static void patientlist(String patient,String id) throws IOException, ClassNotFoundException {
        File file = new File(patient+".txt");
        ObjectInputStream ois = null;
        PradiArray<Patient> sal =  new PradiArray<>();
        System.out.println("\n<========================================================================================================>");
        System.out.println("\t\t\t\t\t\t\t\t\t Welcome to Data View Section");
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

    private static void insert(String patient,String id) throws IOException, ParseException, ClassNotFoundException {
        System.out.println("\n<========================================================================================================>");
        System.out.println("\t\t\t\t\t\t\t\t\t Welcome to Data Insert Section");
        System.out.println("<-------------------------------------------------------------------------------------------------------->");
        Scanner scn = new Scanner(System.in);
        Scanner scnum = new Scanner(System.in);
        ObjectOutputStream oos = null;
        PradiArray<Patient> sal = new PradiArray<>();
        File file =new File(patient+".txt");
        if(file.isFile()){
            ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(file));
            sal = (PradiArray<Patient>) ois.readObject();
            ois.close();
        }
        int ch =-1;
        while (ch != 0){
            Patient patient1 = new Patient();
            System.out.print("=>\t"+id+" (CSTXXXXX)"+" : ");
            String no = scn.nextLine();
            if (consist(patient,no))
            {
                System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
                System.out.println("\t\t\t\t\t\t\t\t\t\t "+id+" Already Added...");
                System.out.println("<-------------------------------------------------------------------------------------------------------->");
            }else {
                patient1.setE_no(no.toUpperCase());
                System.out.print("=>\t"+"Name : ");
                patient1.setName(scn.nextLine().toUpperCase());
                patient1.setDate(MedzeUtil.dateinsert("=>\t"+"Date of Birth (DD/MM/YYYY) : "));
                patient1.setGender(MedzeUtil.gender());
                patient1.setBlood(MedzeUtil.bloodinsert());

                patient1.setContact(MedzeUtil.contact());
                System.out.print("=>\t"+"Special Disease or Allergy : ");
                patient1.setAllergy(scn.nextLine());
                sal.add(patient1);
                System.out.println("\n<========================================================================================================>");
                System.out.println("Patient Details :\t"+patient1);
                System.out.println("<========================================================================================================>");
                System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
                System.out.println("\t\t\t\t\t\t\t\t\t\t  Successfully Added...");
                System.out.println("<-------------------------------------------------------------------------------------------------------->");
            }

            ch = MedzeUtil.iteration();
        }
        oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(sal);
        oos.close();

    }

}
