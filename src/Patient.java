import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;
public class Patient implements Serializable {
    String e_no,name,blood,allergy;
        int dob,gender;
        int contact;
        Patient(String e_noI,String nameI,int dobI, int genderI,String bloodI,String allergyI,int contactI){
            this.e_no = e_noI;
            this.name = nameI;
            this.dob = dobI;
            this.gender = genderI;
            this.blood = bloodI;
            this.allergy = allergyI;
            this.contact = contactI;
        }
        public String toSting(){
            return e_no+" "+name+" "+dob+" "+gender+" "+blood+" "+allergy+" "+contact;
        }

    public static void main(String[] args) throws Exception {
        int ch=0;
        Scanner scn = new Scanner(System.in);
        Scanner scnum = new Scanner(System.in);
        ArrayList<Patient> sal = new ArrayList<>();
        File file = new File("student.txt");
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator li =null;

        if (file.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file));
            sal = (ArrayList<Patient>) ois.readObject();
            ois.close();
        }
        do {
            System.out.println("1.inset\t2.view\t3.search\t4.upadte\t5.delete\t0.exit");
            System.out.print("enter your choise:");
            ch= scnum.nextInt();
            switch (ch){
                case 1:
                    System.out.println("welcome to data insert section");
//                    Patient.insert();
                    for (int i = 0; i < 2; i++) {
                        System.out.print("enrollment number:");
                        String e_number1 =scn.nextLine();
                        System.out.print("name:");
                        String name1 = scn.nextLine();
                        System.out.print("Date of Birth:");
                        int dob1 =scnum.nextInt();
                        System.out.print("1.male\t 2.female\t Gender:");
                        int gender1 =scnum.nextInt();
                        System.out.print("blood group:");
                        String blood1 =scn.nextLine();
                        System.out.print("spectial desaese or allergy:");
                        String allergy1 =scn.nextLine();
                        System.out.print("contact number:");
                        int contact1 =scnum.nextInt();
//            System.out.print("data:"+e_number1+name1+dob1+gender1+blood1+allergy1+contact1);
                        Patient student = new Patient(e_number1,name1,dob1,gender1,blood1,allergy1,contact1);
                        sal.add(student);

                    }
                    oos = new ObjectOutputStream(new FileOutputStream(file));
                    oos.writeObject(sal);
                    oos.close();
                    break;
                case 2:
                    if (file.isFile()) {
                        ois = new ObjectInputStream(new FileInputStream(file));
                        sal = (ArrayList<Patient>) ois.readObject();
                        ois.close();

                        for (Patient st : sal) {
                            System.out.println(st.e_no + " " + st.name + " " + st.dob + " " + st.gender + " " + st.blood + " " + st.allergy + " " + st.contact);
                        }
                    }else {
                        System.out.println("file is not exist!");
                    }
                        break;
                        case 3:
                            if (file.isFile()) {
                                ois = new ObjectInputStream(new FileInputStream(file));
                                sal = (ArrayList<Patient>) ois.readObject();
                                ois.close();
                            boolean found = false;
                            System.out.print("enter the enrolmet number to search:");
                            String search = scn.nextLine();
                            for (Patient st : sal) {
                                if (search.equals(st.e_no)) {
                                    System.out.println(st.e_no + " " + st.name + " " + st.dob + " " + st.gender + " " + st.blood + " " + st.allergy + " " + st.contact);
                                    found = true;
                                }
                            }
                            if (!found) {
                                System.out.println("student not found");
                            }
                    }else {
                        System.out.println("file is not exist!");
                    }
                    break;
                case 4:
                    if (file.isFile()) {
                        ois = new ObjectInputStream(new FileInputStream(file));
                        sal = (ArrayList<Patient>) ois.readObject();
                        ois.close();
                        boolean found = false;
                        System.out.print("enter the enrolmet number to update:");
                        String search = scn.nextLine();
                        li = sal.listIterator();
                        for (Patient st : sal) {
                            if (search.equals(st.e_no)) {

                                System.out.println(st.e_no + " " + st.name + " " + st.dob + " " + st.gender + " " + st.blood + " " + st.allergy + " " + st.contact + "old data");
                                found = true;
                            }
                        }
                        while (li.hasNext()) {
                            Patient e = (Patient) li.next();
                            if (search.equals(e.e_no)) {

                                System.out.print("name:");
                                String name1 = scn.nextLine();
                                System.out.print("Date of Birth:");
                                int dob1 = scnum.nextInt();
                                System.out.print("1.male\t 2.female\t Gender:");
                                int gender1 = scnum.nextInt();
                                System.out.print("blood group:");
                                String blood1 = scn.nextLine();
                                System.out.print("spectial desaese or allergy:");
                                String allergy1 = scn.nextLine();
                                System.out.print("contact number:");
                                int contact1 = scnum.nextInt();
//            System.out.print("data:"+e_number1+name1+dob1+gender1+blood1+allergy1+contact1);
                                Patient student = new Patient(e.e_no,name1, dob1, gender1, blood1, allergy1, contact1);
                                li.set(student);
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
                    break;
                case 5:
                    if (file.isFile()) {
                        ois = new ObjectInputStream(new FileInputStream(file));
                        sal = (ArrayList<Patient>) ois.readObject();
                        ois.close();
                        boolean found = false;
                        System.out.print("enter the enrolmet number to delete:");
                        String search = scn.nextLine();
                        li = sal.listIterator();
                        for (Patient st : sal) {
                            if (search.equals(st.e_no)) {

                                System.out.println(st.e_no + " " + st.name + " " + st.dob + " " + st.gender + " " + st.blood + " " + st.allergy + " " + st.contact+"deleted!");
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
                    break;

                default:
                    System.out.println("inavlid input!");
                    break;
            }
        }while (ch != 0);
    }
//    public static void insert() throws IOException {
//            Scanner scn = new Scanner(System.in);
//            Scanner scnum = new Scanner(System.in);
//        for (int i = 0; i < 2; i++) {
//            System.out.print("enrollment number:");
//            String e_number1 =scn.nextLine();
//            System.out.print("name:");
//            String name1 = scn.nextLine();
//            System.out.print("Date of Birth:");
//            int dob1 =scnum.nextInt();
//            System.out.print("1.mala\t 2.female\t Gender:");
//            int gender1 =scnum.nextInt();
//            System.out.print("blood group:");
//            String blood1 =scn.nextLine();
//            System.out.print("spectial desaese or allergy:");
//            String allergy1 =scn.nextLine();
//            System.out.print("contact number:");
//            int contact1 =scnum.nextInt();
////            System.out.print("data:"+e_number1+name1+dob1+gender1+blood1+allergy1+contact1);
//            Patient.sal.add(new Patient(e_number1,name1,dob1,gender1,blood1,allergy1,contact1));
//        }
//    }
//    public static String gender(int ch){
//            String gent;
//            if (ch==1){
//               gent = "male";
//            } else if (ch==2) {
//               gent = "female";
//            }else {
//               System.out.println("invalid in put");
//               gender();
//            }
//          return gent;
//    }

}
