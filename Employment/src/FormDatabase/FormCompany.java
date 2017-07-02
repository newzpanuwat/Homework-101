package FormDatabase;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Employment.MainMenu;

public class FormCompany extends JFrame {
	
	JTextField txt_compID,txt_compName,txt_compAddr,
				txt_compCHW,txt_compPerson;
	
	public FormCompany(){
		
		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());
		
		//North
		
		JPanel panelNorth = new JPanel();
		panelNorth.setLayout(new GridLayout(1,2));
		
		//North_Left
		JPanel panelNorth_Left = new JPanel();
		panelNorth_Left.setLayout(new GridLayout(5,2,10,10)); // rows,column,horizontal space, vertical space
		
		
		//North_Right
		JPanel panelNorth_Right = new JPanel();
		panelNorth_Right.setLayout(new GridLayout(5,2,10,10));
		
		panelNorth.add(panelNorth_Left);
		panelNorth.add(panelNorth_Right);
		
		// Added north Panel to north zone
		
		
		c.add(panelNorth,BorderLayout.NORTH);
		
		//comp_ID
				JLabel lb_compID = new JLabel("รหัสบริษัท (COM_ID)");
				txt_compID = new JTextField();
				panelNorth_Left.add(lb_compID);
				panelNorth_Left.add(txt_compID);
				
		// Comp_Name
				
				JLabel lb_compName = new JLabel("ชื่อบริษัท (COM_NAME)");
				txt_compName = new JTextField();
				panelNorth_Left.add(lb_compName);
				panelNorth_Left.add(txt_compName);
		
		// Comp_Address
				
				JLabel lb_compAddr = new JLabel("ที่อยู่บริษัท (COM_Address)");
				txt_compAddr = new JTextField();
				panelNorth_Left.add(lb_compAddr);
				panelNorth_Left.add(txt_compAddr);
				
			// Comp_CHW
				
				JLabel lb_compCHW = new JLabel("จังหวัดที่บริษัทอยู่ (COM_CHW)");
				txt_compCHW = new JTextField();
				panelNorth_Left.add(lb_compCHW);
				panelNorth_Left.add(txt_compCHW);
				
			// Comp_Person
				
				JLabel lb_compPerson = new JLabel("ชื่อผู้ติดต่อ (COM_Person)");
				txt_compPerson = new JTextField();
				panelNorth_Left.add(lb_compPerson);
				panelNorth_Left.add(txt_compPerson);
	}
	public static void main(String[] args){
		FormCompany fCompany = new FormCompany();
		fCompany.setTitle("ข้อมูลบริษัที่มีตำแหน่งว่าง(COMPANY)"); // title bar display section
		fCompany.setSize(800,500); // set size of Main menu frame
		fCompany.setDefaultCloseOperation(EXIT_ON_CLOSE); // Close this background process application when you exit the program
		fCompany.setLocationRelativeTo(null); // Set frame align center
		fCompany.setVisible(true); // Display data to screen monitor
	}
}
