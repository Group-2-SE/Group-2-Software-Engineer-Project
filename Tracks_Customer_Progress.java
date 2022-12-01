import java.util.*;
import javax.sql.rowset.CachedRowSet;
import java.io.*;

public class Tracks_Customer_Progress extends Customer{
    private int cust_id;
    private String progress;
    private ArrayList<Integer> Paid_in_Cash= new ArrayList<Integer>();
    private ArrayList<Integer> Transaction_ID_Approved= new ArrayList<Integer>();
    private ArrayList<Integer> Documents_Submitted= new ArrayList<Integer>();
    private ArrayList<Integer> Documents_Approved= new ArrayList<Integer>();
    private ArrayList<Integer> Deposit_Verified= new ArrayList<Integer>();
    private ArrayList<Integer> Vehicle_Pickup_Completed= new ArrayList<Integer>();
    private ArrayList<Integer> Purchase_Completed= new ArrayList<Integer>();
    Customer c= new Customer();
    public Tracks_Customer_Progress(){
        
    }

    public void SearchByID(int cust_id){
        //Display customer by id
        if(Paid_in_Cash.contains(cust_id)){
            System.out.println("Name: "+ c.getName(cust_id) + "Associated car ID: " + c.getCarID(c.getName(cust_id)) + "Progress: Paid in Cash");
        }if (Transaction_ID_Approved.contains(cust_id)) {
            System.out.println("Name: "+ c.getName(cust_id) + "Associated car ID: " + c.getCarID(c.getName(cust_id)) + "Progress: Transaction ID Approved");
        }if (Documents_Submitted.contains(cust_id)) {
            System.out.println("Name: "+ c.getName(cust_id) + "Associated car ID: " + c.getCarID(c.getName(cust_id)) + "Progress: Documents Submitted");
        }if (Documents_Approved.contains(cust_id)) {
            System.out.println("Name: "+ c.getName(cust_id) + "Associated car ID: " + c.getCarID(c.getName(cust_id)) + "Progress: Documents Approved");
        }if (Deposit_Verified.contains(cust_id)) {
            System.out.println("Name: "+ c.getName(cust_id) + "Associated car ID: " + c.getCarID(c.getName(cust_id)) + "Progress: Deposit Verified");
        }if (Vehicle_Pickup_Completed.contains(cust_id)) {
            System.out.println("Name: "+ c.getName(cust_id) + "Associated car ID: " + c.getCarID(c.getName(cust_id)) + "Progress: Vehicle Pickip Completed");
        }if (Purchase_Completed.contains(cust_id)) {
            System.out.println("Name: "+ c.getName(cust_id) + "Associated car ID: " + c.getCarID(c.getName(cust_id)) + "Progress: Purchase Completed");
        }else{
            System.out.println("The priority for " + cust_id + " wasn't set or customer ID doesn't exist");
        }
    }

    //places customer in particular priority list
    public void setPIC(int cust_id){
        if (!Paid_in_Cash.contains(cust_id)){
            Paid_in_Cash.remove(cust_id);
        }
        Paid_in_Cash.add(cust_id);
    }

    public void setTID(int cust_id){
        if (Paid_in_Cash.contains(cust_id)){
            Paid_in_Cash.remove(cust_id);
        }
        Transaction_ID_Approved.add(cust_id);
    }

    public void setDS(int cust_id){
        if (Transaction_ID_Approved.contains(cust_id)){
            Transaction_ID_Approved.remove(cust_id);
        }
        Documents_Submitted.add(cust_id);
    }

    public void setDA(int cust_id){
        if (Documents_Submitted.contains(cust_id)){
            Documents_Submitted.remove(cust_id);
        }
        Documents_Approved.add(cust_id);
    }

    public void setDV(int cust_id){
        if (Documents_Approved.contains(cust_id)){
            Documents_Approved.remove(cust_id);
        }
        Deposit_Verified.add(cust_id);
    }

