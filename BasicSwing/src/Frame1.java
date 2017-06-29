import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class Frame1 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
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
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 385);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	}
	
	public void data(){
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(37, 33, 61, 16);
		frame.getContentPane().add(lblName);
		
		textField = new JTextField();
		textField.setBounds(133, 28, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(37, 70, 61, 16);
		frame.getContentPane().add(lblPassword);
		
		textField_1 = new JTextField();
		textField_1.setBounds(133, 65, 130, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setBounds(37, 195, 61, 16);
		frame.getContentPane().add(lblName_1);
		
		JLabel lblPassword_1 = new JLabel("Password");
		lblPassword_1.setBounds(37, 223, 61, 16);
		frame.getContentPane().add(lblPassword_1);
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setBounds(37, 153, 61, 16);
		frame.getContentPane().add(lblResult);
		
		
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				showData();
				Frame2 frame2 = new Frame2();
				frame2.frame.setVisible(true);
				
				
			}
		});
		btnSubmit.setBounds(133, 103, 117, 29);
		frame.getContentPane().add(btnSubmit);
	}
	
	public String showData(){
		
		String a;
		
		JLabel lblResultname = new JLabel("");
		lblResultname.setBounds(159, 195, 61, 16);
		frame.getContentPane().add(lblResultname);
		
		JLabel lblResultpassword = new JLabel("");
		lblResultpassword.setBounds(159, 223, 61, 16);
		frame.getContentPane().add(lblResultpassword);
		
		a = lblResultname.toString();
		
		return a;
		
	}
	
}
