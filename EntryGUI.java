import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
//import javax.swing.plaf.FontUIResource;

public class EntryGUI extends JFrame{
    
    

    //private JPanel panel1;

    private JLabel heading;

    private JButton customer;
    private JButton employee;
    
    //private Insets insets;
    //private Dimension size;

    private EntryGUI EntryFrame;
    //private LoginGUI LoginFrame;
    //private JFrame thisFrame;
    private InputHandler userInput;

    public EntryGUI(InputHandler userInput){

        //Storing the userInput object and the current frame
        EntryFrame = this;
        this.userInput = userInput;

        //Setting up the different JLabels, JButtons, JTextFields, JPasswordFields 
        //heading = new JLabel("Welcome to Auto Channel Limited, Are you a ...?");//enter the password for managers or sales
        //heading.setFont(new FontUIResource(heading.getText(), Font.BOLD, 12));

        heading = new JLabel("Welcome to Auto Channel Limited, Are you a ...?");//enter the password for managers or sales
        setLayout(new GridLayout(2,1,100,10));
        setBackground(Color.GRAY);

        //Adding action listners to each button to give it functionality
        customer = new JButton("CUSTOMER");
        customer.setPreferredSize(new DimensionUIResource(250, 50));
        //customer.setBounds(5 + insets.left, 45 + insets.top,size.width, size.height);

        employee = new JButton("EMPLOYEE");
        employee.setPreferredSize(new DimensionUIResource(75, 20));
        //employee.setBounds(5 + insets.left, 80 + insets.top,size.width, size.height);

        customer.addActionListener(new customerButtonListner());
        employee.addActionListener(new employeeButtonListner());

        //customer = new JButton("CUSTOMER");
        //customer.setPreferredSize(new DimensionUIResource(75, 20));
        //customer.setFont(new FontUIResource(customer.getText(), Font.BOLD, 10));
        //customer.addActionListener(new customerButtonListner());

        //employee = new JButton("EMPLOYEE");
        //employee.setPreferredSize(new DimensionUIResource(75, 20));
        //employee.setFont(new FontUIResource(employee.getText(), Font.BOLD, 10));
        //employee.addActionListener(new employeeButtonListner());

    
        getContentPane().setBackground(Color.gray);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        pack();
        //Positions Frame in the center of the user's screen
        setSize(350, 200);
        setLocationRelativeTo(null);
        add(customer);
        add(employee);
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
            CustomerInterface CustomerFrame = new CustomerInterface(userInput);
        }
    }

    private class employeeButtonListner implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            EntryFrame.dispose();
            LoginGUI LoginFrame = new LoginGUI(userInput);
        }
    }
}
