import javax.swing.*;
import java.awt.event.*;

public class CustomerInterface extends JFrame {
    
    private JTextField txtCustId; //customer id box
    private JTextField txtFirstName; //customer first name box
    private JTextField txtLastName; //customer last name box
    private JTextField txtTransId; //transaction reference no./id box
    private JTextField txtCarId; //car id box
    //private JTextField txtphoneNo;
    //private JTextField txtEmail;
    //private JTextField txtAddress;
    private JTextField txtChassis; //chassis no. box
    private JButton cmdSearch; //Search button
    private JButton cmdPlaceHold; //Place Hold button

    private JFrame form; //place hold frame
    private JFrame inventory; // view inventory frame
    private JPanel pnlCommand; 
    private JPanel pnlDisplay;
    private static InputHandler userInput;

    public CustomerInterface(InputHandler userInput)
    {
        form =this;
        this.userInput =userInput;

        setVisible(true);
        pnlCommand = new JPanel();
        pnlDisplay = new JPanel();
        inventory = new JFrame("View Inventory");
        inventory.add(new JLabel("Please complete the transaction and collect the transaction identification number before attempting to enter any personal details as this information is required to save your data in the system"));
        inventory.add(new JLabel("Search inventory"));
        txtChassis = new JTextField();
        inventory.add(txtChassis);
        cmdSearch = new JButton("Search");
        inventory.add(cmdSearch);
        pnlDisplay.add(inventory);

        form = new JFrame("Place A Hold");
        form.add(new JLabel("Enter your first name:"));
        txtFirstName = new JTextField();
        form.add(txtFirstName);
        form.add(new JLabel("Enter your last name:"));
        txtLastName = new JTextField();
        form.add(txtLastName);
        form.add(new JLabel("Enter a valid ID:"));
        txtCustId = new JTextField();
        form.add(txtCustId);
        form.add(new JLabel("Enter bank transaction ID"));
        txtTransId = new JTextField();
        form.add(txtTransId);
        form.add(new JLabel("Enter car ID:"));
        txtCarId = new JTextField();
        form.add(txtCarId);
        cmdPlaceHold = new JButton("Place Hold");
        form.add(cmdPlaceHold);
        pnlDisplay.add(form);

        pnlCommand.add(pnlDisplay);
        cmdSearch.addActionListener(new SubmitButtonListener());
        cmdPlaceHold.addActionListener(new PlaceHoldListener());

    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        CustomerInterface newContentPane = new CustomerInterface(userInput);
        newContentPane.setOpacity(0.85f); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }


    private class SubmitButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            //take the chassis no. and uses it to search in inventory
            String chassis = txtChassis.getText();
        }

    }

    private class PlaceHoldListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            int cust_id =  Integer.valueOf(txtCustId.getText());
            int car_id = Integer.valueOf(txtCarId.getText());
            int trans_id = Integer.valueOf(txtTransId.getText());
            new Placing_A_Hold(cust_id, trans_id, car_id);
        }
    }

    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}
