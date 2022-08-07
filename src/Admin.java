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
            System.out.println("1.inset\t2.view\t3.search\t4.upadte\t5.delete\t0.exit");
            System.out.print("enter your choise:");
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
                    System.out.println("thank you");
                    break;
                default:
                    System.out.println("invalid input");
                    break;
            }
        }while (ch != 0);
    }
    private static void delete(String patient,String id) throws IOException,ClassNotFoundException{
        File file = new File(patient+".txt");
        ObjectInputStream ois = null;
        ObjectOutputStream oos =  null;
        PradeeList<Patient> sal;
        Scanner scn = new Scanner(System.in);
        Scanner scnum = new Scanner(System.in);
        ListIterator li = null;
        System.out.println("================================================DELETE=======================================================");
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            sal = (PradeeList<Patient>) ois.readObject();
            ois.close();
            boolean found = false;
            System.out.print("enter the "+id+" to delete:");
            String search = scn.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
            li = (ListIterator) sal.iterator();
            for (Patient st : sal) {
                if (search.equalsIgnoreCase(st.getE_no())) {
                    System.out.println(st.getE_no() + " " + st.getName() + " " + MedzeUtil.dateViwe(st.getDate()) + " " + st.getGender() + " " + st.getBlood() + " " + st.getContact() + " " + st.getAllergy());
                    System.out.println("--------------------------------------------------------------------------------------------------------------------");
                    found = true;
                }
            }
            while (li.hasNext()) {
                Patient e = (Patient) li.next();
                if (search.equals(e.getE_no())){
                    li.remove();
                }
            }

            if (!found) {
                System.out.println(patient+" not found");
            }else {
                System.out.println("success!");
                oos = new ObjectOutputStream(new FileOutputStream(file));
                oos.writeObject(sal);
                oos.close();
            }
        }else {
            System.out.println("file is not exist!");
        }
        System.out.println("==============================================================================================================");
    }

    private static void update(String patient, String id) throws IOException, ClassNotFoundException, ParseException {
        File file = new File(patient+".txt");
        ObjectInputStream ois  = null;
        ObjectOutputStream oos =  null;
        PradeeList<Patient> sal = new PradeeList<>();
        Scanner scn = new Scanner(System.in);
        Scanner scnum = new Scanner(System.in);
        ListIterator<Patient> li =null;
        System.out.println("================================================UPDATE=======================================================");
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            sal = (PradeeList<Patient>) ois.readObject();
            ois.close();
            boolean found = false;
            System.out.print("enter the"+id+" to update:");
            String search = scn.nextLine();
            li = (ListIterator<Patient>) sal.iterator();
            for (Patient st : sal) {
                if (search.equalsIgnoreCase(st.getE_no())) {
                    System.out.println(st.getE_no() + " " + st.getName() + " " + MedzeUtil.dateViwe(st.getDate()) + " " + st.getGender() + " " + st.getBlood() + " " + st.getContact() + " " + st.getAllergy());
                    System.out.println("--------------------------------------------------------------------------------------------------------------------");
                    found = true;
                }
            }
            while (li.hasNext()) {
                Patient e = (Patient) li.next();
                if (search.equalsIgnoreCase(e.getE_no())) {
                    Patient patient1 = new Patient();
                    System.out.print("name:");
                    patient1.setName(scn.nextLine().toUpperCase());
                    patient1.setDate(MedzeUtil.dateinsert("Date of birth:"));
                    patient1.setGender(MedzeUtil.gender());
                    patient1.setBlood(MedzeUtil.bloodinsert());
                    System.out.print("contact number:");
                    patient1.setContact(scnum.nextInt());
                    System.out.print("spectial desaese or allergy:");
                    patient1.setAllergy(scn.nextLine());
                    li.set(patient1);
                    System.out.println("===================================================");
                    System.out.println(patient1);
                    System.out.println("===================================================");
                }
            }

            if (!found) {
                System.out.println(patient+" not found");
            } else {
                System.out.println("success!");
                oos = new ObjectOutputStream(new FileOutputStream(file));
                oos.writeObject(sal);
                oos.close();
            }
        }
        System.out.println("=============================================================================================================");
    }

    private static void search(String patient,String id) throws IOException, ClassNotFoundException {
        File file = new File(patient+".txt");
        ObjectInputStream ois = null;
        PradeeList<Patient> sal = new PradeeList<>();
        Scanner scn = new Scanner(System.in);
        System.out.println("================================================SEARCH=======================================================");
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            sal = (PradeeList<Patient>) ois.readObject();
            ois.close();
            boolean found = false;
            System.out.print("enter "+id+" number to search:");
            String search = scn.nextLine();
                for (Patient st : sal) {
                    if (search.equalsIgnoreCase(st.getE_no())) {
                        System.out.println(st.getE_no() + " " + st.getName() + " " + MedzeUtil.dateViwe(st.getDate()) + " " + st.getGender() + " " + st.getBlood() + " " + st.getContact() + " " + st.getAllergy());
                        System.out.println("--------------------------------------------------------------------------------------------------------------------");
                        found = true;
                    }
                 }
            if (!found) {
                System.out.println(patient+" not found");
            }
        }else {
            System.out.println("file is not exist!");
        }
        System.out.println("=============================================================================================================");
    }

    private static void patientlist(String patient,String id) throws IOException, ClassNotFoundException {
        File file = new File(patient+".txt");
        ObjectInputStream ois = null;
        PradeeList<Patient> sal =  new PradeeList<>();
        System.out.println("================================================LIST=======================================================");
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            sal = (PradeeList<Patient>)ois.readObject();
            ois.close();
            for (Patient st : sal) {
                System.out.println(st.getE_no() + " " + st.getName() + " " + MedzeUtil.dateViwe(st.getDate()) + " " + st.getGender() + " " + st.getBlood() + " " + st.getContact()+ " " + st.getAllergy() );
                System.out.println("--------------------------------------------------------------------------------------------------------------------");
            }
        }else {
            System.out.println("file is not exist!");
        }
        System.out.println("===============================================================================================================");
    }

    public static void insert(String patient,String id) throws IOException, ParseException, ClassNotFoundException {
        System.out.println("================================================INSERT=======================================================");
        System.out.println("welcome to data insert section");
        Scanner scn = new Scanner(System.in);
        Scanner scnum = new Scanner(System.in);
        ObjectOutputStream oos = null;
        PradeeList<Patient> sal = new PradeeList<>();
        File file =new File(patient+".txt");
        if(file.isFile()){
            ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(file));
            sal = (PradeeList<Patient>) ois.readObject();
            ois.close();
        }
        int ch =-1;
        while (ch != 0){
            Patient patient1 = new Patient();
            System.out.print(id+":");
            patient1.setE_no(scn.nextLine().toUpperCase());
            System.out.print("name:");
            patient1.setName(scn.nextLine().toUpperCase());
            patient1.setDate(MedzeUtil.dateinsert("Date of birth:")); 
            patient1.setGender(MedzeUtil.gender()); 
            patient1.setBlood(MedzeUtil.bloodinsert());
            System.out.print("contact number:");
            patient1.setContact(scnum.nextInt());
            System.out.print("spectial desaese or allergy:");
            patient1.setAllergy(scn.nextLine());
            sal.insertAtBeginning(patient1);
            System.out.println("===================================================");
            System.out.println(patient1);
            System.out.println("===================================================");
            ch = MedzeUtil.iteration();
        }
        oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(sal);
        oos.close();
        System.out.println("success!");
        System.out.println("=============================================================================================================");
    }
}
