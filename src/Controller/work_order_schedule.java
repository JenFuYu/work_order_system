package Controller;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.implUsers;
import Model.permission_set;
import Model.users;

import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import server.re_directed;
import server.show;

public class work_order_schedule extends JFrame {

	private JPanel contentPane;
	public static work_order_schedule wos_frame = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//wos_frame = new work_order_schedule(user_id,p1);
					wos_frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public work_order_schedule(int user_id,permission_set p1) {
		
		users u1 = new implUsers().selectId(user_id);
		int sch_id = u1.getSchool();//取得使用者所屬分校
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		

			JLabel lblNewLabel = new JLabel("工單進度");
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
					wos_frame.setVisible(false);
	        		dispose();
				}
			});
		}
		
		if(p1.getSchedule_function() == 1) {
			JButton workorder_schedule_Button = new JButton("工單進度顯示");
			workorder_schedule_Button.setBounds(10, 170, 120, 40);
			contentPane.add(workorder_schedule_Button);
			
		}
		
		if(p1.getInspect_function() == 1) {
			JButton workorder_inspect_Button = new JButton("工單驗收");
			workorder_inspect_Button.setBounds(10, 220, 120, 40);
			contentPane.add(workorder_inspect_Button);
			
			workorder_inspect_Button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new re_directed().change_inspect_work_order(user_id,p1);
					wos_frame.setVisible(false);
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
					wos_frame.setVisible(false);
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
					wos_frame.setVisible(false);
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
					wos_frame.setVisible(false);
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
					wos_frame.setVisible(false);
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
					wos_frame.setVisible(false);
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
					wos_frame.setVisible(false);
	        		dispose();
				}
			});
		}
		
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(140, 170, 622, 370);
		contentPane.add(textArea);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 255, 255));
		panel.setBounds(140, 121, 634, 430);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		JButton assign_Button = new JButton("已指派工單");
		
		assign_Button.setBounds(0, 0, 120, 40);
		panel.add(assign_Button);
		
		JButton uninspect_Button = new JButton("需驗收工單");
		
		uninspect_Button.setBounds(130, 0, 120, 40);
		panel.add(uninspect_Button);
		
		JButton no_assign_Button = new JButton("未指派工單");
		
		no_assign_Button.setBounds(260, 0, 120, 40);
		panel.add(no_assign_Button);
		
		JButton logout_Button = new JButton("登出");
		
		logout_Button.setBounds(654, 72, 120, 40);
		contentPane.add(logout_Button);
		no_assign_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		uninspect_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		//顯示已指派工單
		assign_Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textArea.setText(" ");
				textArea.setText(new show().show_assign_workorder());
			}
		});
		//顯示需驗收工單
		uninspect_Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textArea.setText(" ");
				textArea.setText(new show().show_uninspect_workorder());
			}
		});
		//顯示未指派工單
		no_assign_Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textArea.setText(" ");
				textArea.setText(new show().show_unassign_workorder());
			}
		});
		
		//登出
		logout_Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logout_Button.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						new re_directed().change_index();
						wos_frame.setVisible(false);
		        		dispose();
					}
				});
			}
		});
		
		
	}
}
