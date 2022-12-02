import javax.swing.*;
import java.awt.*;
import java.awt.event;

public class management_Gui implements ActionListener{
  
  private static JLabel password,label;
  private static JTextField username;
  private stativ JButton button;
  private static JPasswordField password;

  JPanel panel=new JPanel();
  panel.setLayout(null);

  JFrame frame = new JFrame();
  frame.setTitle("Executive Login Page");
  frame.setLocation(new Point(500, 300));
  frame.add(panel);
  frame.setSize(new Dimension(400, 200));
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  label=new JLabel("Username");
  label.setBounds(100,8,70,20);
  panel.add(label);

  username = new JTextField();
  username.setBounds(100, 27, 193, 28);
  panel.add(username);

  password1 = new JLabel("Password");
  password1.setBounds(100, 55, 70, 20);
  panel.add(password);

  Password = new JPasswordField();
  Password.setBounds(100, 75, 193, 28);
  panel.add(Password);

  button = new JButton("Login");
  button.setBounds(100, 110, 90, 25);
  button.setForeground(Color.WHITE);
  button.setBackground(Color.BLACK);
  button.addActionListener((ActionListener) new managment_GUI());
  panel.add(button);

}


public void actionPerformed(ActionEvent e) {
	String Username = username.getText();
	String Password = Password.getText();

	if (Username.equals("acmanager") && Password1.equals("management"))
		JOptionPane.showMessageDialog(null, "Login Successful");
	else
		JOptionPane.showMessageDialog(null, "Username or Password mismatch ");
}

  
}