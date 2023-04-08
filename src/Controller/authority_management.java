package Controller;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.implPermission_set;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import server.re_directed;
import server.show;
import javax.swing.JRadioButton;

public class authority_management extends JFrame {

	private JPanel contentPane;
	public static authority_management aum_frame = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//wos_frame = new work_order_schedule(user_id,p1);
					aum_frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public authority_management(int user_id,permission_set p1) {
		
		users u1 = new implUsers().selectId(user_id);
		int sch_id = u1.getSchool();//取得使用者所屬分校
		permission_set ps1 = new implPermission_set().selectId(1);//取得櫃台權限
		permission_set ps2 = new implPermission_set().selectId(2);//取得總務權限
		permission_set ps3 = new implPermission_set().selectId(3);//取得會計權限
		permission_set ps4 = new implPermission_set().selectId(4);//取得管理者權限
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		

			JLabel lblNewLabel = new JLabel("權限管理");
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
					aum_frame.setVisible(false);
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
					aum_frame.setVisible(false);
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
					aum_frame.setVisible(false);
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
					aum_frame.setVisible(false);
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
					aum_frame.setVisible(false);
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
					aum_frame.setVisible(false);
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
					aum_frame.setVisible(false);
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
					aum_frame.setVisible(false);
	        		dispose();
				}
			});
		}
		
		if(p1.getPermission_function()==1) {
			JButton permission_Button = new JButton("級別權限管理");
			permission_Button.setBounds(10, 520, 120, 40);
			contentPane.add(permission_Button);
		}
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 255, 255));
		panel.setBounds(140, 121, 634, 430);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("櫃台人員");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 10, 90, 30);
		panel.add(lblNewLabel_1);
		
		JRadioButton sub_RadioButton = new JRadioButton("表格提交功能");
		sub_RadioButton.setBounds(10, 44, 107, 23);
		panel.add(sub_RadioButton);
		if(ps1.getSub_function() == 1) {
			sub_RadioButton.setSelected(true);
		}else {
			sub_RadioButton.setSelected(false);
		}
		
		
		JRadioButton sch_RadioButton = new JRadioButton("工單進度顯示功能");
		sch_RadioButton.setBounds(119, 44, 107, 23);
		panel.add(sch_RadioButton);
		if(ps1.getSchedule_function() == 1) {
			sch_RadioButton.setSelected(true);
		}else {
			sch_RadioButton.setSelected(false);
		}
		
		JRadioButton aff_RadioButton = new JRadioButton("工單完成提交功能");
		aff_RadioButton.setBounds(228, 44, 121, 23);
		panel.add(aff_RadioButton);
		if(ps1.getAffairs_function() == 1) {
			aff_RadioButton.setSelected(true);
		}else {
			aff_RadioButton.setSelected(false);
		}
		
		JRadioButton ins_RadioButton = new JRadioButton("工單驗收功能");
		ins_RadioButton.setBounds(351, 44, 107, 23);
		panel.add(ins_RadioButton);
		if(ps1.getInspect_function() == 1) {
			ins_RadioButton.setSelected(true);
		}else {
			ins_RadioButton.setSelected(false);
		}
		
		JRadioButton his_RadioButton = new JRadioButton("歷史工單功能");
		his_RadioButton.setBounds(10, 69, 107, 23);
		panel.add(his_RadioButton);
		if(ps1.getHistory_function() == 1) {
			his_RadioButton.setSelected(true);
		}else {
			his_RadioButton.setSelected(false);
		}
		
		JRadioButton acc_RadioButton = new JRadioButton("帳號管理功能");
		acc_RadioButton.setBounds(119, 69, 107, 23);
		panel.add(acc_RadioButton);
		if(ps1.getAccount_mana_function() == 1) {
			acc_RadioButton.setSelected(true);
		}else {
			acc_RadioButton.setSelected(false);
		}
		
		JRadioButton per_RadioButton = new JRadioButton("權限管理功能");
		per_RadioButton.setBounds(228, 69, 121, 23);
		panel.add(per_RadioButton);
		if(ps1.getPermission_function() == 1) {
			per_RadioButton.setSelected(true);
		}else {
			per_RadioButton.setSelected(false);
		}
		
		JRadioButton rep_RadioButton = new JRadioButton("報表功能");
		rep_RadioButton.setBounds(351, 69, 107, 23);
		panel.add(rep_RadioButton);
		if(ps1.getReport_function() == 1) {
			rep_RadioButton.setSelected(true);
		}else {
			rep_RadioButton.setSelected(false);
		}
		
		JRadioButton ass_RadioButton = new JRadioButton("工單指派功能");
		ass_RadioButton.setBounds(460, 44, 107, 23);
		panel.add(ass_RadioButton);
		if(ps1.getAssign_function() == 1) {
			ass_RadioButton.setSelected(true);
		}else {
			ass_RadioButton.setSelected(false);
		}
		
		JLabel lblNewLabel_1_1 = new JLabel("總務人員");
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(10, 110, 90, 30);
		panel.add(lblNewLabel_1_1);
		
		JRadioButton ass_RadioButton2 = new JRadioButton("工單指派功能");
		ass_RadioButton2.setBounds(460, 146, 107, 23);
		panel.add(ass_RadioButton2);
		if(ps2.getAssign_function() == 1) {
			ass_RadioButton2.setSelected(true);
		}else {
			ass_RadioButton2.setSelected(false);
		}
		
		JRadioButton ins_RadioButton2 = new JRadioButton("工單驗收功能");
		ins_RadioButton2.setBounds(351, 146, 107, 23);
		panel.add(ins_RadioButton2);
		if(ps2.getInspect_function() == 1) {
			ins_RadioButton2.setSelected(true);
		}else {
			ins_RadioButton2.setSelected(false);
		}
		
		JRadioButton rep_RadioButton2 = new JRadioButton("報表功能");
		rep_RadioButton2.setBounds(351, 171, 107, 23);
		panel.add(rep_RadioButton2);
		if(ps2.getReport_function() == 1) {
			rep_RadioButton2.setSelected(true);
		}else {
			rep_RadioButton2.setSelected(false);
		}
		
		JRadioButton per_RadioButton2 = new JRadioButton("權限管理功能");
		per_RadioButton2.setBounds(228, 171, 121, 23);
		panel.add(per_RadioButton2);
		if(ps2.getPermission_function() == 1) {
			per_RadioButton2.setSelected(true);
		}else {
			per_RadioButton2.setSelected(false);
		}
		
		JRadioButton aff_RadioButton2 = new JRadioButton("工單完成提交功能");
		aff_RadioButton2.setBounds(228, 146, 121, 23);
		panel.add(aff_RadioButton2);
		if(ps2.getAffairs_function() == 1) {
			aff_RadioButton2.setSelected(true);
		}else {
			aff_RadioButton2.setSelected(false);
		}
		
		JRadioButton sch_RadioButton2 = new JRadioButton("工單進度顯示功能");
		sch_RadioButton2.setBounds(119, 146, 107, 23);
		panel.add(sch_RadioButton2);
		if(ps2.getSchedule_function() == 1) {
			sch_RadioButton2.setSelected(true);
		}else {
			sch_RadioButton2.setSelected(false);
		}
		
		JRadioButton acc_RadioButton2 = new JRadioButton("帳號管理功能");
		acc_RadioButton2.setBounds(119, 171, 107, 23);
		panel.add(acc_RadioButton2);
		if(ps2.getAccount_mana_function() == 1) {
			acc_RadioButton2.setSelected(true);
		}else {
			acc_RadioButton2.setSelected(false);
		}
		
		
		JRadioButton his_RadioButton2 = new JRadioButton("歷史工單功能");
		his_RadioButton2.setBounds(10, 171, 107, 23);
		panel.add(his_RadioButton2);
		if(ps2.getHistory_function() == 1) {
			his_RadioButton2.setSelected(true);
		}else {
			his_RadioButton2.setSelected(false);
		}
		
		
		JRadioButton sub_RadioButton2 = new JRadioButton("表格提交功能");
		sub_RadioButton2.setBounds(10, 146, 107, 23);
		panel.add(sub_RadioButton2);
		if(ps2.getSub_function() == 1) {
			sub_RadioButton2.setSelected(true);
		}else {
			sub_RadioButton2.setSelected(false);
		}
		
		JLabel lblNewLabel_1_1_1 = new JLabel("會計人員");
		lblNewLabel_1_1_1.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(10, 210, 90, 30);
		panel.add(lblNewLabel_1_1_1);
		
		JRadioButton ass_RadioButton3 = new JRadioButton("工單指派功能");
		ass_RadioButton3.setBounds(460, 246, 107, 23);
		panel.add(ass_RadioButton3);
		if(ps3.getAssign_function() == 1) {
			ass_RadioButton3.setSelected(true);
		}else {
			ass_RadioButton3.setSelected(false);
		}
		
		JRadioButton ins_RadioButton3 = new JRadioButton("工單驗收功能");
		ins_RadioButton3.setBounds(351, 246, 107, 23);
		panel.add(ins_RadioButton3);
		if(ps3.getInspect_function() == 1) {
			ins_RadioButton3.setSelected(true);
		}else {
			ins_RadioButton3.setSelected(false);
		}
		
		JRadioButton rep_RadioButton3 = new JRadioButton("報表功能");
		rep_RadioButton3.setBounds(351, 271, 107, 23);
		panel.add(rep_RadioButton3);
		if(ps3.getReport_function() == 1) {
			rep_RadioButton3.setSelected(true);
		}else {
			rep_RadioButton3.setSelected(false);
		}
		
		JRadioButton per_RadioButton3 = new JRadioButton("權限管理功能");
		per_RadioButton3.setBounds(228, 271, 121, 23);
		panel.add(per_RadioButton3);
		if(ps3.getPermission_function() == 1) {
			per_RadioButton3.setSelected(true);
		}else {
			per_RadioButton3.setSelected(false);
		}
		
		JRadioButton aff_RadioButton3 = new JRadioButton("工單完成提交功能");
		aff_RadioButton3.setBounds(228, 246, 121, 23);
		panel.add(aff_RadioButton3);
		if(ps3.getAffairs_function() == 1) {
			aff_RadioButton3.setSelected(true);
		}else {
			aff_RadioButton3.setSelected(false);
		}
		
		JRadioButton sch_RadioButton3 = new JRadioButton("工單進度顯示功能");
		sch_RadioButton3.setBounds(119, 246, 107, 23);
		panel.add(sch_RadioButton3);
		if(ps3.getSchedule_function() == 1) {
			sch_RadioButton3.setSelected(true);
		}else {
			sch_RadioButton3.setSelected(false);
		}
		
		JRadioButton acc_RadioButton3 = new JRadioButton("帳號管理功能");
		acc_RadioButton3.setBounds(119, 271, 107, 23);
		panel.add(acc_RadioButton3);
		if(ps3.getAccount_mana_function() == 1) {
			acc_RadioButton3.setSelected(true);
		}else {
			acc_RadioButton3.setSelected(false);
		}
		
		JRadioButton his_RadioButton3 = new JRadioButton("歷史工單功能");
		his_RadioButton3.setBounds(10, 271, 107, 23);
		panel.add(his_RadioButton3);
		if(ps3.getHistory_function() == 1) {
			his_RadioButton3.setSelected(true);
		}else {
			his_RadioButton3.setSelected(false);
		}
		
		JRadioButton sub_RadioButton3 = new JRadioButton("表格提交功能");
		sub_RadioButton3.setBounds(10, 246, 107, 23);
		panel.add(sub_RadioButton3);
		if(ps3.getSub_function() == 1) {
			sub_RadioButton3.setSelected(true);
		}else {
			sub_RadioButton3.setSelected(false);
		}
		
		JLabel lblNewLabel_1_1_2 = new JLabel("管理者");
		lblNewLabel_1_1_2.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblNewLabel_1_1_2.setBounds(10, 310, 90, 30);
		panel.add(lblNewLabel_1_1_2);
		
		JRadioButton sub_RadioButton4 = new JRadioButton("表格提交功能");
		sub_RadioButton4.setBounds(10, 346, 107, 23);
		panel.add(sub_RadioButton4);
		if(ps4.getSub_function() == 1) {
			sub_RadioButton4.setSelected(true);
		}else {
			sub_RadioButton4.setSelected(false);
		}
		
		JRadioButton sch_RadioButton4 = new JRadioButton("工單進度顯示功能");
		sch_RadioButton4.setBounds(119, 346, 107, 23);
		panel.add(sch_RadioButton4);
		if(ps4.getSchedule_function() == 1) {
			sch_RadioButton4.setSelected(true);
		}else {
			sch_RadioButton4.setSelected(false);
		}
		
		JRadioButton aff_RadioButton4 = new JRadioButton("工單完成提交功能");
		aff_RadioButton4.setBounds(228, 346, 121, 23);
		panel.add(aff_RadioButton4);
		if(ps4.getAffairs_function() == 1) {
			aff_RadioButton4.setSelected(true);
		}else {
			aff_RadioButton4.setSelected(false);
		}
		
		JRadioButton ins_RadioButton4 = new JRadioButton("工單驗收功能");
		ins_RadioButton4.setBounds(351, 346, 107, 23);
		panel.add(ins_RadioButton4);
		if(ps4.getInspect_function() == 1) {
			ins_RadioButton4.setSelected(true);
		}else {
			ins_RadioButton4.setSelected(false);
		}
		
		JRadioButton ass_RadioButton4 = new JRadioButton("工單指派功能");
		ass_RadioButton4.setBounds(460, 346, 107, 23);
		panel.add(ass_RadioButton4);
		if(ps4.getAssign_function() == 1) {
			ass_RadioButton4.setSelected(true);
		}else {
			ass_RadioButton4.setSelected(false);
		}
		
		JRadioButton rep_RadioButton4 = new JRadioButton("報表功能");
		rep_RadioButton4.setBounds(351, 371, 107, 23);
		panel.add(rep_RadioButton4);
		if(ps4.getReport_function() == 1) {
			rep_RadioButton4.setSelected(true);
		}else {
			rep_RadioButton4.setSelected(false);
		}
		
		JRadioButton per_RadioButton4 = new JRadioButton("權限管理功能");
		per_RadioButton4.setBounds(228, 371, 121, 23);
		panel.add(per_RadioButton4);
		if(ps4.getPermission_function() == 1) {
			per_RadioButton4.setSelected(true);
		}else {
			per_RadioButton4.setSelected(false);
		}
		
		JRadioButton acc_RadioButton4 = new JRadioButton("帳號管理功能");
		acc_RadioButton4.setBounds(119, 371, 107, 23);
		panel.add(acc_RadioButton4);
		if(ps4.getAccount_mana_function() == 1) {
			acc_RadioButton4.setSelected(true);
		}else {
			acc_RadioButton4.setSelected(false);
		}
		
		JRadioButton his_RadioButton4 = new JRadioButton("歷史工單功能");
		his_RadioButton4.setBounds(10, 371, 107, 23);
		panel.add(his_RadioButton4);
		if(ps4.getHistory_function() == 1) {
			his_RadioButton4.setSelected(true);
		}else {
			his_RadioButton4.setSelected(false);
		}
		
		JButton change_Button = new JButton("儲存變更");
		change_Button.setBounds(537, 397, 87, 23);
		panel.add(change_Button);
		
		change_Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//抓ps1的新狀態
				if(sub_RadioButton.isSelected()) {
					ps1.setSub_function(1);
				}else {
					ps1.setSub_function(0);
				}
				if(sch_RadioButton.isSelected()) {
					ps1.setSchedule_function(1);
				}else {
					ps1.setSchedule_function(0);
				}
				if(aff_RadioButton.isSelected()) {
					ps1.setAffairs_function(1);
				}else {
					ps1.setAffairs_function(0);
				}
				if(ins_RadioButton.isSelected()) {
					ps1.setInspect_function(1);
				}else {
					ps1.setInspect_function(0);
				}
				if(his_RadioButton.isSelected()) {
					ps1.setHistory_function(1);
				}else {
					ps1.setHistory_function(0);
				}
				if(acc_RadioButton.isSelected()) {
					ps1.setAccount_mana_function(1);
				}else {
					ps1.setAccount_mana_function(0);
				}
				if(per_RadioButton.isSelected()) {
					ps1.setPermission_function(1);
				}else {
					ps1.setPermission_function(0);
				}
				if(rep_RadioButton.isSelected()) {
					ps1.setReport_function(1);
				}else {
					ps1.setReport_function(0);
				}
				if(ass_RadioButton.isSelected()) {
					ps1.setAssign_function(1);
				}else {
					ps1.setAssign_function(0);
				}
				//抓ps2的新狀態
				if(sub_RadioButton2.isSelected()) {
					ps2.setSub_function(1);
				}else {
					ps2.setSub_function(0);
				}
				if(sch_RadioButton2.isSelected()) {
					ps2.setSchedule_function(1);
				}else {
					ps2.setSchedule_function(0);
				}
				if(aff_RadioButton2.isSelected()) {
					ps2.setAffairs_function(1);
				}else {
					ps2.setAffairs_function(0);
				}
				if(ins_RadioButton2.isSelected()) {
					ps2.setInspect_function(1);
				}else {
					ps2.setInspect_function(0);
				}
				if(his_RadioButton2.isSelected()) {
					ps2.setHistory_function(1);
				}else {
					ps2.setHistory_function(0);
				}
				if(acc_RadioButton2.isSelected()) {
					ps2.setAccount_mana_function(1);
				}else {
					ps2.setAccount_mana_function(0);
				}
				if(per_RadioButton2.isSelected()) {
					ps2.setPermission_function(1);
				}else {
					ps2.setPermission_function(0);
				}
				if(rep_RadioButton2.isSelected()) {
					ps2.setReport_function(1);
				}else {
					ps2.setReport_function(0);
				}
				if(ass_RadioButton2.isSelected()) {
					ps2.setAssign_function(1);
				}else {
					ps2.setAssign_function(0);
				}
				//抓ps3的新狀態
				if(sub_RadioButton3.isSelected()) {
					ps3.setSub_function(1);
				}else {
					ps3.setSub_function(0);
				}
				if(sch_RadioButton3.isSelected()) {
					ps3.setSchedule_function(1);
				}else {
					ps3.setSchedule_function(0);
				}
				if(aff_RadioButton3.isSelected()) {
					ps3.setAffairs_function(1);
				}else {
					ps3.setAffairs_function(0);
				}
				if(ins_RadioButton3.isSelected()) {
					ps3.setInspect_function(1);
				}else {
					ps3.setInspect_function(0);
				}
				if(his_RadioButton3.isSelected()) {
					ps3.setHistory_function(1);
				}else {
					ps3.setHistory_function(0);
				}
				if(acc_RadioButton3.isSelected()) {
					ps3.setAccount_mana_function(1);
				}else {
					ps3.setAccount_mana_function(0);
				}
				if(per_RadioButton3.isSelected()) {
					ps3.setPermission_function(1);
				}else {
					ps3.setPermission_function(0);
				}
				if(rep_RadioButton3.isSelected()) {
					ps3.setReport_function(1);
				}else {
					ps3.setReport_function(0);
				}
				if(ass_RadioButton3.isSelected()) {
					ps3.setAssign_function(1);
				}else {
					ps3.setAssign_function(0);
				}
				//抓ps4的新狀態
				if(sub_RadioButton4.isSelected()) {
					ps4.setSub_function(1);
				}else {
					ps4.setSub_function(0);
				}
				if(sch_RadioButton4.isSelected()) {
					ps4.setSchedule_function(1);
				}else {
					ps4.setSchedule_function(0);
				}
				if(aff_RadioButton4.isSelected()) {
					ps4.setAffairs_function(1);
				}else {
					ps4.setAffairs_function(0);
				}
				if(ins_RadioButton4.isSelected()) {
					ps4.setInspect_function(1);
				}else {
					ps4.setInspect_function(0);
				}
				if(his_RadioButton4.isSelected()) {
					ps4.setHistory_function(1);
				}else {
					ps4.setHistory_function(0);
				}
				if(acc_RadioButton4.isSelected()) {
					ps4.setAccount_mana_function(1);
				}else {
					ps4.setAccount_mana_function(0);
				}
				if(per_RadioButton4.isSelected()) {
					ps4.setPermission_function(1);
				}else {
					ps4.setPermission_function(0);
				}
				if(rep_RadioButton4.isSelected()) {
					ps4.setReport_function(1);
				}else {
					ps4.setReport_function(0);
				}
				if(ass_RadioButton4.isSelected()) {
					ps4.setAssign_function(1);
				}else {
					ps4.setAssign_function(0);
				}
				
				new implPermission_set().update(ps1);
				new implPermission_set().update(ps2);
				new implPermission_set().update(ps3);
				new implPermission_set().update(ps4);
				
				/*
        		dispose();*/
			}
		});
		
		
		
	}
}
