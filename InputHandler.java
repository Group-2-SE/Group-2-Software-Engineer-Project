import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputHandler<Customer> {

    private Scanner scan;
    private FileWriter fWriter;
    private FileReader fReader;
    private BufferedWriter bWriter;
    private BufferedReader bReader;
    private Customer currentUser;
    private ArrayList<Customer> customers;
    

    public ArrayList<Customer> getCustomers(){
        return customers;
    }

    public File getFile(String fname){
        //Returns a file if no exceptions are found else returns null
        try{
            File filefound = new File(fname+".txt");
            return filefound;
        }
        catch(NullPointerException fnfe){
            return null;
        }
    }

    public Customer getCurrentUser(){
        return currentUser;
    }

    public void deleteCustomerData(int cust_id)
    {
        Scanner strInput =  new Scanner(System.in);
        String ID, record;
    
        File CustomerData = getFile("CustomerData");
        File tempData = getFile("TemporaryData");
       
        //boolean found = false;

        if (CustomerData!= null)
        {
            try
            {
                BufferedReader br = new BufferedReader( new FileReader( CustomerData ) );
                BufferedWriter bw = new BufferedWriter( new FileWriter( tempData) );
                
                System.out.println("\t\t Delete Customer Record\n");
                System.out.println("Enter the Customer ID: ");
                ID =  strInput.nextLine();
                
                while( ( record = br.readLine() ) != null ) 
                {
                if( record.contains(ID) )
                {
                    //countinue:
                    bw.write(record);
                    bw.flush();
                    bw.newLine();
                }
                }

            br.close();
            bw.close();
            CustomerData.delete();
            tempData.renameTo(CustomerData);
            }

            catch(FileNotFoundException fnfe)
            {System.out.println("File not found");}
            catch(IOException ioe)
            {System.out.println("IO Exception");}
            finally{
                try{
                    if( fWriter != null)
                        fWriter.close();
                    if( bReader != null)
                        bReader.close();
                    if( scan != null)
                        //scan.close();
                    if( fReader != null)
                        fReader.close();
                }
                catch(IOException ioe){System.out.println("Error");}
            }  

        }
    }

     public void updateCustomerData(int cust_id)
    {
        //Method to check if an address exists in the EstateData file then skips over that line and rewrites the file excluding that line.  
    }
        


    public Customer getUser(int cust_id){
        
        //Checks if a user exist in the file "ClientsData" then creates a client and returns it and storeds the created client as the currentUser, if the user exists else returns null
        File CustomerData = getFile("CustomerData");
        String split[];

        if (CustomerData!= null)
        {
            try
            {
                scan = new Scanner(CustomerData);
                while (scan.hasNextLine())
                {
                    split = scan.nextLine().split(":");
                    if (split[0].equals(cust_id))
                    {
                        Customer c = new Customer(Integer.parseInt(split[0]),Integer.parseInt(split[1]),split[2],split[3],Integer.parseInt(split[4]),Integer.parseInt(split[5]));
                        currentUser = c;
                        return c;
                    }
                }
                //scan.close();
            }
            catch(FileNotFoundException fnfe)
            {}

        }
        return null;
    }
    
}
