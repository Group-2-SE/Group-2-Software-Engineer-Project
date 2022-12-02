import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;

public class ClientListing extends JFrame{
    
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane scrollPane;
    private JScrollPane scrollPane2;
    
    private JPanel panel1;

    private JButton dateSortButton;
    private JButton backButton;

    private CustomerListing tableFrame;
    private InputHandler userInput;

    private Insets insets;
    private Dimension size;

    private boolean dateSorted = false;

    private ArrayList<Customers> customers;


    public CustomerListing(InputHandler userInput){

        tableFrame = this;
        this.userInput = userInput;

        String columnNames[] = {"CUSTOMER ID","TRANSACTION NUMBER","FIRST NAME", "LAST NAME", "CAR ID", "EMAIL", "CONTACT NUMBER", "DATE"};
        userInput.loadCustomerData();
        customers = userInput.getCustomers();

        model=new DefaultTableModel(columnNames,0);
        table = new JTable(model);
        table.setBackground(Color.lightGray);
        addToTable();

        scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED){
            public Dimension getPreferredSize() {
               return new Dimension(610, 300);
            };
         };
        scrollPane.setVisible(true);

        panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        
        // editButton = new JButton("Edit My Data")
        // {
        //     public Dimension getPreferredSize() {
        //        return new Dimension(130, 25);
        //     };
        //  };
        // editButton.addActionListener(new EditButtonListener());

        dateSortButton = new JButton("Sort by Date")
        {
            public Dimension getPreferredSize() {
               return new Dimension(165, 25);
            };
         };
        dateSortButton.addActionListener(new dateSortButtonListener());

        backButton = new JButton("Back")
        {
            public Dimension getPreferredSize() {
               return new Dimension(130, 25);
            };
        };
        backButton.addActionListener(new BackButtonListener());
        
        panel1.add(scrollPane);
        // panel1.add(editButton);
        panel1.add(dateSortButton);
        //panel1.add(lnameSortButton);
        panel1.add(backButton);

        setContentPane(panel1);
        setTitle("Auto Channel Limited - Customer Report");
        getContentPane().setBackground(Color.gray);
        setResizable(false);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        pack();
        //Positions Frame in the center of the user's screen
        setSize(630, 380);
        setLocationRelativeTo(null);
        //Makes the window visible to user
        setVisible(true);        

    }

    public void addToTable(){
        if (customers.size() > 0)
            for (int i = 0; i < customers.size(); i++)
                {
                    Customer c = customers.get(i);
                    String[]cData = {c.getcustomerid(),c.getTransId(),c.getfname(),c.getlname(),getCarID(c.getfname()),c.phoneno(),c.getDate()};
                    model.addRow(cData);
                }
    }

    private class dateSortButtonListener implements ActionListener{

        public void actionPerformed(ActionEvent event){

            if (dateSorted == false)
            {
                Collections.sort(customers,new dateSort());
                model.setRowCount(0);
                addToTable();
                dateSortButton.setText("Sort by Date");
                dateSorted = true;
            }
            else if (dateSorted == true)
            {
                Collections.reverse(customers);
                model.setRowCount(0);
                addToTable();
                dateSortButton.setText("Sort by Date");
                dateSorted = false;
            }
        }
    }


    private class BackButtonListener implements ActionListener{

        public void actionPerformed(ActionEvent event){
            tableFrame.dispose();
            ManageMenuGUI ManageMenuFrame = new ManageMenuGUI(userInput);
        }
    }

}
