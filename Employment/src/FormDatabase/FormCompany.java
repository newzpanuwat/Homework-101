package FormDatabase;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



import Employment.MainMenu;
import Employment.MyConnect;

public class FormCompany extends JFrame {
	
	JTextField txt_compID,txt_compName,txt_compAddr,
				txt_compCHW,txt_compPerson,txt_Search;
	
	JButton btnAdd,btnDel,btnEdit;
	
	JTable tableComp;
	DefaultTableModel modelComp;
	
	//Database Connection
	
	Connection conn = MyConnect.getConnection();
	
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
		panelNorth_Right.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		//Title Panel
		panelNorth_Right.setBorder(BorderFactory.createTitledBorder("ค้นหาข้อมูล"));
		
		txt_Search = new JTextField();
		txt_Search.setPreferredSize(new Dimension(300,30));
		txt_Search.addKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent ev){
				showData();
			}
		});
		panelNorth_Right.add(txt_Search);
		
		
		
		// Merge North
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
				
		//Center
		JPanel panelCenter = new JPanel(new FlowLayout(FlowLayout.LEFT));
		btnAdd = new JButton("บันทึก");
		btnEdit = new JButton("แก้ไข");
		btnDel = new JButton("ลบข้อมูล");
		
		panelCenter.add(btnAdd);
		panelCenter.add(btnEdit);
		panelCenter.add(btnDel);
		
		c.add(panelCenter,BorderLayout.CENTER);
		
		//South
		//Create panel for keep data from Model
		
		JPanel panelSouth = new JPanel(); 
		JScrollPane scrollTable = new JScrollPane(); // Make scrollbar
		scrollTable.setPreferredSize(new Dimension(700,450)); // Set W=700 H=450
		
		// Keep initialize data values for tables (2D Arrays)
		Object data[][] = {
				{null,null,null,null,null},	
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null}
		};		
		
		//Keep Header Data table
		String columns[]= {
				"รหัสบริษัท",
				"ชื่อบริษัท",
				"ที่อยู่",
				"จังหวัด",
				"ชื่อผู้ติดต่อ"
		};
		
		//Initial Model of table
		DefaultTableModel initModel =
									new DefaultTableModel(data,columns) {};
		
		
		tableComp = new JTable();//Create new table
		tableComp.setModel(initModel);	//Initial model
		modelComp = (DefaultTableModel)tableComp.getModel(); //Make model to be Initial model for using to the another function
		
		
		scrollTable.add(tableComp); // Insert tableComp to ScrollTable
		scrollTable.setViewportView(tableComp);
		panelSouth.add(scrollTable); // Insert scrollTable to PanelSouth
		c.add(panelSouth,BorderLayout.SOUTH); // Add panelSouth @South in Container
		
		showData();
				
	}
	
	void showData(){
		try{
			
		// 1.Clear data in Table
		// Delete data rows from bottom to top decreasing by -1 value
			int totalRow = tableComp.getRowCount()-1;
				while(totalRow > -1){
					modelComp.removeRow(totalRow);
					totalRow --;
				}
		  
		//2.getText from txt_Search
				String search = txt_Search.getText().trim();
			
		//3.SQL Execution --> ResultSet
				String sql = "SELECT * FROM COMPANY"
						+ " WHERE COMP_ID LIKE '%" + search + "%'"
						+ " OR COMP_NAME LIKE '%" + search + "%'"
						+ " OR COMP_ADDR LIKE '%" + search + "%'"
						+ " OR COMP_CHW LIKE '%" + search + "%'"
						+ " OR COMP_PERSON LIKE '%" + search + "%'";
				
						ResultSet rs = conn.createStatement().executeQuery(sql);
				
		
		//4.looping result set to Model
			int row = 0;
			while(rs.next()){
				modelComp.addRow(new Object[0]);
				modelComp.setValueAt(rs.getString("COMP_ID"), row, 0);
				modelComp.setValueAt(rs.getString("COMP_NAME"), row, 1);
				modelComp.setValueAt(rs.getString("COMP_ADDR"), row, 2);
				modelComp.setValueAt(rs.getString("COMP_CHW"), row, 3);
				modelComp.setValueAt(rs.getString("COMP_PERSON"), row, 4);
				row ++;
			}
				
				
		//5. Model --> show in Table
			tableComp.setModel(modelComp);
				
				
				
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public void Insert(){
		try{
			String sql = "INSERT INTO COMPANY" 
					+" (COMP_ID,COMP_NAME,COMP_ADDR,COMP_CHW,COMP_PERSON)"
					+" VALUES (?,?,?,?,?)";
			
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1,txt_compID.getText().trim());
			pre.setString(2,txt_compName.getText().trim());
			pre.setString(3,txt_compAddr.getText().trim());
			pre.setString(4,txt_compCHW.getText().trim());
			pre.setString(5,txt_compPerson.getText().trim());
			
			
			if(pre.executeUpdate() != -1){
				JOptionPane.showMessageDialog(this,
						"บันทึกรายการแล้ว",
						"ผลบันทึกรายการ",
						JOptionPane.INFORMATION_MESSAGE);
			}
			
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		FormCompany fCompany = new FormCompany();
		fCompany.setTitle("ข้อมูลบริษัที่มีตำแหน่งว่าง(COMPANY)"); // title bar display section
		fCompany.setSize(900,700); // set size of Main menu frame
		fCompany.setDefaultCloseOperation(EXIT_ON_CLOSE); // Close this background process application when you exit the program
		fCompany.setLocationRelativeTo(null); // Set frame align center
		fCompany.setVisible(true); // Display data to screen monitor
	}
}
