import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class Frame1 {

	private JFrame frame;
	private JTextField id_textField;
	private JTextField fnamelname_textField;
	private JTextField addr_textField;
	private JTextField province_textField;
	private JTextField edu_textField;
	private JTextField major_textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTestingApplication = new JLabel("STOU-TEC Company .ltd");
		lblTestingApplication.setBounds(269, 6, 164, 29);
		frame.getContentPane().add(lblTestingApplication);
		
		JLabel lblName = new JLabel("Applicant ID (AP_ID) :");
		lblName.setBounds(15, 120, 210, 25);
		frame.getContentPane().add(lblName);
		
		JLabel lblFirstname = new JLabel("Firstname-Lastname (AP_NAME) :");
		lblFirstname.setBounds(15, 150, 210, 25);
		frame.getContentPane().add(lblFirstname);
		
		id_textField = new JTextField();
		id_textField.setBounds(260, 120, 450, 25);
		frame.getContentPane().add(id_textField);
		id_textField.setColumns(10);
		
		fnamelname_textField = new JTextField();
		fnamelname_textField.setBounds(260, 150, 450, 25);
		fnamelname_textField.setColumns(10);
		frame.getContentPane().add(fnamelname_textField);
		
		addr_textField = new JTextField();
		addr_textField.setBounds(260, 180, 450, 25);
		addr_textField.setColumns(10);
		frame.getContentPane().add(addr_textField);
		
		JLabel lblNewLabel = new JLabel("Application Form for Candidate");
		lblNewLabel.setBounds(250, 40, 210, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblThisApplicationForm = new JLabel("This application form for ICT, Give the applicant input your personal below ");
		lblThisApplicationForm.setBounds(122, 62, 492, 16);
		frame.getContentPane().add(lblThisApplicationForm);
		
		JLabel lblStoutecWillApprove = new JLabel("STOU-TEC Company .ltd will approve following by appropriately");
		lblStoutecWillApprove.setBounds(154, 84, 430, 16);
		frame.getContentPane().add(lblStoutecWillApprove);
		
		JLabel lblAddress = new JLabel("Address (AP_ADDR) :");
		lblAddress.setBounds(15, 180, 210, 25);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblProvince = new JLabel("Province (AP_CHW) :");
		lblProvince.setBounds(15, 210, 210, 25);
		frame.getContentPane().add(lblProvince);
		
		province_textField = new JTextField();
		province_textField.setBounds(260, 210, 225, 25);
		province_textField.setColumns(10);
		frame.getContentPane().add(province_textField);
		
		JLabel lblSex = new JLabel("Sex (AP_SEX) :");
		lblSex.setBounds(15, 240, 210, 25);
		frame.getContentPane().add(lblSex);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(260, 240, 70, 25);
		frame.getContentPane().add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(360, 240, 97, 25);
		frame.getContentPane().add(rdbtnFemale);
		
		JLabel lblEducation = new JLabel("Education (AP_EDU) :");
		lblEducation.setBounds(15, 270, 210, 25);
		frame.getContentPane().add(lblEducation);
		
		edu_textField = new JTextField();
		edu_textField.setBounds(260, 270, 450, 25);
		edu_textField.setColumns(10);
		frame.getContentPane().add(edu_textField);
		
		JLabel lbleg = new JLabel("(e.g B.S., B.A., M.S., M.BA., M.A. )");
		lbleg.setBounds(15, 300, 210, 16);
		frame.getContentPane().add(lbleg);
		
		JLabel lblMajor = new JLabel("Major (AP_MAJ) :");
		lblMajor.setBounds(15, 330, 210, 25);
		frame.getContentPane().add(lblMajor);
		
		major_textField = new JTextField();
		major_textField.setBounds(260, 330, 450, 25);
		major_textField.setColumns(10);
		frame.getContentPane().add(major_textField);
		
		
		/* Combo box section */
		
		String [] comboSpecialSkStrings = {
				"Web_ASP",
				"C++",
				"Database Administrator, DB2",
				"Database Administrator,ORACLE",
				"Graphic Design",
				"JAVA",
				"Management",
				"Network",
				"Secretarial work,45 words/min",
				"Secretarial work,60 words/min",
				"System Analyst, Level 1",
				"System Analyst, Level 2",
				"Visual Basic"
		};
		
		
		JLabel lblqual = new JLabel("Other qualification or Special skills that should be consider (QUAL_DESC) **Required 5 items");
		lblqual.setBounds(30, 370, 600, 15);
		frame.getContentPane().add(lblqual);
		
		// comboBox Label and Special skills selection 1 
		
		JLabel lblSpecialskills_1 = new JLabel("Special skill 1 :");
		lblSpecialskills_1.setBounds(15, 405, 210, 15);
		frame.getContentPane().add(lblSpecialskills_1);
		
		JComboBox specialSk_comboBox_1 = new JComboBox(comboSpecialSkStrings);
		specialSk_comboBox_1.setSelectedIndex(0);
		specialSk_comboBox_1.setBounds(260, 400, 450, 27);
		specialSk_comboBox_1.setToolTipText("");
		frame.getContentPane().add(specialSk_comboBox_1);
		
		
		// comboBox Label and Special skills selection 2
		
		JLabel lblSpecialskills_2 = new JLabel("Special skill 2 :");
		lblSpecialskills_2.setBounds(15, 445, 210, 15);
		frame.getContentPane().add(lblSpecialskills_2);
		
		JComboBox specialSk_comboBox_2 = new JComboBox(comboSpecialSkStrings);
		specialSk_comboBox_1.setSelectedIndex(1);
		specialSk_comboBox_2.setBounds(260, 440, 450, 27);
		frame.getContentPane().add(specialSk_comboBox_2);
		
		// comboBox Label and Special skills selection 3
		
		JLabel lblSpecialskills_3 = new JLabel("Special skill 3 :");
		lblSpecialskills_3.setBounds(15, 485, 210, 15);
		frame.getContentPane().add(lblSpecialskills_3);
		
		JComboBox specialSk_comboBox_3 = new JComboBox(comboSpecialSkStrings);
		specialSk_comboBox_1.setSelectedIndex(2);
		specialSk_comboBox_3.setBounds(260, 480, 450, 27);
		frame.getContentPane().add(specialSk_comboBox_3);
		
		// comboBox Label and Special skills selection 4
		
		JLabel lblSpecialskills_4 = new JLabel("Special skill 4 :");
		lblSpecialskills_4.setBounds(15, 525, 210, 15);
		frame.getContentPane().add(lblSpecialskills_4);
		
		JComboBox specialSk_comboBox_4 = new JComboBox(comboSpecialSkStrings);
		specialSk_comboBox_1.setSelectedIndex(3);
		specialSk_comboBox_4.setBounds(260, 520, 450, 27);
		frame.getContentPane().add(specialSk_comboBox_4);
		
		// comboBox Label and Special skills selection 5
		
		JLabel lblSpecialskills_5 = new JLabel("Special skill 5 :");
		lblSpecialskills_5.setBounds(15, 565, 210, 15);
		frame.getContentPane().add(lblSpecialskills_5);
		
		JComboBox specialSk_comboBox_5 = new JComboBox(comboSpecialSkStrings);
		specialSk_comboBox_1.setSelectedIndex(4);
		specialSk_comboBox_5.setBounds(260, 560, 450, 27);
		frame.getContentPane().add(specialSk_comboBox_5);
		
		/* Job Position */
		
		String [] comboJobPostionStrings = {
				"Technical Programmer",
				"Web Developer",
				"General Manager",
				"ICT Specialist",
				"E-Business Analyst",
				"ICT Documentor",
				"Database Administrator",
				"PC Administrator",
				"Network Specialist",
				"ICT Manager"
		};
		
		
	
		JLabel lblPostionApplyingFor = new JLabel("Postion applying for (POS_NAME) ** Required 3 positions : ");
		lblPostionApplyingFor.setBounds(30, 605, 600, 15);
		frame.getContentPane().add(lblPostionApplyingFor);
		
		// Job Position Label and Job Position selection 1
		
		JLabel lblPosition_1 = new JLabel("Position 1 :");
		lblPosition_1.setBounds(15, 650, 210, 15);
		frame.getContentPane().add(lblPosition_1);
				
		JComboBox position_comboBox_1 = new JComboBox();
		position_comboBox_1.setSelectedIndex(0);
		position_comboBox_1.setBounds(260, 645, 450, 27);
		position_comboBox_1.setToolTipText("");
		frame.getContentPane().add(position_comboBox_1);

		// Job Position Label and Job Position selection 2
		
		JLabel lblPosition_2 = new JLabel("Position 2 :");
		lblPosition_2.setBounds(15, 690, 210, 15);
		frame.getContentPane().add(lblPosition_2);
		
		JComboBox position_comboBox_2 = new JComboBox();
		position_comboBox_2.setSelectedIndex(1);
		position_comboBox_2.setBounds(260, 685, 450, 27);
		frame.getContentPane().add(position_comboBox_2);

		// Job Position Label and Job Position selection 3
		
		JLabel lblPosition_3 = new JLabel("Position 3 :");
		lblPosition_3.setBounds(15, 730, 210, 15);
		frame.getContentPane().add(lblPosition_3);
		
		JComboBox position_comboBox_3 = new JComboBox();
		position_comboBox_3.setSelectedIndex(2);
		position_comboBox_3.setBounds(260, 725, 450, 27);
		frame.getContentPane().add(position_comboBox_3);
		
		// Submit form button
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(260, 792, 117, 29);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		frame.getContentPane().add(btnSubmit);
	}
}
