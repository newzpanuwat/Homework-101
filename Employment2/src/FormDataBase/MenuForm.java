package FormDataBase;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class MenuForm extends JFrame implements ActionListener {//����MainMenu�׺�ʹ��ѧ����JFrame
	
	JButton btApp ,btCo ,btPo ,btQu ,btApQu ,btPos ,btApPos ,btexit;//���ҧ�����᷹������� 8 ���� ����ӴѺ
	
	public MenuForm()  
	{
		Container c = this.getContentPane();//���ҧcontainer ����Ѻ��è� component ��ҧ�
		c.setLayout(new GridLayout(10,1));//��˹��ٻẺ��èѴ�ҧ Layout ��ٻẺ���ҧ��˹����3�� 1 �������
		
		
		JLabel l1 = new JLabel("�к��Ѵ��â����ž�鹰ҹ",
		SwingConstants.CENTER);//���ҧ���¢�ͤ��� swingconstants.center �ʴ����������ç��ҧ
		l1.setFont(new Font("",Font.BOLD | Font.ITALIC,20));
		//����觿͹�� ���͵���ѡ�� , �ٻẺ������§ |���, ��Ҵ����ѡ��
		//�ӻ��¢�ͤ�����è�� container  
		c.add(l1); //��1 ��������� 1
		
		
		JPanel buttonPanel1 = new JPanel();//���ҧJPanel ��èػ������ 8 buttonPanel1 ����âͧPanel
		//FlowLayout()--> �ʴ��Ũҡ�����繢��
		//���ҧ������� 1 �����ż����Ѥ� (APPLICANT)
		btApp = new JButton("�����ż����Ѥ� (APPLICANT)");
		buttonPanel1.add(btApp);//�ӻ���btApp ��� panel
		c.add(buttonPanel1); //��panel ��� container
		
		JPanel buttonPanel2 = new JPanel();
		//���ҧ������� 2 �����ź���ѷ����յ��˹���� (COMPANY)
		btCo = new JButton("�����ź���ѷ����յ��˹���ҧ (COMPANY)");
		buttonPanel2.add(btCo);
		c.add(buttonPanel2);
		btCo.addActionListener(this);
		
		JPanel buttonPanel3 = new JPanel();
		//���ҧ������� 3 �����ŵ��˹觷���Դ�Ѻ (POSITION)
		btPo = new JButton("�����ŵ��˹觷���Դ�Ѻ (POSITION)");
		buttonPanel3.add(btCo);
		c.add(buttonPanel3);
		
		JPanel buttonPanel4 = new JPanel();
		//���ҧ������� 4 �����Ťس���ѵ�੾�е��˹� (QUALFICATION)
		btQu = new JButton("�����Ťس���ѵ�੾�е��˹� (QUALFICATION)");
		buttonPanel4.add(btQu);
		c.add(buttonPanel4);
		
		JPanel buttonPanel5 = new JPanel();
		//���ҧ������� 5 �����ż����Ѥ� �س���ѵ�੾�е��˹� (AP_QUAL)
		btApQu = new JButton("�����ż����Ѥ� �س���ѵ�੾�е��˹� (AP_QUAL)");
		buttonPanel5.add(btApQu);
		c.add(buttonPanel5);
		
		JPanel buttonPanel6 = new JPanel();
		//���ҧ������� 6 �����ŵ��˹� �س���ѵ�੾�е��˹� (POS_QUAL)
		btPos = new JButton("�����ŵ��˹� �س���ѵ�੾�е��˹� (POS_QUAL)");
		buttonPanel6.add(btPos);
		c.add(buttonPanel6);
		
		JPanel buttonPanel7 = new JPanel();
		//���ҧ������� 7 �����ż����Ѥõ��˹� (AP_POS)
		btApPos = new JButton("�����ż����Ѥõ��˹� (AP_POS)");
		buttonPanel7.add(btApPos);
		c.add(buttonPanel7);
		
		JPanel buttonPanel8 = new JPanel();
		//���ҧ������� 8 �Դ
		btexit = new JButton("close");
		buttonPanel8.add(btApPos);
		c.add(buttonPanel8);
		
		//����������� 4 ŧ�JPanel
		buttonPanel1.add(btApp);//Թӻ������panel
		buttonPanel2.add(btCo);
		buttonPanel3.add(btPo);
		buttonPanel4.add(btQu);
		buttonPanel5.add(btApQu);
		buttonPanel6.add(btPos);
		buttonPanel7.add(btApPos);
		buttonPanel8.add(btexit);
		
		//�������Ż���������ŧ��Container
		c.add(buttonPanel1);//��panel���container
		c.add(buttonPanel2);
		c.add(buttonPanel3);
		c.add(buttonPanel4);
		c.add(buttonPanel5);
		c.add(buttonPanel6);
		c.add(buttonPanel7);
		c.add(buttonPanel8);
		
		
	}
	public void actionPerformed(ActionEvent e)//���ʹ�ͧ�Ѻ��á�зӡѺ����  ,e ��͵���� 
	{
		if(e.getSource() == btCo){//getSource �����ҡ���������
			Market mk = new Market();
			mk.setTitle("��ª��͵�Ҵ�Ѵ");
			mk.setSize(800, 600);
			mk.setDefaultCloseOperation(EXIT_ON_CLOSE);
			mk.setLocationRelativeTo(null);
			mk.setVisible(true);
		}else if(e.getSource() == btexit){ //�����Դ
			System.exit(0);//����NORMAL
		}
	}
	
   

	public static void main(String[] args) {//�ʴ��ŢͧJFrame
		//class name = new class();
		MenuForm menuform = new MenuForm();//mainMenu��͵���� MainMenu ��ͤ���
		menuform.setTitle("�к��Ѵ��â����ž��ѹ�ҹ");//title
		menuform.setSize(900,700);//�������ҧ��Ф����٧
		menuform.setDefaultCloseOperation(EXIT_ON_CLOSE);//������Դ�����
		menuform.setLocationRelativeTo(null);//�ʴ�����������ҧ���Ҿ
		menuform.setVisible(true);//�������ʴ��Ţ����
	}

}
