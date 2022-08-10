import pradee.MedzeUtil;
import pradee.PradiArray;

import java.io.*;
import java.util.Scanner;

public class drugC {
 private String patient;
    private static String drug;

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }


    public String getDrug() {
        return drug;
    }

    public void setDrug(String drug) {
        this.drug = drug;
    }
    @Override
    public String toString() {
        return patient+"\n"+drug;
    }
    public  static void druginsert(String ID) throws IOException, ClassNotFoundException {
        {
            System.out.println("\n<========================================================================================================>");
            System.out.println("\t\t\t\t\t\t\t\t\t druginsert");
            System.out.println("<-------------------------------------------------------------------------------------------------------->");
            Scanner scn = new Scanner(System.in);
            Scanner scnum = new Scanner(System.in);
            ObjectOutputStream oos = null;
            PradiArray<drugC> sal = new PradiArray<>();
            File file =new File(ID+".txt");
            if(file.isFile()){
                ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(file));
                sal = (PradiArray<drugC>) ois.readObject();
                ois.close();

            }
            System.out.println("<===========================================================================>\n");
            System.out.println("Press 1 for your Conformation");
            System.out.println("\t1.Confirm\t\t0.Exit");
            System.out.print("Enter Your choice : ");
            int a=scnum.nextInt();
            System.out.println("\n<===========================================================================>");
            if (a == 1) {
                drugC drugAdd=new drugC();
                drugAdd.setPatient(ID);
                drugAdd.setDrug();
                sal.add(drugAdd);
                System.out.println("<========================================================================================================>");
                System.out.println("\n<-------------------------------------------------------------------------------------------------------->");
                System.out.println("\t\t\t\t\t\t\t\t\t\t  Successfully Added...");
                System.out.println("<-------------------------------------------------------------------------------------------------------->");
            }
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(sal);
            oos.close();
        }
    }
    private static String inserter(){
        String drugs=null;
        Scanner scn=new Scanner(System.in);
        System.out.println("Input drugs");
        String input=scn.nextLine();
        if(Drug.consist(input))
        return drugs;
    }
}
