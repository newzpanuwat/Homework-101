package Employment;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

import java.sql.Connection;

import FormDataBase.Block;
import FormDataBase.Market;
import FormDataBase.MenuForm;
import FormDataBase.Report;
import FormSeller.Seller;

public class MainMenu extends JFrame implements ActionListener {
	//คลาสMainMenuสืบทอดไปยังคลาสJFrame คำสั่งทำรับคำสั่ง
	
	JButton btseller/*seller*/ ,btmarket/*MarKet*/, btblock/*Block*/,btreport/*Report*/ ,btexit;//สร้างตัวแปรแทนปุ่มทั้ง 4 ปุ่ม ตามลำดับ
	
	public MainMenu(){
		
		Connection conn = MyConnect.getConnection();//เชื่อมกับฐานข้อมูล
		if(conn !=null){
		System.out.println("Connection OK!.....");	
		}

		
		Container c = this.getContentPane();//สร้างcontainer สำหรับบรรจุ component ต่างๆ
		c.setLayout(new GridLayout(6,1,80,40));//กำหนดรูปแบบการจัดวาง Layout ในรูปแบบตารางกำหนดให้3แถว 1 คอลัมภ์
		
		
		JLabel l1 = new JLabel("ระบบเช่าพื้นที่ตลาด",
		SwingConstants.CENTER);//สร้างป้ายข้อความ swingconstants.center แสดงผลให้อยู่ตรงกลาง
		l1.setFont(new Font("Angsana New",Font.BOLD | Font.BOLD,60));
		l1.setForeground ( Color.RED );
		
		
		JLabel l11 = new JLabel("################# ยินดีต้อนรับ #################",
		SwingConstants.CENTER);//สร้างป้ายข้อความ swingconstants.center แสดงผลให้อยู่ตรงกลาง
		l11.setFont(new Font("Angsana New",Font.BOLD | Font.BOLD,40));
		l11.setForeground ( Color.BLUE );
		
		
        
		

		//คำสั่งฟอนต์ ชื่อตัวอักษร , รูปแบบตัวเอียง |เข้ม, ขนาดตัวอักษร
		//นำป้ายข้อความบรรจุใน container  
		c.add(l1); //แถว1 คอลัมภ์ที่ 1
		c.add(l11);
		
				
		JLabel l2 = new JLabel("The Market Hire System",
		SwingConstants.CENTER);//สร้างป้ายข้อความ swingconstants.center แสดงผลให้อยู่ตรงกลาง
		l2.setFont(new Font("Jokerman",Font.BOLD | Font.ITALIC,30));
		
		//คำสั่งฟอนต์ ชื่อตัวอักษร , รูปแบบตัวเอียง |เข้ม, ขนาดตัวอักษร
		//นำป้ายข้อความบรรจุใน container  
		c.add(l2); //แถว1 คอลัมภ์ที่ 1
		
		JPanel panelNorth_Left = new JPanel();
		panelNorth_Left.setLayout(new GridLayout(1,3,10,10));//5แถว 2 คอลัมภ์
		panelNorth_Left.setBorder(BorderFactory.createTitledBorder("Registratin"));
		c.add(panelNorth_Left);
		panelNorth_Left.setBackground(Color.cyan);
		
		
	
		JPanel buttonPanel = new JPanel();//สร้างJPanel บรรจุปุ่มทั้ง 4
		
		//FlowLayout()--> แสดงผลจากซ้ายเป็นขวา
		//สร้างปุ่มที่ 1 ปุ่มใบสมัคร
		btseller = new JButton("Seller");
		//panelNorth_Left.add(buttonPanel);
		btseller.addActionListener(this);
		
		//สร้างปุ่มที่ 2 ระบบจัดการข้อมูลพื้นฐาน
		btmarket = new JButton("Market");
		btmarket.addActionListener(this);
		
		
		//สร้างปุ่มที่ 3 ระบบรายงาน
		btblock = new JButton("Block");
		btblock.addActionListener(this);
		//btreport = new JButton("ระบบรายงาน");
		
		
		
		//เพิ่มปุ่มทั้ง 4 ลงในJPanel
		buttonPanel.add(btseller);
		buttonPanel.add(btmarket);
		buttonPanel.add(btblock);
		//buttonPanel.add(btreport);
		//buttonPanel.add(btexit);
		//เพิ่มพาเนลปุ่มทั้งหมดลงไปในContainer
		panelNorth_Left.add(buttonPanel);
		//สร้างปุ่มที่ 4 ออกจากโปรแกรม
		
		
		
		
		JPanel panelNorth_Right= new JPanel();
		panelNorth_Right.setLayout(new GridLayout(1,3,10,10));//5แถว 2 คอลัมภ์
		panelNorth_Right.setBorder(BorderFactory.createTitledBorder("Reporting"));
		panelNorth_Right.setBackground(Color.cyan);
		c.add(panelNorth_Right);
		
		JPanel buttonPanel1 = new JPanel();//สร้างJPanel บรรจุปุ่มทั้ง 4
		
		btreport = new JButton("Report");
		btreport.addActionListener(this);
		
		panelNorth_Right.add(buttonPanel1);
		buttonPanel1.add(btreport);
		
		//สร้างปุ่มที่ 4 ออกจากโปรแกรม
		JPanel buttonPanel2 = new JPanel();
		btexit = new JButton("ออกจากโปรแกรม");
		btexit.addActionListener(this);
		buttonPanel2.add(btexit);
		c.add(buttonPanel2);
		
	}
	
