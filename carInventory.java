import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.awt.event.ActionEvent;

public class carInventory { 

	private JFrame frame;
	private JTextField Import_num;
	private JTextField Chasis_num;
	private JTextField Year_made;
	private JTextField Model;
	private JTextField Make;
	DefaultTableModel model;
	private JTable table;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					carInventory window = new carInventory();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public carInventory() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 802, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 776, 532);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("import entry number :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(29, 29, 146, 22);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Chasis number :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(29, 72, 105, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Year made :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(29, 112, 105, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Model :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(28, 161, 106, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Make :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(32, 212, 105, 14);
		panel.add(lblNewLabel_4);
		
		Import_num = new JTextField();
		Import_num.setBounds(173, 31, 146, 20);
		panel.add(Import_num);
		Import_num.setColumns(10);
		
		Chasis_num = new JTextField();
		Chasis_num.setBounds(173, 69, 146, 20);
		panel.add(Chasis_num);
		Chasis_num.setColumns(10);
		
		Year_made = new JTextField();
		Year_made.setBounds(173, 109, 146, 20);
		panel.add(Year_made);
		Year_made.setColumns(10);
		
		Model = new JTextField();
		Model.setBounds(173, 158, 146, 20);
		panel.add(Model);
		Model.setColumns(10);
		
		Make = new JTextField();
		Make.setBounds(173, 209, 146, 20);
		panel.add(Make);
		Make.setColumns(10);
		model = new DefaultTableModel();
		Object[] column = { "Import_Entry_Number","Chasis Number","Year Made","Model","Make" };
		final Object[] row = new Object[5];
		
		model.setColumnIdentifiers(column);
		
		
				
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Import_num.getText().equals("")&& Chasis_num.getText().equals("")&& Year_made.getText().equals("")&&Model.getText().equals("")&& Make.getText().equals(""))
			    {
			        JOptionPane.showMessageDialog(null,"All Fields have not been filled");
			    }
	
			
		
				row[0]= Import_num.getText();
				row[1]= Chasis_num.getText();
				row[2] = Year_made.getText();
				row[3] = Model.getText();
				row[4]= Make.getText();
				model.addRow(row);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(45, 325, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int D = table.getSelectedRow();
				if (D>=0) {
					
					model.removeRow(D);
					JOptionPane.showMessageDialog(null,"Record deleted");}
				else {
					JOptionPane.showMessageDialog(null,"You must select a record to delete");
					
				}
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(204, 325, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Save ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand() == btnNewButton_2.getActionCommand()) {
					try {
							File file = new File("E:/inventoryInfo.txt");
							if (!file.exists()) {
								file.createNewFile();
							}
							FileWriter fw = new FileWriter(file.getAbsoluteFile());
							BufferedWriter bw = new BufferedWriter(fw);
							
							for(int i = 0; i< table.getRowCount();i++) {
								for(int j = 0; j< table.getColumnCount(); j++)
								bw.write(table.getModel().getValueAt(i,j)+ " ");
							}
						
					}catch (Exception ex) {JOptionPane.showMessageDialog(null, e+"");}
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setBounds(131, 435, 89, 23);
		panel.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(329, 34, 437, 487);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(model);
	}
}
