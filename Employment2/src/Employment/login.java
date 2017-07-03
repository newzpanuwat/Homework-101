package Employment;

import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login extends JFrame 
      implements ActionListener
       {
	
	JLabel lblid,lblname,lbltel,lblblock,lblbook,lblpass;
	JTextField txtid,txtuser,txttel,txtblock,txtpass;
	JPanel pnsl1,pnsl2,pnsl3;
	JButton btsubmit;
	
	public login()
	{
		Container cn = this.getContentPane();
		cn.setLayout(new BorderLayout());
		
		pnsl1 = new JPanel();	
		pnsl1.setSize(10,10);
		lblbook = new JLabel("กรอกข้อมูล",SwingConstants.CENTER);
		lblbook.setFont(new Font("Tahoma",1,25));
		pnsl1.add(lblbook);
				
		pnsl2 = new JPanel();
		pnsl2.setLayout(new GridLayout(1,2,20,5));
		
		
		//Username
		lblname = new JLabel("ชื่อผู้ใช้งาน:");
		lblname.setFont(new Font("Tahoma",1,14));
		
		txtuser = new JTextField();
		txtuser.setPreferredSize(new Dimension(30,20));
		pnsl2.add(lblname);
		pnsl2.add(txtuser);

		
		//Password
		lblpass = new JLabel("รหัสผ่าน:");
		lblpass.setFont(new Font("Tahoma",1,14));
		
		txtpass = new JPasswordField();
		txtpass.setPreferredSize(new Dimension(30,20));
		pnsl2.add(lblpass);
		pnsl2.add(txtpass);
		
	

		
		pnsl3 = new JPanel();
		btsubmit = new JButton ("ยืนยัน");
		btsubmit.setFont(new Font("Tahoma",1,16));
		btsubmit.addActionListener(this);
		pnsl3.add(btsubmit);
				
		cn.add(pnsl1,BorderLayout.NORTH);
		cn.add(pnsl2);
		cn.add(pnsl3,BorderLayout.SOUTH);
		
	}
	 public void actionPerformed(ActionEvent e)
	{
		String uname = txtuser.getText();
		String pass = txtpass.getText();
		
			if(uname.equals("admin") && pass.equals("123456")){
				JOptionPane.showMessageDialog(null,"รหัสผ่านถูกต้อง");
				MainMenu mainMenu = new MainMenu();//mainMenuคือตัวแปร MainMenu คือคลาส
				mainMenu.setTitle("ระบบเช่าพื้นที่ตลาด (The Market Hire System)");//title
				mainMenu.setSize(900,700);//ความกว้างและความสูง
				mainMenu.setLocationRelativeTo(null);//แสดงผลให้อยู่กลางจอภาพ
				mainMenu.setVisible(true);//สั่งให้แสดงผลขึ้นมา
			}else{
				JOptionPane.showMessageDialog(null,"รหัสผ่านผิดพลาด โปรดลองอีกครั้ง");
				//clearData();
			}
		}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		login sll = new login();
         sll.setTitle("กรอกข้อมูล");
         sll.setSize(400, 150);
         sll.setDefaultCloseOperation(EXIT_ON_CLOSE);
         sll.setLocationRelativeTo(null);
         sll.setVisible(true);

	}

}
