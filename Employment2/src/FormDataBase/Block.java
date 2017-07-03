package FormDataBase;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Employment.MyConnect;

public class Block extends JFrame implements ActionListener  {

	//private static final long serialVersionUID = 1L;
	
	
	JTextField txt_marid,txt_marna,txt_marlo,txt_search;
	JButton BTA,BTE,BTD;
	JTable tablecomp;
	DefaultTableModel modelComp;
	
	
	
	
	Connection Conn = MyConnect.getConnection();
	
	public Block(){
	
		Container C = this.getContentPane();
		C.setLayout(new BorderLayout());
		txt_search = new JTextField();
		
		JPanel PN1 = new JPanel();
		PN1.setLayout(new GridLayout(3,1));
		
				
		JLabel lb_marid = new JLabel("รหัสแผง (Block ID)");
		txt_marid = new JTextField();
		PN1.add(lb_marid);
		PN1.add(txt_marid);
		
		JLabel lb_marna = new JLabel("ขนาดของแผง (Block Name)");
		txt_marna = new JTextField();
		PN1.add(lb_marna);
		PN1.add(txt_marna);
		
		JLabel lb_marlo = new JLabel("ราคาแผง (Cost Location)");
		txt_marlo = new JTextField();
		PN1.add(lb_marlo);
		PN1.add(txt_marlo);
		
	
		
		C.add(PN1,BorderLayout.NORTH);
		
		
		JPanel PN2 = new JPanel();
		BTA = new JButton("บันทึก");
		BTA.addActionListener(this);
		BTA.setBounds(0, 0, 30, 50);
		BTE = new JButton("แก้ไข");
		BTE.addActionListener(this);
		BTD = new JButton("ลบข้อมูล");
		BTD.addActionListener(this);
		
		PN2.add(BTA);
		PN2.add(BTE);
		PN2.add(BTD);
		
		
		C.add(PN2,BorderLayout.CENTER);
	
		
	
	
	JPanel PS = new JPanel();
	JScrollPane scrollTable = new JScrollPane();
	scrollTable.setPreferredSize(new Dimension(700,350));
	
	
	Object data[][]={
			{null,null,null},
			{null,null,null},
			{null,null,null},
			{null,null,null}
	};

	
	String columns[]={"รหัสแผง","ขนาดแผง","ราคาของแผง"};
	
	
	DefaultTableModel initModel =
			new DefaultTableModel(data,columns);

			
	tablecomp = new JTable();
	tablecomp.addMouseListener(new MouseAdapter(){
	
		public void mouseClicked(MouseEvent event){
		
			int index = tablecomp.getSelectedRow();
			txt_marid.setEditable(false);
			txt_marid.setText(tablecomp.getValueAt(index, 0).toString());
			txt_marna.setText(tablecomp.getValueAt(index, 1).toString());
			txt_marlo.setText(tablecomp.getValueAt(index, 2).toString());
			BTA.setEnabled(false);
		
		}
	});
		
	
	tablecomp.setModel(initModel);
	modelComp = (DefaultTableModel)tablecomp.getModel();
	
	scrollTable.add(tablecomp);
	scrollTable.setViewportView(tablecomp);
	PS.add(scrollTable);
	C.add(PS,BorderLayout.SOUTH);
	showData();
	}

