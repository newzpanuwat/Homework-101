package Employment;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MainMenu extends JFrame{
	
	
	// Create variables instead 4 buttons following by ASC
	JButton btnApp,btnDb,btnRpt,btnExit;
	
	//default constructor
	 MainMenu(){
		Container c = this.getContentPane(); // Create container for components
		c.setLayout(new GridLayout(3,1)); // Set GridLayout 3 rows, 1 column
		JLabel lbl = new JLabel("บริษัท STOU-TEC จำกัด",SwingConstants.CENTER); // Show text label and add second parameters to set label to CENTER
		lbl.setFont(new Font("Tahoma",Font.BOLD | Font.ITALIC,20)); // setup fonts (FontType,Italic | Bold,Size)
		
		JLabel lbl2 = new JLabel("(STOU Temporary Employment Corporation)",SwingConstants.CENTER); // Show text label and add second parameters to set label to CENTER
		lbl2.setFont(new Font("Tahoma",Font.BOLD | Font.ITALIC,18)); // setup fonts (FontType,Italic | Bold,Size)
			
		// get lbl into Container
		c.add(lbl); // column 1 , rows 1
		c.add(lbl2);  // column 1 , rows 2
		
		JPanel buttonPanel = new JPanel();
		
		//FlowLayout() -->
		//Create Button
		
		btnApp = new JButton("แบบฟอร์มใบสมัครพนักงาน");
		btnDb = new JButton("ระบบจัดการข้อมูลพื้นฐาน");
		btnRpt = new JButton("ระบบรายงาน");
		btnExit = new JButton("ออกจากโปรแกรม");
		
		// Button to Panel
		
		buttonPanel.add(btnApp);
		buttonPanel.add(btnDb);
		buttonPanel.add(btnRpt);
		buttonPanel.add(btnExit);
		
		//Added Panel to container
		
		c.add(buttonPanel);
		
	 }
	 
	 
	
	public static void main(String[] args) {
		MainMenu main = new MainMenu();
		main.setTitle("โปรแกรมการจัดการธุรกิจ(กรณีศึกษา:ธุรกิจจัดหางาน"); // title bar display section
		main.setSize(800,500); // set size of Main menu frame
		main.setDefaultCloseOperation(EXIT_ON_CLOSE); // Close this background process application when you exit the program
		main.setLocationRelativeTo(null); // Set frame align center
		main.setVisible(true); // Display data to screen monitor
	}

}