	public void actionPerformed(ActionEvent e)//เมธอดรองรับการกระทำกับปุ่ม  ,e คือตัวแปร 
	{
		if(e.getSource() == btmarket){//getSource คือเรากดปุ่มอะไร
			Market mk = new Market();
			mk.setTitle("รายชื่อตลาดนัด");
			mk.setSize(800, 600);
			//mk.setDefaultCloseOperation(EXIT_ON_CLOSE);
			mk.setLocationRelativeTo(null);
			mk.setVisible(true);
			
		}else if
			(e.getSource() == btreport){//getSource คือเรากดปุ่มอะไร
				Report report = new Report();//mainMenuคือตัวแปร MainMenu คือคลาส
				report.setTitle("แสดงรายงาน");//title
				report.setSize(800,500);//ความกว้างและความสูง
				//menuform.setDefaultCloseOperation(EXIT_ON_CLOSE);//สั่งให้ปิดโปรแกรม
				report.setLocationRelativeTo(null);//แสดงผลให้อยู่กลางจอภาพ
				report.setVisible(true);//สั่งให้แสดงผลขึ้นมา
		
		}else if
		(e.getSource() == btblock){//getSource คือเรากดปุ่มอะไร
			Block block = new Block();//mainMenuคือตัวแปร MainMenu คือคลาส
			block.setTitle("ผังตลาดนัด");//title
			block.setSize(900,700);//ความกว้างและความสูง
			//menuform.setDefaultCloseOperation(EXIT_ON_CLOSE);//สั่งให้ปิดโปรแกรม
			block.setLocationRelativeTo(null);//แสดงผลให้อยู่กลางจอภาพ
			block.setVisible(true);//สั่งให้แสดงผลขึ้นมา
		
		}else if
		(e.getSource() == btseller){//getSource คือเรากดปุ่มอะไร
			Seller sll = new Seller();
	         sll.setTitle("กรอกข้อมูล");
	         sll.setSize(400, 400);
	         //sll.setDefaultCloseOperation(EXIT_ON_CLOSE);
	         sll.setLocationRelativeTo(null);
	         sll.setVisible(true);
		}
		else if(e.getSource() == btexit){ //ปุ่มปิด
			System.exit(0);//หรือNORMAL
		}
		
		
	}

	public static void main(String[] args) {//แสดงผลของJFrame
		//class name = new class();
		MainMenu mainMenu = new MainMenu();//mainMenuคือตัวแปร MainMenu คือคลาส
		mainMenu.setTitle("ระบบเช่าพื้นที่ตลาด (The Market Hire System)");//title
		mainMenu.setSize(900,700);//ความกว้างและความสูง
		mainMenu.setLocationRelativeTo(null);//แสดงผลให้อยู่กลางจอภาพ
		mainMenu.setVisible(true);//สั่งให้แสดงผลขึ้นมา
	
	}

}
