import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frame2 extends Frame1{

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Frame1 frame1 = new Frame1();
		frame1.showData();
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame2 window = new Frame2();
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
	public Frame2() {
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
		
		JLabel lblThisIsPage = new JLabel("This is Page 2");
		lblThisIsPage.setBounds(152, 17, 98, 16);
		frame.getContentPane().add(lblThisIsPage);
	}

}
