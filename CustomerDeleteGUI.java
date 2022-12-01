import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.FontUIResource;

public class CustomerDeleteGUI extends JFrame{

    private JButton submitButton;
    private JButton cancelButton;
    private JLabel textLabel;
    private JTextField textField;
    private JPanel mainPanel;
    private InputHandler userInput;
    private JFrame thisFrame;
    private CustomerListing customerPanel;


    public CustomerDeleteGUI(InputHandler userInput, CustomerListing customerPanel){
        this.userInput = userInput;
        this.thisFrame = this;
        this.customerPanel = customerPanel;
        setPreferredSize(new DimensionUIResource(340, 110));
        setTitle("ACMS - Delete Customer");
        setBackground(Color.lightGray);
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2,2));
        mainPanel.setBackground(Color.lightGray);

        textLabel = new JLabel("Customer ID of Customer to Delete:");
        textLabel.setFont(new FontUIResource(textLabel.getText(), Font.PLAIN, 12));

        textField = new JTextField();
        textField.setPreferredSize(new DimensionUIResource(200, 20));

        submitButton = new JButton("Submit");
        textLabel.setFont(new FontUIResource(textLabel.getText(), Font.BOLD, 12));
        submitButton.addActionListener(new SubmitButtonListener());

        cancelButton = new JButton("Cancel");
        textLabel.setFont(new FontUIResource(cancelButton.getText(), Font.BOLD, 12));
        cancelButton.addActionListener(new CancelButtonListener());

        mainPanel.add(textLabel);
        mainPanel.add(textField);
        mainPanel.add(submitButton);
        mainPanel.add(cancelButton);

        setContentPane(mainPanel);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        getContentPane().setBackground(Color.gray);
        //Positions Frame in the center of the user's screen
        setLocationRelativeTo(null);
        //Makes the window visible to user
        setVisible(true);

    }

    private class SubmitButtonListener implements ActionListener
    {
        
        public void actionPerformed(ActionEvent e){
            String cust_id = textField.getText();
            String cus_fname = userInput.getCurrentUser().getfname();
            userInput.deleteCustomerData(userInput.getCurrentUser().getcustomerid());
            userInput.loadCustomerData();
            customerPanel.getModel().setRowCount(0);
            customerPanel.showTable(userInput.getUser(cus_fname));
            customerPanel.updatecustomerList();
            thisFrame.dispose();
            
        }
    }

    private class CancelButtonListener implements ActionListener
    {
        
        public void actionPerformed(ActionEvent e){
            thisFrame.dispose();
        }
    }
}