package FormDatabase;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class MenuForm extends JFrame {
	
	JButton btnApplicant,
	btnComp,btnPos,
	btnQual,btnAP_Qual,
	btnPOS_Qual,btnAP_POS,
	btnClose;
	
	public MenuForm(){
		Container c = this.getContentPane(); // Create container for components
		c.setLayout(new GridLayout(9,1)); // Set GridLayout 3 rows, 1 column
		JLabel lbl = new JLabel("ระบบจัดการฐานข้อมูลพื่นฐาน",SwingConstants.CENTER); // Show text label and add second parameters to set label to CENTER
		lbl.setFont(new Font("Tahoma",Font.BOLD | Font.ITALIC,20)); // setup fonts (FontType,Italic | Bold,Size)
		
		c.add(lbl);
		
		JPanel buttonPanel1 = new JPanel();
		JPanel buttonPanel2 = new JPanel();
		JPanel buttonPanel3 = new JPanel();
		JPanel buttonPanel4 = new JPanel();
		JPanel buttonPanel5 = new JPanel();
		JPanel buttonPanel6 = new JPanel();
		JPanel buttonPanel7 = new JPanel();
		JPanel buttonPanel8 = new JPanel();
		
		btnApplicant = new JButton("ข้อมูลผู้สมัคร(APPLICANT)");
		btnComp = new JButton("ข้อมูลบริษัทที่มีตำแหน่งว่าง(Company)");
		btnPos = new JButton("ข้อมูลตำแหน่งที่เปิดรับ(POSITION)");
		btnQual = new JButton("ข้อมูลคุณสมบัติเฉพาะตำแหน่ง(QUALIFICATION)");
		btnAP_Qual = new JButton("ข้อมูลผู้สมัคร คุณสมบัติเฉพาะตำแหน่ง(AP_QUAL)");
		btnPOS_Qual = new JButton("ข้อมูลตำแหน่ง คุณสมบัติเฉพาะตำแหน่ง(POS_QUAL)");
		btnAP_POS = new JButton("ข้อมูลผู้สมัคร ตำแหน่ง (AP_POS)");
		btnClose = new JButton("Close");
		
	// Button to Panel
		
		buttonPanel1.add(btnApplicant);
		buttonPanel2.add(btnComp);
		buttonPanel3.add(btnPos);
		buttonPanel4.add(btnQual);
		buttonPanel5.add(btnAP_Qual);
		buttonPanel6.add(btnPOS_Qual);
		buttonPanel7.add(btnAP_POS);
		buttonPanel8.add(btnClose);
		
		//Added Panel to container
		
				c.add(buttonPanel1);
				c.add(buttonPanel2);
				c.add(buttonPanel3);
				c.add(buttonPanel4);
				c.add(buttonPanel5);
				c.add(buttonPanel6);
				c.add(buttonPanel7);
				c.add(buttonPanel8);
				
	}
	
	
	public static void main(String[] args){
		MenuForm menu = new MenuForm();
		menu.setTitle("ระบบจัดการฐานข้อมูลพื้นฐาน"); // title bar display section
		menu.setSize(800,500); // set size of Main menu frame
		menu.setDefaultCloseOperation(EXIT_ON_CLOSE); // Close this background process application when you exit the program
		menu.setLocationRelativeTo(null); // Set frame align center
		menu.setVisible(true); // Display data to screen monitor
	}
}
