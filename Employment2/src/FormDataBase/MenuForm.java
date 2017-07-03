package FormDataBase;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class MenuForm extends JFrame implements ActionListener {//คลาสMainMenuสืบทอดไปยังคลาสJFrame
	
	JButton btApp ,btCo ,btPo ,btQu ,btApQu ,btPos ,btApPos ,btexit;//สร้างตัวแปรแทนปุ่มทั้ง 8 ปุ่ม ตามลำดับ
	
	public MenuForm()  
	{
		Container c = this.getContentPane();//สร้างcontainer สำหรับบรรจุ component ต่างๆ
		c.setLayout(new GridLayout(10,1));//กำหนดรูปแบบการจัดวาง Layout ในรูปแบบตารางกำหนดให้3แถว 1 คอลัมภ์
		
		
		JLabel l1 = new JLabel("ระบบจัดการข้อมูลพื้นฐาน",
		SwingConstants.CENTER);//สร้างป้ายข้อความ swingconstants.center แสดงผลให้อยู่ตรงกลาง
		l1.setFont(new Font("",Font.BOLD | Font.ITALIC,20));
		//คำสั่งฟอนต์ ชื่อตัวอักษร , รูปแบบตัวเอียง |เข้ม, ขนาดตัวอักษร
		//นำป้ายข้อความบรรจุใน container  
		c.add(l1); //แถว1 คอลัมภ์ที่ 1
		
		
		JPanel buttonPanel1 = new JPanel();//สร้างJPanel บรรจุปุ่มทั้ง 8 buttonPanel1 ตัวแปรของPanel
		//FlowLayout()--> แสดงผลจากซ้ายเป็นขวา
		//สร้างปุ่มที่ 1 ข้อมูลผู้สมัคร (APPLICANT)
		btApp = new JButton("ข้อมูลผู้สมัคร (APPLICANT)");
		buttonPanel1.add(btApp);//นำปุ่มbtApp ใส่ panel
		c.add(buttonPanel1); //นำpanel ใส่ container
		
		JPanel buttonPanel2 = new JPanel();
		//สร้างปุ่มที่ 2 ข้อมูลบริษัทที่มีตำแหน่งว่า (COMPANY)
		btCo = new JButton("ข้อมูลบริษัทที่มีตำแหน่งว่าง (COMPANY)");
		buttonPanel2.add(btCo);
		c.add(buttonPanel2);
		btCo.addActionListener(this);
		
		JPanel buttonPanel3 = new JPanel();
		//สร้างปุ่มที่ 3 ข้อมูลตำแหน่งที่เปิดรับ (POSITION)
		btPo = new JButton("ข้อมูลตำแหน่งที่เปิดรับ (POSITION)");
		buttonPanel3.add(btCo);
		c.add(buttonPanel3);
		
		JPanel buttonPanel4 = new JPanel();
		//สร้างปุ่มที่ 4 ข้อมูลคุณสมบัติเฉพาะตำแหน่ง (QUALFICATION)
		btQu = new JButton("ข้อมูลคุณสมบัติเฉพาะตำแหน่ง (QUALFICATION)");
		buttonPanel4.add(btQu);
		c.add(buttonPanel4);
		
		JPanel buttonPanel5 = new JPanel();
		//สร้างปุ่มที่ 5 ข้อมูลผู้สมัคร คุณสมบัติเฉพาะตำแหน่ง (AP_QUAL)
		btApQu = new JButton("ข้อมูลผู้สมัคร คุณสมบัติเฉพาะตำแหน่ง (AP_QUAL)");
		buttonPanel5.add(btApQu);
		c.add(buttonPanel5);
		
		JPanel buttonPanel6 = new JPanel();
		//สร้างปุ่มที่ 6 ข้อมูลตำแหน่ง คุณสมบัติเฉพาะตำแหน่ง (POS_QUAL)
		btPos = new JButton("ข้อมูลตำแหน่ง คุณสมบัติเฉพาะตำแหน่ง (POS_QUAL)");
		buttonPanel6.add(btPos);
		c.add(buttonPanel6);
		
		JPanel buttonPanel7 = new JPanel();
		//สร้างปุ่มที่ 7 ข้อมูลผู้สมัครตำแหน่ง (AP_POS)
		btApPos = new JButton("ข้อมูลผู้สมัครตำแหน่ง (AP_POS)");
		buttonPanel7.add(btApPos);
		c.add(buttonPanel7);
		
		JPanel buttonPanel8 = new JPanel();
		//สร้างปุ่มที่ 8 ปิด
		btexit = new JButton("close");
		buttonPanel8.add(btApPos);
		c.add(buttonPanel8);
		
		//เพิ่มปุ่มทั้ง 4 ลงในJPanel
		buttonPanel1.add(btApp);//ินำปุ่มใส่panel
		buttonPanel2.add(btCo);
		buttonPanel3.add(btPo);
		buttonPanel4.add(btQu);
		buttonPanel5.add(btApQu);
		buttonPanel6.add(btPos);
		buttonPanel7.add(btApPos);
		buttonPanel8.add(btexit);
		
		//เพิ่มพาเนลปุ่มทั้งหมดลงไปในContainer
		c.add(buttonPanel1);//นำpanelใส่container
		c.add(buttonPanel2);
		c.add(buttonPanel3);
		c.add(buttonPanel4);
		c.add(buttonPanel5);
		c.add(buttonPanel6);
		c.add(buttonPanel7);
		c.add(buttonPanel8);
		
		
	}
	public void actionPerformed(ActionEvent e)//เมธอดรองรับการกระทำกับปุ่ม  ,e คือตัวแปร 
	{
		if(e.getSource() == btCo){//getSource คือเรากดปุ่มอะไร
			Market mk = new Market();
			mk.setTitle("รายชื่อตลาดนัด");
			mk.setSize(800, 600);
			mk.setDefaultCloseOperation(EXIT_ON_CLOSE);
			mk.setLocationRelativeTo(null);
			mk.setVisible(true);
		}else if(e.getSource() == btexit){ //ปุ่มปิด
			System.exit(0);//หรือNORMAL
		}
	}
	
   

	public static void main(String[] args) {//แสดงผลของJFrame
		//class name = new class();
		MenuForm menuform = new MenuForm();//mainMenuคือตัวแปร MainMenu คือคลาส
		menuform.setTitle("ระบบจัดการข้อมูลพื้ันฐาน");//title
		menuform.setSize(900,700);//ความกว้างและความสูง
		menuform.setDefaultCloseOperation(EXIT_ON_CLOSE);//สั่งให้ปิดโปรแกรม
		menuform.setLocationRelativeTo(null);//แสดงผลให้อยู่กลางจอภาพ
		menuform.setVisible(true);//สั่งให้แสดงผลขึ้นมา
	}

}
