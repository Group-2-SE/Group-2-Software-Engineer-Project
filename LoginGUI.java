import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.FontUIResource;

public class LoginGUI extends JFrame{
    
    //private JFrame frame;

    private JPanel panel1;

    private JPasswordField pwordbox;

    private JLabel heading;
    private JLabel hint;
    private JLabel pwordlabel;

    private JButton signIn;
    

    private Insets insets;
    private Dimension size;

    private LoginGUI LoginFrame;
    //private EntryGUI EntryFrame;
    private InputHandler userInput;

    public LoginGUI(InputHandler userInput){

        //Storing the userInput object and the current frame
        LoginFrame = this;
        this.userInput = userInput;

        //Setting up the different JLabels, JButtons, JTextFields, JPasswordFields 
        heading = new JLabel("Please enter your password.");//enter the password for managers or sales
        heading.setFont(new FontUIResource(heading.getText(), Font.BOLD, 12));

        hint = new JLabel("Invalid password entered.");
        hint.setForeground(Color.red);
        hint.setFont(new FontUIResource(hint.getText(), Font.ROMAN_BASELINE, 10));
        hint.setVisible(false);

        pwordlabel = new JLabel("Password:");
        pwordlabel.setFont(new FontUIResource(pwordlabel.getText(), Font.PLAIN, 12));
        pwordlabel.setPreferredSize(new DimensionUIResource(65, 12));

        pwordbox = new JPasswordField("");
        pwordbox.setBackground(Color.GRAY);
        pwordbox.setPreferredSize(new DimensionUIResource(130, 15));

        //Adding action listners to each button to give it functionality
        signIn = new JButton("SIGN IN");
        signIn.setPreferredSize(new DimensionUIResource(75, 20));
        signIn.setFont(new FontUIResource(signIn.getText(), Font.BOLD, 10));
        signIn.addActionListener(new LoginButtonListner());

        

        //Adding the differents panels, buttons and fields into the frame
        panel1 = new JPanel();

        panel1.setBackground(Color.white);
        panel1.setBorder(BorderFactory.createTitledBorder("Sign In"));
        panel1.setPreferredSize(new DimensionUIResource(325, 150));
        
        panel1.setLayout(null);

        //Getting the inset of the JPanel called panel1
        insets = panel1.getInsets();

        //Positioning the hint label snd text box
        size = hint.getPreferredSize();
        hint.setBounds(75 +insets.left, -5 + insets.top,size.width, size.height);

        //Positioning the heading label snd text box
        size = heading.getPreferredSize();
        heading.setBounds(40 +insets.left, 10 + insets.top,size.width, size.height);

        //Positioning the "Password:" label snd text box
        size = pwordlabel.getPreferredSize();
        pwordlabel.setBounds(5 + insets.left, 65 + insets.top,size.width, size.height);
        size = pwordbox.getPreferredSize();
        pwordbox.setBounds(5 + insets.left, 80 + insets.top,size.width, size.height);

      //Positioning the "SIGN IN" button snd text box
        size = signIn.getPreferredSize();
        signIn.setBounds(70 + insets.left, 103 + insets.top,size.width, size.height);

        panel1.add(hint);
        panel1.add(heading);
        panel1.add(pwordlabel);
        panel1.add(pwordbox);
        panel1.add(signIn);

        setTitle("Auto Channel Limited Employee Sign In");
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

    private class LoginButtonListner implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String pword = String.valueOf(pwordbox.getPassword());
            pwordbox.setText("");

            //Checking to see if there was String entered in the unamebox and pwordbox by checking the length of the String
            String pword1 = "SalesRep";
            String pword2 = "Admin";
            String pword3 = "Manage";
            if ((pword.length() > 0))
            {
                if (pword.equals(pword1))
                {
                    //Disposes the SignInFrame so that the new frame can be displayed on its own
                    LoginFrame.dispose();
                    hint.setVisible(false);
                    SalesRepMenuFrame = new SalesRepMenuGUI(userInput)   
                }
                else if(userInput.equals(pword2))
                {
                    LoginFrame.dispose();
                    hint.setVisible(false);
                    AdminMenuFrame = new AdminMenuGUI(userInput);
                }
                else if(userInput.equals(pword3))
                {
                    LoginFrame.dispose();
                    hint.setVisible(false);
                    ManageMenuFrame = new ManageMenuGUI(userInput);
                }
                else
                {
                    hint.setVisible(true);
                }
                    
            }
        }
    }

   
}


