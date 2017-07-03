package FormSeller;
import javax.swing.*;

import Employment.MainMenu;
import Employment.MyConnect;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Seller extends JFrame 
      implements ActionListener
       {
	
	JLabel lblid,lblname,lbltel,lblblock,lblbook;
	JTextField txtid,txtname,txttel,txtblock;
	JPanel pnsl1,pnsl2,pnsl3;
	JButton btsubmit;
	
	Connection Conn = MyConnect.getConnection();//สร้างตัวแปรเพื่อเชื่อมต่อฐานข้อมูล
	
	public Seller()
	{
		Container cn = this.getContentPane();
		cn.setLayout(new GridLayout(3,1,50,20));
		
		pnsl1 = new JPanel();	
		pnsl1.setSize(10,10);
		lblbook = new JLabel("กรอกข้อมูล",SwingConstants.CENTER);
		lblbook.setFont(new Font("Tahoma",1,25));
		pnsl1.add(lblbook);
				
		pnsl2 = new JPanel();
		pnsl2.setLayout(new GridLayout(4,2,20,5));
		
		lblid = new JLabel("  ID เลขประจำตัว :" );
		lblid.setFont(new Font("Tahoma",1,14));
		txtid = new JTextField();
		pnsl2.add(lblid);
		pnsl2.add(txtid);
		
		lblname = new JLabel("  NAME ชื่อ  นามสกุล :");
		lblname.setFont(new Font("Tahoma",1,14));
		
		txtname = new JTextField();
		pnsl2.add(lblname);
		pnsl2.add(txtname);

		lbltel = new JLabel("  TEL เบอร์โทรติดต่อ :");
		lblname.setFont(new Font("Tahoma",1,14));
		txttel = new JTextField();
		pnsl2.add(lbltel);
		pnsl2.add(txttel);
		
		lblblock = new JLabel("  BLOCK บล็อค (จำนวน) :");
		lblname.setFont(new Font("Tahoma",1,14));
		txtblock = new JTextField();
		pnsl2.add(lblblock);
		pnsl2.add(txtblock);
		
		pnsl3 = new JPanel();
		btsubmit = new JButton ("ยืนยัน");
		btsubmit.setFont(new Font("Tahoma",1,16));
		btsubmit.addActionListener(this);
		pnsl3.add(btsubmit);
				
		cn.add(pnsl1);
		cn.add(pnsl2);
		cn.add(pnsl3);
		
	}
	 public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == btsubmit)    
		{
			Insert();
			JOptionPane.showMessageDialog(this,"ยืนยันเสร็จสิ้น");
		}
	}
	
	 public void Insert()
		{
			if(txtid.getText().trim().length() < 1 ||
					txtid.getText().trim().length() > 10)
			{
				JOptionPane.showMessageDialog(this,"กรุณากรอกรหัสบริษัทให้ถูกต้อง(1-4 ตัวอักษร)","ผลการบันทึกรายการ",
				JOptionPane.ERROR_MESSAGE);
				return;
			}
			try{
				String sql = 	"INSERT INTO SELLER "
						+" (SL_ID,SL_NAME,SL_TEL,SL_NUM)" 
						+" VALUES (?,?,?,?)";
			
			
			PreparedStatement pre = Conn.prepareStatement(sql);
			pre.setString(1,txtid.getText().trim());
			pre.setString(2,txtname.getText().trim());
			pre.setString(3,txttel.getText().trim());
			pre.setString(4,txtblock.getText().trim());
					
			if (pre.executeUpdate()!=-1)
			{
				JOptionPane.showMessageDialog(this,"บันทึกรายการแล้ว","ผลการบันทึกรายการ",JOptionPane.INFORMATION_MESSAGE);
				clearData();
				MainMenu mainMenu = new MainMenu();//mainMenuคือตัวแปร MainMenu คือคลาส
				mainMenu.setTitle("ระบบเช่าพื้นที่ตลาด (The Market Hire System)");//title
				mainMenu.setSize(900,700);//ความกว้างและความสูง
				mainMenu.setLocationRelativeTo(null);//แสดงผลให้อยู่กลางจอภาพ
				mainMenu.setVisible(true);//สั่งให้แสดงผลขึ้นมา
			}
			}catch(SQLException ex){
				ex.printStackTrace();
			}
			}
	 
	 public void clearData()
	 {
	 	txtid.setText("");
	 	txtname.setText("");
	 	txttel.setText("");
	 	txtblock.setText("");

	 }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Seller sll = new Seller();
         sll.setTitle("กรอกข้อมูล");
         sll.setSize(400, 400);
         sll.setDefaultCloseOperation(EXIT_ON_CLOSE);
         sll.setLocationRelativeTo(null);
         sll.setVisible(true);

	}

}
