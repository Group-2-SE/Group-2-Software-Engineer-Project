import java.util.*;
import java.io.*;

public class Tracks_Customer_Progress extends Customer{
    private int cust_id;

    private static ArrayList<ArrayList<String>> Progress= new ArrayList<ArrayList<String>>();

    public Tracks_Customer_Progress(int cust_id){
        super();
        System.out.println(super.first_name + super.last_name + " placed hold on " + Customer.getDate());
    }

    public void setProgress(int cust_id){
        
    }

    Enum Progress{
        
    }
}
