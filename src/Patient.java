import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Patient implements Serializable{
    String e_no,name,gender,blood,allergy;
    Date date = null;
    int contact;
    Patient(String e_noI,String nameI,String dobI, String genderI,String bloodI,int contactI,String allergyI) throws ParseException {
        SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
        this.e_no = e_noI;
        this.name = nameI;
        this.date = sfd.parse(String.valueOf(dobI));
        this.gender = genderI;
        this.blood = bloodI;
        this.contact = contactI;
        this.allergy = allergyI;
    }
    public String toSting(){
        return e_no+" "+name+" "+date+" "+gender+" "+blood+" "+contact+" "+allergy;
    }
    public static void main(String patient,String id) throws IOException, ClassNotFoundException, ParseException {
        Scanner scn = new Scanner(System.in);
        int ch = 0,n=-1;

        do {
            System.out.println("1.inset\t2.view\t3.search\t4.upadte\t5.delete\t0.exit");
            System.out.print("enter your choise:");
            ch = scn.nextInt();
            switch (ch){
                case 1:
                    Patient.insert(patient, id);
                    break;
                case 2:
                    Patient.patientlist(patient, id);
                    break;
                case 3:
                    Patient.search(patient, id);
                    break;
                case 4:
                    Patient.update(patient, id);
                    break;
                case 5:
                    Patient.delete(patient, id);
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
public static String dateinsert(String x){
    Scanner scn = new Scanner(System.in);
    System.out.print(x);
    String d = scn.next();
    Date date1 = null;
    if (d.matches("[0-9]{2}[/]{1}[0-9]{2}[/]{1}[0-9]{4}")) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date1 = sdf.parse(d);
        } catch (ParseException e) {
            System.out.println("invalid date format" + d);
            dateinsert(x);
        }

    } else {
        System.out.println("invalid date format" + d+"\ncheck the digits of date MM-02 correct MM-18 wrong");
        dateinsert(x);
    }
    return d;
}
public static String gender(){
        int i;
        String g =null;
        Scanner scn =  new Scanner(System.in);
    System.out.print("1.male\t 2.female\t Gender:");
    i = scn.nextInt();
    switch (i) {
        case 1:
         g="MALE";
            break;
        case 2:
            g="FEMALE";
            break;
        default:
            System.out.println("invalid input!");
            g=gender();
            break;
    }
    return g;
}

    public static String bloodinsert(){
        String r= null;
        Scanner scn = new Scanner(System.in);
        System.out.print("blood group:");
        String blood = scn.next();
    if(blood.equalsIgnoreCase("ab+")||blood.equalsIgnoreCase("ab-")||blood.equalsIgnoreCase("a+")||blood.equalsIgnoreCase("a-")||blood.equalsIgnoreCase("b+")||blood.equalsIgnoreCase("b-")||blood.equalsIgnoreCase("o+")||blood.equalsIgnoreCase("o-")){
        r = blood.toUpperCase();
    }else {
        System.out.println("ivalid input try again!");
        r = bloodinsert();
    }
return r;
    }
    private static void delete(String patient,String id) throws IOException,ClassNotFoundException{
        File file = new File(patient+".txt");
        ObjectInputStream ois = null;
        ObjectOutputStream oos =  null;
        ArrayList<Patient> sal = new ArrayList<>();
        Scanner scn = new Scanner(System.in);
        Scanner scnum = new Scanner(System.in);
        ListIterator li = null;
        System.out.println("================================================DELETE=======================================================");
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            sal = (ArrayList<Patient>) ois.readObject();
            ois.close();
            boolean found = false;
            System.out.print("enter the "+id+" to delete:");
            String search = scn.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
            li = sal.listIterator();
            for (Patient st : sal) {
                String D = sdf.format(st.date);
                if (search.equals(st.e_no)) {

                    System.out.println(st.e_no + " " + st.name + " " + D + " " + st.gender + " " + st.blood  + " " + st.contact+ " " + st.allergy+"deleted!");
                    found = true;
                }
            }
            while (li.hasNext()) {
                Patient e = (Patient) li.next();
                if (search.equals(e.e_no)){
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
        ArrayList<Patient> sal = new ArrayList<>();
        Scanner scn = new Scanner(System.in);
        Scanner scnum = new Scanner(System.in);
        ListIterator li =null;
        System.out.println("================================================UPDATE=======================================================");
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            sal = (ArrayList<Patient>) ois.readObject();
            ois.close();
            boolean found = false;
            System.out.print("enter the"+id+" to update:");
            String search = scn.nextLine();
            li = sal.listIterator();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
            for (Patient st : sal) {
                String D = sdf.format(st.date);
                if (search.equals(st.e_no)) {

                    System.out.println(st.e_no + " " + st.name + " " + D + " " + st.gender + " " + st.blood + " " + st.contact + " " + st.allergy +"old data");
                    System.out.println("--------------------------------------------------------------------------------------------------------------------");
                    found = true;
                }
            }
            while (li.hasNext()) {
                Patient e = (Patient) li.next();
                if (search.equals(e.e_no)) {

                    System.out.print("name:");
                    String name1 = scn.nextLine().toUpperCase();
                    String dob1 = dateinsert("Date of birth:");
                    String gender1 =  gender();
                    String blood1 = bloodinsert();
                    System.out.print("contact number:");
                    int contact1 = scnum.nextInt();
                    System.out.print("spectial desaese or allergy:");
                    String allergy1 = scn.nextLine();
                    Patient patient1 = new Patient(e.e_no,name1, dob1, gender1, blood1, contact1, allergy1);
                    li.set(patient1);
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
        File file = new File("patient.txt");
        ObjectInputStream ois = null;
        ArrayList<Patient> sal = new ArrayList<>();
        Scanner scn = new Scanner(System.in);
        System.out.println("================================================SEARCH=======================================================");
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            sal = (ArrayList<Patient>) ois.readObject();
            ois.close();
            boolean found = false;
            System.out.print("enter "+id+" number to search:");
            String search = scn.nextLine();
            for (Patient st : sal) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
                String D = sdf.format(st.date);
                if (search.equals(st.e_no)) {
                    System.out.println(st.e_no + " " + st.name + " " + D  + " " + st.gender + " " + st.blood  + " " + st.contact+ " " + st.allergy);
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
        ArrayList<Patient> sal =  new ArrayList<>();
        System.out.println("================================================LIST=======================================================");
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            sal = (ArrayList<Patient>) ois.readObject();
            ois.close();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");

            for (Patient st : sal) {
                String D = sdf.format(st.date);
                System.out.println(st.e_no + " " + st.name + " " + D + " " + st.gender + " " + st.blood + " " + st.contact+ " " + st.allergy );
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
        ArrayList<Patient> sal = new ArrayList<>();
        File file =new File(patient+".txt");
        if(file.isFile()){
            ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(file));
            sal = (ArrayList<Patient>) ois.readObject();
            ois.close();
        }
        int ch =-1;
        while (ch != 0){
            System.out.print(id+":");
            String e_number1 = scn.nextLine().toUpperCase();
            System.out.print("name:");
            String name1 = scn.nextLine().toUpperCase();
            String date1 = dateinsert("Date of birth:");
            String gender1 = gender();
            String blood1 = bloodinsert();
            System.out.print("contact number:");
            int contact1 = scnum.nextInt();
            System.out.print("spectial desaese or allergy:");
            String allergy1 = scn.nextLine();
            Patient patient1 = new Patient(e_number1, name1, date1, gender1, blood1, contact1, allergy1);
            sal.add(patient1);
            ch = iteration();
        }
        oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(sal);
        oos.close();
        System.out.println("success!");
        System.out.println("=============================================================================================================");
    }
    public static int iteration(){
        Scanner scn = new Scanner(System.in);
        System.out.println("1.next \t0.back choise:");
        int ch = scn.nextInt();
        if (ch == 1){
            System.out.println("====================================new====================================");
        } else if (ch == 0) {
            System.out.println("thank you");
            return ch;
        }else {
            System.out.print("invalid input");
            Patient.iteration();
        }
        return ch;
    }
}
