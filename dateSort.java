import java.util.Comparator;

public class FirstNameSort implements Comparator<Customer> {
    public int compare(Customer c1, Customer c2)
    {
        return c1.getDate().compareTo(c2.getDate());
    }
}