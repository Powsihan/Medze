import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Date;


public class Patient implements Serializable{
    String e_no,name,blood,allergy;
    int gender;
    Date date = null;
    int contact;
    Patient(String e_noI,String nameI,String dobI, int genderI,String bloodI,String allergyI,int contactI) throws ParseException {
        SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
        this.e_no = e_noI;
        this.name = nameI;
        this.date = sfd.parse(String.valueOf(dobI));
        this.gender = genderI;
        this.blood = bloodI;
        this.allergy = allergyI;
        this.contact = contactI;
    }
    public String toSting(){
        return e_no+" "+name+" "+date+" "+gender+" "+blood+" "+allergy+" "+contact;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException, ParseException {
        Scanner scn = new Scanner(System.in);
        int ch = 0;

        do {
            System.out.println("1.inset\t2.view\t3.search\t4.upadte\t5.delete\t0.exit");
            System.out.print("enter your choise:");
            ch = scn.nextInt();
            switch (ch){
                case 1:
                    Patient.inert();
                    break;
                case 2:
                    Patient.patientlist();
                    break;
                case 3:
                    Patient.search();
                    break;
                case 4:
                    Patient.update();
                    break;
                case 5:
                    Patient.delete();
                    break;
                default:
                    System.out.println("invalid input");
                    break;
            }
        }while (ch != 0);
    }
public static String dateinsert(){
    Scanner scn = new Scanner(System.in);
    System.out.print("date of birth:");
    String d = scn.next();
    Date date1 = null;
    if (d.matches("[0-9]{2}[/]{1}[0-9]{2}[/]{1}[0-9]{4}")) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date1 = sdf.parse(d);
        } catch (ParseException e) {
            System.out.println("invalid date format" + d);
            dateinsert();
        }

    } else {
        System.out.println("invalid date format" + d+"\ncheck the digits of date MM-02 correct MM-18 wrong");
        dateinsert();
    }
    return d;
}
    private static void delete() throws IOException,ClassNotFoundException{
        File file = new File("Patient.txt");
        ObjectInputStream ois = null;
        ObjectOutputStream oos =  null;
        ArrayList<Patient> sal = new ArrayList<>();
        Scanner scn = new Scanner(System.in);
        Scanner scnum = new Scanner(System.in);
        ListIterator li = null;

        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            sal = (ArrayList<Patient>) ois.readObject();
            ois.close();
            boolean found = false;
            System.out.print("enter the enrolmet number to delete:");
            String search = scn.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
            li = sal.listIterator();
            for (Patient st : sal) {
                String D = sdf.format(st.date);
                if (search.equals(st.e_no)) {

                    System.out.println(st.e_no + " " + st.name + " " + D + " " + st.gender + " " + st.blood + " " + st.allergy + " " + st.contact+"deleted!");
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
                System.out.println("student not found");
            }else {
                System.out.println("success!");
                oos = new ObjectOutputStream(new FileOutputStream(file));
                oos.writeObject(sal);
                oos.close();
            }
        }else {
            System.out.println("file is not exist!");
        }
    }

    private static void update() throws IOException, ClassNotFoundException, ParseException {
        File file = new File("Patient.txt");
        ObjectInputStream ois  = null;
        ObjectOutputStream oos =  null;
        ArrayList<Patient> sal = new ArrayList<>();
        Scanner scn = new Scanner(System.in);
        Scanner scnum = new Scanner(System.in);
        ListIterator li =null;
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            sal = (ArrayList<Patient>) ois.readObject();
            ois.close();
            boolean found = false;
            System.out.print("enter the enrolmet number to update:");
            String search = scn.nextLine();
            li = sal.listIterator();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
            for (Patient st : sal) {
                String D = sdf.format(st.date);
                if (search.equals(st.e_no)) {

                    System.out.println(st.e_no + " " + st.name + " " + D + " " + st.gender + " " + st.blood + " " + st.allergy + " " + st.contact + "old data");
                    found = true;
                }
            }
            while (li.hasNext()) {
                Patient e = (Patient) li.next();
                if (search.equals(e.e_no)) {

                    System.out.print("name:");
                    String name1 = scn.nextLine();
                    System.out.print("Date of Birth:");
                    String dob1 = String.valueOf(dateinsert());
                    System.out.print("1.male\t 2.female\t Gender:");
                    int gender1 = scnum.nextInt();
                    System.out.print("blood group:");
                    String blood1 = scn.nextLine();
                    System.out.print("spectial desaese or allergy:");
                    String allergy1 = scn.nextLine();
                    System.out.print("contact number:");
                    int contact1 = scnum.nextInt();
                    Patient patient = new Patient(e.e_no,name1, dob1, gender1, blood1, allergy1, contact1);
                    li.set(patient);
                }
            }

            if (!found) {
                System.out.println("student not found");
            } else {
                System.out.println("success!");
                oos = new ObjectOutputStream(new FileOutputStream(file));
                oos.writeObject(sal);
                oos.close();
            }
        }
    }

    private static void search() throws IOException, ClassNotFoundException {
        File file = new File("patient.txt");
        ObjectInputStream ois = null;
        ArrayList<Patient> sal = new ArrayList<>();
        Scanner scn = new Scanner(System.in);
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            sal = (ArrayList<Patient>) ois.readObject();
            ois.close();
            boolean found = false;
            System.out.print("enter the enrolmet number to search:");
            String search = scn.nextLine();
            for (Patient st : sal) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
                String D = sdf.format(st.date);
                if (search.equals(st.e_no)) {
                    System.out.println(st.e_no + " " + st.name + " " + D  + " " + st.gender + " " + st.blood + " " + st.allergy + " " + st.contact);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("satf not found");
            }
        }else {
            System.out.println("file is not exist!");
        }
    }

    private static void patientlist() throws IOException, ClassNotFoundException {
        File file = new File("patient.txt");
        ObjectInputStream ois = null;
        ArrayList<Patient> sal =  new ArrayList<>();
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            sal = (ArrayList<Patient>) ois.readObject();
            ois.close();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");

            for (Patient st : sal) {
                String D = sdf.format(st.date);
                System.out.println(st.e_no + " " + st.name + " " + D + " " + st.gender + " " + st.blood + " " + st.allergy + " " + st.contact);
            }
        }else {
            System.out.println("file is not exist!");
        }
    }

    public static void inert() throws IOException, ParseException {
        System.out.println("welcome to data insert section");
        Scanner scn = new Scanner(System.in);
        Scanner scnum = new Scanner(System.in);
        ArrayList<Patient> sal = new ArrayList<>();
        File file =new File("patient.txt");
        ObjectOutputStream oos = null;
        for (int i = 0; i < 2; i++) {
            System.out.print("enrollment number:");
            String e_number1 =scn.nextLine();
            System.out.print("name:");
            String name1 = scn.nextLine();
            System.out.print("Date of Birth:");
            String date1 = dateinsert();
            System.out.print("1.male\t 2.female\t Gender:");
            int gender1 =scnum.nextInt();
            System.out.print("blood group:");
            String blood1 =scn.nextLine();
            System.out.print("spectial desaese or allergy:");
            String allergy1 =scn.nextLine();
            System.out.print("contact number:");
            int contact1 =scnum.nextInt();
            Patient patient = new Patient(e_number1,name1,date1,gender1,blood1,allergy1,contact1);
            sal.add(patient);

        }
        oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(sal);
        oos.close();
    }
}
