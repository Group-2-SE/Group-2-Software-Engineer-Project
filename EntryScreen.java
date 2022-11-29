import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.FontUIResource;

public class EntryGUI extends JFrame{
    
    //private JFrame frame;

    private JPanel panel1;

    private JLabel heading;

    private JButton customer;
    private JButton employee;
    
    private Insets insets;
    private Dimension size;

    private EntryGUI LoginFrame;
    private InputHandler userInput;

    public EntryGUI(InputHandler userInput){

        //Storing the userInput object and the current frame
        EntryFrame = this;
        this.userInput = userInput;

        //Setting up the different JLabels, JButtons, JTextFields, JPasswordFields 
        heading = new JLabel("Welcome to Auto Channel Limited, Are you a ...?");//enter the password for managers or sales
        heading.setFont(new FontUIResource(heading.getText(), Font.BOLD, 12));

        

        //Adding action listners to each button to give it functionality
        customer = new JButton("CUSTOMER");
        customer.setPreferredSize(new DimensionUIResource(75, 20));
        customer.setFont(new FontUIResource(customer.getText(), Font.BOLD, 10));
        customer.addActionListener(new customerButtonListner());

        employee = new JButton("EMPLOYEE");
        employee.setPreferredSize(new DimensionUIResource(75, 20));
        employee.setFont(new FontUIResource(employee.getText(), Font.BOLD, 10));
        employee.addActionListener(new employeeButtonListner());

        

        //Adding the differents panels, buttons and fields into the frame
        panel1 = new JPanel();

        panel1.setBackground(Color.gray);
        panel1.setBorder(BorderFactory.createTitledBorder("Entry"));
        panel1.setPreferredSize(new DimensionUIResource(325, 150));
        
        panel1.setLayout(null);

        //Getting the inset of the JPanel called panel1
        insets = panel1.getInsets();

        

        //Positioning the "CUSTOMER" button snd text box
        size = signIn.getPreferredSize();
        signIn.setBounds(5 + insets.left, 45 + insets.top,size.width, size.height);

        //Positioning the "EMPLOYEE" button snd text box
        size = cancel.getPreferredSize();
        cancel.setBounds(5 + insets.left, 80 + insets.top,size.width, size.height);

       
        panel1.add(heading);
        panel1.add(customer);
        panel1.add(employee);
        

        setTitle("Auto Channel Limited Entry Screen");
        getContentPane().setBackground(Color.gray);
        //Disabling the mimize and resizing functionality of the frame
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        pack();
        setSize(340, 200);

        add(panel1);
    
        //Positions Frame in the center of the user's screen
        setLocationRelativeTo(null);

        //Makes the window visible to user
        setVisible(true);

    }

    //This should allow the customer to place a hold 
    private class customerButtonListner implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            //Place a hold 
            EntryFrame.dispose();
            CustomerMenuGUI CustomerMenu = new CustomerMenuGUI(user input);
        }
    }

    private class employeeButtonListner implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            EntryFrame.dispose();
            LoginGUI LoginFrame = new LoginGUI(user input);
        }
    }
}
