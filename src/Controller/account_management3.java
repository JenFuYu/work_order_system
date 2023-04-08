package Controller;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.implOrder_type;
import Dao.implPermission_set;
import Dao.implSchools;
import Dao.implUsers;
import Dao.implWork_order;
import Model.order_type;
import Model.permission_set;
import Model.schools;
import Model.users;
import Model.work_order;

import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import server.hash;
import server.re_directed;
import server.show;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class account_management3 extends JFrame {

	private JPanel contentPane;
	public static account_management3 am3_frame = null;
	private JTextField ema_textField;
	private JTextField name_textField;
	private JTextField eng_name_textField;
	private JTextField gen_textField;
	private JTextField bir_textField;
	private JTextField cel_textField;
	private JTextField password_textField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//wos_frame = new work_order_schedule(user_id,p1);
					am3_frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public account_management3(int user_id,permission_set p1,users u) {
		
		users u1 = new implUsers().selectId(user_id);//使用者
		int sch_id = u1.getSchool();//取得使用者所屬分校
		users u2 = new users();//使用者

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		

			JLabel lblNewLabel = new JLabel("新增帳號");
			lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 45));
			lblNewLabel.setBounds(305, 10, 190, 102);
			contentPane.add(lblNewLabel);

		
		if(p1.getSub_function() == 1) {
			JButton New_workorder_Button = new JButton("新增工單");
			New_workorder_Button.setBounds(10, 120, 120, 40);
			contentPane.add(New_workorder_Button);
			
			New_workorder_Button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new re_directed().change_new_work_order(user_id,p1);
					am3_frame.setVisible(false);
	        		dispose();
				}
			});
		}
		
		if(p1.getSchedule_function() == 1) {
			JButton workorder_schedule_Button = new JButton("工單進度顯示");
			workorder_schedule_Button.setBounds(10, 170, 120, 40);
			contentPane.add(workorder_schedule_Button);
			
			workorder_schedule_Button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new re_directed().change_work_order_schedule(user_id,p1);
					am3_frame.setVisible(false);
	        		dispose();
				}
			});
		}
		
		if(p1.getInspect_function() == 1) {
			JButton workorder_inspect_Button = new JButton("工單驗收");
			workorder_inspect_Button.setBounds(10, 220, 120, 40);
			contentPane.add(workorder_inspect_Button);
			workorder_inspect_Button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new re_directed().change_inspect_work_order(user_id,p1);
					am3_frame.setVisible(false);
		    		dispose();
				}
			});
		}
		
		if(p1.getAffairs_function() == 1) {
			JButton workorder_affairs_Button = new JButton("工單完成提交");
			workorder_affairs_Button.setBounds(10, 270, 120, 40);
			contentPane.add(workorder_affairs_Button);
			workorder_affairs_Button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new re_directed().change_affairs_work_order(user_id,p1);
					am3_frame.setVisible(false);
	        		dispose();
				}
			});
		}
		
		if(p1.getHistory_function() == 1) {
			JButton workorder_history_Button = new JButton("歷史工單");
			workorder_history_Button.setBounds(10, 320, 120, 40);
			contentPane.add(workorder_history_Button);
			workorder_history_Button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new re_directed().change_history_work_order(user_id,p1);
					am3_frame.setVisible(false);
	        		dispose();
				}
			});
		}
		
		if(p1.getReport_function()==1) {
			JButton workorder_report_Button = new JButton("工單報表");
			workorder_report_Button.setBounds(10, 370, 120, 40);
			contentPane.add(workorder_report_Button);
			workorder_report_Button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new re_directed().change_report(user_id,p1);
					am3_frame.setVisible(false);
	        		dispose();
				}
			});
		}
		
		if(p1.getAssign_function()==1) {
			JButton assign_Button = new JButton("工單指派");
			assign_Button.setBounds(10, 420, 120, 40);
			contentPane.add(assign_Button);
			assign_Button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new re_directed().change_assign_work_order(user_id,p1);
					am3_frame.setVisible(false);
	        		dispose();
				}
			});
		}
		
		if(p1.getAccount_mana_function()==1) {
			JButton account_mana_Button = new JButton("人員帳號管理");
			account_mana_Button.setBounds(10, 470, 120, 40);
			contentPane.add(account_mana_Button);
			account_mana_Button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new re_directed().change_account_management(user_id,p1);
					am3_frame.setVisible(false);
	        		dispose();
				}
			});
		}
		
		if(p1.getPermission_function()==1) {
			JButton permission_Button = new JButton("級別權限管理");
			permission_Button.setBounds(10, 520, 120, 40);
			contentPane.add(permission_Button);
			permission_Button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new re_directed().change_authority_management(user_id,p1);
					am3_frame.setVisible(false);
	        		dispose();
				}
			});
		}
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 255, 255));
		panel.setBounds(140, 121, 634, 430);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("帳號 : ");
		lblNewLabel_1.setBounds(10, 10, 66, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("姓名 : ");
		lblNewLabel_1_1.setBounds(10, 72, 66, 15);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("英文姓名 : ");
		lblNewLabel_1_2.setBounds(10, 103, 66, 15);
		panel.add(lblNewLabel_1_2);
		
		
		JButton check_Button = new JButton("新增帳號");
		
		check_Button.setBounds(537, 397, 87, 23);
		panel.add(check_Button);
		
		JButton return_Button = new JButton("取消");
		return_Button.setBounds(440, 397, 87, 23);
		panel.add(return_Button);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("性別 : ");
		lblNewLabel_1_2_2.setBounds(10, 134, 66, 15);
		panel.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("生日 : ");
		lblNewLabel_1_2_2_1.setBounds(10, 165, 66, 15);
		panel.add(lblNewLabel_1_2_2_1);
		
		ema_textField = new JTextField();
		ema_textField.setColumns(10);
		ema_textField.setBounds(86, 7, 167, 21);
		panel.add(ema_textField);
		
		
		JLabel lblNewLabel_1_2_2_1_2 = new JLabel("電話 : ");
		lblNewLabel_1_2_2_1_2.setBounds(10, 196, 66, 15);
		panel.add(lblNewLabel_1_2_2_1_2);
		
		JLabel lblNewLabel_1_2_2_1_3 = new JLabel("所屬分校 : ");
		lblNewLabel_1_2_2_1_3.setBounds(10, 221, 66, 15);
		panel.add(lblNewLabel_1_2_2_1_3);
		
		JLabel lblNewLabel_1_2_2_1_3_1 = new JLabel("職別 : ");
		lblNewLabel_1_2_2_1_3_1.setBounds(10, 252, 66, 15);
		panel.add(lblNewLabel_1_2_2_1_3_1);
		
		name_textField = new JTextField();
		name_textField.setColumns(10);
		name_textField.setBounds(86, 69, 167, 21);
		panel.add(name_textField);
		
		eng_name_textField = new JTextField();
		eng_name_textField.setColumns(10);
		eng_name_textField.setBounds(86, 100, 167, 21);
		panel.add(eng_name_textField);
		
		gen_textField = new JTextField();
		gen_textField.setColumns(10);
		gen_textField.setBounds(86, 131, 167, 21);
		panel.add(gen_textField);
		
		bir_textField = new JTextField();
		bir_textField.setColumns(10);
		bir_textField.setBounds(86, 162, 167, 21);
		panel.add(bir_textField);
		
		cel_textField = new JTextField();
		cel_textField.setColumns(10);
		cel_textField.setBounds(86, 193, 167, 21);
		panel.add(cel_textField);
		
		password_textField = new JTextField();
		password_textField.setColumns(10);
		password_textField.setBounds(86, 38, 167, 21);
		panel.add(password_textField);
		
		JLabel lblNewLabel_2 = new JLabel("※1為男性，2為女性");
		lblNewLabel_2.setBounds(263, 134, 188, 15);
		panel.add(lblNewLabel_2);
		
		JComboBox school_comboBox = new JComboBox();
		school_comboBox.setBounds(86, 223, 167, 23);
		panel.add(school_comboBox);
		List<schools> s2 = new implSchools().selectAll();
		for(schools o:s2) {
			String school_name =  o.getSchool_name();
			school_comboBox.addItem(school_name);
		}
		school_comboBox.setSelectedIndex(0); 		//設定初始值。SelectedIndex從0開始，school_id從1開始
		
		JComboBox permission_comboBox = new JComboBox();
		permission_comboBox.setBounds(86, 254, 167, 23);
		panel.add(permission_comboBox);
		List<permission_set> p2 = new implPermission_set().selectAll();
		for(permission_set o:p2) {
			String permission_name =  o.getPosition_name();
			permission_comboBox.addItem(permission_name);
		}
		permission_comboBox.setSelectedIndex(0); 		//設定初始值。SelectedIndex從0開始，school_id從1開始
		
		JLabel lblNewLabel_1_3 = new JLabel("密碼 : ");
		lblNewLabel_1_3.setBounds(10, 42, 66, 15);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_2_1 = new JLabel("※格式為YYYY-MM-DD");
		lblNewLabel_2_1.setBounds(263, 165, 188, 15);
		panel.add(lblNewLabel_2_1);
		
		JLabel check_show = new JLabel("");
		check_show.setBounds(411, 372, 213, 15);
		panel.add(check_show);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("※請輸入信箱");
		lblNewLabel_2_1_1.setBounds(259, 10, 188, 15);
		panel.add(lblNewLabel_2_1_1);
		
		
		
		//school選單操作
		school_comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int school_sel =0;
				schools s =new schools();
				school_sel = school_comboBox.getSelectedIndex();	//從0開始算
				for(int n =0; n <= school_sel;n++) {
		        	s = s2.get(school_sel);			//從List<schools> s2的第school_sel個取值
		        }			
				u2.setSchool(s.getId());
			}
		});
		
		//權限選單操作
		permission_comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int per_sel =0;
				permission_set p =new permission_set();
				per_sel = permission_comboBox.getSelectedIndex();	//從0開始算
				for(int n =0; n <= per_sel;n++) {
		        	p = p2.get(per_sel);			
		        }			
				u2.setPermission_id(p.getId());
			}
		});
		
		//進行資料變更,返回帳號管理頁面
		check_Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Boolean check_cus = new implUsers().querycustomer(ema_textField.getText(),password_textField.getText());
				String pattern = "[A-Za-z0-9]{1,20}@\\D{1,20}";
				String pattern2 = "\\d";	//性別欄輸入限制
				String pattern3 = "\\d{4}-\\d{2}-\\d{2}";	//生日欄輸入限制
				String pattern4 = "\\d{9,10}";	//電話欄輸入限制
				
				String md5password = new hash().change_MD5(password_textField.getText());		//密碼加密
				
				
				if(check_cus) {
					check_show.setText("帳號重複，請重新設定");
					ema_textField.setText("");
				}else if(!ema_textField.getText().matches(pattern)){
					check_show.setText("帳號輸入錯誤，請重新設定");
					ema_textField.setText("");
				}else if(!gen_textField.getText().matches(pattern2)) {
					check_show.setText("性別輸入錯誤，請重新設定");
					gen_textField.setText("");
				}else if(!bir_textField.getText().matches(pattern3)) {
					check_show.setText("生日格式輸入錯誤，請重新設定");
					bir_textField.setText("");
				}
				else if(!cel_textField.getText().matches(pattern4)) {
					check_show.setText("電話輸入錯誤，請重新設定");
					cel_textField.setText("");
				}else {
					u2.setEmail(ema_textField.getText());
					u2.setUser_name(name_textField.getText());
					u2.setEnglish_name(eng_name_textField.getText());
					u2.setGender(Integer.parseInt(gen_textField.getText()));
					u2.setPassword(md5password);
					u2.setBirth_date(bir_textField.getText());
					u2.setCell_phone(cel_textField.getText());
					u2.setSchool(school_comboBox.getSelectedIndex()+1);
					u2.setPermission_id(permission_comboBox.getSelectedIndex()+1);
					u2.setCreated_at(getDateTime());
					u2.setFake(0);
					new implUsers().add(u2);
					
					account_management.am_frame = new account_management(user_id,p1);
					am3_frame.setVisible(false);
					account_management.am_frame.setVisible(true);
	        		dispose();
				}

			}
		});
		
		//取消變更，返回帳號管理
		return_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				account_management.am_frame = new account_management(user_id,p1);
				am3_frame.setVisible(false);
				account_management.am_frame.setVisible(true);
        		dispose();
			}
		});
		
	}
	
	//抓取時間
	public String getDateTime(){
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		String strDate = sdFormat.format(date);
		return strDate;
	}
}
