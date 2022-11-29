import java.util.*;
import java.io.*;

public class Placing_A_Hold extends Customer{
    
    private int cust_id;
    private int car_id;
    private int trans_id;
    private static int index= 0;
    private Date present_date;
    private ArrayList<ArrayList<Integer>> holds= new ArrayList<ArrayList<Integer>>();
    private Boolean status;

    public Placing_A_Hold(int cust_id, int trans_id, int car_id){
        super();
        this.cust_id = cust_id;
        this.trans_id = trans_id;
        this.car_id = car_id;
        //loop through inventory arraylist using car id and take out the car so its no longer available
       /*  for(int counter = 0; counter< arraylist.size(); counter++){
            if (arraylist[counter]== car_id){
                arraylist.remove(counter);
            }
        }*/
        index++;
        holds.add(new ArrayList<Integer>());
        holds.get(index).add(0, cust_id);
        holds.get(index).add(1, car_id);
        holds.get(index).add(2, trans_id);
    }

    public Boolean findingHold(int cust_id){
        for(int counter = 0; counter< holds.size(); counter++){
            if ((holds.get(counter).get(0)== cust_id)){
                status= true;
            }
        }
        return status;        
    } 
}
