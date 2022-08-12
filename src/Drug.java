import pradee.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

//The methods and classes are same as admin but only the variables differ.
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
    //Formats how the objects are printed
    public String toSting(){
        return d_id+" | "+name+" | "+c_name+" | "+MedzeUtil.dateViwe(mdate)+" | "+MedzeUtil.dateViwe(edate)+" | "+quantity;
    }
    //Main Function
    public static void main() throws IOException, ClassNotFoundException, ParseException {
        Scanner scn = new Scanner(System.in);
        int ch = 0,n=-1;

        do {
            System.out.println("\n<========================================================================================================>");
            System.out.println("\t\t\t\t\t\t\t\t\t\t Welcome to Drugs Section");
            System.out.println("<========================================================================================================>");
            System.out.println("\t\t\t1.Insert\t\t2.View\t\t3.Search\t\t4.Update\t\t5.Delete\t\t0.Exit");
            System.out.println("<-------------------------------------------------------------------------------------------------------->");
            System.out.print("Enter your Choice : ");
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
    //Delete Function
    private static void delete() throws IOException,ClassNotFoundException{
        File file = new File("drug.UWU");
        ObjectInputStream ois = null;
        ObjectOutputStream oos =  null;
        PradiArray<Drug> sal = new PradiArray<>();
        Scanner scn = new Scanner(System.in);
        System.out.println("\n<========================================================================================================>");
        System.out.println("\t\t\t\t\t\t\t\t\t Welcome to Drug Delete Section");
        System.out.println("<-------------------------------------------------------------------------------------------------------->");
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            sal = (PradiArray<Drug>) ois.readObject();
            ois.close();
            boolean found = false;
            System.out.print("Enter the Drug ID to Delete:");
            String search = scn.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
            for (Drug st : sal) {
                if (search.equals(st.d_id)) {
                    System.out.println("\n<========================================================================================================>");
                    System.out.println("Drug Details :\t"+st.getD_id() + " " + st.getName()+ " " + st.getC_name() + " " + MedzeUtil.dateViwe(st.getMdate()) + " " + MedzeUtil.dateViwe(st.getEdate())+ " " + st.getQuantity());
                    System.out.println("<========================================================================================================>");
                    System.out.println(st.d_id);
                    sal.remove(st);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
                System.out.println("\t\t\t\t\t\t\t\t\t\t  Drug not Found...");
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
    //Update Function
    private static void update() throws IOException, ClassNotFoundException, ParseException {
        File file = new File("Drug.UWU");
        ObjectInputStream ois  = null;
        ObjectOutputStream oos =  null;
        PradiArray<Drug> sal = new PradiArray<>();
        Scanner scn = new Scanner(System.in);
        Scanner scnum = new Scanner(System.in);
        System.out.println("\n<========================================================================================================>");
        System.out.println("\t\t\t\t\t\t\t\t\t Welcome to Drug Update Section");
        System.out.println("<-------------------------------------------------------------------------------------------------------->");
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            sal = (PradiArray<Drug>) ois.readObject();
            Drug old = new Drug();
            ois.close();
            boolean found = false;
            System.out.print("Enter the Drug ID to Update : ");
            String search = scn.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
            for (Drug st : sal) {
                if (search.equals(st.d_id)) {
                    System.out.println("\n<========================================================================================================>");
                    System.out.println("Drug Details :\t"+st.getD_id() + " " + st.getName()+ " " + st.getC_name() + " " + MedzeUtil.dateViwe(st.getMdate()) + " " + MedzeUtil.dateViwe(st.getEdate())+ " " + st.getQuantity());
                    System.out.println("<========================================================================================================>");
                    found = true;
                    old = st;
                }
            }
            if (!found) {
                System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
                System.out.println("\t\t\t\t\t\t\t\t\t\t  Drug not found...");
                System.out.println("<-------------------------------------------------------------------------------------------------------->");
            } else {
                Drug drug = new Drug();
                drug.setD_id(old.getD_id());
                System.out.print("=>\t"+"Drug Name : ");
                drug.setName(scn.nextLine().toUpperCase());
                System.out.print("=>\t"+"Company Name : ");
                drug.setC_name(scn.nextLine().toUpperCase());
                drug.setMdate(MedzeUtil.dateinsert("=>\t"+"Manufacture Date (DD/MM/YYYY) : "));
                drug.setEdate(MedzeUtil.dateinsert("=>\t"+"Expired Date (DD/MM/YYYY) : "));
                System.out.print("=>\t"+"Quantity : ");
                drug.setQuantity(scnum.nextInt());
                sal.update(old,drug);
                System.out.println("\n<========================================================================================================>");
                System.out.println("Drug Details :\t"+drug.getD_id() + " " + drug.getName()+ " " + drug.getC_name() + " " + MedzeUtil.dateViwe(drug.getMdate()) + " " + MedzeUtil.dateViwe(drug.getEdate())+ " " + drug.getQuantity());
                System.out.println("<========================================================================================================>");

                System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
                System.out.println("\t\t\t\t\t\t\t\t\t\t  Successfully Updated...");
                System.out.println("<-------------------------------------------------------------------------------------------------------->");
                oos = new ObjectOutputStream(new FileOutputStream(file));
                oos.writeObject(sal);
                oos.close();
            }
        }
        System.out.println("\n<========================================================================================================>");
    }
    //Search Function
    private static void search() throws IOException, ClassNotFoundException {
        File file = new File("Drug.UWU");
        ObjectInputStream ois = null;
        PradiArray<Drug> sal = new PradiArray<>();
        Scanner scn = new Scanner(System.in);
        System.out.println("\n<========================================================================================================>");
        System.out.println("\t\t\t\t\t\t\t\t\t Welcome to Drug Search Section");
        System.out.println("<-------------------------------------------------------------------------------------------------------->");
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            sal = (PradiArray<Drug>) ois.readObject();
            ois.close();
            boolean found = false;
            System.out.print("Enter the Drug ID number to Search:");
            String search = scn.nextLine();
            for (Drug st : sal) {
                if (search.equals(st.d_id)) {
                    System.out.println("\n<========================================================================================================>");
                    System.out.println("Drug Details :\t"+st.getD_id() + " " + st.getName()+ " " + st.getC_name() + " " + MedzeUtil.dateViwe(st.getMdate()) + " " + MedzeUtil.dateViwe(st.getEdate())+ " " + st.getQuantity());
                    System.out.println("<========================================================================================================>");
                    found = true;
                }
            }
            if (!found) {
                System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
                System.out.println("\t\t\t\t\t\t\t\t\t\t  Drug not Found...");
                System.out.println("<-------------------------------------------------------------------------------------------------------->");
            }
        }else {
            System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
            System.out.println("\t\t\t\t\t\t\t\t\t\t  File is not Exist...");
            System.out.println("<-------------------------------------------------------------------------------------------------------->");
        }
        System.out.println("\n<========================================================================================================>");
    }
    //Display Drug List Function
    public static void Druglist() throws IOException, ClassNotFoundException {
        File file = new File("Drug.UWU");
        ObjectInputStream ois = null;
        PradiArray<Drug> sal =  new PradiArray<>();
        System.out.println("\n<========================================================================================================>");
        System.out.println("\t\t\t\t\t\t\t\t\t Welcome to Drug View Section");
        System.out.println("<-------------------------------------------------------------------------------------------------------->\n");
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            sal = (PradiArray<Drug>) ois.readObject();
            ois.close();
            System.out.println("Id\t\tName\t\tC_Name\t\tM_Date\t\t\tE_Date\t\t\tQuantity");
            System.out.println("<------------------------------------------------------------------------------------------------->\n");
            for (Drug st : sal) {
                System.out.println(st.getD_id() + "\t" + st.getName() + "\t\t"  + st.getC_name() + "\t\t"+ MedzeUtil.dateViwe(st.getMdate()) + "\t\t" +MedzeUtil.dateViwe(st.getEdate()) + "\t\t" + st.getQuantity());
                System.out.println("<-------------------------------------------------------------------------------------------->");
            }
        }else {
            System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
            System.out.println("\t\t\t\t\t\t\t\t\t\t  File is not Exist...");
            System.out.println("<-------------------------------------------------------------------------------------------------------->");
        }
        System.out.println("\n<========================================================================================================>");
    }
    //Insert Drug Function
    public static void insert() throws IOException, ParseException, ClassNotFoundException {
        System.out.println("\n<========================================================================================================>");
        System.out.println("\t\t\t\t\t\t\t\t\t Welcome to Data Insert Section");
        System.out.println("<-------------------------------------------------------------------------------------------------------->");
        Scanner scn = new Scanner(System.in);
        Scanner scnum = new Scanner(System.in);
        ObjectOutputStream oos = null;
        PradiArray<Drug> sal = new PradiArray<>();
        File file =new File("Drug.UWU");
        if(file.isFile()){
            ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(file));
            sal = (PradiArray<Drug>) ois.readObject();
            ois.close();
        }
        int ch =-1;
        while (ch != 0){
            Drug drug = new Drug();
            System.out.print("=>\tDrug (DXXX)"+" : ");
            drug.setD_id(scn.nextLine().toUpperCase());
            System.out.print("=>\t"+"Drug Name : ");
            drug.setName(scn.nextLine().toUpperCase());
            System.out.print("=>\t"+"Company Name : ");
            drug.setC_name(scn.nextLine().toUpperCase());
            drug.setMdate(MedzeUtil.dateinsert("=>\t"+"Manufacture Date (DD/MM/YYYY) : "));
            drug.setEdate(MedzeUtil.dateinsert("=>\t"+"Expired Date (DD/MM/YYYY) : "));
            System.out.print("=>\t"+"Quantity : ");
            drug.setQuantity(scnum.nextInt());
            sal.add(drug);
            System.out.println("\n<========================================================================================================>");
            System.out.println("Drug Details :\t"+drug.getD_id() + " " + drug.getName()+ " " + drug.getC_name() + " " + MedzeUtil.dateViwe(drug.getMdate()) + " " + MedzeUtil.dateViwe(drug.getEdate())+ " " + drug.getQuantity());
            System.out.println("<========================================================================================================>");

            ch = MedzeUtil.iteration();
        }
        oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(sal);
        oos.close();
        System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
        System.out.println("\t\t\t\t\t\t\t\t\t\t  Successfully Added...");
        System.out.println("<-------------------------------------------------------------------------------------------------------->");
        System.out.println("\n<========================================================================================================>");
    }
}
