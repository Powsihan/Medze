import pradee.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Drug implements Serializable{
   private String d_id,name,c_name;
    private Date mdate = null;
    private Date edate = null;
   private int quantity;
    SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
    public String getD_id() {
        return d_id;
    }

    public void setD_id(String d_id) {
        this.d_id = d_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public Date getMdate() {
        return mdate;
    }

    public void setMdate(String mdate) throws ParseException {
        this.mdate = sfd.parse(String.valueOf(mdate));
    }

    public Date getEdate() {
        return edate;
    }

    public void setEdate(String edate) throws ParseException {
        this.edate = sfd.parse(String.valueOf(edate));
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toSting(){
        return d_id+" | "+name+" | "+c_name+" | "+MedzeUtil.dateViwe(mdate)+" | "+MedzeUtil.dateViwe(edate)+" | "+quantity;
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
        PradiArray<Drug> sal = new PradiArray<>();
        Scanner scn = new Scanner(System.in);
        System.out.println("================================================DELETE=======================================================");
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            sal = (PradiArray<Drug>) ois.readObject();
            ois.close();
            boolean found = false;
            System.out.print("enter the Drug ID to delete:");
            String search = scn.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
            for (Drug st : sal) {
                if (search.equals(st.d_id)) {
                    System.out.println(st+"deleted!");
                    sal.remove(st);
                    found = true;
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
        PradiArray<Drug> sal = new PradiArray<>();
        Scanner scn = new Scanner(System.in);
        Scanner scnum = new Scanner(System.in);
        System.out.println("================================================UPDATE=======================================================");
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            sal = (PradiArray<Drug>) ois.readObject();
            Drug old = new Drug();
            ois.close();
            boolean found = false;
            System.out.print("enter theDrug ID to update:");
            String search = scn.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
            for (Drug st : sal) {
                if (search.equals(st.d_id)) {
                    System.out.println(st+"deleted!");
                    System.out.println("--------------------------------------------------------------------------------------------------------------------");
                    found = true;
                    old = st;
                }
            }
            if (!found) {
                System.out.println("Drug not found");
            } else {
                Drug drug = new Drug();
                drug.setD_id(old.getD_id());
                System.out.print("name:");
                drug.setC_name(scn.nextLine().toUpperCase());
                System.out.print("company name:");
                drug.setC_name(scn.nextLine().toUpperCase());
                drug.setMdate(MedzeUtil.dateinsert("manufactuerd date:"));
                drug.setEdate(MedzeUtil.dateinsert("expired date:"));
                System.out.print("Quantity:");
                drug.setQuantity(scnum.nextInt());
                sal.update(old,drug);
                System.out.println("====================================================================================================================");
                System.out.println(drug);
                System.out.println("====================================================================================================================");

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
        PradiArray<Drug> sal = new PradiArray<>();
        Scanner scn = new Scanner(System.in);
        System.out.println("================================================SEARCH=======================================================");
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            sal = (PradiArray<Drug>) ois.readObject();
            ois.close();
            boolean found = false;
            System.out.print("enter Drug ID number to search:");
            String search = scn.nextLine();
            for (Drug st : sal) {
                if (search.equals(st.d_id)) {
                    System.out.println(st);
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
        PradiArray<Drug> sal =  new PradiArray<>();
        System.out.println("================================================LIST=======================================================");
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            sal = (PradiArray<Drug>) ois.readObject();
            ois.close();
            for (Drug st : sal) {
                System.out.println(st);
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
        PradiArray<Drug> sal = new PradiArray<>();
        File file =new File("Drug.txt");
        if(file.isFile()){
            ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(file));
            sal = (PradiArray<Drug>) ois.readObject();
            ois.close();
        }
        int ch =-1;
        while (ch != 0){
            Drug drug = new Drug();
            System.out.print("Drug ID:");
            drug.setD_id(scn.nextLine().toUpperCase());
            System.out.print("name:");
            drug.setC_name(scn.nextLine().toUpperCase());
            System.out.print("company name:");
            drug.setC_name(scn.nextLine().toUpperCase());
            drug.setMdate(MedzeUtil.dateinsert("manufactuerd date:"));
            drug.setEdate(MedzeUtil.dateinsert("expired date:"));
            System.out.print("Quantity:");
            drug.setQuantity(scnum.nextInt());
            sal.add(drug);
            System.out.println("====================================================================================================================");
            System.out.println(drug);
            System.out.println("====================================================================================================================");

            ch = MedzeUtil.iteration();
        }
        oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(sal);
        oos.close();
        System.out.println("success!");
        System.out.println("=============================================================================================================");
    }

}
