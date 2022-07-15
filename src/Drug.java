import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Drug implements Serializable{
    String d_id,name,c_name;
    Date mdate = null;
    Date edate = null;
    int quantity;
    Drug(String d_id1,String name1,String c_name1,String mdate1,String edate1,int quantity1) throws ParseException {
        SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
        this.d_id = d_id1;
        this.name = name1;
        this.c_name = c_name1;
        this.mdate = sfd.parse(String.valueOf(mdate1));
        this.edate = sfd.parse(String.valueOf(edate1));
        this.quantity = quantity1;
       
    }
    public String toSting(){
        return d_id+" "+name+" "+c_name+" "+mdate+" "+edate+" "+quantity;
    }
    public static void main() throws IOException, ClassNotFoundException, ParseException {
        Scanner scn = new Scanner(System.in);
        int ch = 0,n=-1;

        do {
            System.out.println("1.inset\t2.view\t3.search\t4.upadte\t5.delete\t0.exit");
            System.out.print("enter your choise:");
            ch = scn.nextInt();
            switch (ch){
                case 1:
                    Drug.insert();
                    break;
                case 2:
                    Drug.Druglist();
                    break;
                case 3:
                    Drug.search();
                    break;
                case 4:
                    Drug.update();
                    break;
                case 5:
                    Drug.delete();
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
    
    private static void delete() throws IOException,ClassNotFoundException{
        File file = new File("drug.txt");
        ObjectInputStream ois = null;
        ObjectOutputStream oos =  null;
        ArrayList<Drug> sal = new ArrayList<>();
        Scanner scn = new Scanner(System.in);
        Scanner scnum = new Scanner(System.in);
        ListIterator li = null;
        System.out.println("================================================DELETE=======================================================");
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            sal = (ArrayList<Drug>) ois.readObject();
            ois.close();
            boolean found = false;
            System.out.print("enter the Drug ID to delete:");
            String search = scn.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
            li = sal.listIterator();
            for (Drug st : sal) {
                String mD = sdf.format(st.mdate);
                String eD = sdf.format(st.edate);

                if (search.equals(st.d_id)) {

                    System.out.println(st.d_id+" "+st.name+" "+st.c_name+" "+mD+" "+eD+" "+st.quantity+"deleted!");
                  
                    found = true;
                }
            }
            while (li.hasNext()) {
                Drug e = (Drug) li.next();
                if (search.equals(e.d_id)){
                    li.remove();
                }
            }

            if (!found) {
                System.out.println("Drug not found");
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

    private static void update() throws IOException, ClassNotFoundException, ParseException {
        File file = new File("Drug.txt");
        ObjectInputStream ois  = null;
        ObjectOutputStream oos =  null;
        ArrayList<Drug> sal = new ArrayList<>();
        Scanner scn = new Scanner(System.in);
        Scanner scnum = new Scanner(System.in);
        ListIterator li =null;
        System.out.println("================================================UPDATE=======================================================");
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            sal = (ArrayList<Drug>) ois.readObject();
            ois.close();
            boolean found = false;
            System.out.print("enter theDrug ID to update:");
            String search = scn.nextLine();
            li = sal.listIterator();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
            for (Drug st : sal) {
               String mD = sdf.format(st.mdate);
                String eD = sdf.format(st.edate);
                if (search.equals(st.d_id)) {

                    System.out.println(st.d_id+" "+st.name+" "+st.c_name+" "+mD+" "+eD+" "+st.quantity+"deleted!");
                    System.out.println("--------------------------------------------------------------------------------------------------------------------");
                    found = true;
                }
            }
            while (li.hasNext()) {
                Drug e = (Drug) li.next();
                if (search.equals(e.d_id)) {
                    System.out.print("name:");
                    String name1 = scn.nextLine().toUpperCase();
                    System.out.print("company name:");
                    String c_name1 = scn.nextLine().toUpperCase();
                    String md = Patient.dateinsert("manufactured date:");
                    String ed = Patient.dateinsert("expired date:");
                    System.out.print("Quantity:");
                    int quantity = scnum.nextInt();
                    Drug drug = new Drug(e.d_id,name1,c_name1,md,ed,quantity);
                    li.set(drug);
                }
            }

            if (!found) {
                System.out.println("Drug not found");
            } else {
                System.out.println("success!");
                oos = new ObjectOutputStream(new FileOutputStream(file));
                oos.writeObject(sal);
                oos.close();
            }
        }
        System.out.println("=============================================================================================================");
    }

    private static void search() throws IOException, ClassNotFoundException {
        File file = new File("Drug.txt");
        ObjectInputStream ois = null;
        ArrayList<Drug> sal = new ArrayList<>();
        Scanner scn = new Scanner(System.in);
        System.out.println("================================================SEARCH=======================================================");
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            sal = (ArrayList<Drug>) ois.readObject();
            ois.close();
            boolean found = false;
            System.out.print("enter Drug ID number to search:");
            String search = scn.nextLine();
            for (Drug st : sal) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
               String mD = sdf.format(st.mdate);
                String eD = sdf.format(st.edate);
                if (search.equals(st.d_id)) {
                    System.out.println(st.d_id+" "+st.name+" "+st.c_name+" "+mD+" "+eD+" "+st.quantity);
                    System.out.println("--------------------------------------------------------------------------------------------------------------------");
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Drug not found");
            }
        }else {
            System.out.println("file is not exist!");
        }
        System.out.println("=============================================================================================================");
    }

    private static void Druglist() throws IOException, ClassNotFoundException {
        File file = new File("Drug.txt");
        ObjectInputStream ois = null;
        ArrayList<Drug> sal =  new ArrayList<>();
        System.out.println("================================================LIST=======================================================");
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            sal = (ArrayList<Drug>) ois.readObject();
            ois.close();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");

            for (Drug st : sal) {
               String mD = sdf.format(st.mdate);
                String eD = sdf.format(st.edate);
                System.out.println(st.d_id+" "+st.name+" "+st.c_name+" "+mD+" "+eD+" "+st.quantity);
                System.out.println("--------------------------------------------------------------------------------------------------------------------");
            }
        }else {
            System.out.println("file is not exist!");
        }
        System.out.println("===============================================================================================================");
    }

    public static void insert() throws IOException, ParseException, ClassNotFoundException {
        System.out.println("================================================INSERT=======================================================");
        System.out.println("welcome to data insert section");
        Scanner scn = new Scanner(System.in);
        Scanner scnum = new Scanner(System.in);
        ObjectOutputStream oos = null;
        ArrayList<Drug> sal = new ArrayList<>();
        File file =new File("Drug.txt");
        if(file.isFile()){
            ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(file));
            sal = (ArrayList<Drug>) ois.readObject();
            ois.close();
        }
        int ch =-1;
        while (ch != 0){
            System.out.print("Drug ID:");
            String d_id1 = scn.nextLine().toUpperCase();
            System.out.print("name:");
            String name1 = scn.nextLine().toUpperCase();
            System.out.print("company name:");
            String c_name1 = scn.nextLine().toUpperCase();
            String md = Patient.dateinsert("manufactuerd date:");
            String ed = Patient.dateinsert("expired date:");
            System.out.print("Quantity:");
            int quantity = scnum.nextInt();
            Drug drug = new Drug(d_id1,name1,c_name1,md,ed,quantity);
            sal.add(drug);
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
            Drug.iteration();
        }
        return ch;
    }
}
