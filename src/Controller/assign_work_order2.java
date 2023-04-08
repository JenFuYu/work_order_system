package Controller;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.implOrder_type;
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

import server.re_directed;
import server.show;
import javax.swing.JComboBox;

public class assign_work_order2 extends JFrame {

	private JPanel contentPane;
	public static assign_work_order2 awo2_frame = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//wos_frame = new work_order_schedule(user_id,p1);
					awo2_frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public assign_work_order2(int user_id,permission_set p1,work_order wo) {
		
		users u1 = new implUsers().selectId(user_id);
		users u3 = new implUsers().selectId(wo.getSubmitter_id());//提交者
		int sch_id = u1.getSchool();//取得使用者所屬分校
		schools s_name = new implSchools().selectId(wo.getSchool_id());
		order_type ot2 = new implOrder_type().selectId(wo.getOrder_type_id());

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		

			JLabel lblNewLabel = new JLabel("指派工單");
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
					awo2_frame.setVisible(false);
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
					awo2_frame.setVisible(false);
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
					awo2_frame.setVisible(false);
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
					awo2_frame.setVisible(false);
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
					awo2_frame.setVisible(false);
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
					awo2_frame.setVisible(false);
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
					awo2_frame.setVisible(false);
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
					awo2_frame.setVisible(false);
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
					awo2_frame.setVisible(false);
	        		dispose();
				}
			});
		}
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 255, 255));
		panel.setBounds(140, 121, 634, 430);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("提出分校 : ");
		lblNewLabel_1.setBounds(10, 10, 66, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("提交人員 : ");
		lblNewLabel_1_1.setBounds(10, 41, 66, 15);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("工單類型 : ");
		lblNewLabel_1_2.setBounds(10, 72, 66, 15);
		panel.add(lblNewLabel_1_2);
		
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 197, 614, 190);
		panel.add(textArea);
		textArea.setText(wo.getContent());
		
		JLabel lblNewLabel_1_2_1 = new JLabel("說明 : ");
		lblNewLabel_1_2_1.setBounds(10, 172, 66, 15);
		panel.add(lblNewLabel_1_2_1);
		
		
		JButton check_Button = new JButton("指派");
		
		check_Button.setBounds(537, 397, 87, 23);
		panel.add(check_Button);
		
		JLabel sub_show = new JLabel("");
		sub_show.setBounds(75, 41, 150, 15);
		panel.add(sub_show);
		sub_show.setText(u3.getUser_name());
		
		JButton return_Button = new JButton("取消");
		return_Button.setBounds(440, 397, 87, 23);
		panel.add(return_Button);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("指派主管 : ");
		lblNewLabel_1_2_2.setBounds(10, 103, 66, 15);
		panel.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("指派人員 : ");
		lblNewLabel_1_2_2_1.setBounds(10, 134, 66, 15);
		panel.add(lblNewLabel_1_2_2_1);
		
		JComboBox assign_comboBox = new JComboBox();
		assign_comboBox.setBounds(75, 128, 150, 23);
		panel.add(assign_comboBox);
		List<users> u2 = new implUsers().querypermission_id2();
		for(users o:u2) {
			String user_name =  o.getUser_name();
			assign_comboBox.addItem(user_name);
		}
		assign_comboBox.setSelectedIndex(0); 
		
		JLabel assign_mana_show = new JLabel((String) null);
		assign_mana_show.setBounds(75, 103, 150, 15);
		panel.add(assign_mana_show);
		assign_mana_show.setText(u1.getUser_name());
		
		JLabel school_show = new JLabel((String) null);
		school_show.setBounds(75, 10, 150, 15);
		panel.add(school_show);
		school_show.setText(s_name.getSchool_name());
		
		JLabel type_show = new JLabel((String) null);
		type_show.setBounds(75, 72, 150, 15);
		panel.add(type_show);
		type_show.setText(ot2.getType_name());
		
		//指派人員選單
		assign_comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int assign_sel =0;
				users u =new users();
				assign_sel = assign_comboBox.getSelectedIndex();	//從0開始算，要+1
				for(int n =0; n <= assign_sel;n++) {
		        	u = u2.get(assign_sel);
		        }			
				wo.setGeneral_affairs_id(u.getId());
			}
		});
			
		
		//提交工單指定處理人員,返回工單進度頁面
		check_Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				wo.setContent(textArea.getText());
				wo.setAssignment_id(user_id);
				new implWork_order().update_assign(wo);
				
				work_order_schedule.wos_frame = new work_order_schedule(user_id,p1);
				awo2_frame.setVisible(false);
				work_order_schedule.wos_frame.setVisible(true);
        		dispose();
			}
		});
		
		//取消指定，返回指定頁面
		return_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				assign_work_order.awo_frame = new assign_work_order(user_id,p1);
				awo2_frame.setVisible(false);
				assign_work_order.awo_frame.setVisible(true);
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
