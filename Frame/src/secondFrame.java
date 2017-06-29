import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class secondFrame extends firstFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					secondFrame window = new secondFrame();
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
	public secondFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblShowData = new JLabel("Show Data");
		lblShowData.setBounds(41, 69, 112, 16);
		frame.getContentPane().add(lblShowData);
		
		JLabel lblShow = new JLabel("Here...");
		lblShow.setBounds(227, 69, 89, 16);
		frame.getContentPane().add(lblShow);
		
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblShow.setText(firstFrame.textField.getText());
			}
		});
		btnShow.setBounds(132, 127, 117, 29);
		frame.getContentPane().add(btnShow);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
		
	}

}