	void showData(){
		try{
			//1.Clear Data
			int totalrow = tablecomp.getRowCount()-1;
				while(totalrow >- 1){
					modelComp.removeRow(totalrow);
					totalrow--;
			}
		
			//2.Get text
			String search = "";
			//String search = txt_search.getText().trim();	
			
			//3.SQL Execution
			String sql = "SELECT * FROM BLOCK"
					+ " WHERE BL_ID LIKE '%"+ search + "%'"
					+ " OR BL_SIZE LIKE '%"+ search + "%'"
					+ " OR BL_COST LIKE '%"+ search + "%'";
		

			ResultSet RS = Conn.createStatement().executeQuery(sql);
			
			//4.Looping resultSet
			
					int row = 0;
					while(RS.next())
					{
						modelComp.addRow(new Object[0]);
						modelComp.setValueAt(RS.getString("BL_ID"),row, 0);
						modelComp.setValueAt(RS.getString("BL_SIZE"),row, 1);
						modelComp.setValueAt(RS.getString("BL_COST"),row, 2);
						row++;
					}
					
					//5 Model show in table
					tablecomp.setModel(modelComp);
	
				}catch(SQLException ex)
				 {
					ex.printStackTrace();
				 }

	
				}
				public void Insert()
				{
					if(txt_marid.getText().trim().length() < 1 ||
							txt_marid.getText().trim().length() > 10)
					{
						JOptionPane.showMessageDialog(this,"กรุณากรอกรหัสบริษัทให้ถูกต้อง(1-4 ตัวอักษร)","ผลการบันทึกรายการ",
						JOptionPane.ERROR_MESSAGE);
						return;
					}
					try{
						String sql = 	"INSERT INTO BLOCK "
								+" (BL_ID,BL_SIZE,BL_COST)" 
								+" VALUES (?,?,?)";
					
					
		PreparedStatement pre = Conn.prepareStatement(sql);
		pre.setString(1,txt_marid.getText().trim());
		pre.setString(2,txt_marna.getText().trim());
		pre.setString(3,txt_marlo.getText().trim());
				
		if (pre.executeUpdate()!=-1)
		{
			JOptionPane.showMessageDialog(this,"บันทึกรายการแล้ว","ผลการบันทึกรายการ",JOptionPane.INFORMATION_MESSAGE);
			showData();
			clearData();
		}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		}

public void actionPerformed(ActionEvent e)
{
	if (e.getSource()== BTA){
		Insert();
	}else if (e.getSource()== BTE){
		Update();
	
	}else if (e.getSource()== BTD){
		Delete();
	}
}
public void clearData()
{
	txt_marid.setText("");
	txt_marna.setText("");
	txt_marlo.setText("");

}
public void Update()
{
	if(txt_marid.getText().trim().length() < 1 ||
			txt_marid.getText().trim().length() > 10)
	{
		JOptionPane.showMessageDialog(this,"กรุณากรอกรหัสตลาดนัดให้ถูกต้อง","ผลการบันทึกรายการ",
				JOptionPane.ERROR_MESSAGE);
		return;
	}
	try{
		String sql = "UPDATE BLOCK SET " 
						+ "BL_COST=?, "
						+ "BL_SIZE=? "
						+ " WHERE BL_ID=?";

									
		PreparedStatement pre = Conn.prepareStatement(sql);
		pre.setString(1,txt_marna.getText().trim());
		pre.setString(2,txt_marlo.getText().trim());
		pre.setString(3,txt_marid.getText().trim());
		
		if (pre.executeUpdate() != -1)
			{
			JOptionPane.showMessageDialog(this,"แก้ไขรายการเรียบร้อยแล้ว","ผลการบันทึกรายการ",
					JOptionPane.INFORMATION_MESSAGE);
			showData();
			clearData();
			txt_marid.setEditable(true);
			BTA.setEnabled(true);
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}

	
public void Delete()
{
	if(txt_marid.getText().trim().length() < 1 ||
			txt_marid.getText().trim().length() > 10)
	{
		JOptionPane.showMessageDialog(this,"กรุณากรอกรหัสตลาดนัดให้ถูกต้อง","ผลการบันทึกรายการ",
				JOptionPane.ERROR_MESSAGE);
		return;
	}
	try{
		int index = tablecomp.getSelectedRow();
		String comp_id = tablecomp.getValueAt(index, 0).toString();
		String sql = 	"DELETE FROM BLOCK WHERE BL_ID=? " ;
						
									
		PreparedStatement Per = Conn.prepareStatement(sql);
		Per.setString(1,comp_id);
		
		if (Per.executeUpdate()!=-1)
		{
			JOptionPane.showMessageDialog(this,"ลบรายการเรียบร้อยแล้ว","ผลบันทึกรายการ"
					,JOptionPane.INFORMATION_MESSAGE);
			showData();
			clearData();
			txt_marid.setEditable(true);
			BTA.setEnabled(true);
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Block bl = new Block();
		bl.setTitle("รายชื่อตลาดนัด");
		bl.setSize(800, 600);
		bl.setLocationRelativeTo(null);
		bl.setVisible(true);
		}
	}
		
		
	

