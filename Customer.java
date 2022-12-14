import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.nio.file.*;
import java.time.*;
import java.text.SimpleDateFormat;

public class Customer {

    private int car_id;
    private int trans_id;
    private int phoneNumber;
    private int cust_id= 1000;
    private static int index= 0;
    private String first_name;
    private String last_name;
    private String address;
    private String email;
    private Date date;
    protected ArrayList<ArrayList<String>> customer_info= new ArrayList<ArrayList<String>>();

    public Customer( String first_name, String last_name, int trans_id, int car_id, int phoneNumber, String address, int cust_id){
        this.cust_id = cust_id++;
        this.first_name= first_name;
        this.last_name= last_name;
        this.trans_id= trans_id;
        this.car_id= car_id;
        this.phoneNumber= phoneNumber;
        this.address= address;

        customer_info.add(new ArrayList<String>());
        customer_info.get(index).add(0, Integer.toString(cust_id));
        customer_info.get(index).add(1, Integer.toString(trans_id));
        customer_info.get(index).add(2, first_name);
        customer_info.get(index).add(3, last_name);
        customer_info.get(index).add(4, Integer.toString(car_id));
        customer_info.get(index).add(5, Integer.toString(phoneNumber));
        customer_info.get(index).add(6, getDate());
    }
    
    public void addCustomerInfo(String first_name, String last_name, int trans_id, int car_id, int phoneNumber, String address)
    {
        //Path output = Paths.get("customerFile.txt");
        File customerFile = getFile("customerFile");
        try{
            FileWriter f = new FileWriter(customerFile, true);
            f.append(System.getProperty("line.separator"));
            f.append(first_name+":"+last_name+":"+trans_id+":"+getCustID(first_name)+":"+address+":"+email+":"+phoneNumber+);
            f.close();
        }
        catch(IOException ioe){}
       
    }

    private File getFile(String string) {
        return null;
    }

    public Customer() {
    }

    public String getCarID(String first_name){
        String id= "";
        for(int counter = 0; counter< customer_info.size(); counter++){
            if ((customer_info.get(counter).get(2) == first_name)){
                id= customer_info.get(counter).get(4);
                break;
            }
        }
        if(id!= " "){
            System.out.println("Not Found");
        }
        return id;
    }

    public String getDate(){
        date= new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        String formattedDate = sdf.format(date);
        return formattedDate;
    }
    
    public String getName(int cust_id){
        String Name= "";
        for(int counter = 0; counter< customer_info.size(); counter++){
            if ((customer_info.get(counter).get(0) == Integer.toString(cust_id))){
                Name= customer_info.get(counter).get(2);
                Name+= customer_info.get(counter).get(3);
                break;
            }
        }
        if(Name!= " "){
            System.out.println("Not Found");
        }
        return Name;
    }

    public String getCustID(String first_name){
        String id= "";
        for(int counter = 0; counter< customer_info.size(); counter++){
            if ((customer_info.get(counter).get(2) == first_name)){
                id= customer_info.get(counter).get(0);
                break;
            }
        }
        if(id!= " "){
            System.out.println("Not Found");
        }
        return id;
    }

    public int getTransId(){
        return trans_id;
    }

    public int getcustomerid(){
        return cust_id;
    }

    public int phoneno(){
        return phoneNumber;
    }

    public String getemail(){
        return email;
    }

    public String getaddress(){
        return address;
    }

    public String getfname(){
        return first_name;
    }

    public String getlname(){
        return last_name;
    }
    /*public void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your first name: ");
        first_name = input.nextLine();
        System.out.println("Enter your last name ");
        last_name = input.nextLine();
        System.out.println("Enter your phone number: ");
        phoneNumber = Integer.valueOf(input.nextLine());
        System.out.println("Enter your address: ");
        address = input.nextLine();
        System.out.println("Enter your email: ");
        email = input.nextLine();
        System.out.println("Enter your transaction ID: ");
        trans_id = input.nextLine();
    } */
}
