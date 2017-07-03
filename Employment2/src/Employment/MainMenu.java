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
	//����MainMenu�׺�ʹ��ѧ����JFrame ����觷��Ѻ�����
	
	JButton btseller/*seller*/ ,btmarket/*MarKet*/, btblock/*Block*/,btreport/*Report*/ ,btexit;//���ҧ�����᷹������� 4 ���� ����ӴѺ
	
	public MainMenu(){
		
		Connection conn = MyConnect.getConnection();//������Ѻ�ҹ������
		if(conn !=null){
		System.out.println("Connection OK!.....");	
		}

		
		Container c = this.getContentPane();//���ҧcontainer ����Ѻ��è� component ��ҧ�
		c.setLayout(new GridLayout(6,1,80,40));//��˹��ٻẺ��èѴ�ҧ Layout ��ٻẺ���ҧ��˹����3�� 1 �������
		
		
		JLabel l1 = new JLabel("�к���Ҿ�鹷���Ҵ",
		SwingConstants.CENTER);//���ҧ���¢�ͤ��� swingconstants.center �ʴ����������ç��ҧ
		l1.setFont(new Font("Angsana New",Font.BOLD | Font.BOLD,60));
		l1.setForeground ( Color.RED );
		
		
		JLabel l11 = new JLabel("################# �Թ�յ�͹�Ѻ #################",
		SwingConstants.CENTER);//���ҧ���¢�ͤ��� swingconstants.center �ʴ����������ç��ҧ
		l11.setFont(new Font("Angsana New",Font.BOLD | Font.BOLD,40));
		l11.setForeground ( Color.BLUE );
		
		
        
		

		//����觿͹�� ���͵���ѡ�� , �ٻẺ������§ |���, ��Ҵ����ѡ��
		//�ӻ��¢�ͤ�����è�� container  
		c.add(l1); //��1 ��������� 1
		c.add(l11);
		
				
		JLabel l2 = new JLabel("The Market Hire System",
		SwingConstants.CENTER);//���ҧ���¢�ͤ��� swingconstants.center �ʴ����������ç��ҧ
		l2.setFont(new Font("Jokerman",Font.BOLD | Font.ITALIC,30));
		
		//����觿͹�� ���͵���ѡ�� , �ٻẺ������§ |���, ��Ҵ����ѡ��
		//�ӻ��¢�ͤ�����è�� container  
		c.add(l2); //��1 ��������� 1
		
		JPanel panelNorth_Left = new JPanel();
		panelNorth_Left.setLayout(new GridLayout(1,3,10,10));//5�� 2 �������
		panelNorth_Left.setBorder(BorderFactory.createTitledBorder("Registratin"));
		c.add(panelNorth_Left);
		panelNorth_Left.setBackground(Color.cyan);
		
		
	
		JPanel buttonPanel = new JPanel();//���ҧJPanel ��èػ������ 4
		
		//FlowLayout()--> �ʴ��Ũҡ�����繢��
		//���ҧ������� 1 �������Ѥ�
		btseller = new JButton("Seller");
		//panelNorth_Left.add(buttonPanel);
		btseller.addActionListener(this);
		
		//���ҧ������� 2 �к��Ѵ��â����ž�鹰ҹ
		btmarket = new JButton("Market");
		btmarket.addActionListener(this);
		
		
		//���ҧ������� 3 �к���§ҹ
		btblock = new JButton("Block");
		btblock.addActionListener(this);
		//btreport = new JButton("�к���§ҹ");
		
		
		
		//����������� 4 ŧ�JPanel
		buttonPanel.add(btseller);
		buttonPanel.add(btmarket);
		buttonPanel.add(btblock);
		//buttonPanel.add(btreport);
		//buttonPanel.add(btexit);
		//�������Ż���������ŧ��Container
		panelNorth_Left.add(buttonPanel);
		//���ҧ������� 4 �͡�ҡ�����
		
		
		
		
		JPanel panelNorth_Right= new JPanel();
		panelNorth_Right.setLayout(new GridLayout(1,3,10,10));//5�� 2 �������
		panelNorth_Right.setBorder(BorderFactory.createTitledBorder("Reporting"));
		panelNorth_Right.setBackground(Color.cyan);
		c.add(panelNorth_Right);
		
		JPanel buttonPanel1 = new JPanel();//���ҧJPanel ��èػ������ 4
		
		btreport = new JButton("Report");
		btreport.addActionListener(this);
		
		panelNorth_Right.add(buttonPanel1);
		buttonPanel1.add(btreport);
		
		//���ҧ������� 4 �͡�ҡ�����
		JPanel buttonPanel2 = new JPanel();
		btexit = new JButton("�͡�ҡ�����");
		btexit.addActionListener(this);
		buttonPanel2.add(btexit);
		c.add(buttonPanel2);
		
	}
	
	public void actionPerformed(ActionEvent e)//���ʹ�ͧ�Ѻ��á�зӡѺ����  ,e ��͵���� 
	{
		if(e.getSource() == btmarket){//getSource �����ҡ���������
			Market mk = new Market();
			mk.setTitle("��ª��͵�Ҵ�Ѵ");
			mk.setSize(800, 600);
			//mk.setDefaultCloseOperation(EXIT_ON_CLOSE);
			mk.setLocationRelativeTo(null);
			mk.setVisible(true);
			
		}else if
			(e.getSource() == btreport){//getSource �����ҡ���������
				Report report = new Report();//mainMenu��͵���� MainMenu ��ͤ���
				report.setTitle("�ʴ���§ҹ");//title
				report.setSize(800,500);//�������ҧ��Ф����٧
				//menuform.setDefaultCloseOperation(EXIT_ON_CLOSE);//������Դ�����
				report.setLocationRelativeTo(null);//�ʴ�����������ҧ���Ҿ
				report.setVisible(true);//�������ʴ��Ţ����
		
		}else if
		(e.getSource() == btblock){//getSource �����ҡ���������
			Block block = new Block();//mainMenu��͵���� MainMenu ��ͤ���
			block.setTitle("�ѧ��Ҵ�Ѵ");//title
			block.setSize(900,700);//�������ҧ��Ф����٧
			//menuform.setDefaultCloseOperation(EXIT_ON_CLOSE);//������Դ�����
			block.setLocationRelativeTo(null);//�ʴ�����������ҧ���Ҿ
			block.setVisible(true);//�������ʴ��Ţ����
		
		}else if
		(e.getSource() == btseller){//getSource �����ҡ���������
			Seller sll = new Seller();
	         sll.setTitle("��͡������");
	         sll.setSize(400, 400);
	         //sll.setDefaultCloseOperation(EXIT_ON_CLOSE);
	         sll.setLocationRelativeTo(null);
	         sll.setVisible(true);
		}
		else if(e.getSource() == btexit){ //�����Դ
			System.exit(0);//����NORMAL
		}
		
		
	}

	public static void main(String[] args) {//�ʴ��ŢͧJFrame
		//class name = new class();
		MainMenu mainMenu = new MainMenu();//mainMenu��͵���� MainMenu ��ͤ���
		mainMenu.setTitle("�к���Ҿ�鹷���Ҵ (The Market Hire System)");//title
		mainMenu.setSize(900,700);//�������ҧ��Ф����٧
		mainMenu.setLocationRelativeTo(null);//�ʴ�����������ҧ���Ҿ
		mainMenu.setVisible(true);//�������ʴ��Ţ����
	
	}

}
