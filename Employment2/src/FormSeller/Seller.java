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
	
	Connection Conn = MyConnect.getConnection();//���ҧ����������������Ͱҹ������
	
	public Seller()
	{
		Container cn = this.getContentPane();
		cn.setLayout(new GridLayout(3,1,50,20));
		
		pnsl1 = new JPanel();	
		pnsl1.setSize(10,10);
		lblbook = new JLabel("��͡������",SwingConstants.CENTER);
		lblbook.setFont(new Font("Tahoma",1,25));
		pnsl1.add(lblbook);
				
		pnsl2 = new JPanel();
		pnsl2.setLayout(new GridLayout(4,2,20,5));
		
		lblid = new JLabel("  ID �Ţ��Шӵ�� :" );
		lblid.setFont(new Font("Tahoma",1,14));
		txtid = new JTextField();
		pnsl2.add(lblid);
		pnsl2.add(txtid);
		
		lblname = new JLabel("  NAME ����  ���ʡ�� :");
		lblname.setFont(new Font("Tahoma",1,14));
		
		txtname = new JTextField();
		pnsl2.add(lblname);
		pnsl2.add(txtname);

		lbltel = new JLabel("  TEL �����õԴ��� :");
		lblname.setFont(new Font("Tahoma",1,14));
		txttel = new JTextField();
		pnsl2.add(lbltel);
		pnsl2.add(txttel);
		
		lblblock = new JLabel("  BLOCK ���ͤ (�ӹǹ) :");
		lblname.setFont(new Font("Tahoma",1,14));
		txtblock = new JTextField();
		pnsl2.add(lblblock);
		pnsl2.add(txtblock);
		
		pnsl3 = new JPanel();
		btsubmit = new JButton ("�׹�ѹ");
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
			JOptionPane.showMessageDialog(this,"�׹�ѹ�������");
		}
	}
	
	 public void Insert()
		{
			if(txtid.getText().trim().length() < 1 ||
					txtid.getText().trim().length() > 10)
			{
				JOptionPane.showMessageDialog(this,"��سҡ�͡���ʺ���ѷ���١��ͧ(1-4 ����ѡ��)","�š�úѹ�֡��¡��",
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
				JOptionPane.showMessageDialog(this,"�ѹ�֡��¡������","�š�úѹ�֡��¡��",JOptionPane.INFORMATION_MESSAGE);
				clearData();
				MainMenu mainMenu = new MainMenu();//mainMenu��͵���� MainMenu ��ͤ���
				mainMenu.setTitle("�к���Ҿ�鹷���Ҵ (The Market Hire System)");//title
				mainMenu.setSize(900,700);//�������ҧ��Ф����٧
				mainMenu.setLocationRelativeTo(null);//�ʴ�����������ҧ���Ҿ
				mainMenu.setVisible(true);//�������ʴ��Ţ����
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
         sll.setTitle("��͡������");
         sll.setSize(400, 400);
         sll.setDefaultCloseOperation(EXIT_ON_CLOSE);
         sll.setLocationRelativeTo(null);
         sll.setVisible(true);

	}

}
