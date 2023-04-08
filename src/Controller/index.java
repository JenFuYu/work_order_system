package Controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.implPermission_set;
import Dao.implUsers;
import Model.permission_set;
import Model.users;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class index extends JFrame {

	private JPanel contentPane;
	private JTextField email;
	private JTextField password;
	public static index frame = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new index();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public index() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("工單系統_測試版");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 45));
		lblNewLabel.setBounds(220, 10, 360, 102);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("帳號 : ");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 35));
		lblNewLabel_1.setBounds(10, 141, 115, 41);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("密碼 : ");
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.BOLD, 35));
		lblNewLabel_1_1.setBounds(10, 210, 115, 41);
		contentPane.add(lblNewLabel_1_1);
		
		email = new JTextField();
		email.setBounds(135, 141, 390, 41);
		contentPane.add(email);
		email.setColumns(10);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(135, 210, 390, 41);
		contentPane.add(password);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 308, 764, 243);
		contentPane.add(textArea);
		
		JButton login_Button = new JButton("登入");
		
		login_Button.setFont(new Font("新細明體", Font.PLAIN, 25));
		login_Button.setBounds(616, 154, 87, 69);
		contentPane.add(login_Button);
		
		JLabel show_string = new JLabel("");
		show_string.setFont(new Font("新細明體", Font.PLAIN, 25));
		show_string.setBounds(135, 261, 390, 37);
		contentPane.add(show_string);
		
		/*登入動作*/
		login_Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Email = email.getText();
				String Password = password.getText();
				Boolean check_cus = new implUsers().querycustomer(Email,Password);
				if(check_cus) {
					users user = new implUsers().querymember(Email,Password);
					int user_id = user.getId();
					int user_per = user.getPermission_id();
					permission_set p1 = new implPermission_set().selectId(user_per);
					
					work_order_schedule.wos_frame = new work_order_schedule(user_id,p1);
	        		frame.setVisible(false);
	        		work_order_schedule.wos_frame.setVisible(true);
	        		
	        		dispose();

				}else {
					show_string.setText("帳號或密碼錯誤，請重新輸入！");
				}
				
			}
		});
		
		/*textArea帳號密碼提示框*/
		textArea.append("總管理者帳號: test@gmail.com\n"
				+ "總管理者密碼: 1234\n"
				+ "櫃台測試帳號: abc@gmail.com\n"
				+ "櫃台測試密碼: 1234\n "
				+ "總務人員測試帳號: def@gmail.com\n "
				+ "總務人員測試密碼: 1234\n "
				+ "會計人員測試帳號: qwe@gmail.com\n "
				+ "會計人員測試密碼: 1234\n "
				+ "管理者測試帳號: acc@gmail.com\n "
				+ "管理者測試密碼: 1234\n ");
	}
}