    public void setVPC(int cust_id){
        if (Deposit_Verified.contains(cust_id)){
            Deposit_Verified.remove(cust_id);
        }
        Vehicle_Pickup_Completed.add(cust_id);
    }

    public void setPC(int cust_id){
        if (Vehicle_Pickup_Completed.contains(cust_id)){
            Vehicle_Pickup_Completed.remove(cust_id);
        }
        Purchase_Completed.add(cust_id);
    }

    //Display customer by priority
    public void Paid_in_Cash(int cust_id){
        System.out.println("Name: "+ c.getName(cust_id) + "Associated car ID: " + c.getCarID(c.getName(cust_id)));
    }

    public void Transaction_ID_Approved(int cust_id){
        System.out.println("Name: "+ c.getName(cust_id) + "Associated car ID: " + c.getCarID(c.getName(cust_id)));
    }

    public void Documents_Submitted(int cust_id){
        System.out.println("Name: "+ c.getName(cust_id) + "Associated car ID: " + c.getCarID(c.getName(cust_id)));
    }

    public void Documents_Approved(int cust_id){
        System.out.println("Name: "+ c.getName(cust_id) + "Associated car ID: " + c.getCarID(c.getName(cust_id)));
    }

    public void Deposit_Verified(int cust_id){
        System.out.println("Name: "+ c.getName(cust_id) + "Associated car ID: " + c.getCarID(c.getName(cust_id)));
    }

    public void Vehicle_Pickup_Completed(int cust_id){
        System.out.println("Name: "+ c.getName(cust_id) + "Associated car ID: " + c.getCarID(c.getName(cust_id)));
    }

    public void Purchase_Completed(int cust_id){
        System.out.println("Name: "+ c.getName(cust_id) + "Associated car ID: " + c.getCarID(c.getName(cust_id)));
    }
    
    //shows all customer information with progress
    public String showall(){
        String cid= " ";
        String newLine= System.getProperty("line.separator");
        customer_info = new ArrayList<>(customer_info);
        for(int counter = 0; counter< customer_info.size(); counter++){
            int x= Integer.valueOf(customer_info.get(counter).get(0));
            if(Paid_in_Cash.contains(x)){
                cid = "Name: "+ c.getName(x) + "Associated car ID: " + c.getCarID(c.getName(x)) + "Progress: Paid in Cash" + "/n";
            }
            if (Transaction_ID_Approved.contains(x)){
                cid.concat(newLine);
                cid.concat( "Name: "+ c.getName(cust_id) + "Associated car ID: " + c.getCarID(c.getName(cust_id)) + "Progress: Transaction ID Approved");
            }
            if (Documents_Submitted.contains(x)) {
                cid.concat(newLine);
                cid.concat("Name: "+ c.getName(cust_id) + "Associated car ID: " + c.getCarID(c.getName(cust_id)) + "Progress: Documents Submitted");
            }
            if(Documents_Approved.contains(x)){
                cid.concat(newLine);
                cid.concat("Name: "+ c.getName(cust_id) + "Associated car ID: " + c.getCarID(c.getName(cust_id)) + "Progress: Documents Approved");
            }
            if(Deposit_Verified.contains(x)){
                cid.concat(newLine);
                cid.concat("Name: "+ c.getName(cust_id) + "Associated car ID: " + c.getCarID(c.getName(cust_id)) + "Progress: Deposit Verified");
            }
            if(Vehicle_Pickup_Completed.contains(x)){
                cid.concat(newLine);
                cid.concat("Name: "+ c.getName(cust_id) + "Associated car ID: " + c.getCarID(c.getName(cust_id)) + "Progress: Vehicle Pickip Completed");
            }
            if(Purchase_Completed.contains(x)){
                cid.concat(newLine);
                cid.concat("Name: "+ c.getName(cust_id) + "Associated car ID: " + c.getCarID(c.getName(cust_id)) + "Progress: Purchase Completed");
            }
            else{
                System.out.println("An error occurred");
            }
        }
        return cid;
    }



}

